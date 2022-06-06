package linda.server;
import java.rmi.*;
import linda.Tuple;
import linda.Callback;
import java.rmi.server.*;


public class MycallbackImpl extends UnicastRemoteObject implements Mycallback {
    private Callback cb;
    public MycallbackImpl (Callback cb) throws RemoteException{
        this.cb = cb;
    }
    public void call(Tuple t){
        this.cb.call(t);
    }
}