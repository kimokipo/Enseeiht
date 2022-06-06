/**
 */
package eNIGME;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lieu</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eNIGME.Lieu#getName <em>Name</em>}</li>
 *   <li>{@link eNIGME.Lieu#getPersonnes <em>Personnes</em>}</li>
 * </ul>
 *
 * @see eNIGME.ENIGMEPackage#getLieu()
 * @model
 * @generated
 */
public interface Lieu extends JeuElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eNIGME.ENIGMEPackage#getLieu_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eNIGME.Lieu#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Personnes</b></em>' containment reference list.
	 * The list contents are of type {@link eNIGME.Personne}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Personnes</em>' containment reference list.
	 * @see eNIGME.ENIGMEPackage#getLieu_Personnes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Personne> getPersonnes();

} // Lieu
