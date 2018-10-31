package persistence;

import domain.classes.*;
import domain.interfaces.*;
import persistence.dao.*;
import persistence.pojo.*;
import utilities.ObjectMapperUtils;

import java.util.List;


public class DatabaseFacade {

	// Person
	public List<Person> listAllpersons() {
		PersonDAO dao = PersonDAO.getInstance();
		List<PersonPOJO> persons = dao.getAll();
		return ObjectMapperUtils.mapAll(persons, Person.class);
	}

	public Person getPersonByID(Integer ID){

		PersonDAO dao = PersonDAO.getInstance();
		PersonPOJO person = dao.getByKey(ID);
		if(person != null){
			return ObjectMapperUtils.map(person, Person.class);
		}
		return null;
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


	// Competition
	public Competition getCompetitionByID(Integer ID){

		CompetitionDAO dao = CompetitionDAO.getInstance();
		CompetitionPOJO comp = dao.getByKey(ID);
		if(comp!=null){
			return ObjectMapperUtils.map(comp, Competition.class);
			// return new Competition(comp.getLocation(), comp.getStartDate());
		}
		return null;
	}

	public List<Competition> listAllcompetitions(){
		CompetitionDAO dao = CompetitionDAO.getInstance();
		List<CompetitionPOJO> competitions = dao.getAll();
		return ObjectMapperUtils.mapAll(competitions, Competition.class);
	}

	// probably not working ...
	public void insertCompetition(Icompetition iCompetition){
		CompetitionPOJO competitionPOJO = new CompetitionPOJO();
		ObjectMapperUtils.map(iCompetition, competitionPOJO);
		CompetitionDAO dao = CompetitionDAO.getInstance();
		dao.insert(competitionPOJO);
	}


}