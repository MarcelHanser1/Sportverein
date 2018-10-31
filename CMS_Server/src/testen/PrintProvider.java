package testen;

import domain.classes.Competition;
import domain.classes.Person;
import domain.interfaces.Icompetition;
import domain.interfaces.Iperson;

public class PrintProvider {

    private static final PrintProvider instance = new PrintProvider();

    //private constructor to avoid client applications to use constructor
    private PrintProvider(){}

    public static PrintProvider getInstance(){
        return instance;
    }

    public void printPerson(Person targetPerson){

        if(targetPerson == null){
            System.out.println("Person data not available!");
        } else {
            System.out.println("First Name: \t" + targetPerson.getFirstName());
            System.out.println("Last Name: \t\t" + targetPerson.getLastName());
            System.out.println("Date of birth: \t" + targetPerson.getDateOfBirth());
            System.out.println("UserID: \t\t" + targetPerson.getUserId());
            System.out.println("SSN: \t\t\t" + targetPerson.getSocialSecurityNumber() + "\n");
        }
    }

    public void printPersonInterface(Iperson targetPersonInterface){
        if(targetPersonInterface == null){
            System.out.println("Person data not available!");
        } else {
            System.out.println("First Name: \t" + targetPersonInterface.getFirstName());
            System.out.println("Last Name: \t\t" + targetPersonInterface.getLastName());
            System.out.println("Date of birth: \t" + targetPersonInterface.getDateOfBirth());
            System.out.println("UserID: \t\t" + targetPersonInterface.getUserId());
            System.out.println("SSN: \t\t\t" + targetPersonInterface.getSocialSecurityNumber() + "\n");
        }
    }

    public void printCompetition(Competition targetCompetition){
        if(targetCompetition == null){
            System.out.println("Competition data not available!");
        } else {
            System.out.println("Location: \t" + targetCompetition.getLocation());
            System.out.println("Start Date: \t" + targetCompetition.getStartDate());
        }
    }
}
