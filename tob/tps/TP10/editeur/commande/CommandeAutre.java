package editeur.commande;


import menu.*;

/** Commande qui rassemble les commandes non relatives au curseur.
  * @author	Kamal Hammi
  * @version	$Revision: 1.0 $
  */
public class CommandeAutre extends Menu implements Commande {

	public void executer() {
		    this.afficher();
		    this.selectionner();
		    this.valider();
 
	}

	public CommandeAutre(){
		super("Autre");
	}

	public boolean estExecutable() {
		return true;
	}

}
