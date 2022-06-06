package linda.server;
import java.rmi.*;
import linda.Tuple;

public interface Mycallback extends Remote {
    
    public void call (Tuple t) throws RemoteException;
}