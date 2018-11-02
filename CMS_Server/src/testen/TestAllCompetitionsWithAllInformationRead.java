package testen;

import domain.classes.Competition;
import domain.classes.Team;
import persistence.DatabaseFacade;

import java.util.List;

public class TestAllCompetitionsWithAllInformationRead {
    public static void main(String[] args) {
        DatabaseFacade databaseFacade = new DatabaseFacade();
        List<Competition> competitionList = databaseFacade.listAllcompetitions();
        for (Competition competition:competitionList) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Tournament Name:: " + competition.getCompName());
            System.out.println("Location: " + competition.getLocation());
            System.out.println("Start Date: " + competition.getStartDate());
            System.out.println("----------------------------------------------------------------------\n");
            List<Team> allTeams = competition.getTeamList();
            for (Team team: allTeams) {
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Team Name: " + team.getTeamName());
                System.out.println("Team League: " + team.getLeague().getLeagueName());
                System.out.println("Team Sport: " + team.getSport().getSportName());
                System.out.println("----------------------------------------------------------------------\n");
            }
            System.out.println("******************************************************\n");
        }
        System.exit(0);
    }
}
