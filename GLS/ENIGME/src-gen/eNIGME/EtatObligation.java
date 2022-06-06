/**
 */
package eNIGME;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Etat Obligation</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see eNIGME.ENIGMEPackage#getEtatObligation()
 * @model
 * @generated
 */
public enum EtatObligation implements Enumerator {
	/**
	 * The '<em><b>Obligatoire</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OBLIGATOIRE_VALUE
	 * @generated
	 * @ordered
	 */
	OBLIGATOIRE(0, "obligatoire", "obligatoire"),

	/**
	 * The '<em><b>Nobligatoire</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOBLIGATOIRE_VALUE
	 * @generated
	 * @ordered
	 */
	NOBLIGATOIRE(1, "nobligatoire", "nobligatoire");

	/**
	 * The '<em><b>Obligatoire</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OBLIGATOIRE
	 * @model name="obligatoire"
	 * @generated
	 * @ordered
	 */
	public static final int OBLIGATOIRE_VALUE = 0;

	/**
	 * The '<em><b>Nobligatoire</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOBLIGATOIRE
	 * @model name="nobligatoire"
	 * @generated
	 * @ordered
	 */
	public static final int NOBLIGATOIRE_VALUE = 1;

	/**
	 * An array of all the '<em><b>Etat Obligation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EtatObligation[] VALUES_ARRAY = new EtatObligation[] { OBLIGATOIRE, NOBLIGATOIRE, };

	/**
	 * A public read-only list of all the '<em><b>Etat Obligation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EtatObligation> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Etat Obligation</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EtatObligation get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EtatObligation result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Etat Obligation</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EtatObligation getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EtatObligation result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Etat Obligation</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EtatObligation get(int value) {
		switch (value) {
		case OBLIGATOIRE_VALUE:
			return OBLIGATOIRE;
		case NOBLIGATOIRE_VALUE:
			return NOBLIGATOIRE;
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
	private EtatObligation(int value, String name, String literal) {
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

} //EtatObligation
