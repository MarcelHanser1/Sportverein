package rmi.interfaces;

import rmi.dto.PersonDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface MemberRemotable extends Remote {

    void addMember(PersonDTO personDTO) throws RemoteException;

    Collection<PersonDTO> displayMembers() throws RemoteException;
}
