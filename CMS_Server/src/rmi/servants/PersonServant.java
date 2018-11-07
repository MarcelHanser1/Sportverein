package rmi.servants;
import program.MemberHandler;
import rmi.dto.PersonDTO;
import rmi.dto.RoleDTO;
import rmi.interfaces.MemberRemotable;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class PersonServant extends UnicastRemoteObject implements  MemberRemotable, Serializable {

    private static final long serialVersionUID = 1L;

    private MemberHandler _memberHandler = new MemberHandler();

    protected  PersonServant() throws RemoteException {
        super();
    }

    @Override
    public void addNewMember(PersonDTO personDTO) throws RemoteException {
        // mapping: DTO to POJO
        // add member
        _memberHandler.addNewMember(personDTO);
    }

    @Override
    public void deleteMember(PersonDTO personDTO) {
        _memberHandler.deleteMember(personDTO);
    }

    @Override
    public void updateMember(PersonDTO personDTO) {
        _memberHandler.updateMember(personDTO);
    }

    @Override
    public List<PersonDTO> getAllMember() throws RemoteException {
        return _memberHandler.getAllMember();
    }

    @Override
    public PersonDTO addRolesToPersonDTO(PersonDTO person) throws RemoteException {
        return _memberHandler.addRolesToPersonDTO(person);
    }

    @Override
    public List<RoleDTO> getRolesFromPersonDto(PersonDTO person) throws RemoteException {
        return _memberHandler.getRolesFromPersonDto(person);
    }

    @Override
    public List<RoleDTO> getAllRoles () {
        return _memberHandler.getAllRoles();
    }

    /*
    @Override
    public void addMember(PersonDTO personDTO) {

        // mapping: DTO to POJO
        // add member
        System.out.println("First name: " + personDTO.getFirstName());
    }
    */

    /*
    @Override
    public Collection<PersonDTO> displayMembers() {
        Collection<PersonDTO> collection = new Collection<PersonDTO>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<PersonDTO> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(PersonDTO personDTO) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends PersonDTO> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };

        return collection;
    }
    */


}
