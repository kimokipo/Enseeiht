package linda.shm;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.*;

import linda.Callback;
import linda.Linda;
import linda.Tuple;

/** Shared memory implementation of Linda. */
public class CentralizedLinda implements Linda {
    private ReentrantLock mon_moniteur;

	private ArrayList<Tuple> listeOftyples;
    private HashMap<Tuple,Condition>  liste_Conditions_Take;
    private HashMap<Tuple,Condition>  liste_Conditions_Read;
    private HashMap<Tuple,HashMap<Callback,eventMode>> liste_callbacks_future;

    public CentralizedLinda() {
        listeOftyples = new ArrayList<Tuple>();
        this.mon_moniteur = new ReentrantLock();
        this.liste_Conditions_Take = new HashMap<Tuple,Condition>();
        this.liste_Conditions_Read = new HashMap<Tuple,Condition>();
        this.liste_callbacks_future = new HashMap<Tuple,HashMap<Callback,eventMode>>();
    }
    
    /** Adds a tuple t to the tuplespace. */
    public void write(Tuple t){
        mon_moniteur.lock();
        listeOftyples.add(t);
        for (Map.Entry<Tuple,Condition> e : liste_Conditions_Take.entrySet()){
            if (t.matches(e.getKey())){
                e.getValue().signal();
            }
        }
        for (Map.Entry<Tuple,Condition> e : liste_Conditions_Read.entrySet()){
            if (t.matches(e.getKey())){
                e.getValue().signalAll();
            }
        }

        HashMap<Tuple,ArrayList<Callback>> liste_remove = new HashMap<Tuple,ArrayList<Callback>>();

        for (Map.Entry<Tuple,HashMap<Callback,eventMode>> e : liste_callbacks_future.entrySet()){
            if (t.matches(e.getKey())){
                HashMap<Callback,eventMode> liste = e.getValue();
                ArrayList<Callback> liste_callback_local = new ArrayList<Callback>();
                for (Map.Entry<Callback,eventMode> c : liste.entrySet()){
                    if (c.getValue()== eventMode.READ ){
                        c.getKey().call(t);
                        liste_callback_local.add(c.getKey());
                    }else if (c.getValue() == eventMode.TAKE){
                        if (listeOftyples.contains(t)){
                            listeOftyples.remove(t);
                            c.getKey().call(t);
                        }
                        liste_callback_local.add(c.getKey());
                    }   
                }
                liste_remove.put(e.getKey(),liste_callback_local);
            }
        }

        for (Map.Entry<Tuple,ArrayList<Callback>> e : liste_remove.entrySet()){
            liste_callbacks_future.get(e.getKey()).remove(e.getValue());
        }
        mon_moniteur.unlock();
    }

    public Tuple chercher(Tuple template){
        for (Tuple t : listeOftyples){
                        if (t.matches(template)){
                            return t;
                        }
                    }
        return null;
    }

    public ArrayList<Tuple> chercherAll(Tuple template){
        ArrayList<Tuple> resultat = new ArrayList<Tuple>();
        for (Tuple t : listeOftyples){
                        if (t.matches(template)){
                            resultat.add(t);
                        }
                    }
        return resultat;
    }

