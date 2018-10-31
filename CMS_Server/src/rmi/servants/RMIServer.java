package rmi.servants;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {

    public static void main(String[] args){

        try{
            // start rmiregistry
            LocateRegistry.createRegistry(0);

            // create the stubs
            PersonServant personStub = new PersonServant();

            // Bind the servants to the RMIRegistry
            Naming.rebind("Server", personStub);

            // Confirmation method!
            System.out.println("Objects bound to RMIRegistry!");

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
