import java.util.List;

/** Quelques outils (méthodes) sur les listes.  */
public class Outils {

	/** Retourne vrai ssi tous les éléments de la collection respectent le critère. */
	public static <E extends T ,T> boolean tous(
			List<E> elements,
			Critere<T> critere)
	{
		for(E e : elements){
			if (!critere.satisfaitSur(e)){
				return false;	
			}
		}
		return true;// TODO à corriger
	}


	/** Ajouter dans resultat tous les éléments de la source
	 * qui satisfont le critère aGarder.
	 */
	public static <E extends T1,T1 extends T2,T2> void filtrer(
			List<E> source,
			Critere<T1> aGarder,
			List<T2> resultat)
	{
		for(E e : source){
			if (aGarder.satisfaitSur(e)){
				resultat.add(e);	
			}
		}
		// TODO : à corriger
	}

}
