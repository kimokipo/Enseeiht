/**
 */
package eNIGME;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Etat Chemin</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see eNIGME.ENIGMEPackage#getEtatChemin()
 * @model
 * @generated
 */
public enum EtatChemin implements Enumerator {
	/**
	 * The '<em><b>Ouvert</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUVERT_VALUE
	 * @generated
	 * @ordered
	 */
	OUVERT(0, "ouvert", "ouvert"),

	/**
	 * The '<em><b>Ferme</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FERME_VALUE
	 * @generated
	 * @ordered
	 */
	FERME(1, "ferme", "ferme");

	/**
	 * The '<em><b>Ouvert</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUVERT
	 * @model name="ouvert"
	 * @generated
	 * @ordered
	 */
	public static final int OUVERT_VALUE = 0;

	/**
	 * The '<em><b>Ferme</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FERME
	 * @model name="ferme"
	 * @generated
	 * @ordered
	 */
	public static final int FERME_VALUE = 1;

	/**
	 * An array of all the '<em><b>Etat Chemin</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EtatChemin[] VALUES_ARRAY = new EtatChemin[] { OUVERT, FERME, };

	/**
	 * A public read-only list of all the '<em><b>Etat Chemin</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EtatChemin> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Etat Chemin</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EtatChemin get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EtatChemin result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Etat Chemin</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EtatChemin getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EtatChemin result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Etat Chemin</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EtatChemin get(int value) {
		switch (value) {
		case OUVERT_VALUE:
			return OUVERT;
		case FERME_VALUE:
			return FERME;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EtatChemin(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //EtatChemin
