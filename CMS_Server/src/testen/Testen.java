package testen;

import domain.classes.Competition;
import domain.classes.PersonDto;
import domain.interfaces.Iperson;
import persistence.DatabaseFacade;

import java.util.List;

public class Testen {
    public static void main(String[] args) {

        PrintProvider printer = PrintProvider.getInstance();

        DatabaseFacade databaseFacade = new DatabaseFacade();

        // Test: get all persons of the database
        List<PersonDto> personDtoList = databaseFacade.listAllpersons();
        for (Iperson iPerson: personDtoList) {
            printer.printPersonInterface(iPerson);
        }

        List<Competition> competitionList = databaseFacade.listAllcompetitions();



        /*
        // Test: insert a person
        databaseFacade.insertPerson(
                new PersonDto("TimeLord","Clock",
                        new java.sql.Date.valueOf("2018-10-31"),
                        "GilbMos","123456789"));
        */
        /*
        // Test: get PersonDto by id
        Integer testPersonID = 1;
        PersonDto numberOne = databaseFacade.getPersonByID(testPersonID);
        System.out.println("PersonDto with the id " + testPersonID);
        printer.printPersonInterface(numberOne);
*/
        // Test: insert a competition

        /*
        String compLocation = "Vienna";
        Date compTime = Date.valueOf("2018-10-31");
        // Date compTime = new Date(new Date(2018, 10, 31).getTime());
        Competition insertThisComp = new Competition(compLocation, compTime);
        databaseFacade.insertCompetition(insertThisComp);
        */

        // Test: get Competition by id
/*
        Integer testCompetitionID = 1;
        Competition testComp = databaseFacade.getCompetitionByID(testCompetitionID);
        printer.printCompetition(testComp);
*/
        System.exit(0);
    }
}
