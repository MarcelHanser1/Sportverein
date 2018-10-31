package rmi;

import rmi.dto.PersonDto;

import java.rmi.Remote;
import java.util.Collection;

public interface MemberRemoteable extends Remote {
    void addMember();

    Collection<PersonDto> displayMembers();
}
