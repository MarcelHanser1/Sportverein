package testen;

import domain.classes.Competition;
import domain.classes.League;
import domain.classes.Sport;
import domain.classes.Team;
import org.hibernate.dialect.Database;
import persistence.DatabaseFacade;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class TestCompleteCompetitionSave {
    public static void main(String[] args) throws ParseException {
        Competition competition = new Competition();
        competition.setLocation("Niklasdorf");


        String date = "2019-01-28";
        java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        competition.setStartDate(sqlDate);
        League league = new League();
        league.setLeagueID(1);
        league.setLeagueName("First League");
        Sport sport = new Sport();
        sport.setSportId(1);
        sport.setSportName("football");
        Team team1 = new Team();
        team1.setLeague(league);
        team1.setSport(sport);
        team1.setTeamID(1);
        team1.setTeamName("Tigers");
        Team team2 = new Team();
        team2.setTeamID(2);
        team2.setTeamName("Hunters");
        team2.setSport(sport);
        team2.setLeague(league);
        List<Team> teams = new LinkedList<>();
        teams.add(team1);
        teams.add(team2);
        competition.setTeamList(teams);
        DatabaseFacade databaseFacade = new DatabaseFacade();
        databaseFacade.insertCompetition(competition);
        System.exit(0);
    }
}
