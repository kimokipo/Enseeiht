package linda.nombrepremiers;
import java.util.Collection;

import linda.Linda;
import linda.Tuple;
import linda.shm.CentralizedLinda;

public class ErastoLinda {
    public static void main(String args[]) {
        if (args.length == 0) {
            System.err.println("Give the number N");
            return;
    	}
       // final Linda linda = new linda.shm.CentralizedLinda();
        final Linda linda = new linda.server.LindaClient("//localhost:4000/aaa");
                
        int n = Integer.parseInt(args[0]);
        Thread thread = new Thread(){
            public void run(){
                for(int i=2; i<=n; i++){
                    Tuple t = new Tuple(i);
                    linda.write(t);
                }
                System.out.println("Thread Running");
            }
        };        
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int x = (int) Math.sqrt(n);
        Thread[] tl = new Thread[x];
        for(int i=2; i<=x; i++){
            
            final int it = i;
            Thread t = new Thread(){
                public void run(){
                    
                    Tuple tu = linda.tryRead(new Tuple(it));
                    int k = it;
                    if (tu != null){
                        if (k*k < n){
                            for (int j=k*k ;j<n; j= j+k){
                                linda.tryTake(new Tuple(j));
                            }
                        } else if(k*k ==n){
                            linda.tryTake(new Tuple(k*k));
                        }
                            
                    }

                    

                    
                }
            
            };
            tl[i-1] = t;
            t.start();

        }
        for (int j=1; j<x; j++){
            try {
                tl[j].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Collection<Tuple> ct = linda.readAll(new Tuple(Integer.class));
        System.out.println(ct);
        

        


    }
    
}
