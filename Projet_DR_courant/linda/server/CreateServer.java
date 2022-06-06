package linda.server;


import linda.Callback;
import linda.Linda;
import linda.Tuple;
import linda.shm.*;
import java.rmi.server.*;
import java.rmi.*;
import java.util.*;
import java.rmi.registry.*;

public class CreateServer extends UnicastRemoteObject implements Serveur {
    private Linda ma_linda;
    public CreateServer () throws RemoteException{
        this.ma_linda = new CentralizedLinda();
    }

    private class CallBackServer implements Callback {
        private Mycallback cb;

        public CallBackServer(Mycallback cb){
            this.cb = cb;
        }

        public void call (Tuple t){
            try {
            this.cb.call(t);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    /** Adds a tuple t to the tuplespace. */
    public void write(Tuple t){
        ma_linda.write(t);
    }

    /** Returns a tuple matching the template and removes it from the tuplespace.
     * Blocks if no corresponding tuple is found. */
    public Tuple take(Tuple template){
        return ma_linda.take(template);
    }


    /** Returns a tuple matching the template and leaves it in the tuplespace.
     * Blocks if no corresponding tuple is found. */
    public Tuple read(Tuple template){
        return ma_linda.read(template);
    }

    /** Returns a tuple matching the template and removes it from the tuplespace.
     * Returns null if none found. */
    public Tuple tryTake(Tuple template){
        return ma_linda.tryTake(template);
    }

    /** Returns a tuple matching the template and leaves it in the tuplespace.
     * Returns null if none found. */
    public Tuple tryRead(Tuple template){

        return ma_linda.tryRead(template);
    }

    /** Returns all the tuples matching the template and removes them from the tuplespace.
     * Returns an empty collection if none found (never blocks).
     * Note: there is no atomicity or consistency constraints between takeAll and other methods;
     * for instance two concurrent takeAll with similar templates may split the tuples between the two results.
     */
    public Collection<Tuple> takeAll(Tuple template){

        return ma_linda.takeAll(template);
    }

    /** Returns all the tuples matching the template and leaves them in the tuplespace.
     * Returns an empty collection if none found (never blocks).
     * Note: there is no atomicity or consistency constraints between readAll and other methods;
     * for instance (write([1]);write([2])) || readAll([?Integer]) may return only [2].
     */
    public Collection<Tuple> readAll(Tuple template){

        return ma_linda.readAll(template);
    }

    /** Registers a callback which will be called when a tuple matching the template appears.
     * If the mode is Take, the found tuple is removed from the tuplespace.
     * The callback is fired once. It may re-register itself if necessary.
     * If timing is immediate, the callback may immediately fire if a matching tuple is already present; if timing is future, current tuples are ignored.
     * Beware: a callback should never block as the calling context may be the one of the writer (see also {@link AsynchronousCallback} class).
     * Callbacks are not ordered: if more than one may be fired, the chosen one is arbitrary.
     * Beware of loop with a READ/IMMEDIATE re-registering callback !
     *
     * @param mode read or take mode.
     * @param timing (potentially) immediate or only future firing.
     * @param template the filtering template.
     * @param callback the callback to call if a matching tuple appears.
     */
    public void eventRegister(String mode, String timing, Tuple template, Mycallback callback){
        CallBackServer mon_callback_server = new CallBackServer(callback);
                ma_linda.eventRegister(Linda.eventMode.valueOf(mode),Linda.eventTiming.valueOf(timing),template,mon_callback_server);
            
    }

    
    public void eventCorrection(Tuple template, Mycallback callback){
        CallBackServer mon_callback_correction = new CallBackServer(callback);
        ma_linda.eventCorrection(template,mon_callback_correction);

   }
   
    /** To debug, prints any information it wants (e.g. the tuples in tuplespace or the registered callbacks), prefixed by <code>prefix</code. */
    public void debug(String prefix){
        ma_linda.debug(prefix);
    }

    public static void main (String [] args){
        if (args.length != 2){
            System.out.println("CreateServer 'nom_server' port");
            return;
        }
        int port = Integer.parseInt(args[1]);
        try {
                Serveur serveur = new CreateServer();
                Registry registre = LocateRegistry.createRegistry(port);
                Naming.rebind("//localhost:"+port+"/"+args[0], serveur);
	   }catch(Exception e ) {
		   e.printStackTrace();
	   }
    }
}
