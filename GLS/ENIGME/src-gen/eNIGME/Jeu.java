/**
 */
package eNIGME;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jeu</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eNIGME.Jeu#getName <em>Name</em>}</li>
 *   <li>{@link eNIGME.Jeu#getJeuelement <em>Jeuelement</em>}</li>
 * </ul>
 *
 * @see eNIGME.ENIGMEPackage#getJeu()
 * @model
 * @generated
 */
public interface Jeu extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eNIGME.ENIGMEPackage#getJeu_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eNIGME.Jeu#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Jeuelement</b></em>' containment reference list.
	 * The list contents are of type {@link eNIGME.JeuElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jeuelement</em>' containment reference list.
	 * @see eNIGME.ENIGMEPackage#getJeu_Jeuelement()
	 * @model containment="true"
	 * @generated
	 */
	EList<JeuElement> getJeuelement();

} // Jeu
