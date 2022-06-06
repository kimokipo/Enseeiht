/** Tester quelques cas limites.
  * @author	Xavier Crégut
  * @version	$Revision$
  */
public class CasLimitesTest {
	@UnTest
	public void testOK() {
		// OK.
	}
	
	@UnTest
	private void testMethodePrivee() {
		throw new RuntimeException("Une méthode privée n'est pas un test !");
	}
	
	@UnTest
	protected void testMethodeProtegee() {
		throw new RuntimeException("Une méthode protected n'est pas un test !");
	}
	
	@UnTest
	void testMethodePaquetage() {
		throw new RuntimeException("Une méthode de droit d'accès paquetage n'est pas un test !");
	}
	
	@UnTest
	public static void testMethodeDeClasse() {
		throw new RuntimeException("Une méthode de classe n'est pas un test !");
	}
	
	@UnTest
	public void testAvecParametre(int a) {
		throw new RuntimeException("Une méthode avec des paramètres n'est pas un test !");
	}
	
	@UnTest
	public void testAvecParametre2(int a) {
		throw new RuntimeException("Une méthode avec des paramètres n'est pas un test !");
	}

}
