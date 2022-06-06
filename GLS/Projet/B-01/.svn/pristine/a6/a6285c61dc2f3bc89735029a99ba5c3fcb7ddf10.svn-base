
import java.util.*;
public class Enigme {

	// SCANNER DES REPONSES DE L UTILISATEUR
	public static final Scanner in = new Scanner(System.in);
	
	// TERRITOIRE
	public Territoire territoire;
	
	public Territoire getTerritoire() {
		return this.territoire;
	}
	
	// JOUEUR
	public Joueur joueur;

	// ENSEMBLE DE CONDITIONS
	public List<Condition> allconditions;
	
	public Joueur getJoueur() {
		return this.joueur;
	}

	public List<Condition> getallconditions() {
		return this.allconditions;
	}
	
	public static void Initialiser_Territoire(Enigme enigme) {
		List<Personne> personnes_Enigme = new ArrayList<Personne>();
			List<Choix> choix_Sphinx = new ArrayList<Choix>();

				Choix choix_Debut_Question = enigme.new Choix(null, null, null);
				List<Reponse> reponses_Question = new ArrayList<Reponse>();
				
					List<Objet> objets_c_r1 = new ArrayList<Objet>();
						objets_c_r1.add(enigme.new Objet("TentativeConsomme", 1, 0, EtatVisibilite.visible, EtatPossession.possede));
					List<Objet> objets_a_r1 = new ArrayList<Objet>();
					List<Connaissance> connaissances_a_r1 = new ArrayList<Connaissance>();
					Action action_r1 =  enigme.new Action("mauvaiseReponse", objets_c_r1, objets_a_r1, connaissances_a_r1);
					Reponse reponse_r1 = enigme.new Reponse("r1", enigme.new Qualification("Ifrane"), action_r1, EtatReponse.mauvaise);
					reponses_Question.add(reponse_r1);			
					List<Objet> objets_c_r2 = new ArrayList<Objet>();
						objets_c_r2.add(enigme.new Objet("TentativeConsomme", 1, 0, EtatVisibilite.visible, EtatPossession.possede));
					List<Objet> objets_a_r2 = new ArrayList<Objet>();
					List<Connaissance> connaissances_a_r2 = new ArrayList<Connaissance>();
					Action action_r2 =  enigme.new Action("mauvaiseReponse", objets_c_r2, objets_a_r2, connaissances_a_r2);
					Reponse reponse_r2 = enigme.new Reponse("r2", enigme.new Qualification("Tanger"), action_r2, EtatReponse.mauvaise);
					reponses_Question.add(reponse_r2);			
					List<Objet> objets_c_r3 = new ArrayList<Objet>();
						objets_c_r3.add(enigme.new Objet("TentativeConsomme", 1, 0, EtatVisibilite.visible, EtatPossession.possede));
					List<Objet> objets_a_r3 = new ArrayList<Objet>();
					List<Connaissance> connaissances_a_r3 = new ArrayList<Connaissance>();
					Action action_r3 =  enigme.new Action("mauvaiseReponse", objets_c_r3, objets_a_r3, connaissances_a_r3);
					Reponse reponse_r3 = enigme.new Reponse("r3", enigme.new Qualification("Tinghir"), action_r3, EtatReponse.mauvaise);
					reponses_Question.add(reponse_r3);			
					List<Objet> objets_c_r4 = new ArrayList<Objet>();
						objets_c_r4.add(enigme.new Objet("TentativeConsomme", 1, 0, EtatVisibilite.visible, EtatPossession.possede));
					List<Objet> objets_a_r4 = new ArrayList<Objet>();
					List<Connaissance> connaissances_a_r4 = new ArrayList<Connaissance>();
						connaissances_a_r4.add(enigme.new Connaissance("ReussitePos", enigme.new Qualification("invalid"), EtatVisibilite.visible, EtatPossession.possede));
					Action action_r4 =  enigme.new Action("bonneReponse", objets_c_r4, objets_a_r4, connaissances_a_r4);
					Reponse reponse_r4 = enigme.new Reponse("r4", enigme.new Qualification("Rabat"), action_r4, EtatReponse.bonne);
					reponses_Question.add(reponse_r4);			

				// CONDITIONS DE SORTIE DU CHOIX
				
				// CHOIX DE L INTERACTION
				choix_Debut_Question.setName("Debut");
				choix_Debut_Question.setReponses(reponses_Question);
				// choix_Debut_Question.setConditions(conditions_Debut_Enigme);
				choix_Sphinx.add(choix_Debut_Question);


			//CHOIX FIN DE LA PERSONNE

			Choix choixFin_Sphinx = enigme.new Choix(null, null, null);
				List<Reponse> reponses_choixFin_Sphinx = new ArrayList<Reponse>();
				
					List<Objet> objets_FIN_c_r5 = new ArrayList<Objet>();
					List<Objet> objets_FIN_a_r5 = new ArrayList<Objet>();
					List<Connaissance> connaissances_FIN_a_r5 = new ArrayList<Connaissance>();
					Action action_FIN_r5 =  enigme.new Action("Quitter", objets_FIN_c_r5, objets_FIN_a_r5, connaissances_FIN_a_r5);
					Reponse reponse_FIN_r5 = enigme.new Reponse("r5", enigme.new Qualification("Quitter"), action_FIN_r5, EtatReponse.bonne);
					reponses_choixFin_Sphinx.add(reponse_FIN_r5);			
				
				// CHOIX FIN DE L INTERACTION
				choixFin_Sphinx.setName("Question");
				choixFin_Sphinx.setReponses(reponses_choixFin_Sphinx);
				// choixFin_Sphinx.setConditions(conditions_choixFin_Sphinx);

			// INTERACTION DE LA PERSONNE
			Interaction interaction_Sphinx = enigme.new Interaction("Question", choix_Sphinx, choixFin_Sphinx);
			// QUALIFICATION DE LA PERSONNE
			Qualification texte_Sphinx = enigme.new Qualification("Quel est la capitale du Maroc  ?");

			// CONDITION D OBLIGATION DE LA PERSONNE
			
			// CONDITION DE VISIBILITE DE LA PERSONNE

			// PERSONNE DU LIEU DE DEBUT
			Personne personne_Sphinx = enigme.new Personne("Sphinx", EtatObligation.obligatoire, "invalid", EtatVisibilite.visible, "CondVisibleSphynx", texte_Sphinx, interaction_Sphinx);	
			personnes_Enigme.add(personne_Sphinx);

		// CONSTRUCTEUR DU LIEU DE DEBUT
		Lieu Enigme = enigme.new Lieu("Enigme", personnes_Enigme);
		
		// LIEUXINTERMEDIAIRES
		List<Lieu> lieuxintermediaires = new ArrayList<Lieu>();
			
		
		// LIEUXFIN
		List<Lieu> lieuxfin = new ArrayList<Lieu>();
			List<Personne> personnes_Succes = new ArrayList<Personne>();
			Lieu Succes = enigme.new Lieu("Succes", personnes_Succes);
			lieuxfin.add(Succes);
			List<Personne> personnes_Echec = new ArrayList<Personne>();
			Lieu Echec = enigme.new Lieu("Echec", personnes_Echec);
			lieuxfin.add(Echec);
		
		// CHEMINS
		List<Chemin> chemins = new ArrayList<Chemin>();
			Chemin chemin_Enigme_Echec = enigme.new Chemin(EtatChemin.ouvert, EtatObligation.obligatoire, EtatVisibilite.visible, Enigme, Echec);
			chemins.add(chemin_Enigme_Echec);
			Chemin chemin_Enigme_Succes = enigme.new Chemin(EtatChemin.ferme, EtatObligation.obligatoire, EtatVisibilite.visible, Enigme, Succes);
			chemins.add(chemin_Enigme_Succes);
	
		// AJOUT DE TOUT CECI AU TERRITOIRE
		enigme.territoire = enigme.new Territoire("Egypte", Enigme, lieuxintermediaires, lieuxfin, chemins);
	}
	
