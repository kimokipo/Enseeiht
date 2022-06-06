/**
 * generated by Xtext 2.23.0
 */
package fr.n7.eNIGME.tests;

import fr.n7.eNIGME.ENIGMEFactory;
import fr.n7.eNIGME.Jeu;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Jeu</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class JeuTest extends TestCase {

	/**
	 * The fixture for this Jeu test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Jeu fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(JeuTest.class);
	}

	/**
	 * Constructs a new Jeu test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JeuTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Jeu test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Jeu fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Jeu test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Jeu getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ENIGMEFactory.eINSTANCE.createJeu());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //JeuTest