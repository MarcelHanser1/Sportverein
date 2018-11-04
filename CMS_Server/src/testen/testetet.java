package testen;

import persistence.DatabaseFacade;
import rmi.dto.PersonDTO;

public class testetet {

    public static void main(String[] args) {
        DatabaseFacade databaseFacade = new DatabaseFacade();
        PersonDTO personDTO = new PersonDTO();
        personDTO.setPersonID(12);
        databaseFacade.addRolesToPersonDto(personDTO);
    }
}
