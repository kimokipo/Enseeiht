package allumettes;

public class JeuNonConfiant implements Jeu {

	protected int NombreAllumettes;

	public JeuNonConfiant(int nbAlummettes){
		this.NombreAllumettes = nbAlummettes;
	}

	/** Obtenir le nombre d'allumettes encore en jeu.
	 * @return nombre d'allumettes encore en jeu
	 */
	public int getNombreAllumettes() {
		return NombreAllumettes;
	}

	/** Retirer des allumettes.  Le nombre d'allumettes doit Ãªtre compris
	 * entre 1 et PRISE_MAX, dans la limite du nombre d'allumettes encore
	 * en jeu.
	 * @param nbPrises nombre d'allumettes prises.
	 * @throws CoupInvalideException tentative de prendre un nombre invalide d'alumettes
	 */
	
	public void retirer(int nbPrises) throws CoupInvalideException {
		if (nbPrises >=1 & nbPrises <= PRISE_MAX & nbPrises <= NombreAllumettes) {
			NombreAllumettes -= nbPrises;
		}else if (nbPrises < 1) {
			throw new CoupInvalideException(nbPrises, "< 1");
		} else if (nbPrises > NombreAllumettes) {
			throw new CoupInvalideException(nbPrises, "> " + NombreAllumettes);
		}else {
			throw new CoupInvalideException(nbPrises, "> " + PRISE_MAX);
		}
	}
}