	private static void Initialiser_Joueur(Enigme enigme) {
		ArrayList<Objet> objets = new ArrayList<Objet>();
			objets.add(enigme.new Objet("Tentative", 3, 0, EtatVisibilite.visible, EtatPossession.possede));
		ArrayList<Connaissance> connaissances = new ArrayList<Connaissance>();
		enigme.joueur = enigme.new Joueur("Moi", 1, objets, connaissances);
	}

	private static void Initialiser_Conditions(Enigme enigme) {
		enigme.allconditions = new ArrayList<Condition>();
			List<Objet> objets_r_CondVisibleSphynx = new ArrayList<Objet>();
			List<Connaissance> connaissances_r_CondVisibleSphynx = new ArrayList<Connaissance>();
				objets_r_CondVisibleSphynx.add(enigme.new Objet("TentativeZero", 0, 0, EtatVisibilite.visible, EtatPossession.possede));
				connaissances_r_CondVisibleSphynx.add(enigme.new Connaissance("ReussiteNonPos", enigme.new Qualification("invalid"), EtatVisibilite.visible, EtatPossession.npossede));
				enigme.allconditions.add(enigme.new Condition("CondVisibleSphynx", objets_r_CondVisibleSphynx, connaissances_r_CondVisibleSphynx));
			List<Objet> objets_r_condTentativePos = new ArrayList<Objet>();
			List<Connaissance> connaissances_r_condTentativePos = new ArrayList<Connaissance>();
				objets_r_condTentativePos.add(enigme.new Objet("TentativeConsomme", 1, 0, EtatVisibilite.visible, EtatPossession.possede));
				enigme.allconditions.add(enigme.new Condition("condTentativePos", objets_r_condTentativePos, connaissances_r_condTentativePos));
			List<Objet> objets_r_condZeroTentative = new ArrayList<Objet>();
			List<Connaissance> connaissances_r_condZeroTentative = new ArrayList<Connaissance>();
				objets_r_condZeroTentative.add(enigme.new Objet("TentativeZero", 0, 0, EtatVisibilite.visible, EtatPossession.possede));
				enigme.allconditions.add(enigme.new Condition("condZeroTentative", objets_r_condZeroTentative, connaissances_r_condZeroTentative));
			List<Objet> objets_r_condReussitePos = new ArrayList<Objet>();
			List<Connaissance> connaissances_r_condReussitePos = new ArrayList<Connaissance>();
				connaissances_r_condReussitePos.add(enigme.new Connaissance("ReussitePos", enigme.new Qualification("invalid"), EtatVisibilite.visible, EtatPossession.possede));
				enigme.allconditions.add(enigme.new Condition("condReussitePos", objets_r_condReussitePos, connaissances_r_condReussitePos));
			List<Objet> objets_r_ConditionObligationCheminEchec = new ArrayList<Objet>();
			List<Connaissance> connaissances_r_ConditionObligationCheminEchec = new ArrayList<Connaissance>();
				objets_r_ConditionObligationCheminEchec.add(enigme.new Objet("TentativeZero", 0, 0, EtatVisibilite.visible, EtatPossession.possede));
				connaissances_r_ConditionObligationCheminEchec.add(enigme.new Connaissance("ReussiteNonPos", enigme.new Qualification("invalid"), EtatVisibilite.visible, EtatPossession.npossede));
				enigme.allconditions.add(enigme.new Condition("ConditionObligationCheminEchec", objets_r_ConditionObligationCheminEchec, connaissances_r_ConditionObligationCheminEchec));
	}

