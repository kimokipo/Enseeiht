package linda.test;

import linda.*;

public class TestCache3 {

    public static void main(String[] a) {
        //final Linda linda = new linda.shm.CentralizedLinda();
                      final Linda linda = new linda.server.LindaClient("//localhost:4000/kamal");
        new Thread() {
            public void run() {   
                for (int i = 1; i <= 3; i++) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Tuple motif = new Tuple(Integer.class, String.class);
                    Tuple res = linda.read(motif);
                    System.out.println("Resultat Read:" + res);
                    linda.debug("("+i+")");
                }  
            }
        }.start();
                
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Tuple t1 = new Tuple(4, 5);
                System.out.println("(0) write: " + t1);
                linda.write(t1);

                Tuple t2 = new Tuple("hello", 15);
                System.out.println("(0) write: " + t2);
                linda.write(t2);


                Tuple t3 = new Tuple(4, "foo");
                System.out.println("(0) write: " + t3);
                linda.write(t3);


                Tuple t4 = new Tuple(5, "foo");
                System.out.println("(0) write: " + t4);
                linda.write(t4);
                                
                //linda.debug("(0)");

            }
        }.start();

           
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Tuple motif = new Tuple(4, "foo");
                Tuple res = linda.take(motif);
                System.out.println("Resultat Take:" + res);
            }
        }.start();
                
    }
}
