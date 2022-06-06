package linda.shm;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import linda.Callback;
import linda.Linda;
import linda.Tuple;

/** Shared memory implementation of Linda. */
public class CentralizedLinda_Kamal implements Linda {

	private ArrayList<Tuple> listeOftyples;
    private ReentrantLock mon_moniteur;
    private Semaphore mutex;
    private Condition Attente ;
    private HashMap<Tuple,LinkedList<String>> FileDemandeurs;
    private HashMap<Tuple,HashMap<Callback,AbstractMap.SimpleEntry<eventMode, eventTiming>>> Liste_Callback;

    public CentralizedLinda_Kamal() {
        listeOftyples = new ArrayList<Tuple>();
        FileDemandeurs = new HashMap<Tuple,LinkedList<String>>();
        Liste_Callback = new HashMap<Tuple,HashMap<Callback,AbstractMap.SimpleEntry<eventMode, eventTiming>>>();
        mon_moniteur = new java.util.concurrent.locks.ReentrantLock();
        mutex = new Semaphore(1);
        Attente = mon_moniteur.newCondition();
    }
    
    private HashMap<Tuple,HashMap<Callback,AbstractMap.SimpleEntry<eventMode, eventTiming>>> creerCopie (HashMap<Tuple,HashMap<Callback,AbstractMap.SimpleEntry<eventMode, eventTiming>>> origin){
        HashMap<Tuple,HashMap<Callback,AbstractMap.SimpleEntry<eventMode, eventTiming>>> copie = new HashMap<Tuple,HashMap<Callback,AbstractMap.SimpleEntry<eventMode, eventTiming>>>();
        try{
            mutex.acquire();
        for (Map.Entry<Tuple,HashMap<Callback,AbstractMap.SimpleEntry<eventMode,eventTiming>>> entry : origin.entrySet()){
            Tuple template = entry.getKey();
            HashMap<Callback,AbstractMap.SimpleEntry<eventMode,eventTiming>> liste = entry.getValue();
            HashMap<Callback,AbstractMap.SimpleEntry<eventMode,eventTiming>> liste_copie = new HashMap<Callback,AbstractMap.SimpleEntry<eventMode,eventTiming>>();
                for (Map.Entry<Callback,AbstractMap.SimpleEntry<eventMode,eventTiming>> e : liste.entrySet()){
                    Callback c = e.getKey();
                    AbstractMap.SimpleEntry<eventMode,eventTiming> modes = e.getValue();
                    eventMode Mode = modes.getKey();
                    eventTiming Timing = modes.getValue();
                    liste.put(c,new AbstractMap.SimpleEntry(Mode,Timing));
                }
                copie.put(template,liste_copie);
        }
        mutex.release();
    }catch(Exception e){
        e.printStackTrace();
    }
        return copie;
    }

    /** Adds a tuple t to the tuplespace. */
    public void write(Tuple t){
        mon_moniteur.lock();
        listeOftyples.add(t);
        Attente.signalAll();
        mon_moniteur.unlock();
        new Thread() {
            public void run() {
                HashMap<Tuple,HashMap<Callback,AbstractMap.SimpleEntry<eventMode, eventTiming>>> liste_callback_local = creerCopie(Liste_Callback);
            for (Map.Entry<Tuple,HashMap<Callback,AbstractMap.SimpleEntry<eventMode,eventTiming>>> entry : liste_callback_local.entrySet()){
                Tuple template = entry.getKey();
                HashMap<Callback,AbstractMap.SimpleEntry<eventMode,eventTiming>> liste = entry.getValue();
                if (t.matches(template)){
                    for (Map.Entry<Callback,AbstractMap.SimpleEntry<eventMode,eventTiming>> e : liste.entrySet()){
                        Callback c = e.getKey();
                        AbstractMap.SimpleEntry<eventMode,eventTiming> modes = e.getValue();
                        eventMode Mode = modes.getKey();
                        eventTiming Timing = modes.getValue();
                        if (Mode == eventMode.READ){
                            if (Timing == eventTiming.FUTURE){
                                c.call(read(template));
                            }else{
                                c.call(tryRead(template));
                            }
                        }else{
                            if (Timing == eventTiming.FUTURE){
                                c.call(take(template));
                            }else{
                                c.call(tryTake(template));
                            }
                        }
                    }
                }
            }
        }
    }.start();
    }

    /** Returns a tuple matching the template and removes it from the tuplespace.
     * Blocks if no corresponding tuple is found. */
    public Tuple take(Tuple template){
        try {
            mon_moniteur.lock();
            String nomThreadCourant = Thread.currentThread().toString();

            LinkedList<String> list_noms = FileDemandeurs.get(template);
            if (list_noms == null) {
                list_noms = new LinkedList<String>();
            }
            list_noms.add(nomThreadCourant);
            FileDemandeurs.put(template,list_noms);
            Tuple resultat = null;
            while (!FileDemandeurs.get(template).getFirst().equals(nomThreadCourant) || (resultat = chercher(template)) == null ) {
                Attente.await();
            }
            FileDemandeurs.get(template).removeFirst();
            listeOftyples.remove(resultat);
            Attente.signalAll();
            mon_moniteur.unlock();
            return resultat;
        }catch (Exception e){
            e.printStackTrace();;
        }
        return null;
    }

