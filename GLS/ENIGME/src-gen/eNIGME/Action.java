/**
 */
package eNIGME;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eNIGME.Action#getName <em>Name</em>}</li>
 *   <li>{@link eNIGME.Action#getObjetsconsommables <em>Objetsconsommables</em>}</li>
 *   <li>{@link eNIGME.Action#getObjetsattribuables <em>Objetsattribuables</em>}</li>
 *   <li>{@link eNIGME.Action#getConnaissancesattribuables <em>Connaissancesattribuables</em>}</li>
 * </ul>
 *
 * @see eNIGME.ENIGMEPackage#getAction()
 * @model
 * @generated
 */
public interface Action extends JeuElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eNIGME.ENIGMEPackage#getAction_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eNIGME.Action#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Objetsconsommables</b></em>' reference list.
	 * The list contents are of type {@link eNIGME.Objet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objetsconsommables</em>' reference list.
	 * @see eNIGME.ENIGMEPackage#getAction_Objetsconsommables()
	 * @model
	 * @generated
	 */
	EList<Objet> getObjetsconsommables();

	/**
	 * Returns the value of the '<em><b>Objetsattribuables</b></em>' reference list.
	 * The list contents are of type {@link eNIGME.Objet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objetsattribuables</em>' reference list.
	 * @see eNIGME.ENIGMEPackage#getAction_Objetsattribuables()
	 * @model
	 * @generated
	 */
	EList<Objet> getObjetsattribuables();

	/**
	 * Returns the value of the '<em><b>Connaissancesattribuables</b></em>' reference list.
	 * The list contents are of type {@link eNIGME.Connaissance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connaissancesattribuables</em>' reference list.
	 * @see eNIGME.ENIGMEPackage#getAction_Connaissancesattribuables()
	 * @model
	 * @generated
	 */
	EList<Connaissance> getConnaissancesattribuables();

} // Action