    /** Returns a tuple matching the template and removes it from the tuplespace.
     * Blocks if no corresponding tuple is found. */
    public Tuple take(Tuple template){
        try{
        mon_moniteur.lock();
            Condition attente = liste_Conditions_Take.get(template);
            if (attente == null){
                attente = mon_moniteur.newCondition();
                liste_Conditions_Take.put(template,attente);
            }
        
            Tuple resultat = null;
            while((resultat = chercher(template)) == null){
                attente.await();
            }
            listeOftyples.remove(resultat);
        mon_moniteur.unlock();
        return resultat;
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return null;
        
    }

    /** Returns a tuple matching the template and leaves it in the tuplespace.
     * Blocks if no corresponding tuple is found. */
    public Tuple read(Tuple template){
        try{
        mon_moniteur.lock();
            Condition attente = liste_Conditions_Read.get(template);
            if (attente == null){
                attente = mon_moniteur.newCondition();
                liste_Conditions_Read.put(template,attente);
            }
        
            Tuple resultat = null;
            while((resultat = chercher(template)) == null){
                attente.await();
            }
        mon_moniteur.unlock();
        return resultat;
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return null;
        
    }


    /** Returns a tuple matching the template and removes it from the tuplespace.
     * Returns null if none found. */
    public Tuple tryTake(Tuple template){
        mon_moniteur.lock();
        
            Tuple resultat = null;
            if((resultat = chercher(template)) != null){
                listeOftyples.remove(resultat);
            }
        mon_moniteur.unlock();
        return resultat;
    }

    /** Returns a tuple matching the template and leaves it in the tuplespace.
     * Returns null if none found. */
    public Tuple tryRead(Tuple template){
        mon_moniteur.lock();
        
            Tuple resultat = chercher(template);
            
        mon_moniteur.unlock();
        return resultat;
        
    }

    /** Returns all the tuples matching the template and removes them from the tuplespace.
     * Returns an empty collection if none found (never blocks).
     * Note: there is no atomicity or consistency constraints between takeAll and other methods;
     * for instance two concurrent takeAll with similar templates may split the tuples between the two results.
     */
    public Collection<Tuple> takeAll(Tuple template){
        try{
        mon_moniteur.lock();
            Condition attente = liste_Conditions_Take.get(template);
            if (attente == null){
                attente = mon_moniteur.newCondition();
                liste_Conditions_Take.put(template,attente);
            }
        
            ArrayList<Tuple> resultat = new ArrayList<Tuple>();
            while((resultat = chercherAll(template)).size() == 0){
                attente.await();
            }
            for (Tuple t: resultat){
                listeOftyples.remove(t);
            }
        mon_moniteur.unlock();
        return resultat;
        }catch(InterruptedException e){
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
        mon_moniteur.lock();
            Condition attente = liste_Conditions_Read.get(template);
            if (attente == null){
                attente = mon_moniteur.newCondition();
                liste_Conditions_Read.put(template,attente);
            }
        
            ArrayList<Tuple> resultat = new ArrayList<Tuple>();
            while((resultat = chercherAll(template)).size() == 0){
                attente.await();
            }
        mon_moniteur.unlock();
        return resultat;
        }catch(InterruptedException e){
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
        mon_moniteur.lock();
        if (timing == eventTiming.FUTURE){
            HashMap<Callback,eventMode> liste = liste_callbacks_future.get(template);
            if (liste == null) {
                liste = new HashMap<Callback,eventMode>();
            }
            liste.put(callback,mode);
            liste_callbacks_future.put(template,liste);
        }else{
            Tuple resultat = chercher(template);
            if (resultat != null){
                if (mode == eventMode.READ){
                    callback.call(resultat);
                }else{
                    listeOftyples.remove(resultat);
                    callback.call(resultat);
                }
            }
        }
        mon_moniteur.unlock();
    }

    /** To debug, prints any information it wants (e.g. the tuples in tuplespace or the registered callbacks), prefixed by <code>prefix</code. */
    public void debug(String prefix){
        System.out.println(prefix);
        System.out.println("liste des tuples en tuplespace: ");
        if (listeOftyples.size()!= 0){ 
            for (Tuple t : listeOftyples){
                System.out.println(t);
            }
        }
        System.out.println("liste des rappels: ");
        for (Map.Entry<Tuple,HashMap<Callback,eventMode>> e : liste_callbacks_future.entrySet()){
            System.out.println("tuple "+e.getKey()+":");
            HashMap<Callback,eventMode> s = e.getValue();
            for(Map.Entry<Callback,eventMode> t : s.entrySet()){
                System.out.println(t.getKey());
            }
        }
        
    }

}
