/**
 * generated by Xtext 2.23.0
 */
package org.xtext.enigme.eNIGME.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.xtext.enigme.eNIGME.Choix;
import org.xtext.enigme.eNIGME.ENIGMEFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Choix</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ChoixTest extends TestCase {

	/**
	 * The fixture for this Choix test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Choix fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ChoixTest.class);
	}

	/**
	 * Constructs a new Choix test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChoixTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Choix test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Choix fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Choix test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Choix getFixture() {
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
		setFixture(ENIGMEFactory.eINSTANCE.createChoix());
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

} //ChoixTest