    private Tuple chercher(Tuple template){
        for (Tuple t : listeOftyples){
            if (t.matches(template)){
                return t;
            }
        }
        return null;
    }

    private ArrayList<Tuple> chercherAll(Tuple template){
        ArrayList<Tuple> resultat = new ArrayList<Tuple>();
        for (Tuple t : listeOftyples){
            if (t.matches(template)){
                resultat.add(t);
            }
        }
        return resultat;
    }

    /** Returns a tuple matching the template and leaves it in the tuplespace.
     * Blocks if no corresponding tuple is found. */
    public Tuple read(Tuple template){
        try{
            mon_moniteur.lock();
        String nomThreadCourant = Thread.currentThread().toString();

        LinkedList<String> list_noms = FileDemandeurs.get(template);
        if (list_noms == null) {
            list_noms = new LinkedList<String>();
        }
        list_noms.add(nomThreadCourant);
        FileDemandeurs.put(template,list_noms);
        Tuple resultat = null;
        while (!FileDemandeurs.get(template).getFirst().equals(nomThreadCourant) || (resultat = chercher(template)) == null ) {
            Attente.await();
        }
        FileDemandeurs.get(template).removeFirst();
        Attente.signalAll();
        mon_moniteur.unlock();
        return resultat;
    }catch (Exception e){
        e.printStackTrace();;
    }
    return null;
    }


    /** Returns a tuple matching the template and removes it from the tuplespace.
     * Returns null if none found. */
    public Tuple tryTake(Tuple template){
        mon_moniteur.lock();
        String nomThreadCourant = Thread.currentThread().toString();

        LinkedList<String> list_noms = FileDemandeurs.get(template);
        if (list_noms == null) {
            list_noms = new LinkedList<String>();
        }
        list_noms.add(nomThreadCourant);
        FileDemandeurs.put(template,list_noms);
        Tuple resultat = null;
        if (FileDemandeurs.get(template).getFirst().equals(nomThreadCourant) && (resultat = chercher(template)) != null ) {
            FileDemandeurs.get(template).removeFirst();
            listeOftyples.remove(resultat);
        }
        mon_moniteur.unlock();
        return resultat;
    }

    /** Returns a tuple matching the template and leaves it in the tuplespace.
     * Returns null if none found. */
    public Tuple tryRead(Tuple template){
        mon_moniteur.lock();
        String nomThreadCourant = Thread.currentThread().toString();

        LinkedList<String> list_noms = FileDemandeurs.get(template);
        if (list_noms == null) {
            list_noms = new LinkedList<String>();
        }
        list_noms.add(nomThreadCourant);
        FileDemandeurs.put(template,list_noms);
        Tuple resultat = null;
        if (FileDemandeurs.get(template).getFirst().equals(nomThreadCourant) && (resultat = chercher(template)) != null ) {
            FileDemandeurs.get(template).removeFirst();
        }
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
        String nomThreadCourant = Thread.currentThread().toString();

        LinkedList<String> list_noms = FileDemandeurs.get(template);
        if (list_noms == null) {
            list_noms = new LinkedList<String>();
        }
        list_noms.add(nomThreadCourant);
        FileDemandeurs.put(template,list_noms);
        ArrayList<Tuple> resultat = null;
        while (!FileDemandeurs.get(template).getFirst().equals(nomThreadCourant) || (resultat = chercherAll(template)).size() == 0 ) {
            Attente.await();
        }
        FileDemandeurs.get(template).removeFirst();
        for (Tuple t : resultat){
            listeOftyples.remove(t);
        }
        Attente.signalAll();
        mon_moniteur.unlock();
        return resultat;
    }catch (Exception e){
        e.printStackTrace();;
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
        String nomThreadCourant = Thread.currentThread().toString();

        LinkedList<String> list_noms = FileDemandeurs.get(template);
        if (list_noms == null) {
            list_noms = new LinkedList<String>();
        }
        list_noms.add(nomThreadCourant);
        FileDemandeurs.put(template,list_noms);
        ArrayList<Tuple> resultat = null;
        while (!FileDemandeurs.get(template).getFirst().equals(nomThreadCourant) || (resultat = chercherAll(template)).size() == 0 ) {
            Attente.await();
        }
        FileDemandeurs.get(template).removeFirst();
        Attente.signalAll();
        mon_moniteur.unlock();
        return resultat;
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
            mutex.acquire();
        HashMap<Callback,AbstractMap.SimpleEntry<eventMode,eventTiming>> list_callback_modes = Liste_Callback.get(template);
        if (list_callback_modes == null) {
            list_callback_modes = new HashMap<Callback,AbstractMap.SimpleEntry<eventMode,eventTiming>>();
        }
        list_callback_modes.put(callback,new AbstractMap.SimpleEntry(mode,timing));
        Liste_Callback.put(template,list_callback_modes);
        mutex.release();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /** To debug, prints any information it wants (e.g. the tuples in tuplespace or the registered callbacks), prefixed by <code>prefix</code. */
    public void debug(String prefix){}

}
