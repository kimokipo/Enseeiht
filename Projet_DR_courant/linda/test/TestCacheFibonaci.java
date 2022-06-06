package linda.test;
import java.util.Collection;

import linda.Linda;
import linda.Tuple;
import linda.shm.CentralizedLinda;

public class TestCacheFibonaci {
    public static void main(String args[]) {
        long start = System.nanoTime();
        if (args.length == 0) {
            System.err.println("Give the number N of reads");
            return;
    	}
       // final Linda linda = new linda.shm.CentralizedLinda();
        final Linda linda = new linda.server.LindaClient("//localhost:4000/kamal");
                
        int n = Integer.parseInt(args[0]);
        if (n <2){
            System.out.println("Resultat:" + 1);
        }else{
            Thread thread = new Thread(){
                public void run(){
                        Tuple t = new Tuple(1);
                        linda.write(t);
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
            Thread t = new Thread(){
                public void run(){
                        
                    for(int i=2; i<=n; i++){
                            Tuple tu1 = linda.take(new Tuple(Integer.class));
                            Tuple tu2 = linda.read(new Tuple(Integer.class));
                            Tuple motif = new Tuple((Integer) tu1.get(0)+(Integer) tu2.get(0));
                            linda.write(motif);
                            System.out.println("Resultat:" + motif);

                        
                    }
                }
            };
            t.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        

        long end = System.nanoTime();
        System.out.println("temps en ms : "+(end - start)/1000000);

    }
    
}
