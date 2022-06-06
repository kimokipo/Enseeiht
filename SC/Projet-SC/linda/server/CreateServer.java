package linda.server;
import linda.server.Server;
import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import linda.Callback;
import linda.Linda;
import linda.Tuple;
import linda.shm.*;

public class CreateServer extends UnicastRemoteObject implements Server {

    private static final long serialVersionUID = 1L;

    private Linda maLinda;

    public CreateServer() throws RemoteException{
        maLinda = new CentralizedLinda();
    }
    
    private class MyCallback implements Callback {
        private MyCallBack myCallBack;
        public MyCallback(MyCallBack cb){
            this.myCallBack = cb;
        }
        public void call(Tuple t) {
            try{
                this.myCallBack.call(t);
            }catch (Exception e){
                e.printStackTrace();;
            }
        }
    }

    /** Adds a tuple t to the tuplespace. */
    public void write(Tuple t){
        new Thread() {  
            public void run() {
                maLinda.write(t);
            }
        }.start();
    }

    /** Returns a tuple matching the template and removes it from the tuplespace.
     * Blocks if no corresponding tuple is found. */
    public Tuple take(Tuple template){
        ExecutorService xs = Executors.newFixedThreadPool(1);
        Future<Tuple> resultat = xs.submit(new Callable<Tuple>() {  
            public Tuple call() {
                return maLinda.take(template);
            }
        });
        xs.shutdown();
        try{
            return resultat.get();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /** Returns a tuple matching the template and leaves it in the tuplespace.
     * Blocks if no corresponding tuple is found. */
    public Tuple read(Tuple template){
        ExecutorService xs = Executors.newFixedThreadPool(1);
        Future<Tuple> resultat = xs.submit(new Callable<Tuple>() {  
            public Tuple call() {
                return maLinda.read(template);
            }
        });
        xs.shutdown();
        try{
            return resultat.get();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /** Returns a tuple matching the template and removes it from the tuplespace.
     * Returns null if none found. */
    public Tuple tryTake(Tuple template){
        ExecutorService xs = Executors.newFixedThreadPool(1);
        Future<Tuple> resultat = xs.submit(new Callable<Tuple>() {  
            public Tuple call() {
                return maLinda.tryTake(template);
            }
        });
        xs.shutdown();
        try{
            return resultat.get();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /** Returns a tuple matching the template and leaves it in the tuplespace.
     * Returns null if none found. */
    public Tuple tryRead(Tuple template){
        ExecutorService xs = Executors.newFixedThreadPool(1);
        Future<Tuple> resultat = xs.submit(new Callable<Tuple>() {  
            public Tuple call() {
                return maLinda.tryRead(template);
            }
        });
        xs.shutdown();
        try{
            return resultat.get();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /** Returns all the tuples matching the template and removes them from the tuplespace.
     * Returns an empty collection if none found (never blocks).
     * Note: there is no atomicity or consistency constraints between takeAll and other methods;
     * for instance two concurrent takeAll with similar templates may split the tuples between the two results.
     */
    public Collection<Tuple> takeAll(Tuple template){
        ExecutorService xs = Executors.newFixedThreadPool(1);
        Future<Collection<Tuple>> resultat = xs.submit(new Callable<Collection<Tuple>>() {  
            public Collection<Tuple> call() {
                return maLinda.takeAll(template);
            }
        });
        xs.shutdown();
        try{
            return resultat.get();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<Tuple>();
    }

    /** Returns all the tuples matching the template and leaves them in the tuplespace.
     * Returns an empty collection if none found (never blocks).
     * Note: there is no atomicity or consistency constraints between readAll and other methods;
     * for instance (write([1]);write([2])) || readAll([?Integer]) may return only [2].
     */
    public Collection<Tuple> readAll(Tuple template){
        ExecutorService xs = Executors.newFixedThreadPool(1);
        Future<Collection<Tuple>> resultat = xs.submit(new Callable<Collection<Tuple>>() {  
            public Collection<Tuple> call() {
                return maLinda.readAll(template);
            }
        });
        xs.shutdown();
        try{
            return resultat.get();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<Tuple>();
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
    public void eventRegister(String mode, String timing, Tuple template, MyCallBack callback){
        Thread t = new Thread() {  
            public void run() {
                maLinda.eventRegister(Linda.eventMode.valueOf(mode), Linda.eventTiming.valueOf(timing),template,new MyCallback(callback));        
            }
        };
        t.start();
        try{
            t.join();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    /** To debug, prints any information it wants (e.g. the tuples in tuplespace or the registered callbacks), prefixed by <code>prefix</code. */
    public void debug(String prefix){
        Thread t = new Thread() {  
            public void run() {
                maLinda.debug(prefix);}
        };
        t.start();
        try{
            t.join();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main (String [] args){
        if (args.length != 1){
    		System.err.println("CreateServer nomServeur.");
    		return;
        }
        try{
        String URL = "//localhost:4000/"+args[0];
        System.out.println(URL);
        Registry registry = LocateRegistry.createRegistry(4000);
        Server serveur = new CreateServer();
        Naming.rebind(URL, serveur);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
