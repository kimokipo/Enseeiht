/**
 */
package eNIGME;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choix</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eNIGME.Choix#getName <em>Name</em>}</li>
 *   <li>{@link eNIGME.Choix#getReponses <em>Reponses</em>}</li>
 *   <li>{@link eNIGME.Choix#getConditions <em>Conditions</em>}</li>
 * </ul>
 *
 * @see eNIGME.ENIGMEPackage#getChoix()
 * @model
 * @generated
 */
public interface Choix extends JeuElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eNIGME.ENIGMEPackage#getChoix_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eNIGME.Choix#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Reponses</b></em>' reference list.
	 * The list contents are of type {@link eNIGME.Reponse}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reponses</em>' reference list.
	 * @see eNIGME.ENIGMEPackage#getChoix_Reponses()
	 * @model
	 * @generated
	 */
	EList<Reponse> getReponses();

	/**
	 * Returns the value of the '<em><b>Conditions</b></em>' reference list.
	 * The list contents are of type {@link eNIGME.Condition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditions</em>' reference list.
	 * @see eNIGME.ENIGMEPackage#getChoix_Conditions()
	 * @model
	 * @generated
	 */
	EList<Condition> getConditions();

} // Choix
