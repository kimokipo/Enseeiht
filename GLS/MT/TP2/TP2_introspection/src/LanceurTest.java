import junit.framework.TestCase;

public class LanceurTest extends TestCase{
	protected LanceurIndependant l1;
	protected LanceurIndependant l2;
	protected LanceurIndependant l3;


	public void testerMonnaie1() {
		this.l1 = new LanceurIndependant("MonnaieTest");
		Assert.assertTrue(l1.getNbTests() == 2);
		Assert.assertTrue(l1.getNbEchecs() == 0);
		Assert.assertTrue(l1.getNbErreurs() == 0);
	}

	public void testerMonnaie2() {
		this.l2 = new LanceurIndependant("MonnaieTest2");
		Assert.assertTrue(l2.getNbTests() == 3);
		Assert.assertTrue(l2.getNbEchecs() == 0);
		Assert.assertTrue(l2.getNbErreurs() == 0);
	}
	

	public void testerCasLimitesTest() {
		this.l3 = new LanceurIndependant("CasLimitesTest");
		Assert.assertTrue(l3.getNbTests() == 1);
		Assert.assertTrue(l3.getNbEchecs() == 0);
		Assert.assertTrue(l3.getNbErreurs() == 0);
	}

}
