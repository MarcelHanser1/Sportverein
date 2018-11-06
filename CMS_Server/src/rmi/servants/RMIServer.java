package rmi.servants;

import org.hibernate.SessionFactory;
import persistence.HibernateUtil;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.stream.Stream;

public class RMIServer {
    // RMI URL
    private static String rmiURL;


    private static void initIP() throws UnknownHostException {
            SessionFactory _sessionFactory = HibernateUtil.getSessionFactory();
            rmiURL = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/";
            System.out.println("\nServer IP Address: " + InetAddress.getLocalHost().getHostAddress() + "\n");

    }

    public static void main(String[] args) {

        try {
            initIP();
            Registry rmiRegistry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

            // set the policy file
            // alternative:
            // add this line to the Run/Debug Configurations VM:
            // -Djava.security.policy=src/rmi/servants/server.policy
            // System.setProperty("java.security.policy", "file:./server.policy");


            Factory factory = new Factory();
            Naming.rebind(rmiURL + "Factory", factory);
            // Confirmation message!
            System.out.println("Objects bound to RMIRegistry!");

            System.out.println("\nAll bound Objects:");
            Stream.of(rmiRegistry.list()).forEach(x -> System.out.println(x));

            System.out.println("\n");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}