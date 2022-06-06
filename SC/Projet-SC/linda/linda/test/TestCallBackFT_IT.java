
package linda.test;

import org.w3c.dom.events.Event;

import linda.*;
import linda.Linda.eventMode;
import linda.Linda.eventTiming;

public class TestCallBackFT_IT {

    private static Linda linda;
    private static Tuple cbmotif;
    
    private static class MyCallback implements Callback {
        private int id;
        private eventMode mode;
        private eventTiming timing;
        public MyCallback(int i,eventMode mode, eventTiming timing){
            id = i;
            this.mode = mode;
            this.timing = timing;
        }
        public void call(Tuple t) {
            System.out.println("CB "+id+" got "+t);
            linda.eventRegister(mode, timing, cbmotif, this);
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
            new Thread() {  
                public void run() {
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    linda.eventRegister(eventMode.TAKE, eventTiming.FUTURE, cbmotif, new MyCallback(1,eventMode.TAKE,eventTiming.FUTURE));    
                    linda.debug("(1)");
                }
            }.start();

            new Thread() {  
                public void run() {
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    linda.eventRegister(eventMode.TAKE, eventTiming.IMMEDIATE, cbmotif, new MyCallback(2,eventMode.TAKE,eventTiming.IMMEDIATE));    
                    linda.debug("(2)");
                }
            }.start();
        

        Tuple t1 = new Tuple(4, 5);
        System.out.println("(3) write: " + t1);
        linda.write(t1);

        Tuple t2 = new Tuple("hello", 15);
        System.out.println("(3) write: " + t2);
        linda.write(t2);
        linda.debug("(3)");

        Tuple t3 = new Tuple(4, "foo");
        System.out.println("(3) write: " + t3);
        linda.write(t3);

        linda.debug("(3)");

    }

}
