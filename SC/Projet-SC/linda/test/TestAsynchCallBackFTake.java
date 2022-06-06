
package linda.test;

import linda.*;
import linda.Linda.eventMode;
import linda.Linda.eventTiming;

public class TestAsynchCallBackFTake {

    private static Linda linda;
    private static Tuple cbmotif;
    
    private static class MyCallback implements Callback {
        private int id;
        public MyCallback(int i){
            id = i;
        }
        public void call(Tuple t) {
            System.out.println("CB "+id+" got "+t);
            linda.eventRegister(eventMode.TAKE, eventTiming.FUTURE, cbmotif, this);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("CB "+id+" done with "+t);
        }
    }

    public static void main(String[] a) {
        linda = new linda.shm.CentralizedLinda();
        // linda = new linda.server.LindaClient("//localhost:4000/toto");

        
        cbmotif = new Tuple(Integer.class, String.class);

        for (int i = 1; i <= 3; i++) {
            final int j = i;
            new Thread() {  
                public void run() {
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    linda.eventRegister(eventMode.TAKE, eventTiming.FUTURE, cbmotif, new AsynchronousCallback (new MyCallback(j)));    
                    linda.debug("("+j+")");
                }
            }.start();
        }

        Tuple t1 = new Tuple(4, 5);
        System.out.println("(4) write: " + t1);
        linda.write(t1);

        Tuple t2 = new Tuple("hello", 15);
        System.out.println("(4) write: " + t2);
        linda.write(t2);
        linda.debug("(4)");

        Tuple t3 = new Tuple(4, "foo");
        System.out.println("(4) write: " + t3);
        linda.write(t3);

        linda.debug("(4)");

    }

}
