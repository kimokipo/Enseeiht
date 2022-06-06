import java.util.ArrayList;

public class GroupeAgenda extends ObjetNomme implements Agenda{
	private ArrayList<Agenda> groupe = new ArrayList<Agenda>();
	private ArrayList<Agenda> AgendaModifiees = new ArrayList<Agenda>();
	private String nom;
	public GroupeAgenda(String nom){
		super(nom);
	}
	
	/**
	 * Obtenir le nom de l'agenda.
	 * @return le nom de l'agenda
	 */
	public String getNom(){
		return this.nom;
	}

	public void enregistrer(int creneau, String rdv) throws OccupeException, IllegalArgumentException, CreneauInvalideException{
		AgendaAbstrait.verifierCreneauValide(creneau);
		if (rdv == null || rdv.length() == 0){
			throw new IllegalArgumentException();
		}
		boolean enregistre = false;
		for (Agenda a : groupe) {
			try{
 				a.enregistrer(creneau, rdv);
				AgendaModifiees.add(a);
				enregistre = true;
			}catch (Throwable e){
				continue;
			}
		}
		if (!enregistre){
			annuler(creneau);
			throw new OccupeException();
		}
	}
	

	public String getRendezVous(int creneau) throws LibreException{
		boolean libre = true;
		String rdv = null;
		try {
			rdv = groupe.get(0).getRendezVous(creneau);
			libre = false;
		}catch(LibreException e){
		}
		for (Agenda a : groupe) {
			try{
				if (rdv != a.getRendezVous(creneau)){
					return null;
				}
				libre = false;
			}catch (LibreException e){
				continue;
			}
		}
		if (libre){
			throw new LibreException ();
		}
		return rdv;
	}

	/** Savoir si un agenda appartient à ce groupe.
         * @param cherche l'agenda cherché
         * @return vrai si l'agenda appartient à ce groupe
         */
        public boolean contient(Agenda cherche){ 
		for (Agenda a : groupe) {
			if (a == cherche){
				return true;
			}
		}
		return false;
	}

	public void ajouter(Agenda nouvelAgenda){
		if (this.contient(nouvelAgenda)){
			throw new Error("l'agenda à ajouter est déja existante dans le groupe");
		}
		groupe.add(nouvelAgenda);
	}
		
	public boolean annuler(int creneau){
		for (Agenda a : AgendaModifiees){
			a.annuler(creneau);
		}
		return true;
	}	
}

		
