package allumettes;
import java.util.InputMismatchException;

public class StrategieHumain implements Strategie {
	private String nomJoueur;
	public StrategieHumain(String nomJoueur){
		this.nomJoueur = nomJoueur;
 	}
	public int getPrise(Jeu jeu) throws CoupInvalideException, OperationInterditException{
		int PRISE_MAX = Jeu.PRISE_MAX;
			boolean reussi = false;
			int prise =0;
			do{
				try{
					System.out.print(this.nomJoueur + ", combien d'allumettes ? ");
					
					String tricher = scanner.nextLine();
					if (tricher.equals("triche")){
						jeu.retirer(1);
						System.out.println("[Une allumette en moins, plus que " + jeu.getNombreAllumettes() + ". Chut !]");
					}else{
						prise = Integer.parseInt(tricher);
						reussi = true;
					}
				}catch(NumberFormatException e){
					System.out.println("Vous devez donner un entier.");
				}
			}while (!reussi);
			return prise;
	}
}
