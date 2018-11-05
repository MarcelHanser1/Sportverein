package rmi.servants;

import rmi.interfaces.FactoryRemotable;
import rmi.interfaces.MemberRemotable;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Factory extends UnicastRemoteObject implements FactoryRemotable, Serializable {

    private static final long serialVersionUID = 12345678910L;

    protected Factory() throws RemoteException {
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
}
