package application;

import domain.classes.Person;
import domain.interfaces.Iperson;
import persistence.DatabaseFacade;
import persistence.pojo.PersonPOJO;

import java.util.LinkedList;
import java.util.List;

public class DatabasePerson {

    public void insertPerson(Iperson iperson) {
        DatabaseFacade databaseFacade = new DatabaseFacade();
        PersonPOJO personPOJO = new PersonPOJO();
        personPOJO.setFirstName(iperson.getFirstName());
        personPOJO.setLastName(iperson.getLastName());
        personPOJO.setDateOfBirth(iperson.getDateOfBirth());
        personPOJO.setUserId(iperson.getUserId());
        databaseFacade.insertPerson(personPOJO);
    }

    public List<Iperson> getAllPersons () {
        DatabaseFacade databaseFacade = new DatabaseFacade();
        List<Iperson> iPersonList = new LinkedList<Iperson>();
        List<PersonPOJO> personPOJOList = databaseFacade.listAllPersons();
        for (PersonPOJO personPOJO:personPOJOList) {
            Iperson person = new Person();
            person.setDateOfBirth(personPOJO.getDateOfBirth());
            person.setFirstName(personPOJO.getFirstName());
            person.setLastName(personPOJO.getLastName());
            person.setPersonId(personPOJO.getPersonId());
            person.setSocialSecurityNumber(personPOJO.getSocialSecurityNumber());
            person.setUserId(personPOJO.getUserId());
            iPersonList.add(person);
        }
        return iPersonList;
    }

}
