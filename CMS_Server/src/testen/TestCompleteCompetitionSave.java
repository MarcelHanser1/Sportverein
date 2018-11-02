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
        competition.setCompName("Main Tournament 2019");
        competition.setLocation("Herrenau");


        String date = "2019-11-11";
        java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        competition.setStartDate(sqlDate);
        List<Team> teams = new LinkedList<>();
        teams.add(new Team(1));
        teams.add(new Team(2));
        teams.add(new Team(4));
        teams.add(new Team(12));
        teams.add(new Team(14));
        competition.setTeamList(teams);
        DatabaseFacade databaseFacade = new DatabaseFacade();
        databaseFacade.insertCompetition(competition);
        System.exit(0);
    }
}
