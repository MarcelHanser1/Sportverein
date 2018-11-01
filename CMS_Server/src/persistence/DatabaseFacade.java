package persistence;

import domain.classes.*;
import domain.interfaces.Iperson;
import persistence.dao.CompetitionDAO;
import persistence.dao.PersonDAO;
import persistence.pojo.*;
import utilities.ObjectMapperUtils;

import java.util.List;


public class DatabaseFacade {

	// PersonDTO
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
//			Iperson iPerson = new PersonDTO();
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

		List<Competition> competitionList = ObjectMapperUtils.mapAll(competitions, Competition.class);
		for(int i = 0; i < competitions.size();i++) {
            competitionList.get(i).setTeamList((ObjectMapperUtils.mapAll(competitions.get(i).getAllteams(), Team.class)));
            for (int j = 0; j < competitions.get(i).getAllteams().size(); j++) {
                competitionList.get(i).getTeamList().get(j).setSport((ObjectMapperUtils.map(competitions.get(i).getAllteams().get(j).getSportBySportId(), Sport.class)));
                competitionList.get(i).getTeamList().get(j).setLeague((ObjectMapperUtils.map(competitions.get(i).getAllteams().get(j).getLeagueByLeagueId(), League.class)));
            }
        }
        return competitionList;
	}



	public void insertCompetition(Competition competition){
        CompetitionDAO dao = CompetitionDAO.getInstance();
        CompetitionPOJO competitionPOJO = ObjectMapperUtils.map(competition, CompetitionPOJO.class);
            for (int i = 0; i < competition.getTeamList().size();i++) {
                competitionPOJO.setAllteams(ObjectMapperUtils.mapAll(competition.getTeamList(), TeamPOJO.class));
                competitionPOJO.getAllteams().get(i).setSportBySportId(ObjectMapperUtils.map(competition.getTeamList().get(i).getSport(),SportPOJO.class));
            }
		dao.insert(competitionPOJO);
	}




}