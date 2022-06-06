package linda.search.basic;

import java.util.UUID;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Paths;
import linda.*;

public class Manager implements Runnable {

    private Linda linda;
    private int k;
    private int p;

    private UUID reqUUID;
    private String pathname;
    private String search;
    private int bestvalue = Integer.MAX_VALUE; // lower is better
    private String bestresult;

    public Manager(Linda linda, String pathname, String search, int k, int p) {
        this.linda = linda;
        this.pathname = pathname;
        this.search = search;
        this.k = k;
        this.p = p;
    }

    private void addSearch(String search) {
        this.search = search;
        this.reqUUID = UUID.randomUUID();
        System.out.println("Search " + this.reqUUID + " for " + this.search);
        linda.eventRegister(Linda.eventMode.TAKE, Linda.eventTiming.IMMEDIATE, new Tuple(Code.Result, this.reqUUID, String.class, Integer.class), new CbGetResult());
        linda.write(new Tuple(Code.Request, this.reqUUID, this.search,this.k));
    }

    private void loadData(String pathname) {
        try (Stream<String> stream = Files.lines(Paths.get(pathname))) {
            if (this.p ==0){
                stream.limit(2000).forEach(s -> linda.write(new Tuple(Code.Value, s.trim())));
            } else{
                stream.skip(p*2000).limit(2000).forEach(s -> linda.write(new Tuple(Code.Value, s.trim())));
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void waitForEndSearch() {
        Tuple t = linda.take(new Tuple(Code.Searcher, "done",Integer.class, this.reqUUID));
        int j = (Integer) t.get(2);

        linda.take(new Tuple(Code.Request, this.reqUUID, String.class)); // remove query
        System.out.println("query done by "+ j);
    }

    private class CbGetResult implements linda.Callback {
        public void call(Tuple t) {  // [ Result, ?UUID, ?String, ?Integer ]
            String s = (String) t.get(2);
            Integer v = (Integer) t.get(3);
            if (v < bestvalue) {
                bestvalue = v;
                bestresult = s;
                System.out.println("New best (" + bestvalue + "): \"" + bestresult + "\"");
            }
            linda.eventRegister(Linda.eventMode.TAKE, Linda.eventTiming.IMMEDIATE, new Tuple(Code.Result, reqUUID, String.class, Integer.class), this);
        }
    }

    public void run() {
        this.loadData(pathname);
        this.addSearch(search);
        this.waitForEndSearch();
    }
}
