
package linda.server;
import java.io.Serializable;

import java.rmi.*;
import linda.Tuple;
import linda.Linda;
import linda.Callback;

public interface MyCallBack extends Remote{
      /** Callback when a tuple appears. 
     * See Linda.eventRegister for details.
     * 
     * @param t the new tuple
     */
    void call(Tuple t) throws RemoteException;
}
