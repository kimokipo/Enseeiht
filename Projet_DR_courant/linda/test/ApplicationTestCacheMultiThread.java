package linda.test;
import java.util.Collection;

import linda.Linda;
import linda.Tuple;
import linda.shm.CentralizedLinda;

public class ApplicationTestCacheMultiThread {
    public static void main(String args[]) {


        if (args.length == 0) {
            System.err.println("Give the numbers L number of reads, R of clients reads, T of clients takes, and W of clients writes ");
            return;
    	}
       // final Linda linda = new linda.shm.CentralizedLinda();
                     
        int L = Integer.parseInt(args[0]);
        int R = Integer.parseInt(args[1]);        
        int T = Integer.parseInt(args[2]);        
        int W = Integer.parseInt(args[3]);

        long start = System.nanoTime();

        Thread[] tlR = new Thread[R];

        Thread[] tlT = new Thread[T];
        Thread[] tlW = new Thread[W];

        for(int i=1; i<=R; i++){
            final int j = i;
            Thread t = new Thread(){
                public void run(){
                    
                    Linda linda = new linda.server.LindaClient("//localhost:4000/kamal");
                    for (int k= 1; k <= L;k++){
                        Tuple motif1 = new Tuple(Integer.class, String.class);
                        Tuple tu1 = linda.read(motif1);
                        //System.out.println("Client read : "+j+" Resultat1:" + tu1);

                        Tuple motif2 = new Tuple(1, String.class);
                        Tuple tu2 = linda.read(motif2);
                        //System.out.println("Client read : "+j+" Resultat2:" + tu2);

                        Tuple motif3 = new Tuple(Integer.class, "a");
                        Tuple tu3 = linda.read(motif3);
                        //System.out.println("Client read : "+j+" Resultat3:" + tu3);

                        Tuple motif4 = new Tuple(2, "b");
                        Tuple tu4 = linda.read(motif4);
                        //System.out.println("Client read : "+j+" Resultat4:" + tu4);
                    } 

                }
            
            };
            tlR[i-1] = t;
            t.start();

        }

        for(int i=1; i<=T; i++){
            final int j = i;
            Thread t = new Thread(){
                public void run(){
                    
                    Linda linda = new linda.server.LindaClient("//localhost:4000/kamal");

                    Tuple motif1 = new Tuple(Integer.class, String.class);
                    Tuple tu1 = linda.take(motif1);
                    //System.out.println("Client take : "+j+" Resultat1:" + tu1);

                    Tuple motif2 = new Tuple(1, String.class);
                    Tuple tu2 = linda.take(motif2);
                    //System.out.println("Client take : "+j+" Resultat2:" + tu2);

                    Tuple motif3 = new Tuple(Integer.class, "a");
                    Tuple tu3 = linda.take(motif3);
                    //System.out.println("Client take : "+j+" Resultat3:" + tu3);

                    Tuple motif4 = new Tuple(2, "b");
                    Tuple tu4 = linda.take(motif4);
                    //System.out.println("Client take : "+j+" Resultat4:" + tu4);

                }
            
            };
            tlT[i-1] = t;
            t.start();

        }


        for(int i=1; i<=W; i++){
            final int j = i;
            Thread t = new Thread(){
                public void run(){
                    
                    Linda linda = new linda.server.LindaClient("//localhost:4000/kamal");

                    Tuple motif1 = new Tuple(1, "a");
                    linda.write(motif1);
                    //System.out.println("Client write : "+j+" tuple ecrit1:" + motif1);

                    Tuple motif2 = new Tuple(1, "b");
                    linda.write(motif2);
                    //System.out.println("Client write : "+j+" tuple ecrit2:" + motif2);

                    Tuple motif3 = new Tuple(2, "a");
                    linda.write(motif3);
                    //System.out.println("Client write : "+j+" tuple ecrit3:" + motif3);

                    Tuple motif4 = new Tuple(2, "b");
                    linda.write(motif4);
                    //System.out.println("Client write : "+j+" tuple ecrit4:" + motif4);

                }
            
            };
            tlW[i-1] = t;
            t.start();

        }

        for (int j=1; j<R; j++){
            try {
                tlR[j].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


        for (int j=1; j<T; j++){
            try {
                tlT[j].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        

        for (int j=1; j<W; j++){
            try {
                tlW[j].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        long end = System.nanoTime();
        //System.out.println("nombre L : "+L+", nombre R : "+ R+", nombre T : "+T+", nombre W : "+W+", temps en ms : "+(end - start)/1000000);
        System.out.println("t : "+(end - start)/1000000);

    }
    
}
