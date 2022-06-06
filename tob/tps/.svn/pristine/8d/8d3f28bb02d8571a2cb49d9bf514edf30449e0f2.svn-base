package allumettes;
import java.util.InputMismatchException;

public class StrategieExpert implements Strategie {
	private String nomJoueur;
	public StrategieExpert(String nomJoueur){
		this.nomJoueur = nomJoueur;
 	}
	public int getPrise(Jeu jeu) {
		int PRISE_MAX = Jeu.PRISE_MAX;
			if (jeu.getNombreAllumettes() % (PRISE_MAX+1) == 1){
				return 1;
			}
			return (jeu.getNombreAllumettes() % (PRISE_MAX+1) != 0) ? jeu.getNombreAllumettes() % (PRISE_MAX+1)-1 : PRISE_MAX;
	}
}
