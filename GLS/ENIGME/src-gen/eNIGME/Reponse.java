/**
 */
package eNIGME;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reponse</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eNIGME.Reponse#getName <em>Name</em>}</li>
 *   <li>{@link eNIGME.Reponse#getEtat <em>Etat</em>}</li>
 *   <li>{@link eNIGME.Reponse#getTexte <em>Texte</em>}</li>
 *   <li>{@link eNIGME.Reponse#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @see eNIGME.ENIGMEPackage#getReponse()
 * @model
 * @generated
 */
public interface Reponse extends JeuElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eNIGME.ENIGMEPackage#getReponse_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eNIGME.Reponse#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Etat</b></em>' attribute.
	 * The literals are from the enumeration {@link eNIGME.EtatReponse}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Etat</em>' attribute.
	 * @see eNIGME.EtatReponse
	 * @see #setEtat(EtatReponse)
	 * @see eNIGME.ENIGMEPackage#getReponse_Etat()
	 * @model
	 * @generated
	 */
	EtatReponse getEtat();

	/**
	 * Sets the value of the '{@link eNIGME.Reponse#getEtat <em>Etat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Etat</em>' attribute.
	 * @see eNIGME.EtatReponse
	 * @see #getEtat()
	 * @generated
	 */
	void setEtat(EtatReponse value);

	/**
	 * Returns the value of the '<em><b>Texte</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Texte</em>' reference.
	 * @see #setTexte(Qualification)
	 * @see eNIGME.ENIGMEPackage#getReponse_Texte()
	 * @model
	 * @generated
	 */
	Qualification getTexte();

	/**
	 * Sets the value of the '{@link eNIGME.Reponse#getTexte <em>Texte</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Texte</em>' reference.
	 * @see #getTexte()
	 * @generated
	 */
	void setTexte(Qualification value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' reference.
	 * @see #setAction(Action)
	 * @see eNIGME.ENIGMEPackage#getReponse_Action()
	 * @model
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link eNIGME.Reponse#getAction <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

} // Reponse
