package rmi.servants;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

    public static void main(String[] args){

        try{
            // start rmiregistry
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            // LocateRegistry.createRegistry(1099);

            // Security Manager
            if(System.getSecurityManager() == null) {

                System.setSecurityManager(new SecurityManager());
            }

            // set the policy file
            // System.setProperty("java.security.policy", "file:./server.policy");
            System.setProperty("java.rmi.server.hostname","172.22.32.123");

            // create the stubs
            PersonServant personStub = new PersonServant();

            // Bind the servants to the RMIRegistry
            Naming.rebind("Server", personStub);

            // Confirmation message!
            System.out.println("Objects bound to RMIRegistry!");

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
