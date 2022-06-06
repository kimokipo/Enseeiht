package allumettes;
import java.util.InputMismatchException;

public class StrategieRapide implements Strategie {
	private String nomJoueur;
	public StrategieRapide(String nomJoueur) {
		this.nomJoueur = nomJoueur;
 	}

	public int getPrise(Jeu jeu) {
		int PRISE_MAX = Jeu.PRISE_MAX;
			for (int i =0;i<PRISE_MAX;i++){
				if (jeu.getNombreAllumettes() >= (PRISE_MAX-i)){
					return PRISE_MAX-i;
				}
			}
		return 1;
	}
}
