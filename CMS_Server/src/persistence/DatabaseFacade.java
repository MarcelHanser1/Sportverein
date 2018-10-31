package persistence;

import domain.classes.Person;
import domain.interfaces.Iperson;
import persistence.dao.PersonDAO;
import persistence.pojo.PersonPOJO;
import utilities.ObjectMapperUtils;

import java.util.List;


public class DatabaseFacade {

	public List<Person> listAllpersons() {
		PersonDAO dao = PersonDAO.getInstance();
		List<PersonPOJO> persons = dao.getAll();
		return ObjectMapperUtils.mapAll(persons, Person.class);
	}


//	public List<Iperson> listAllIpersons() {
//		PersonDAO dao = PersonDAO.getInstance();
//		List<Iperson> iPersonList = new LinkedList<>();
//		List<PersonPOJO> PersonPOJOList = dao.getAll();
//		for (PersonPOJO personPOJO:PersonPOJOList) {
//			Iperson iPerson = new Person();
//			iPerson.setDateOfBirth(personPOJO.getDateOfBirth());
//			iPerson.setFirstName(personPOJO.getFirstName());
//			iPerson.setLastName(personPOJO.getLastName());
//			iPerson.setSocialSecurityNumber(personPOJO.getSocialSecurityNumber());
//			iPerson.setUserId(personPOJO.getUserId());
//			iPersonList.add(iPerson);
//		}
//		return iPersonList;
//	}

	public void insertPerson (Iperson iPerson) {
		PersonPOJO personPOJO = new PersonPOJO();
		ObjectMapperUtils.map(iPerson, personPOJO);
		PersonDAO dao = PersonDAO.getInstance();
		dao.insert(personPOJO);
	}
}