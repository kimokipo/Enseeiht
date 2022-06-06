import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecuterUneCommandeShellRuntimeExec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Process processus = Runtime.getRuntime().exec("node ../../adherer.js"); 
			
			StringBuilder resultat = new StringBuilder(); 
			
			BufferedReader lecteur = new BufferedReader(new InputStreamReader(processus.getInputStream())); 
			
			String ligne;
			
			while ((ligne = lecteur.readLine()) != null) {
				resultat.append(ligne + "\n"); 
			}
			
			int valeurDeSortie = processus.waitFor();
			if (valeurDeSortie == 0) {
				System.out.println("Success!");
				System.out.println(resultat); 
				System.exit(0);
			} else {
				System.out.println("Quelquechose de pas normal s'es produit :( "); 
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
