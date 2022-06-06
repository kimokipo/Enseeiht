/** Définition d'un ensemble ordonné d'éléments de type <E>. */
public class EnsembleOrdonneChaine<E> extends EnsembleChaine<E> implements EnsembleOrdonne<E> {

	

	public EnsembleOrdonneChaine<E>(){
		super();
	}

	/** Obtenir le plus petit élément dans l'ensemble.
	 * @return le plus petit élément dans l'ensemble.  */
	public <E extends Comparable<E>> E min(){
		assert(!estVide());
		Cellule curseur = super.cellule;
		E min = null;
		while(curseur != null){
			if (min == null ||  min.compareTo(curseur.element) > 0){
				min = curseur.element;
			}
			curseur = curseur.suivante;
		}
		return min;
	}
	
	/** Obtenir le plus petit élément strictement plus grand que 
	 * celui passé en paramètre. 
	 * retourner null si cet élément n’existe pas.
	 * @param élément inférieur au min des autres éléments de l'ensemble.
	 * @return min des autres éléments de l'ensemble supérieures strictement à l'élément passé en paramètre.*/
	public <E extends Comparable<E>> E justePlusGrandQue(E element){
		assert(!estVide());
		Cellule curseur = super.cellule;
		E min = null;
		while(curseur != null){
			if (min == null ||  min.compareTo(curseur.element) > 0 & element.compareTo(curseur.element) < 0){
				min = curseur.element;
			}
			curseur = curseur.suivante;
		}
		return min;
	}

}
