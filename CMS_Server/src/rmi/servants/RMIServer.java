package rmi.servants;

import org.hibernate.SessionFactory;
import persistence.HibernateUtil;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    // required ip address ...
    // get your ip address information:
    // cmd command: ipconfig
    private static String rmiHostName;

    static {
        try {
            SessionFactory _sessionFactory = HibernateUtil.getSessionFactory();
            rmiHostName = InetAddress.getLocalHost().getHostAddress();
            System.out.println(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    // private static String rmiHostName = "172.22.10.168";
    // private static String rmiHostName = "192.168.43.248";
    // private static String rmiHostName = "localhost";

    // RMI port number
    private static int rmiPort = 1099;

    // RMI URL
    private static String rmiURL;

    public static void main(String[] args){

        try{
            // start rmiregistry
            // LocateRegistry.createRegistry(rmiPort);
            Registry rmiRegistry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            // LocateRegistry.createRegistry(1099);

            // set the policy file
            // alternative:
            // add this line to the Run/Debug Configurations VM:
            // -Djava.security.policy=src/rmi/servants/server.policy
            // System.setProperty("java.security.policy", "file:./server.policy");

            // Security Manager (optional)
//            if(System.getSecurityManager() == null) {
//
//                System.setSecurityManager(new SecurityManager());
//            }

            // set hostname property
//            System.setProperty("java.rmi.server.hostname", rmiHostName);

            // set codebase
/*            String rmiServerCodeBase = RMIServer.class.getProtectionDomain().getCodeSource().getLocation().toString();
            System.setProperty("java.rmi.server.codebase", rmiServerCodeBase);
            System.out.println("RMI Server Codebase: \n" + rmiServerCodeBase + "\n");*/

            // create the stubs
            PersonServant personStub = new PersonServant();

            // Bind the servants to the RMIRegistry
            // Naming.rebind("Server", personStub);
            // rmiURL = "//" + rmiHostName + ":" + rmiPort + "/";
            // rmiURL = "rmi://" + rmiHostName + ":" + rmiPort + "/";
            rmiURL = "rmi://" + rmiHostName + "/";
            // String bindName = rmiURL + "Server";
            Naming.rebind(rmiURL + "Server", personStub);

            // Confirmation message!
            System.out.println("Objects bound to RMIRegistry!");

            System.out.println("\nAll bound Objects:");
            for(String info : rmiRegistry.list()){
                System.out.println(info);
            }
            System.out.println("\n");

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
