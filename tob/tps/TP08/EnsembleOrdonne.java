/** Définition d'un ensemble ordonné d'entier. */
public interface EnsembleOrdonne<E> extends Ensemble<E> {
	
	
	/** Obtenir le plus petit élément dans l'ensemble.
	 * @return le plus petit élément dans l'ensemble.  */
	/*@ pure helper @*/ E min();

	/** Obtenir le plus petit élément strictement plus grand que 
	 * celui passé en paramètre. 
	 * retourner null si cet élément n’existe pas.
	 * @param élément inférieur au min des autres éléments de l'ensemble.
	 * @return min des autres éléments de l'ensemble supérieures strictement à l'élément passé en paramètre.*/
	/*@ pure helper @*/ E justePlusGrandQue(E element);
}
