package editeur;

import editeur.commande.*;
import menu.Menu;

/** Un éditeur pour une ligne de texte.  Les commandes de
 * l'éditeur sont accessibles par un menu.
 *
 * @author	Xavier Crégut
 * @version	1.6
 */
public class EditeurLigne {

	/** La ligne de notre éditeur */
	private Ligne ligne;

	/** Le menu principal de l'éditeur */
	private Menu menuPrincipal;
		// Remarque : Tous les éditeurs ont le même menu mais on
		// ne peut pas en faire un attribut de classe car chaque
		// commande doit manipuler la ligne propre à un éditeur !

	/** Initialiser l'éditeur à partir de la lign à éditer. */
	public EditeurLigne(Ligne l) {
		ligne = l;

		// Créer le menu principal
		menuPrincipal = new Menu("Menu principal");
		CommandeCurseur sousmenu1 = new CommandeCurseur();
		CommandeAutre sousmenu2 = new CommandeAutre();
		
		sousmenu2.ajouter("Ajouter un texte en fin de ligne",
					new CommandeAjouterFin(ligne),"[A]");
		sousmenu1.ajouter("Avancer le curseur d'un caractère",
					new CommandeCurseurAvancer(ligne),"[l]");
		sousmenu1.ajouter("Reculer le curseur d'un caractère",
					new CommandeCurseurReculer(ligne),"[h]");
		sousmenu1.ajouter("Ramener le curseur sur le premier caractère de la ligne",
					new CommandeRaz(ligne),"[0]");
		sousmenu1.ajouter("Supprimer le caractère sous le curseur",
					new CommandeSupprimer(ligne),"[x]");
		menuPrincipal.ajouter("Gérer le curseur", sousmenu1,"[c]");
		menuPrincipal.ajouter("Autre", sousmenu2,"[a]");
		
	}

	public void editer() {
		do {
			// Afficher la ligne
			System.out.println();
			ligne.afficher();
			System.out.println();

			// Afficher le menu
			menuPrincipal.afficher();

			// Sélectionner une entrée dans le menu
			menuPrincipal.selectionner();

			// Valider l'entrée sélectionnée
			menuPrincipal.valider();

		} while (! menuPrincipal.estQuitte());
	}

}
