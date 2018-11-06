package persistence;

import persistence.dao.PersonDAO;
import persistence.dao.RoleDAO;
import persistence.pojo.PersonPOJO;
import persistence.pojo.RolePOJO;
import rmi.dto.PersonDTO;
import rmi.dto.RoleDTO;
import utilities.ObjectMapperUtils;

import java.util.List;


public class MemberDatabaseFacade {

	public List<PersonDTO> listAllpersons() {
		PersonDAO dao = PersonDAO.getInstance();
		List<PersonPOJO> persons = dao.getAll();
		return ObjectMapperUtils.mapAll(persons, PersonDTO.class);
	}

	public PersonDTO getPersonByID(Integer ID){

		PersonDAO dao = PersonDAO.getInstance();
		PersonPOJO person = dao.getEagerRolesForPersonByKey(ID);
		if(person != null){
			return ObjectMapperUtils.map(person, PersonDTO.class);
		}
		return null;
	}

	public PersonDTO addRolesToPersonDto (PersonDTO person) {
		PersonDAO dao = PersonDAO.getInstance();
		PersonPOJO personPOJO = dao.getEagerRolesForPersonByKey(person.getPersonID());
		person = ObjectMapperUtils.map(personPOJO, PersonDTO.class);
		person.setRoleDTOList(ObjectMapperUtils.mapAll(personPOJO.getRoleList(), RoleDTO.class));
		return person;
	}

	public List<RoleDTO> getRolesFromPersonDto(PersonDTO person) {
		PersonDAO dao = PersonDAO.getInstance();
		PersonPOJO personPOJO = dao.getEagerRolesForPersonByKey(person.getPersonID());
		return ObjectMapperUtils.mapAll(personPOJO.getRoleList(), RoleDTO.class);
	}



    public PersonPOJO getPersonPOJOByID(Integer ID){
        PersonDAO dao = PersonDAO.getInstance();
        PersonPOJO person = dao.getEagerRolesForPersonByKey(ID);
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