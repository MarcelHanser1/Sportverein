package testen;

import program.CompetitionHandler;
import rmi.dto.CompetitionDTO;
import rmi.dto.TeamDTO;

import java.util.List;

public class TestAddRole {
    public static void main(String[] args) {
        CompetitionHandler competitionHandler = new CompetitionHandler();
        List<CompetitionDTO> competitionList  = competitionHandler.getAllCompetitions();
        CompetitionDTO competitionDTO = competitionList.get(5);
        List<TeamDTO> teamDTOS = competitionHandler.getAllTeams();
        TeamDTO teamDTO = teamDTOS.get(0);
        competitionDTO.setTeamList(teamDTOS);
        competitionHandler.insertCompetition(competitionDTO);


        System.exit(0);
    }
}
