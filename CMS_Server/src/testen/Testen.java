package testen;

import domain.classes.Person;
import domain.interfaces.Iperson;
import persistence.DatabaseFacade;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class Testen {
    public static void main(String[] args) throws ParseException {
        DatabaseFacade databaseFacade = new DatabaseFacade();

        List<Iperson> personList = databaseFacade.listAllIpersons();
        for (Iperson iPerson: personList) {
            System.out.println("First Name: \t" + iPerson.getFirstName());
            System.out.println("Last Name: \t\t" + iPerson.getLastName());
            System.out.println("Date of birth: \t" + iPerson.getDateOfBirth());
            System.out.println("UserID: \t\t" + iPerson.getUserId());
            System.out.println("SSN: \t\t\t" + iPerson.getSocialSecurityNumber() + "\n");
        }



        databaseFacade.insertPerson(new Person("Gilbert","Moser",
                new java.sql.Date(new Date(1985, 1, 1).getTime()),
                "GilbMos","123456789"));


    }
}
