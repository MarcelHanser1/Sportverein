package rmi.servants;

import program.MemberHandler;
import rmi.dto.PersonDTO;
import rmi.dto.RoleDTO;
import rmi.interfaces.RoleRemotable;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RoleServant extends UnicastRemoteObject implements RoleRemotable, Serializable {

    private static final long serialVersionUID = 2L;
    private MemberHandler _memberHandler = new MemberHandler();

    protected RoleServant() throws RemoteException {
        super();
    }

    public List<RoleDTO> getAllRoles () {
        return _memberHandler.getAllRoles();
    }

    List<PersonDTO> getAllMember() {
        return _memberHandler.getAllMember();
    }

}
