package rmi.servants;

import program.MemberHandler;
import rmi.interfaces.CompetitionRemotable;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CompetitionServant extends UnicastRemoteObject implements CompetitionRemotable, Serializable {

    private static final long serialVersionUID = 215648486;

    private MemberHandler _memberHandler = new MemberHandler();

    protected CompetitionServant() throws RemoteException {
        super();
    }




}
