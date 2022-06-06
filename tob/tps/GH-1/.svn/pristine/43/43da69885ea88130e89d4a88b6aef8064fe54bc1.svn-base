package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Jeu.Interfaces.Capacite;
import Jeu.Modeles.CapaciteSimple;

/** Test le fonctionnement des capacites.
 * @author Basile Gros
 * @version 2eme iteration
*/

public class CapaciteTest {
	// précision pour les comparaisons réelle
			public final static double EPSILON = 10e-3;
			
			Capacite capacite; //La capacité testée
			
		@Before public void setUp() {
			capacite = new CapaciteSimple("Technologie Objet");
		}
		
		@Test public void testerObtenirNom() {
			assertEquals("Technologie Objet",capacite.getNom());
		}
		
		
		
		@Test public void testerObtenirValeurSansInitialisation() {
			assertEquals("",capacite.getValeur());
		}
		
		@Test public void testerSecondConstructeur() {
			capacite = new CapaciteSimple("Technologie Objet","Over 9000 !");
			assertEquals("Technologie Objet",capacite.getNom());
			assertEquals("Over 9000 !",capacite.getValeur());
		}
		
		@Test public void testerAjouterValeur() {
			capacite.setValeur("Under -273.15 °C");
			assertEquals("Technologie Objet",capacite.getNom());
			assertEquals("Under -273.15 °C",capacite.getValeur());
		}
		
		@Test public void testerModifierValeur() {
			capacite.setValeur("Over 9000 !");
			capacite.setValeur("Under -273.15 °C");
			assertEquals("Under -273.15 °C",capacite.getValeur());
		}
		
		@Test public void testerCaracteresSpeciaux() {
			String chaineSpeciale1 = "çè€§$ê£ì";
			String chaineSpeciale2 = "Δοκιμή Контрольная работа";
			capacite = new CapaciteSimple(chaineSpeciale1,chaineSpeciale2);
			assertEquals("çè€§$ê£ì",capacite.getNom());
			assertEquals("Δοκιμή Контрольная работа",capacite.getValeur());
			}
		
		@Test public void testerNomNull() {
			capacite = new CapaciteSimple(null);
			assertEquals(null,capacite.getNom());
		}
		
		@Test public void testerValeurNull() {
			capacite = new CapaciteSimple(null,null);
			assertEquals(null,capacite.getNom());
			assertEquals(null,capacite.getValeur());
		}
		
		
}
