import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class executer_test {
    public static void main(String args[]) {


        if (args.length == 0) {
            System.err.println("Give the numbers L number of reads, R of clients reads, T of clients takes, and W of clients writes ");
            return;
    	}
                     
        int L = Integer.parseInt(args[0]);
        int R = Integer.parseInt(args[1]);        
        int T = Integer.parseInt(args[2]);        
        int W = Integer.parseInt(args[3]);
        String result = "";
        
        
    for (int l = 1; l<=L;l++){
        
        Process processus1 = null;
        try{
            processus1 = Runtime.getRuntime().exec("java linda.server.CreateServer kamal 4000"); 
        }catch(Exception e){
            e.printStackTrace();
        }	
        Process processus2 = null;
        
        try{
            try {
                    Thread.sleep(3);
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
            processus2 = Runtime.getRuntime().exec("java linda.test.ApplicationTestCacheMultiThread "+l+" "+R+" "+T+" "+W); 
        
        
            StringBuilder resultat = new StringBuilder(); 
					    
		    BufferedReader lecteur = new BufferedReader(new InputStreamReader(processus2.getInputStream())); 
					    
		    String ligne;
					    
		    while (((ligne = lecteur.readLine()) != null)  && (!ligne.contains("t :"))) {
						    //System.out.println(ligne); 
		    }
		    //System.out.println(ligne);
		    if ( ligne.contains("t :") ) {
		                    //System.out.println("destroy");
		                    result = result + " "+ligne.substring(4);
						    processus2.destroy();
                            processus1.destroy();
		    }
		}catch(Exception e){
            e.printStackTrace();
        }	
    } 
    System.out.println(result);

    }
    
}

