package de;

/** Définition du « modèle » du jeu du Morpion.
  * @author	Alexandre FRAY
  */

public interface LancerDe {

	// Les différents états possibles du dé
	//enum Etat {UN, DEUX, TROIS, QUATRE, CINQ, SIX};

	/** Obtenir le numéro du dé */
	int getValeur();
	void changerNbFaces(int N);

}
