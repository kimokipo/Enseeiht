package linda.test;

import linda.Tuple;

import java.util.Collection;

import linda.*;

public class BasicTestTakeAll {

    public static void main(String[] a) {
                
        final Linda linda = new linda.shm.CentralizedLinda();
        // final Linda linda = new linda.server.LindaClient("//localhost:4000/aaa");
                
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Tuple motif = new Tuple(Integer.class, Integer.class);
                //Collection<Tuple> res = linda.takeAll(motif);
               // System.out.println("(1) Resultat:" + res);
              //  linda.debug("(1)");
            }
        }.start();
                
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                Tuple t1 = new Tuple(4, 5);
                System.out.println("(2) write: " + t1);
                linda.write(t1);

                Tuple t11 = new Tuple(4, 5);
                System.out.println("(2) write: " + t11);
                linda.write(t11);

                Tuple motif = new Tuple(Integer.class, Integer.class);
                Collection<Tuple> res = linda.takeAll(motif);
                System.out.println("(2) TakeAll Resultat:" + res);

                Tuple t12 = new Tuple(4, 5);
                System.out.println("(2) write: " + t12);
                linda.write(t12);

                Tuple t2 = new Tuple("hello", 15);
                System.out.println("(2) write: " + t2);
                linda.write(t2);

                Tuple t3 = new Tuple(4, "foo");
                System.out.println("(2) write: " + t3);
                linda.write(t3);


                             
                linda.debug("(2)");
      
            }
        }.start();
                
    }
}
