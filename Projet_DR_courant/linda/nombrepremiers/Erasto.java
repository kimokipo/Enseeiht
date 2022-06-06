package linda.nombrepremiers;

import java.util.ArrayList;

public class Erasto {
    public static void main(String args[]) {
        if (args.length == 0) {
            System.err.println("Give the number N");
            return;
    	}
        int n = Integer.parseInt(args[0]);
        boolean[] l = new boolean[n];
        for (int i=0; i<n; i++){
            l[i] = true;
        }
        l[0] = false;
        for (int i=1; i<n; i++){
            if (l[i]){
                int p = (i+1)*(i+1);
                if (p<=n){
                    for (int j= (i+1)*(i+1)-1 ; j<n ; j=j+i+1){
                        l[j] = false;
                    }
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<n; i++){
            if (l[i]){
                list.add(i+1);
            }
        }
        System.out.println(list);

    }
    
}
