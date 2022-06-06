package linda.test;
import java.util.Collection;

import linda.Linda;
import linda.Tuple;
import linda.shm.CentralizedLinda;

public class TestCacheLotRead {
    public static void main(String args[]) {
        long start = System.nanoTime();
        if (args.length == 0) {
            System.err.println("Give the number N of reads");
            return;
    	}
       // final Linda linda = new linda.shm.CentralizedLinda();
        final Linda linda = new linda.server.LindaClient("//localhost:4000/kamal");
                
        int n = Integer.parseInt(args[0]);
        Thread thread = new Thread(){
            public void run(){
                    Tuple t = new Tuple(5);
                    linda.write(t);
            }
        };        
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Thread[] tl = new Thread[n];
        for(int i=1; i<=n; i++){
            
            Thread t = new Thread(){
                public void run(){
                    
                    Tuple tu = linda.tryRead(new Tuple(Integer.class));
                    System.out.println("Resultat:" + tu);

                }
            
            };
            tl[i-1] = t;
            t.start();

        }
        for (int j=1; j<n; j++){
            try {
                tl[j].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        

        long end = System.nanoTime();
        System.out.println("nombre de threads : "+n+", temps en ms : "+(end - start)/1000000);

    }
    
}
