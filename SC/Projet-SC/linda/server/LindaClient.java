package linda.server;

import java.rmi.Naming;

import java.util.*;
import linda.Callback;
import linda.Linda;
import linda.Tuple;

/** Client part of a client/server implementation of Linda.
 * It implements the Linda interface and propagates everything to the server it is connected to.
 * */
public class LindaClient implements Linda {
	
    private Server server; 
    /** Initializes the Linda implementation.
     *  @param serverURI the URI of the server, e.g. "rmi://localhost:4000/LindaServer" or "//localhost:4000/LindaServer".
     */
    public LindaClient(String serverURI) {
        try{
            this.server = (Server) Naming.lookup(serverURI);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    /** Adds a tuple t to the tuplespace. */
    public void write(Tuple t){
        try{
            System.out.println(t.toString());
            server.write(t.deepclone());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /** Returns a tuple matching the template and removes it from the tuplespace.
     * Blocks if no corresponding tuple is found. */
    public Tuple take(Tuple template){
        try{
        return server.take(template);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /** Returns a tuple matching the template and leaves it in the tuplespace.
     * Blocks if no corresponding tuple is found. */
    public Tuple read(Tuple template){
        try{
        return server.read(template);
         }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /** Returns a tuple matching the template and removes it from the tuplespace.
     * Returns null if none found. */
    public Tuple tryTake(Tuple template){
        try{
            return server.tryTake(template);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /** Returns a tuple matching the template and leaves it in the tuplespace.
     * Returns null if none found. */
    public Tuple tryRead(Tuple template){
        try{
        return server.tryRead(template);
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
       try{
        return server.takeAll(template);
    }catch (Exception e){
        e.printStackTrace();
    }
    return null;
    }

    /** Returns all the tuples matching the template and leaves them in the tuplespace.
     * Returns an empty collection if none found (never blocks).
     * Note: there is no atomicity or consistency constraints between readAll and other methods;
     * for instance (write([1]);write([2])) || readAll([?Integer]) may return only [2].
     */
    public Collection<Tuple> readAll(Tuple template){
        try{
            return server.readAll(template);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
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
    public void eventRegister(eventMode mode, eventTiming timing, Tuple template, Callback callback){
        try{
            MyCallBack mycallback = new CallbackImpl(callback);
            server.eventRegister(mode.toString(),timing.toString(), template,mycallback);
        }catch (Exception e){
            e.printStackTrace();
        }
   }
    /** To debug, prints any information it wants (e.g. the tuples in tuplespace or the registered callbacks), prefixed by <code>prefix</code. */
    public void debug(String prefix){
        try{
            server.debug(prefix);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}