package rmi.servants;

import rmi.interfaces.MemberRemotable;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PersonServant extends UnicastRemoteObject implements MemberRemotable {

    private static final long serialVersionUID = 1L;

    protected  PersonServant() throws RemoteException{
        super();
    }

    /*
    @Override
    public void addMember(PersonDTO personDTO) {

        // mapping: DTO to POJO
        // add member
        System.out.println("First name: " + personDTO.getFirstName());
    }
    */

    @Override
    public void test() throws RemoteException {

        System.out.println("Test successful!");
    }

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
