/**
 */
package eNIGME;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eNIGME.Condition#getName <em>Name</em>}</li>
 *   <li>{@link eNIGME.Condition#getObjetsRequis <em>Objets Requis</em>}</li>
 *   <li>{@link eNIGME.Condition#getConnaissancesRequises <em>Connaissances Requises</em>}</li>
 * </ul>
 *
 * @see eNIGME.ENIGMEPackage#getCondition()
 * @model
 * @generated
 */
public interface Condition extends JeuElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eNIGME.ENIGMEPackage#getCondition_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eNIGME.Condition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Objets Requis</b></em>' reference list.
	 * The list contents are of type {@link eNIGME.Objet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objets Requis</em>' reference list.
	 * @see eNIGME.ENIGMEPackage#getCondition_ObjetsRequis()
	 * @model
	 * @generated
	 */
	EList<Objet> getObjetsRequis();

	/**
	 * Returns the value of the '<em><b>Connaissances Requises</b></em>' reference list.
	 * The list contents are of type {@link eNIGME.Connaissance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connaissances Requises</em>' reference list.
	 * @see eNIGME.ENIGMEPackage#getCondition_ConnaissancesRequises()
	 * @model
	 * @generated
	 */
	EList<Connaissance> getConnaissancesRequises();

} // Condition