	public static void main(String[] args) throws InterruptedException {

		// PROGRAMME PRINCIPAL
		System.out.println("BONJOUR, BIENVENUE AU JEU Enigme");
		System.out.println("Pour démarrer le jeu, taper D");
		System.out.println("Pour quitter le jeu, taper Q");

		// LIRE L ENTREE DE L UTILISATEUR
		boolean b = true;
		while(b) {
			String rep = in.nextLine();
			if (rep.contentEquals("Q")) {
				System.out.println("MERCI, A BIENTOT !");
				System.exit(0);
			}
			else if (rep.contentEquals("D")) {
				Demarrer();
				b = false;
			}
			else {
				System.out.println("Veuillez taper soit D soit Q");
			}
		}
	}

	public static void Demarrer() throws InterruptedException {
		System.out.println("Le jeu démarre dans 3 secondes");
		System.out.println("A vos marques");
		Thread.sleep(1000);
		System.out.println("Prets");
		Thread.sleep(1000);
		System.out.println("Partez !");
		Thread.sleep(1000);

		Enigme enigme = new Enigme();
		Initialiser_Territoire(enigme);
		Initialiser_Joueur(enigme);
		
		/**initialiser_Sphinx_reponses();	
		initialiser_Final_reponses();
		initialiser_chemins();
		initialiser_objets_joueur(); */

		System.out.println("Vous etes maintenant au lieu" + enigme.getTerritoire().lieuDebut.name);
		Interagir(enigme);
	}

