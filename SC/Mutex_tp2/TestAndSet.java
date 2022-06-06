import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
public class TestAndSet {

    static AtomicBoolean occupe = new AtomicBoolean();
    static ArrayList<Thread> activites = new ArrayList<Thread>();
    static Object mutex = new Object();

    public static void main(String[] args) {
    	
    	int N = 2; //Nombre de processus
    	if (args.length == 1){
    		try {
    			N = Integer.parseInt (args[0]);
    		}
		catch (NumberFormatException nfx) {
                	System.out.println("Usage : TestAndSet <Nb activités> ,"
                                   +"avec Nb activités >= 1");
                	System.exit (1);
            	}
            	if (N < 1){
            		System.out.println("Usage : TestAndSet <Nb activités> ,"
                                   +"avec Nb activités >= 1");
                	System.exit (1);
           	}
        }
        for (int i = 0; i<N; i++){
        	activites.add(new Thread(new Proc(),""+i));
     	 }
     	 for (int i = 0; i<N; i++){
        	activites.get(i).start();
     	 }
     	 float départ = System.nanoTime();
     	 for (int i = 0; i<N; i++){
     	     try {
                activites.get(i).join();
            }
            catch (InterruptedException e)
            {
                System.out.println(e);
            }
     	 }
        float fin = System.nanoTime();
        System.out.println("Durée exécution TestAndSet (ms): " + (fin-départ)/1000000L);
    }
}

class Proc implements Runnable {
    public void run() {
     int id =  Integer.parseInt(Thread.currentThread().getName());
        //for ( ; ; ) {
            System.out.println("Thread " + id + " attend SC des autres");
            entrer();
            System.out.println("Thread " + Thread.currentThread().getName() + " en SC ");
            sortir();
            System.out.println("Thread " + Thread.currentThread().getName() + " hors SC ");
        //}
    }

    void entrer() {	
        synchronized (Peterson.mutex) {	
        	while (TestAndSet.occupe.getAndSet(true)) {
        	    ;//System.out.println(".."+id+"..");
        	}
        }
    }

    void sortir() {
        TestAndSet.occupe.set(false);
    }
}
