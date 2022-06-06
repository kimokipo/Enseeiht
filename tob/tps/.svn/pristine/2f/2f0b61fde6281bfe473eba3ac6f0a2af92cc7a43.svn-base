package allumettes;
import java.util.InputMismatchException;

public class StrategieTricheur implements Strategie {
	private String nomJoueur;
	public StrategieTricheur(String nomJoueur){
		this.nomJoueur = nomJoueur;
 	}
	public int getPrise(Jeu jeu) throws CoupInvalideException, OperationInterditException{
		int PRISE_MAX = Jeu.PRISE_MAX;
			System.out.println("[Je triche ...]");
			int rest = (jeu.getNombreAllumettes()-2)%PRISE_MAX;
			int q = (jeu.getNombreAllumettes()-2-rest)/PRISE_MAX;
			for (int k=0;k<q;k++){
				jeu.retirer(PRISE_MAX);
			}
			if (rest!=0){
				jeu.retirer(rest);
			}
			System.out.println("[Allumettes restantes : 2]");
			return 1;
	}
}
