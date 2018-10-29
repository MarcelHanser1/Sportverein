package testen;

import application.DatabasePerson;
import domain.interfaces.Iperson;

import java.util.List;

public class Testen {
    public static void main(String[] args) {
        DatabasePerson databasePerson = new DatabasePerson();
        List<Iperson> ipersonList = databasePerson.getAllPersons();
        for (Iperson person:ipersonList) {
            System.out.println("First Name: \t" + person.getFirstName());
            System.out.println("Last Name: \t\t" + person.getLastName());
            System.out.println("Date of birth: \t" + person.getDateOfBirth());
            System.out.println("UserID: \t\t" + person.getUserId());
            System.out.println("SSN: \t\t\t" + person.getSocialSecurityNumber() + "\n");
        }
    }
}
