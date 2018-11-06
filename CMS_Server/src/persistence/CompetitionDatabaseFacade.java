package persistence;

import domain.classes.Competition;
import domain.classes.League;
import domain.classes.Sport;
import domain.classes.Team;
import persistence.dao.CompetitionDAO;
import persistence.dao.TeamDAO;
import persistence.pojo.CompetitionPOJO;
import persistence.pojo.TeamPOJO;
import rmi.dto.CompetitionDTO;
import rmi.dto.TeamDTO;
import utilities.ObjectMapperUtils;

import java.util.List;

public class CompetitionDatabaseFacade {

    public void addNewCompetition(CompetitionDTO competition) {
        CompetitionPOJO competitionPOJO = ObjectMapperUtils.map(competition, CompetitionPOJO.class);
        if (competitionPOJO.getAllteams() != null) {
            competitionPOJO.setAllteams(ObjectMapperUtils.mapAll(competition.getTeamList(), TeamPOJO.class));
        }
        CompetitionDAO dao = CompetitionDAO.getInstance();
        dao.insert(competitionPOJO);
    }

    public List<CompetitionDTO> getAllCompetitions() {
        CompetitionDAO dao = CompetitionDAO.getInstance();
        List<CompetitionPOJO> competitionPOJOList = dao.getAll();
        return ObjectMapperUtils.mapAll(competitionPOJOList, CompetitionDTO.class);
    }

    public CompetitionDTO addTeamsToCompetitionDTO (CompetitionDTO competitionDTO) {
        CompetitionDAO dao = CompetitionDAO.getInstance();
        CompetitionPOJO competitionPOJO = dao.getByKey(competitionDTO.getCompId());
        competitionDTO = ObjectMapperUtils.map(competitionPOJO, CompetitionDTO.class);
        competitionDTO.setTeamList(ObjectMapperUtils.mapAll(competitionPOJO.getAllteams(), TeamDTO.class));
        return competitionDTO;
    }

    public List<TeamDTO> getTeamsfromCompetitionDto(CompetitionDTO competitionDTO) {
        CompetitionDAO dao = CompetitionDAO.getInstance();
        CompetitionPOJO CompetitionPOJO = dao.getByKey(competitionDTO.getCompId());
        return ObjectMapperUtils.mapAll(CompetitionPOJO.getAllteams(), TeamDTO.class);
    }

    public void updateCompetition (CompetitionDTO competitionDTO) {
        CompetitionPOJO CompetitionPOJO = ObjectMapperUtils.map(competitionDTO, CompetitionPOJO.class);
        if (competitionDTO.getTeamList() != null) {
            CompetitionPOJO.setAllteams(ObjectMapperUtils.mapAll(competitionDTO.getTeamList(), TeamPOJO.class));
        }
        CompetitionDAO dao = CompetitionDAO.getInstance();
        dao.update(CompetitionPOJO);
    }

    public void insertCompetition (CompetitionDTO competitionDTO) {
        CompetitionPOJO competitionPOJO = ObjectMapperUtils.map(competitionDTO, CompetitionPOJO.class);
        if (competitionDTO.getTeamList() != null) {
            competitionPOJO.setAllteams(ObjectMapperUtils.mapAll(competitionDTO.getTeamList(), TeamPOJO.class));
        }
        CompetitionDAO dao = CompetitionDAO.getInstance();
        dao.insert(competitionPOJO);
    }

    public void addTeam (CompetitionDTO competitionDTO) {
        CompetitionPOJO competitionPOJO = ObjectMapperUtils.map(competitionDTO, CompetitionPOJO.class);
        competitionPOJO.setAllteams(ObjectMapperUtils.mapAll(competitionDTO.getTeamList(), TeamPOJO.class));
        CompetitionDAO dao = CompetitionDAO.getInstance();
        dao.update(competitionPOJO);
    }

    public List<Competition> listAllcompetitionsWithAllInfos(){
        CompetitionDAO dao = CompetitionDAO.getInstance();
        List<CompetitionPOJO> competitions = dao.getAll();
        List<Competition> competitionList = ObjectMapperUtils.mapAll(competitions, Competition.class);
        for(int i = 0; i < competitions.size();i++) {
            competitionList.get(i).setTeamList((ObjectMapperUtils.mapAll(competitions.get(i).getAllteams(), Team.class)));
            for (int j = 0; j < competitions.get(i).getAllteams().size(); j++) {
                competitionList.get(i).getTeamList().get(j).setSport((ObjectMapperUtils.map(competitions.get(i).getAllteams().get(j).getSportBySportId(), Sport.class)));
                competitionList.get(i).getTeamList().get(j).setLeague((ObjectMapperUtils.map(competitions.get(i).getAllteams().get(j).getLeagueByLeagueId(), League.class)));
            }
        }
        return competitionList;
    }

    public void deleteMember(CompetitionDTO competitionDTO) {
        CompetitionDAO dao = CompetitionDAO.getInstance();
        CompetitionPOJO competitionPOJO = ObjectMapperUtils.map(competitionDTO,CompetitionPOJO.class);
        dao.delete(competitionPOJO);
    }

    public List<TeamDTO> getAllTeams() {
        TeamDAO teamDAO = TeamDAO.getInstance();
        return ObjectMapperUtils.mapAll(teamDAO.getAll(), TeamDTO.class);
    }
}
