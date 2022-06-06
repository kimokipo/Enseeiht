package allumettes;

public class Joueur {
	private String nom;
	private Strategie strategie;
	public Joueur(String nom, Strategie strategie){
		this.nom = nom;
		this.strategie = strategie;
	}
	public String getNom(){
		return this.nom;
	}
	
	public void setStrategie(Strategie strategie){
		this.strategie = strategie;
	}	
	
	public int getPrise(Jeu jeu) throws CoupInvalideException, OperationInterditException{
		return strategie.getPrise(jeu);		
	}
}
				
	
