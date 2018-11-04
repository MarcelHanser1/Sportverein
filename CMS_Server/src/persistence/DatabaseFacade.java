package persistence;

import domain.classes.*;
import persistence.dao.CompetitionDAO;
import persistence.dao.PersonDAO;
import persistence.dao.RoleDAO;
import persistence.pojo.CompetitionPOJO;
import persistence.pojo.PersonPOJO;
import persistence.pojo.RolePOJO;
import rmi.dto.PersonDTO;
import rmi.dto.RoleDTO;
import utilities.ObjectMapperUtils;

import java.util.List;


public class DatabaseFacade {

	public List<PersonDTO> listAllpersons() {
		PersonDAO dao = PersonDAO.getInstance();
		List<PersonPOJO> persons = dao.getAll();
		return ObjectMapperUtils.mapAll(persons, PersonDTO.class);
	}

	public PersonDTO getPersonByID(Integer ID){

		PersonDAO dao = PersonDAO.getInstance();
		PersonPOJO person = dao.getByKey(ID);
		if(person != null){
			return ObjectMapperUtils.map(person, PersonDTO.class);
		}
		return null;
	}

	public PersonDTO addRolesToPersonDto (PersonDTO person) {
		PersonDAO dao = PersonDAO.getInstance();
		PersonPOJO personPOJO = dao.getByKey(person.getPersonID());
		person = ObjectMapperUtils.map(personPOJO, PersonDTO.class);
		person.setRoleDTOList(ObjectMapperUtils.mapAll(personPOJO.getRoleList(), RoleDTO.class));
		return person;
	}

	public List<RoleDTO> getRolesFromPersonDto(PersonDTO person) {
		PersonDAO dao = PersonDAO.getInstance();
		PersonPOJO personPOJO = dao.getByKey(person.getPersonID());
		return ObjectMapperUtils.mapAll(personPOJO.getRoleList(), RoleDTO.class);
	}



    public PersonPOJO getPersonPOJOByID(Integer ID){

        PersonDAO dao = PersonDAO.getInstance();
        PersonPOJO person = dao.getByKey(ID);
        if(person != null){
            return person;
        }
        return null;
    }

    public void updatePerson (PersonDTO personDTO) {
        PersonPOJO personPOJO = ObjectMapperUtils.map(personDTO, PersonPOJO.class);
        if (personDTO.getRoleDTOList() != null) {
            personPOJO.setRoleList(ObjectMapperUtils.mapAll(personDTO.getRoleDTOList(), RolePOJO.class));
        }
        PersonDAO dao = PersonDAO.getInstance();
        dao.update(personPOJO);
    }


	public void insertPerson (PersonDTO personDTO) {
        PersonPOJO personPOJO = ObjectMapperUtils.map(personDTO, PersonPOJO.class);
        if (personDTO.getRoleDTOList() != null) {
            personPOJO.setRoleList(ObjectMapperUtils.mapAll(personDTO.getRoleDTOList(), RolePOJO.class));
        }
		PersonDAO dao = PersonDAO.getInstance();
		dao.insert(personPOJO);
	}

    public void addRole (PersonDTO personDTO) {
        PersonPOJO personPOJO = ObjectMapperUtils.map(personDTO, PersonPOJO.class);
        personPOJO.setRoleList(ObjectMapperUtils.mapAll(personDTO.getRoleDTOList(), RolePOJO.class));
        PersonDAO dao = PersonDAO.getInstance();
        dao.update(personPOJO);
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
//                competitionPOJO.setAllteams(ObjectMapperUtils.mapAll(competition.getTeamList(), TeamPOJO.class));
//                competitionPOJO.getAllteams().get(i).setSportBySportId(ObjectMapperUtils.map(competition.getTeamList().get(i).getSport(),SportPOJO.class));
//            }
		dao.insert(competitionPOJO);
	}

	public void deleteMember(PersonDTO personDTO) {
		PersonDAO dao = PersonDAO.getInstance();
		PersonPOJO personPOJO = ObjectMapperUtils.map(personDTO,PersonPOJO.class);
		dao.delete(personPOJO);
	}

	public List<RoleDTO> getAllRoles() {
		RoleDAO roleDAO = RoleDAO.getInstance();
		return ObjectMapperUtils.mapAll(roleDAO.getAll(), RoleDTO.class);
	}

}