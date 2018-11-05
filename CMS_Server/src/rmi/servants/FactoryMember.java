package rmi.servants;

import rmi.interfaces.CompetitionRemotable;
import rmi.interfaces.FactoryCompetitionRemotable;
import rmi.interfaces.FactoryMemberRemotable;
import rmi.interfaces.MemberRemotable;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FactoryMember extends UnicastRemoteObject implements FactoryCompetitionRemotable, FactoryMemberRemotable, Serializable {

    private static final long serialVersionUID = 12345678910L;

    protected FactoryMember() throws RemoteException {
        super();
    }

    @Override
    public MemberRemotable factoryMember() {
        try {
            return new PersonServant();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CompetitionRemotable factoryMember() throws RemoteException {
        return new CompetitionServant();
    }


}
