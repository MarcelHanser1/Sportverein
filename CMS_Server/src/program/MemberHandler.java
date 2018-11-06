package program;

import persistence.MemberDatabaseFacade;
import rmi.dto.PersonDTO;
import rmi.dto.RoleDTO;

import java.util.List;

public class MemberHandler {

    private MemberDatabaseFacade _memberDatabaseFacade = new MemberDatabaseFacade();

    public void addNewMember(PersonDTO personDTO) {
        _memberDatabaseFacade.insertPerson(personDTO);
    }

    public void deleteMember(PersonDTO personDTO) {
        _memberDatabaseFacade.deleteMember(personDTO);
    }

    public List<RoleDTO> getAllRoles() {
        return _memberDatabaseFacade.getAllRoles();
    }

    public void updateMember(PersonDTO personDTO) {
        _memberDatabaseFacade.updatePerson(personDTO);
    }

    public List<PersonDTO> getAllMember() {
        return _memberDatabaseFacade.listAllpersons();
    }
    public PersonDTO addRolesToPersonDTO(PersonDTO personDTO) {
        personDTO = _memberDatabaseFacade.addRolesToPersonDto(personDTO);
        return personDTO;
    }

    public List<RoleDTO> getRolesFromPersonDto(PersonDTO person) {
        return _memberDatabaseFacade.getRolesFromPersonDto(person);
    }
}
