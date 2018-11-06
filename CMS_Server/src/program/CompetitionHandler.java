package program;

import domain.classes.Competition;
import persistence.CompetitionDatabaseFacade;
import rmi.dto.CompetitionDTO;
import rmi.dto.TeamDTO;

import java.util.List;

public class CompetitionHandler {

    private CompetitionDatabaseFacade _competitionDatabaseFacade = new CompetitionDatabaseFacade();

    public void addNewCompetition(CompetitionDTO competition) {}

    public List<CompetitionDTO> getAllCompetitions() {
        return _competitionDatabaseFacade.getAllCompetitions();
    }

    public CompetitionDTO addTeamsToCompetitionDTO (CompetitionDTO competitionDTO) {
        return _competitionDatabaseFacade.addTeamsToCompetitionDTO(competitionDTO);
    }

    public List<TeamDTO> getTeamsfromCompetitionDto(CompetitionDTO competitionDTO) {
        return _competitionDatabaseFacade.getTeamsfromCompetitionDto(competitionDTO);
    }

    public void updateCompetition (CompetitionDTO competitionDTO) {
        _competitionDatabaseFacade.updateCompetition(competitionDTO);
    }

    public void insertCompetition (CompetitionDTO competitionDTO) {
        _competitionDatabaseFacade.insertCompetition(competitionDTO);
    }

    public void addTeam (CompetitionDTO competitionDTO) {
        _competitionDatabaseFacade.addTeam(competitionDTO);
    }

    public List<Competition> listAllcompetitionsWithAllInfos(){
        return _competitionDatabaseFacade.listAllcompetitionsWithAllInfos();
    }

    public void deleteCompetition(CompetitionDTO competitionDTO) {
        _competitionDatabaseFacade.deleteMember(competitionDTO);
    }

    public List<TeamDTO> getAllTeams() {
        return _competitionDatabaseFacade.getAllTeams();
    }
}
