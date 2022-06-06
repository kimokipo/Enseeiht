public class Peterson {

    static int tour = 0;
    static boolean [] demande = {false,false};
    static Object mutex = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Proc(),"1");
        Thread t2 = new Thread(new Proc(),"0");
        float départ = System.nanoTime();
        t1.start(); 
        t2.start(); 
        try {
                t1.join();
            }
            catch (InterruptedException e)
            {
                System.out.println(e);
            }
        try {
                t2.join();
            }
            catch (InterruptedException e)
            {
                System.out.println(e);
            }
        float fin = System.nanoTime();
        System.out.println("Durée exécution Peterson (ms): " + (fin-départ)/1000000L);
    }
}

class Proc implements Runnable {
	int id, di;
    public void run() {
     id =  Integer.parseInt(Thread.currentThread().getName());
     di = (id+1) % 2;
        for ( ; ; ) {
            System.out.println("Thread " + id + " attend SC " + di);
            entrer();
            System.out.println("Thread " + Thread.currentThread().getName() + " en SC ");
            sortir();
            System.out.println("Thread " + Thread.currentThread().getName() + " hors SC ");
        }
    }

    void entrer() {
        Peterson.demande[id] = true;
        Peterson.tour = di ;
        synchronized (Peterson.mutex) {	
        	while ((Peterson.tour != id) && (Peterson.demande[di])) {
        	    ;//System.out.println(".."+id+"..");
        	}
      	}
    }

    void sortir() {
        Peterson.demande[id] =false;
    }
}
