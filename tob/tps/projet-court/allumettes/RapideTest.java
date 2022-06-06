package allumettes;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Scanner;

/** Classe de test pour la stratégie rapide.
  * @author	Kamal Hammi
  */
public class RapideTest {

	private Joueur j1;
	private Joueur j2;
	private Strategie strategie1;
	private Strategie strategie2;
	private Jeu jeu;	

	@Before public void setUp(){
		strategie1 = new StrategieRapide("Ordinateur1");
		strategie2 = new StrategieRapide("Ordinateur2");
		
		j1 = new Joueur("Ordinateur1",strategie1);
		j2 = new Joueur("Ordinateur2",strategie2);
		jeu = new JeuNonConfiant(13);
		
	}

	@Test
	public void testerRapide1() throws CoupInvalideException, OperationInterditException {
		assertEquals(jeu.getNombreAllumettes(),13);
		jeu.retirer(j1.getPrise(jeu));
		assertEquals(jeu.getNombreAllumettes(),10);
		jeu.retirer(j2.getPrise(jeu));
		assertEquals(jeu.getNombreAllumettes(),7);
		jeu.retirer(j1.getPrise(jeu));
		assertEquals(jeu.getNombreAllumettes(),4);
		jeu.retirer(j2.getPrise(jeu));
		assertEquals(jeu.getNombreAllumettes(),1);
		jeu.retirer(j1.getPrise(jeu));
		assertEquals(jeu.getNombreAllumettes(),0);
	}

	@Test
	public void testerRapide2() throws CoupInvalideException, OperationInterditException{
		assertEquals(jeu.getNombreAllumettes(),13);
		jeu.retirer(2);
		assertEquals(jeu.getNombreAllumettes(),11);
		jeu.retirer(j1.getPrise(jeu));
		assertEquals(jeu.getNombreAllumettes(),8);
		jeu.retirer(j2.getPrise(jeu));
		assertEquals(jeu.getNombreAllumettes(),5);
		jeu.retirer(j1.getPrise(jeu));
		assertEquals(jeu.getNombreAllumettes(),2);
		jeu.retirer(j2.getPrise(jeu));
		assertEquals(jeu.getNombreAllumettes(),0);
	}

	@Test
	public void testerRapide3() throws CoupInvalideException, OperationInterditException{
		assertEquals(jeu.getNombreAllumettes(),13);
		jeu.retirer(1);
		assertEquals(jeu.getNombreAllumettes(),12);
		jeu.retirer(j1.getPrise(jeu));
		assertEquals(jeu.getNombreAllumettes(),9);
		jeu.retirer(j2.getPrise(jeu));
		assertEquals(jeu.getNombreAllumettes(),6);
		jeu.retirer(j1.getPrise(jeu));
		assertEquals(jeu.getNombreAllumettes(),3);
		jeu.retirer(j2.getPrise(jeu));
		assertEquals(jeu.getNombreAllumettes(),0);
	}	

}

