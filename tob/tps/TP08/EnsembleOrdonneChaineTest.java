/**
 * Classe de test pour EnsembleChaine.
 */
public class EnsembleOrdonneChaineTest extends EnsembleTestAbstrait {

	protected Ensemble<Integer> nouvelEnsemble<Integer>(int capacite) {
		return new EnsembleOrdonneChaine<Integer>();
	}

}
