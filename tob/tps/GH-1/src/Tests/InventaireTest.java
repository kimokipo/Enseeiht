package Tests;


import Jeu.Interfaces.Inventaire;
import Jeu.Modeles.InventaireSimple;
import org.junit.*;
import static org.junit.Assert.*;

/** Test le fonctionnement de l'inventaire.
 * @author Basile Gros
 * @version 2eme iteration
*/

public class InventaireTest{
	// précision pour les comparaisons réelle
		public final static double EPSILON = 10e-3;
		
		Inventaire inventaire; /*L'inventaire testé*/
		
		String objet1 = "Baton"; /*Des objets à ajouter à l'inventaire*/
		String objet2 = "Caillou";
		
	@Before public void setUp() {
		inventaire = new InventaireSimple();
	}
	
	@Test public void testerAjoutSimple() {
		
		inventaire.ajouter(objet1);
		assertEquals("1x Baton.", inventaire.toString());
		inventaire.ajouter(objet2);
		assertEquals("1x Caillou,1x Baton.",inventaire.toString());
	}
	
	@Test public void testerAjoutMultiple() {
		for (int i = 1; i <= 10; i++) {
			inventaire.ajouter(objet1);
			assertEquals(i+"x Baton.",inventaire.toString());
		}
		
		for (int i = 1; i <= 25; i++) {
			inventaire.ajouter(objet2);
			assertEquals(i+"x Caillou,10x Baton.",inventaire.toString());
		}
		
	}
	
	@Test public void testerAjoutDesordre() {
		inventaire.ajouter(objet1);
		assertEquals("1x Baton.",inventaire.toString());
		inventaire.ajouter(objet2);
		assertEquals("1x Caillou,1x Baton.",inventaire.toString());
		inventaire.ajouter(objet1);
		assertEquals("1x Caillou,2x Baton.",inventaire.toString());
		inventaire.ajouter(objet2);
		assertEquals("2x Caillou,2x Baton.",inventaire.toString());
	}
	
	@Test public void testerAjouterVide() {
		String objetVide = "";
		inventaire.ajouter(objetVide);
		assertEquals("", inventaire.toString());
		inventaire.ajouter(objetVide);
		assertEquals("",inventaire.toString());
		inventaire.ajouter(objetVide);
		assertEquals("",inventaire.toString());
	}
	
	@Test public void testerAjouterNull() {
		String objetNull = null;
		inventaire.ajouter(objetNull);
		assertEquals("",inventaire.toString());
	}
	
	@Test public void testerAjoutCaracteresSpeciaux() {
		String objetSpecial1 = "çè€§$ê£ì";
		String objetSpecial2 = "Δοκιμή Контрольная работа";
		inventaire.ajouter(objetSpecial1);
		assertEquals("1x çè€§$ê£ì.",inventaire.toString());
		inventaire.ajouter(objetSpecial2);
		assertEquals("1x çè€§$ê£ì,1x Δοκιμή Контрольная работа.",inventaire.toString());
		}
	
	@Test public void testerSuppressionSimple() {
		inventaire.ajouter(objet1);
		assertEquals("1x Baton.",inventaire.toString());
		inventaire.supprimer(objet1);
		assertEquals("",inventaire.toString());
		inventaire.ajouter(objet2);
		assertEquals("1x Caillou.",inventaire.toString());
		inventaire.supprimer(objet2);
		assertEquals("",inventaire.toString());
		
	}
	
	@Test public void testerSuppressionMultiple() {
		for (int i = 1; i <= 10; i++) {
			inventaire.ajouter(objet1);
		}
		
		for (int i = 1; i <= 25; i++) {
			inventaire.ajouter(objet2);
		}
		
		for (int i = 24; i >= 1; i--) {
			inventaire.supprimer(objet2);
			assertEquals(i+"x Caillou,10x Baton.",inventaire.toString());
		}
		inventaire.supprimer(objet2);
		assertEquals("10x Baton.",inventaire.toString());
		
		for (int i = 9; i >= 1; i--) {
			inventaire.supprimer(objet1);
			assertEquals(i+"x Baton.",inventaire.toString());
		}
		
		inventaire.supprimer(objet1);
		assertEquals("",inventaire.toString());
	}
	
	@Test public void testSupprimerAbsent() {
		inventaire.supprimer(objet1);
		assertEquals("",inventaire.toString());
		inventaire.supprimer(objet2);
		assertEquals("",inventaire.toString());
	}
	
	@Test public void testSupprimerNull() {
		String objetNull = null;
		inventaire.ajouter(objetNull);
	}
	
	@Test public void testReinitialiser() {
		for (int i = 1; i <= 10; i++) {
			inventaire.ajouter(objet1);
		}
		assertEquals("10x Baton.",inventaire.toString());
		inventaire.clear();
		assertEquals("",inventaire.toString());
	}
	
	@Test public void testReinitialiserMultiplesObjets() {
		for (int i = 1; i <= 10; i++) {
			inventaire.ajouter(objet1);
			inventaire.ajouter(objet2);
		}
		assertEquals("10x Caillou,10x Baton.",inventaire.toString());
		inventaire.clear();
		assertEquals("",inventaire.toString());
	}
	
	@Test public void testReinitialiserVide() {
		assertEquals("",inventaire.toString());
		inventaire.clear();
		assertEquals("",inventaire.toString());
	}
}