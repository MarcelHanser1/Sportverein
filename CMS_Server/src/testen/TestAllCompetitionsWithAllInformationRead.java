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
            System.out.println("Location: " + competition.getLocation());
            System.out.println("Start Date: " + competition.getStartDate() + "\n\n");
            List<Team> allTeams = competition.getTeamList();
            for (Team team: allTeams) {
                System.out.println("Team Name: " + team.getTeamName());
                System.out.println("Team League: " + team.getLeague().getLeagueName());
                System.out.println("Team Sport: " + team.getSport().getSportName() + "\n\n");
            }
        }
        System.exit(0);
    }
}
