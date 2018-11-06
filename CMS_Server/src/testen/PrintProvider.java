package testen;

import domain.classes.Competition;
import rmi.dto.PersonDTO;

public class PrintProvider {

    private static final PrintProvider instance = new PrintProvider();
    //private constructor to avoid client applications to use constructor
    private PrintProvider(){}
    public static PrintProvider getInstance(){
        return instance;
    }

    public void printPerson(PersonDTO targetPersonDto){

        if(targetPersonDto == null){
            System.out.println("PersonDTO data not available!");
        } else {
            System.out.println("First Name: \t" + targetPersonDto.getFirstName());
            System.out.println("Last Name: \t\t" + targetPersonDto.getLastName());
            System.out.println("Date of birth: \t" + targetPersonDto.getDateOfBirth());
            System.out.println("UserID: \t\t" + targetPersonDto.getUserId());
            System.out.println("SSN: \t\t\t" + targetPersonDto.getSocialSecurityNumber() + "\n");
        }
    }

    public void printPersonInterface(PersonDTO targetPersonInterface){
        if(targetPersonInterface == null){
            System.out.println("PersonDTO data not available!");
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
