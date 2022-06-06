import java.awt.Color;
import org.junit.*;
import static org.junit.Assert.*;

/**
  * Classe de test des exigences E12, E13, et E14 de la classe Cercle.
  * @author	Kamal Hammi
  * @version	1.0
  */
public class CercleTest {

	// précision pour les comparaisons réelle
	public final static double EPSILON = 0.001;

	// Les points du sujet
	private Point A, B, C, D, E, F;

	// Les cercles du sujet
	private Cercle C1, C2, C3;

	@Before public void setUp() {
		// Construire les points
		A = new Point(1, 7);
		B = new Point(8, 2);
		C = new Point(6, 9);
		D = new Point(10, 5);
		E = new Point(5, 11);
		F = new Point(12, 6);

		// Construire les cercles
		C1 = new Cercle(A, B);
		C2 = new Cercle(C, D, Color.yellow);
		C3 = C1.creerCercle(E, F);
		C3.setCouleur(Color.green);
	}

	/** Vérifier si deux points ont mêmes coordonnées.
	  * @param p1 le premier point
	  * @param p2 le deuxième point
	  */
	static void memesCoordonnees(String message, Point p1, Point p2) {
		assertEquals(message + " (x)", p1.getX(), p2.getX(), EPSILON);
		assertEquals(message + " (y)", p1.getY(), p2.getY(), EPSILON);
	}
	

	@Test public void testerE12C1() {
		memesCoordonnees("E12 : Centre de C1 incorrect", new Point(4.5,4.5), C1.getCentre());
		assertEquals("E12 : Rayon de C1 incorrect",
				4.301, C1.getRayon(), EPSILON);
		assertEquals("E12 : Diamètre de C1 incorrect",
				8.602, C1.getDiametre(), EPSILON);
		assertEquals(Color.blue, C1.getCouleur());
	}

	@Test public void testerE13C2() {
		memesCoordonnees("E13 : Centre de C2 incorrect", new Point(8,7), C2.getCentre());
		assertEquals("E13 : Rayon de C2 incorrect",
				2.828, C2.getRayon(), EPSILON);
		assertEquals("E13 : Diamètre de C2 incorrect",
				5.656, C2.getDiametre(), EPSILON);
		assertEquals(Color.yellow, C2.getCouleur());
	}
	
	@Test public void testerE14C3() {
		memesCoordonnees("E14 : Centre de C3 incorrect", E, C3.getCentre());
		assertEquals("E14 : Rayon de C3 incorrect",
				8.602, C3.getRayon(), EPSILON);
		assertEquals("E14 : Diamètre de C3 incorrect",
				17.204, C3.getDiametre(), EPSILON);
		assertEquals(Color.green, C3.getCouleur());
	}

}
