package testen;

import persistence.DatabaseFacade;
import rmi.dto.PersonDTO;
import rmi.dto.RoleDTO;

import java.util.LinkedList;
import java.util.List;

public class testest {
    public static void main(String[] args) {
        DatabaseFacade databaseFacade = new DatabaseFacade();
        PersonDTO person = databaseFacade.getPersonByID(2);
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(1);
        List<RoleDTO> roleDTOList = new LinkedList<>();
        roleDTOList.add(roleDTO);
        person.setRoleDTOList(roleDTOList);
        databaseFacade.addRole(person);
        System.exit(0);
    }
}