	public static void Interagir(Enigme enigme) throws InterruptedException {
		// OBJET DU JOUEUR
		int nbtentative = enigme.getJoueur().getObjets().get(0).getOccurrence();
		// ON BOUCLE SUR LES PERSONNES DU TERRITOIRE
		for (int i = 0; i < enigme.getTerritoire().getLieuDebut().getPersonnes().size(); i++) {
			System.out.println("Bonjour, je suis la personne " + enigme.getTerritoire().getLieuDebut().getPersonnes().get(i).getName());
			System.out.println("Vous devez à la question suivante : " + enigme.getTerritoire().getLieuDebut().getPersonnes().get(i).getTexte().getQualification());
			// LA CONDITION DE SORTIE DE LA BOUCLE EST QUE LES TENTATIVES SOIENT TOUTES CONSOMMES
			while(nbtentative != 0) {
				System.out.println("Choisissez entre les réponses suivantes : ");
				for(Reponse r : enigme.getTerritoire().getLieuDebut().getPersonnes().get(i).getInteraction().getChoix().get(0).getReponses()) {
					System.out.println(r.getName()+':'+r.getTexte().getQualification());
				}
				String re = in.nextLine();
				String r = re;
				boolean b = true;
				while(b) {
					// AU CAS OU LE JOUEUR N AS PAS TAPE UNE DES REPONSES EXISTANTES
					if(!(enigme.getTerritoire().getLieuDebut().getPersonnes().get(i).getInteraction().getChoix().get(0).getNames().contains(r))) {
						System.out.println("Vous devez taper une des réponses suivantes : ");
						for (Reponse rep : enigme.getTerritoire().getLieuDebut().getPersonnes().get(i).getInteraction().getChoix().get(0).getReponses()) {
	                		System.out.println(rep.getName()+':'+rep.getTexte().getQualification());
	                	}
	            		r = in.nextLine();
					}
					else {
	        			b = false;
	        		}
				}
				int pos = enigme.getTerritoire().getLieuDebut().getPersonnes().get(i).getInteraction().getChoix().get(0).getNames().indexOf(r);
				EtatReponse etat = enigme.getTerritoire().getLieuDebut().getPersonnes().get(i).getInteraction().getChoix().get(0).getReponses().get(pos).getEtat();
	        	if (etat.toString().contentEquals("bonne")) {
	        		System.out.println("Félicitations, Bonne réponse !");
	        		Thread.sleep(1000);
	        		System.exit(0);
	        	}
				else {
					// ON DIMINUE LE NOMBRE DE TENTATIVES DU JOUEUR SELON L ACTION CORRESPONDANTE 
					nbtentative = nbtentative - enigme.getTerritoire().getLieuDebut().getPersonnes().get(i).getInteraction().getChoix().get(0).getReponses().get(pos).getAction().getObjetsconsommables().get(0).getOccurrence();
					enigme.getTerritoire().getLieuDebut().getPersonnes().get(i).getInteraction().getChoix().get(0).getReponses().remove(pos);
	        		if (nbtentative == 0) {
	        			break;
	        		}
	        		System.out.println("Mauvaise réponse, il ne vous reste que " + nbtentative + " " + enigme.getJoueur().getObjets().get(0).getName());
	        	}
			}
		}
		
		System.out.println("Mauvaise réponse !");
    	Thread.sleep(1000);;
    	System.out.println("Malheureusement, vous avez perdu toutes vos tentatives");
    	System.exit(0);
	}
	
