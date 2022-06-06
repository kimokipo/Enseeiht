package allumettes;

public class Arbitre {

	private Joueur joueur1;

	private Joueur joueur2;

	public Arbitre(Joueur j1, Joueur j2) {
		this.joueur1 = j1;
		this.joueur2 = j2;
	}

	public void arbitrer(Jeu jeu) {
		Procuration procuration = new Procuration(jeu, 13);
		Joueur courant = joueur1;
		boolean abandon = true;
		boolean exit = false;
		while (jeu.getNombreAllumettes() != 0 && !exit) {
			System.out.println("\nNombre d'allumettes restantes :" + jeu.getNombreAllumettes());
			try {
				int prise = 0;
				if (jeu instanceof JeuConfiant) {
					prise = courant.getPrise(jeu);
				}else {
					prise = courant.getPrise(procuration);
				}
				System.out.print(courant.getNom() + " prend " +  prise + " allumette"); 
				System.out.println((prise == 1 | prise == 0 | prise == -1) ? ".":"s.");
				jeu.retirer(prise);
				courant = (courant == joueur1) ? joueur2 : joueur1;
			}catch (CoupInvalideException e) {
				System.out.println("Impossible ! " + e.getMessage());
			}catch (OperationInterditException e) {
				System.out.print("Abandon de la partie car " + courant.getNom() + " triche !");
				abandon = false;
				exit = true;
			}
		}
		if (abandon) {
			Joueur perdeur = (courant == joueur1) ? joueur2 : joueur1;
			System.out.println("\n"+perdeur.getNom() + " perd !");
			System.out.print(courant.getNom() + " gagne !\n");
		}
	}
}
