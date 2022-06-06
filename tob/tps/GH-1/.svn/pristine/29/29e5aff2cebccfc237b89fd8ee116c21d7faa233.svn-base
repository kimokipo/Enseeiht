package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import java.util.*;


import Jeu.Modeles.ModeleFichePersonnage;
import Jeu.Utils;
import Jeu.Interfaces.Capacite;
import Jeu.Modeles.CapaciteSimple;
import Jeu.Interfaces.Inventaire;
import Jeu.Modeles.InventaireSimple;

import javax.swing.*; //Pour l'ImageIcon

/** Test le fonctionnement de la fiche personnage.
 * @author Basile Gros
 * @version 2eme iteration
*/

public class FichePersonnageTest {
	
	ModeleFichePersonnage fiche;
	Capacite capacite1;
	Capacite capacite2;
	Inventaire inventaire;
	ImageIcon imageProfile;
	
	String nom = "Yorel Rievax";
	String role = "Fan de méthodes formelles";
	
	@Before
	public void setUp() {
		inventaire = new InventaireSimple();
		fiche = new ModeleFichePersonnage(nom, role);
	}
	
	@Test
	public void testerConstructeur() {
		assertEquals(nom, fiche.getNom());
		assertEquals(role, fiche.getRole());
		assertEquals(10,fiche.getVie());
		assertEquals(Utils.DEFAULT_ICON,fiche.getImage());
		assertEquals("",fiche.getInventaire().toString());
		assertEquals(new ArrayList<Capacite>(),fiche.getCapacites());
	}
	
	@Test
	public void testerModifierNom() {
		fiche.setNom("Purtsuorts Enrajb");
		assertEquals("Purtsuorts Enrajb", fiche.getNom());
	}
	
	@Test
	public void testerModifierRole() {
		fiche.setRole("Membre du gourdin de ventilateur de langages fonctionnelles.");
		assertEquals("Membre du gourdin de ventilateur de langages fonctionnelles.", fiche.getRole());
	}
	
	@Test
	public void testerModifierVie() {
		fiche.setVie(42);
		assertEquals(42, fiche.getVie());
	}
	
	@Test
	public void testerAjouterCapacite() {
		capacite1 = fiche.ajouterCapacite("Ocaml");
		assertEquals("Ocaml", capacite1.getNom());
		assertEquals("", capacite1.getValeur());
		assertEquals("Ocaml", fiche.getCapacites().get(0).getNom());
		assertEquals("", fiche.getCapacites().get(0).getValeur());
	}
	
	@Test
	public void testerReinitialiser() {
		fiche.ajouterCapacite("Ocaml");
		fiche.reinitialiser();
		assertEquals("", fiche.getNom());
		assertEquals("", fiche.getRole());
		assertEquals(10,fiche.getVie());
		assertEquals(Utils.DEFAULT_ICON,fiche.getImage());
		assertEquals("",fiche.getInventaire().toString());
		assertEquals(new ArrayList<Capacite>(),fiche.getCapacites());
	}
	
	@Test
	public void testerAjouterCapaciteDejaExistante() {
		fiche.ajouterCapacite("Ocaml");
		capacite1 = fiche.ajouterCapacite("Ocaml");
		assertEquals(null,capacite1);
		assertEquals(1,fiche.getCapacites().size());
	}
	
	@Test
	public void testerAjouterCapaciteNulle() {
		capacite1 = fiche.ajouterCapacite(null);
		assertEquals(new ArrayList<Capacite>(),fiche.getCapacites());
		assertEquals(0,fiche.getCapacites().size());
	}
	
	public void testerModifierCapacite() {
		capacite1 = fiche.ajouterCapacite("Ocaml");
		capacite1.setValeur("Over 9000 !");
		assertEquals("Over 9000 !", fiche.getCapacites().get(0).getValeur());
	}
}
