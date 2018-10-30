package persistence;

import domain.classes.Person;
import domain.interfaces.Iperson;
import persistence.dao.PersonDAO;
import persistence.pojo.PersonPOJO;

import java.util.LinkedList;
import java.util.List;



public class DatabaseFacade {

	public List<Iperson> listAllIpersons() {
		PersonDAO dao = PersonDAO.getInstance();
		List<Iperson> iPersonList = new LinkedList<Iperson>();
		List<PersonPOJO> PersonPOJOList = dao.getAll();
		for (PersonPOJO personPOJO:PersonPOJOList) {
			Iperson iPerson = new Person();
			iPerson.setDateOfBirth(personPOJO.getDateOfBirth());
			iPerson.setFirstName(personPOJO.getFirstName());
			iPerson.setLastName(personPOJO.getLastName());
			iPerson.setPersonId(personPOJO.getPersonId());
			iPerson.setSocialSecurityNumber(personPOJO.getSocialSecurityNumber());
			iPerson.setUserId(personPOJO.getUserId());
			iPersonList.add(iPerson);
		}
		return iPersonList;
	}

	public void insertPerson (Iperson iPerson) {
		PersonPOJO PersonPOJO = new PersonPOJO();
		PersonPOJO.setFirstName(iPerson.getFirstName());
		PersonPOJO.setLastName(iPerson.getLastName());
		PersonPOJO.setDateOfBirth(iPerson.getDateOfBirth());
		PersonPOJO.setUserId(iPerson.getUserId());
		PersonDAO.getInstance().insert(PersonPOJO);
	}
}