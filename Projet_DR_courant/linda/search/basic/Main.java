package linda.search.basic;

import linda.*;

public class Main {

    public static void main(String args[]) {
    	if (args.length != 2) {
            System.err.println("linda.search.basic.Main search file.");
            return;
    	}
        //Linda linda = new linda.shm.CentralizedLinda();
        final Linda linda = new linda.server.LindaClient("//localhost:4000/aaa");
        Thread[] h = new Thread[10];
        for(int i=0; i<5; i++){
                Manager manager = new Manager(linda, args[1], args[0],i,i);
                Thread m = (new Thread(manager));                
                Searcher searcher = new Searcher(linda,i);
                Thread s = (new Thread(searcher));
                h[i] = m;
                h[5+i] = s;
                m.start();
                s.start();
                
        
        }
        for (int j=0; j<5; j++){
            try{
                h[j].join();  h[j+5].join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        
        
    }
}