	public class Joueur {
		public String name;
		public int limite;
		public ArrayList<Objet> objets;
		public ArrayList<Connaissance> connaissances;
		public Joueur (String name, int limite, ArrayList<Objet> objets, ArrayList<Connaissance> connaissances) {
			this.connaissances = connaissances;
			this.limite = limite;
			this.name = name;
			this.objets = objets;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getLimite() {
			return limite;
		}
		public void setLimite(int limite) {
			this.limite = limite;
		}
		public ArrayList<Objet> getObjets() {
			return objets;
		}
		public void setObjets(ArrayList<Objet> objets) {
			this.objets = objets;
		}
		public ArrayList<Connaissance> getConnaissances() {
			return connaissances;
		}
		public void setConnaissances(ArrayList<Connaissance> connaissances) {
			this.connaissances = connaissances;
		}
	}
	
	public class Objet {
		public String name;
		public int occurrence;
		public int taille;
		public EtatVisibilite etatvi;
		public EtatPossession etatp; 
		public Objet(String name, int occurrence, int taille, EtatVisibilite etatvi, EtatPossession etatp) {
			this.etatvi = etatvi;
			this.etatp = etatp;
			this.name = name;
			this.occurrence = occurrence;
			this.taille = taille;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getOccurrence() {
			return occurrence;
		}
		public void setOccurrence(int occurrence) {
			this.occurrence = occurrence;
		}
		public int getTaille() {
			return taille;
		}
		public void setTaille(int taille) {
			this.taille = taille;
		}
		public EtatVisibilite getEtatvi() {
			return etatvi;
		}
		public void setEtatvi(EtatVisibilite etatvi) {
			this.etatvi = etatvi;
		}
		public EtatPossession getEtatp() {
			return etatp;
		}
		public void setEtatPossession(EtatPossession etatp) {
			this.etatp = etatp;
		}
	}
	
	public class Connaissance {
		public String name;
		public Qualification qualification;
		public EtatVisibilite etatvi;
		public EtatPossession etatp;
		public Connaissance(String name, Qualification qualification, EtatVisibilite etatvi, EtatPossession etatp) {
			this.etatp = etatp;
			this.etatvi = etatvi;
			this.name = name;
			this.qualification = qualification;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public EtatVisibilite getEtatvi() {
			return etatvi;
		}
		public void setEtatvi(EtatVisibilite etatvi) {
			this.etatvi = etatvi;
		}
		public EtatPossession getEtatPossession() {
			return etatp;
		}
		public void setEtatPossession(EtatPossession etatp) {
			this.etatp = etatp;
		}
		public Qualification getQualification() {
			return qualification;
		}
		public void setQualification(Qualification qualif) {
			this.qualification = qualif;
		}
	}
	
	public class Territoire {
		public String name;
		public Lieu lieuDebut;
		public List<Lieu> lieuxintermediaires;
		public List<Lieu> lieuxFin;
		public List<Chemin> chemins;
		public Territoire(String name, Lieu lieudebut, List<Lieu> lieuxintermediaires2, List<Lieu> lieuxfin2, List<Chemin> chemins2) {
			this.chemins = chemins2;
			this.lieuDebut = lieudebut;
			this.lieuxintermediaires = lieuxintermediaires2;
			this.lieuxFin = lieuxfin2;
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Lieu getLieuDebut() {
			return lieuDebut;
		}
		public void setLieuDebut(Lieu lieuDebut) {
			this.lieuDebut = lieuDebut;
		}
		public List<Lieu> getLieuxintermediaires() {
			return lieuxintermediaires;
		}
		public void setLieuxintermediaires(List<Lieu> lieuxintermediaires) {
			this.lieuxintermediaires = lieuxintermediaires;
		}
		public List<Lieu> getLieuxFin() {
			return lieuxFin;
		}
		public void setLieuxFin(List<Lieu> lieuxFin) {
			this.lieuxFin = lieuxFin;
		}
		public List<Chemin> getChemins() {
			return chemins;
		}
		public void setChemins(List<Chemin> chemins) {
			this.chemins = chemins;
		}
		
		
	}
	
