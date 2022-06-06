package allumettes;

/** Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 * @author	Kamal Hammi
 * @version	$Revision: 1.0 $
 */
public class Jouer {

	/** Lancer une partie. En argument sont donnés les deux joueurs sous
	 * la forme nom@stratégie.
	 * @param args la description des deux joueurs
	 */
	public static void main(String[] args) {
		try {
			verifierNombreArguments(args);
			Jeu jeu;
			int i =0;
			if (!args[0].equals("-confiant")){
				jeu = new JeuNonConfiant(13);
			}else{
				jeu = new JeuConfiant(13);
				i = 1;
			}
			Joueur joueur1 = InitialiserJoueur(args,i);
			Joueur joueur2 = InitialiserJoueur(args,i+1);
			Arbitre arbitre = new Arbitre(joueur1,joueur2);
			arbitre.arbitrer(jeu);
			//System.out.println("\n\tNombre d'allumettes restantes :"+jeu.getNombreAllumettes()+"\n");

		} catch (ConfigurationException | IllegalArgumentException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
			System.exit(1);
		}
	}

	private static void verifierNombreArguments(String[] args) {
		final int nbJoueurs = 2;
		if (args.length < nbJoueurs) {
			throw new ConfigurationException("Trop peu d'arguments : "
					+ args.length);
		}
		if (args.length > nbJoueurs + 1) {
			throw new ConfigurationException("Trop d'arguments : "
					+ args.length);
		}
	}
	
	public static Strategie InitialiserStrategie(String nom, String nomJoueur){
		if (nom.equals("HUMAIN")){
			return new StrategieHumain(nomJoueur);
		}else if (nom.equals("TRICHEUR")){
			return new StrategieTricheur(nomJoueur);
		}else if (nom.equals("RAPIDE")){
			return new StrategieRapide(nomJoueur);
		}else if (nom.equals("EXPERT")){
			return new StrategieExpert(nomJoueur);
		}else if (nom.equals("NAIF")){
			return new StrategieNaif(nomJoueur);
		}else{
			throw new IllegalArgumentException("le nom de la strategie donnée n'est pas valide");
		}
	}

	public static Joueur InitialiserJoueur(String [] args, int i){
			try {
				String[] tab = args[i].split("@");
				String Nom = tab[0];
				Strategie Strategie = InitialiserStrategie(tab[1].toUpperCase(), Nom);
				return new Joueur(Nom,Strategie);
			}catch (IndexOutOfBoundsException e){
				throw new IllegalArgumentException("l'usage n'est pas correcte");
			}
	}

	/** Afficher des indications sur la manière d'exécuter cette classe. */
	public static void afficherUsage() {
		System.out.println("\n" + "Usage :"
				+ "\n\t" + "java allumettes.Jouer joueur1 joueur2"
				+ "\n\t" + "ou"
				+ "\n\t" + "java allumettes.Jouer -confiant joueur1 joueur2"
				+ "\n\t\t" + "joueur est de la forme nom@stratégie"
				+ "\n\t\t" + "strategie = naif | rapide | expert | humain | tricheur"
				+ "\n"
				+ "\n\t" + "Exemple :"
				+ "\n\t" + "	java allumettes.Jouer Xavier@humain "
					   + "Ordinateur@naif"
				+ "\n"
				);
	}

}
