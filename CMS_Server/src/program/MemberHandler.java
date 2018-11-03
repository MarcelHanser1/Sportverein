package program;

import persistence.DatabaseFacade;
import rmi.dto.PersonDTO;
import rmi.dto.RoleDTO;

import java.util.List;

public class MemberHandler {
    private DatabaseFacade _databaseFacade = new DatabaseFacade();


    public void addNewMember(PersonDTO personDTO) {
        _databaseFacade.insertPerson(personDTO);
    }

    public void deleteMember(int id) {
        _databaseFacade.deleteMember(id);
    }

    public List<RoleDTO> getAllRoles() {
        return _databaseFacade.getAllRoles();
    }


}
