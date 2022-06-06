/**
 */
package eNIGME;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Etat Reponse</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see eNIGME.ENIGMEPackage#getEtatReponse()
 * @model
 * @generated
 */
public enum EtatReponse implements Enumerator {
	/**
	 * The '<em><b>Bonne</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BONNE_VALUE
	 * @generated
	 * @ordered
	 */
	BONNE(0, "bonne", "bonne"),

	/**
	 * The '<em><b>Mauvaise</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAUVAISE_VALUE
	 * @generated
	 * @ordered
	 */
	MAUVAISE(1, "mauvaise", "mauvaise");

	/**
	 * The '<em><b>Bonne</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BONNE
	 * @model name="bonne"
	 * @generated
	 * @ordered
	 */
	public static final int BONNE_VALUE = 0;

	/**
	 * The '<em><b>Mauvaise</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAUVAISE
	 * @model name="mauvaise"
	 * @generated
	 * @ordered
	 */
	public static final int MAUVAISE_VALUE = 1;

	/**
	 * An array of all the '<em><b>Etat Reponse</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EtatReponse[] VALUES_ARRAY = new EtatReponse[] { BONNE, MAUVAISE, };

	/**
	 * A public read-only list of all the '<em><b>Etat Reponse</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EtatReponse> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Etat Reponse</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EtatReponse get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EtatReponse result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Etat Reponse</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EtatReponse getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EtatReponse result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Etat Reponse</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EtatReponse get(int value) {
		switch (value) {
		case BONNE_VALUE:
			return BONNE;
		case MAUVAISE_VALUE:
			return MAUVAISE;
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
	private EtatReponse(int value, String name, String literal) {
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

} //EtatReponse
