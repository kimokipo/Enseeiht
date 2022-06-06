/**
 * generated by Xtext 2.23.0
 */
package org.xtext.enigme.eNIGME.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.xtext.enigme.eNIGME.ENIGMEFactory;
import org.xtext.enigme.eNIGME.Territoire;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Territoire</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TerritoireTest extends TestCase {

	/**
	 * The fixture for this Territoire test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Territoire fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TerritoireTest.class);
	}

	/**
	 * Constructs a new Territoire test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerritoireTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Territoire test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Territoire fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Territoire test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Territoire getFixture() {
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
		setFixture(ENIGMEFactory.eINSTANCE.createTerritoire());
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

} //TerritoireTest