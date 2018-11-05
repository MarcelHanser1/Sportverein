package rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FactoryCompetitionRemotable extends Remote {

    CompetitionRemotable factoryMember() throws RemoteException;
}
