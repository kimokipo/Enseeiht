package allumettes;

public class Procuration extends JeuNonConfiant implements Jeu {
	private Jeu jeu;

	/** Obtenir le nombre d'allumettes encore en jeu.
	 * @return nombre d'allumettes encore en jeu
	 */
	@Override
	public int getNombreAllumettes(){
		return this.jeu.getNombreAllumettes();
	}
	public Procuration(Jeu jeu, int nbAlummettes){
		super(nbAlummettes);
		this.jeu = jeu;
	}	
		
	/** Retirer des allumettes.  Le nombre d'allumettes doit Ãªtre compris
	 * entre 1 et PRISE_MAX, dans la limite du nombre d'allumettes encore
	 * en jeu.
	 * @param nbPrises nombre d'allumettes prises.
	 * @throws OperationInterditException tentative d'un joueur d'utiliser une opération interdite
	 */
	@Override
	public void retirer(int nbPrises) {
		throw new OperationInterditException();
	}
}