	public class Lieu {
		public String name;
		public List<Personne> personnes;
		public Lieu (String name, List<Personne> personnes) {
			this.name = name;
			this.personnes = personnes;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Personne> getPersonnes() {
			return personnes;
		}
		public void setPersonnes(List<Personne> personnes) {
			this.personnes = personnes;
		}
	}
	
	public class Chemin {
		public EtatChemin etatch;
		public EtatObligation etatob;
		public String conditionc;
		public String conditiono;
		public String conditionv;
		public EtatVisibilite etatvi;
		public Lieu precedent;
		public Lieu suivant;
		public Chemin(EtatChemin etatch, EtatObligation etatob, EtatVisibilite etatvi, Lieu precedent, Lieu suivant) {
			this.etatch = etatch;
			this.etatob = etatob;
			this.etatvi = etatvi;
			this.precedent = precedent;
			this.suivant = suivant;
		}
		public EtatChemin getEtatch() {
			return etatch;
		}
		public void setEtatch(EtatChemin etatch) {
			this.etatch = etatch;
		}
		public EtatObligation getEtatob() {
			return etatob;
		}
		public void setEtatob(EtatObligation etatob) {
			this.etatob = etatob;
		}
		public EtatVisibilite getEtatvi() {
			return etatvi;
		}
		public void setEtatvi(EtatVisibilite etatvi) {
			this.etatvi = etatvi;
		}
		public Lieu getPrecedent() {
			return precedent;
		}
		public void setPrecedent(Lieu precedent) {
			this.precedent = precedent;
		}
		public Lieu getSuivant() {
			return suivant;
		}
		public void setSuivant(Lieu suivant) {
			this.suivant = suivant;
		}
	}
	
	public class Personne {
		public String name;
		public EtatObligation etatob;
		public String conditiono;
		public EtatVisibilite etatvi;
		public String conditionv;
		public Qualification texte;
		public Interaction interaction;
		public Personne(String name, EtatObligation etatob, String conditiono, EtatVisibilite etatvi, String conditionv, Qualification texte, Interaction interaction) {
			this.name = name;
			this.etatob = etatob;
			this.conditiono = conditiono;
			this.etatvi = etatvi;
			this.conditionv = conditionv;
			this.texte = texte;
			this.interaction = interaction;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public EtatObligation getEtatob() {
			return etatob;
		}
		public void setEtatob(EtatObligation etatob) {
			this.etatob = etatob;
		}
		public EtatVisibilite getEtatvi() {
			return etatvi;
		}
		public void setEtatvi(EtatVisibilite etatvi) {
			this.etatvi = etatvi;
		}
		public Qualification getTexte() {
			return texte;
		}
		public void setTexte(Qualification texte) {
			this.texte = texte;
		}
		public Interaction getInteraction() {
			return interaction;
		}
		public void setInteraction(Interaction interaction) {
			this.interaction = interaction;
		}
		public String getConditiono() {
			return conditiono;
		}
		public void setConditiono(String conditiono) {
			this.conditiono = conditiono;
		}
		public String getConditionv() {
			return conditionv;
		}
		public void setConditionv(String conditionv) {
			this.conditionv = conditionv;
		}
	}
	
	public class Qualification {
		public String qualification;
		public Qualification(String qualification) {
			this.qualification = qualification;
		}
		public String getQualification() {
			return qualification;
		}
		public void setQualification(String qualification) {
			this.qualification = qualification;
		}
	}
	
