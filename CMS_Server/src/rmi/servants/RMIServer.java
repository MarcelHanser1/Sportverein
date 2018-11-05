package rmi.servants;

import org.hibernate.SessionFactory;
import persistence.HibernateUtil;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.stream.Stream;

public class RMIServer {

    private static String rmiHostName;

    static {
        try {
            SessionFactory _sessionFactory = HibernateUtil.getSessionFactory();
            rmiHostName = InetAddress.getLocalHost().getHostAddress();
            System.out.println("\nServer IP Address: " + InetAddress.getLocalHost().getHostAddress() +"\n");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    // RMI URL
    private static String rmiURL;

    private static void initializeIP(){
        try(final DatagramSocket socket = new DatagramSocket()){
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            String ip = socket.getLocalAddress().getHostAddress();
            System.out.println("\nLukas IP Address: " + ip + "\n");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){

        try{
            Registry rmiRegistry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

            initializeIP();

            // set the policy file
            // alternative:
            // add this line to the Run/Debug Configurations VM:
            // -Djava.security.policy=src/rmi/servants/server.policy
            // System.setProperty("java.security.policy", "file:./server.policy");


            rmiURL = "rmi://" + rmiHostName + "/";
            Factory factory = new Factory();
            Naming.rebind(rmiURL + "Factory", factory);
            // Confirmation message!
            System.out.println("Objects bound to RMIRegistry!");

            System.out.println("\nAll bound Objects:");
            Stream.of(rmiRegistry.list()).forEach(x -> System.out.println(x));

            System.out.println("\n");

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
