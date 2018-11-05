package rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FactoryMemberRemotable extends Remote {

    MemberRemotable factoryMember() throws RemoteException;

}
