package editeur.commande;

import editeur.Ligne;

/** supprimer le caractère sous le curseur.
 * @author	Kamal Hammi
 * @version	1.0
 */
public class CommandeSupprimer
	extends CommandeLigne
{

	/** Initialiser la ligne sur laquelle travaille
	 * cette commande.
	 * @param l la ligne
	 */
	//@ requires l != null;	// la ligne doit être définie
	public CommandeRaz(Ligne l) {
		super(l);
	}

	public void executer() {
		ligne.raz();
	}

	public boolean estExecutable() {
		return ligne.getLongueur() > 0;
	}

}
