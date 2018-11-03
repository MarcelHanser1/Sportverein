package program;

import persistence.DatabaseFacade;
import rmi.dto.PersonDTO;

public class MemberHandler {
    private DatabaseFacade _databaseFacade = new DatabaseFacade();


    public void addNewMember(PersonDTO personDTO) {
        _databaseFacade.insertPerson(personDTO);
    }

}
