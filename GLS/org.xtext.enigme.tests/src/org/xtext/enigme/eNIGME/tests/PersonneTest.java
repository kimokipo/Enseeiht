/**
 * generated by Xtext 2.23.0
 */
package org.xtext.enigme.eNIGME.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.xtext.enigme.eNIGME.ENIGMEFactory;
import org.xtext.enigme.eNIGME.Personne;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Personne</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PersonneTest extends TestCase {

	/**
	 * The fixture for this Personne test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Personne fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PersonneTest.class);
	}

	/**
	 * Constructs a new Personne test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersonneTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Personne test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Personne fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Personne test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Personne getFixture() {
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
		setFixture(ENIGMEFactory.eINSTANCE.createPersonne());
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

} //PersonneTest
