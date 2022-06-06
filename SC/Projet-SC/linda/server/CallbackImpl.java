package linda.server;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

import linda.Tuple;
import linda.server.MyCallBack;
import linda.Linda;
import linda.Tuple;
import linda.Callback;

public class CallbackImpl extends UnicastRemoteObject implements MyCallBack{

    
    private Callback callBack;

    public CallbackImpl (Callback cb) throws RemoteException{
            this.callBack = cb;
    }

    public void call (Tuple t){
        this.callBack.call(t);
    }
}
