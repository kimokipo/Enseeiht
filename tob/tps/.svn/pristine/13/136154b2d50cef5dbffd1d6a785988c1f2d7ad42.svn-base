/** Définition d'un ensemble d'entier. */
public class EnsembleChaine<E> implements Ensemble<E> {
	//@ public invariant estVide() <==> cardinal() == 0;
	//@ public invariant 0 <= cardinal();
	public Cellule cellule; 
	

	public EnsembleChaine(){
		this.cellule = null;
	}

	/** Obtenir le nombre d'éléments dans l'ensemble.
	 * @return nombre d'éléments dans l'ensemble.  */
	public int cardinal(){
		Cellule curseur = this.cellule;
		int card = 0;
		while(curseur != null){
			card++;
			curseur = curseur.suivante;
		}
		return card;
	}
	

	/** Savoir si l'ensemble est vide.
	 * @return Est-ce que l'ensemble est vide ? */
	public boolean estVide(){
		return this.cellule == null;
	}
	
	/** Savoir si un élément est présent dans l'ensemble.
	 * @param x l'élément cherché
	 * @return x est dans l'ensemble */
	public boolean contient(int x){
		Cellule curseur = this.cellule;
		while(curseur != null){
			if (curseur.element == x){
				return true;
			}
			curseur = curseur.suivante;
		}
		return false;
	}

	/** Ajouter un élément dans l'ensemble.
	 * @param x l'élément à ajouter */
	//@ ensures contient(x);        // élément ajouté
	public void ajouter(E x){
		this.cellule = new Cellule(x, this.cellule);
	}

	/** Enlever un élément de l'ensemble.
	  * @param x l'élément à supprimer */
	//@ ensures ! contient(x);      // élément supprimé
	public void supprimer(E x){
		Cellule curseur = this.cellule;
		while(curseur != null){
			if (curseur.element == x){
				curseur = curseur.suivante;
			}
			
		}
	}
}
