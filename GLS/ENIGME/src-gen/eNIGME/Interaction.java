/**
 */
package eNIGME;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eNIGME.Interaction#getName <em>Name</em>}</li>
 *   <li>{@link eNIGME.Interaction#getChoix <em>Choix</em>}</li>
 *   <li>{@link eNIGME.Interaction#getChoixFin <em>Choix Fin</em>}</li>
 * </ul>
 *
 * @see eNIGME.ENIGMEPackage#getInteraction()
 * @model
 * @generated
 */
public interface Interaction extends JeuElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eNIGME.ENIGMEPackage#getInteraction_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eNIGME.Interaction#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Choix</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choix</em>' reference.
	 * @see #setChoix(Choix)
	 * @see eNIGME.ENIGMEPackage#getInteraction_Choix()
	 * @model
	 * @generated
	 */
	Choix getChoix();

	/**
	 * Sets the value of the '{@link eNIGME.Interaction#getChoix <em>Choix</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Choix</em>' reference.
	 * @see #getChoix()
	 * @generated
	 */
	void setChoix(Choix value);

	/**
	 * Returns the value of the '<em><b>Choix Fin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choix Fin</em>' reference.
	 * @see #setChoixFin(Choix)
	 * @see eNIGME.ENIGMEPackage#getInteraction_ChoixFin()
	 * @model
	 * @generated
	 */
	Choix getChoixFin();

	/**
	 * Sets the value of the '{@link eNIGME.Interaction#getChoixFin <em>Choix Fin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Choix Fin</em>' reference.
	 * @see #getChoixFin()
	 * @generated
	 */
	void setChoixFin(Choix value);

} // Interaction
