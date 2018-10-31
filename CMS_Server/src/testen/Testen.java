package testen;

import domain.classes.Competition;
import domain.classes.Person;
import domain.interfaces.Iperson;
import persistence.DatabaseFacade;

import java.util.List;

public class Testen {
    public static void main(String[] args) {

        PrintProvider printer = PrintProvider.getInstance();

        DatabaseFacade databaseFacade = new DatabaseFacade();
        // Test: get all persons of the database
        List<Person> personList = databaseFacade.listAllpersons();
        for (Iperson iPerson: personList) {
            printer.printPersonInterface(iPerson);
        }

//        databaseFacade.insertPerson(new PersonDto("Gilbert","Moser",
//                new java.sql.Date(new Date(1985, 1, 1).getTime()),
//                "GilbMos","123456789"));

        // Test: get PersonDto by id
        Integer testPersonID = 1;
        Person numberOne = databaseFacade.getPersonByID(testPersonID);
        System.out.println("PersonDto with the id " + testPersonID);
        printer.printPersonInterface(numberOne);

        // Test: get Competition by id
        Integer testCompetitionID = 1;
        Competition testComp = databaseFacade.getCompetitionByID(testCompetitionID);
        printer.printCompetition(testComp);

        /*
        String compLocation = "Vienna";
        Date compTime = Date.valueOf("2018-10-31");

        Competition insertThisComp = new Competition(compLocation, compTime);

        databaseFacade.insertCompetition(insertThisComp);
        */

        System.exit(0);
    }
}
