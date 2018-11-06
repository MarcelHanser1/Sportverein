package testen;

import persistence.MemberDatabaseFacade;
import rmi.dto.PersonDTO;
import rmi.dto.RoleDTO;

public class TestAddRole {
    public static void main(String[] args) {
//        CompetitionDatabaseFacade competitionDatabaseFacade = new CompetitionDatabaseFacade();
//        CompetitionDTO competitionDTO = new CompetitionDTO();
//        competitionDTO.setCompId(1);
//        competitionDTO.setTeamList(competitionDatabaseFacade.getTeamsfromCompetitionDto(competitionDTO));




        MemberDatabaseFacade memberDatabaseFacade = new MemberDatabaseFacade();
        PersonDTO personDTO = new PersonDTO();
        personDTO.setPersonID(134);
        personDTO = memberDatabaseFacade.addRolesToPersonDto(personDTO);
        memberDatabaseFacade.updatePerson(personDTO);

        for(RoleDTO role:personDTO.getRoleDTOList()) {
            System.out.println(role.getRoleName());
        }

        System.exit(0);
    }
}
