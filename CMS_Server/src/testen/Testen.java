package testen;

import domain.interfaces.Iperson;
import persistence.DatabaseFacade;

import java.util.List;

public class Testen {
    public static void main(String[] args) {
        DatabaseFacade databaseFacade = new DatabaseFacade();
        List<Iperson> personList = databaseFacade.listAllIpersons();
        for (Iperson person: personList) {
            System.out.println("First Name: \t" + person.getFirstName());
            System.out.println("Last Name: \t\t" + person.getLastName());
            System.out.println("Date of birth: \t" + person.getDateOfBirth());
            System.out.println("UserID: \t\t" + person.getUserId());
            System.out.println("SSN: \t\t\t" + person.getSocialSecurityNumber() + "\n");
        }
    }
}