	public class Interaction {
		public String name;
		public List<Choix> choix;
		public Choix choixFin;
		public Interaction (String name, List<Choix> choix, Choix choixFin) {
			this.choixFin = choixFin;
			this.choix = choix;
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Choix> getChoix() {
			return choix;
		}
		public void setChoix(List<Choix> choix) {
			this.choix = choix;
		}
		public Choix getChoixFin() {
			return choixFin;
		}
		public void setChoixFin(Choix choixfin) {
			this.choixFin = choixfin;
		}
	}
	
	public class Choix {
		public String name;
		public List<Reponse> reponses;
		public List<String> conditions;
		public Choix(String name, List<Reponse> reponses, List<String> conditions) {
			this.name = name;
			this.reponses = reponses;
			this.conditions = conditions;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Reponse> getReponses() {
			return reponses;
		}
		public void setReponses(List<Reponse> reponses) {
			this.reponses = reponses;
		}
		public ArrayList<String> getNames() {
			ArrayList<String> names = new ArrayList<String>();
			reponses.forEach((n) -> names.add(n.getName()));
			return names;
		}
		public List<String> getConditions() {
			return conditions;
		}
		public void setConditions(List<String> conditions) {
			this.conditions = conditions;
		}
	}
	
	public class Reponse {
		public String name;
		public Qualification texte;
		public Action action;
		public EtatReponse etat;
		public Reponse(String name, Qualification texte, Action action, EtatReponse etat) {
			this.name = name;
			this.action = action;
			this.texte = texte;
			this.etat = etat;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public EtatReponse getEtat() {
			return etat;
		}
		public void setEtat(EtatReponse etat) {
			this.etat = etat;
		}
		public Qualification getTexte() {
			return texte;
		}
		public void setTexte(Qualification texte) {
			this.texte = texte;
		}
		public Action getAction() {
			return action;
		}
		public void setAction(Action action) {
			this.action = action;
		}
	}
	
	public class Action {
		public String texte;
		public List<Objet> objetsconsommables;
		public List<Objet> objetsattribuables;
		public List<Connaissance> connaissancesattribuables;
		public Action(String texte, List<Objet> oc, List<Objet> oa, List<Connaissance> ca) {
			this.texte = texte;
			this.objetsconsommables = oc;
			this.objetsattribuables = oa;
			this.connaissancesattribuables = ca;
		}
		public String getTexte() {
			return texte;
		}
		public void setTexte(String texte) {
			this.texte = texte;
		}
		public List<Objet> getObjetsconsommables() {
			return objetsconsommables;
		}
		public void setObjetsconsommables(List<Objet> objetsconsommables) {
			this.objetsconsommables = objetsconsommables;
		}
		public List<Objet> getObjetsattribuables() {
			return objetsattribuables;
		}
		public void setObjetsattribuables(List<Objet> objetsattribuables) {
			this.objetsattribuables = objetsattribuables;
		}
		public List<Connaissance> getConnaissancesattribuables() {
			return connaissancesattribuables;
		}
		public void setConnaissancesattribuables(List<Connaissance> connaissancesattribuables) {
			this.connaissancesattribuables = connaissancesattribuables;
		}
	}

	public class Condition {
		public String name;
		public List<Objet> objetsRequis;
		public List<Connaissance> connaissancesRequises;
		public Condition(String name, List<Objet> or, List<Connaissance> cr) {
			this.name = name;
			this.objetsRequis = or;
			this.connaissancesRequises = cr;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Objet> getObjetsRequis() {
			return objetsRequis;
		}
		public void setObjetsRequis(List<Objet> objetsrequis) {
			this.objetsRequis = objetsrequis;
		}
		public List<Connaissance> getConnaissancesRequises() {
			return connaissancesRequises;
		}
		public void setConnaissancesRequises(List<Connaissance> connaissancesrequises) {
			this.connaissancesRequises = connaissancesrequises;
		}
	}
	
	private enum EtatReponse {
		bonne, mauvaise
	}

	private enum EtatVisibilite {
		visible, nvisible
	}
	
	private enum EtatObligation {
		obligatoire, nobligatoire
	}
	
	private enum EtatChemin {
		ouvert, ferme
	}
	
	private enum EtatPossession {
		possede, npossede
	}

}

