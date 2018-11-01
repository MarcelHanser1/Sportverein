package rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MemberRemotable extends Remote {

    // void addMember(PersonDTO personDTO) throws RemoteException;

    // Collection<PersonDTO> displayMembers() throws RemoteException;

    void test() throws RemoteException;
}
