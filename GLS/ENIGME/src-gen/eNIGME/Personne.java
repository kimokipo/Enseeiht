/**
 */
package eNIGME;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Personne</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eNIGME.Personne#getName <em>Name</em>}</li>
 *   <li>{@link eNIGME.Personne#getEtato <em>Etato</em>}</li>
 *   <li>{@link eNIGME.Personne#getConditiono <em>Conditiono</em>}</li>
 *   <li>{@link eNIGME.Personne#getEtatv <em>Etatv</em>}</li>
 *   <li>{@link eNIGME.Personne#getConditionv <em>Conditionv</em>}</li>
 *   <li>{@link eNIGME.Personne#getTexte <em>Texte</em>}</li>
 *   <li>{@link eNIGME.Personne#getInteraction <em>Interaction</em>}</li>
 * </ul>
 *
 * @see eNIGME.ENIGMEPackage#getPersonne()
 * @model
 * @generated
 */
public interface Personne extends JeuElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eNIGME.ENIGMEPackage#getPersonne_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eNIGME.Personne#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Etato</b></em>' attribute.
	 * The literals are from the enumeration {@link eNIGME.EtatObligation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Etato</em>' attribute.
	 * @see eNIGME.EtatObligation
	 * @see #setEtato(EtatObligation)
	 * @see eNIGME.ENIGMEPackage#getPersonne_Etato()
	 * @model
	 * @generated
	 */
	EtatObligation getEtato();

	/**
	 * Sets the value of the '{@link eNIGME.Personne#getEtato <em>Etato</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Etato</em>' attribute.
	 * @see eNIGME.EtatObligation
	 * @see #getEtato()
	 * @generated
	 */
	void setEtato(EtatObligation value);

	/**
	 * Returns the value of the '<em><b>Conditiono</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditiono</em>' reference.
	 * @see #setConditiono(Condition)
	 * @see eNIGME.ENIGMEPackage#getPersonne_Conditiono()
	 * @model
	 * @generated
	 */
	Condition getConditiono();

	/**
	 * Sets the value of the '{@link eNIGME.Personne#getConditiono <em>Conditiono</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conditiono</em>' reference.
	 * @see #getConditiono()
	 * @generated
	 */
	void setConditiono(Condition value);

	/**
	 * Returns the value of the '<em><b>Etatv</b></em>' attribute.
	 * The literals are from the enumeration {@link eNIGME.EtatVisibilite}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Etatv</em>' attribute.
	 * @see eNIGME.EtatVisibilite
	 * @see #setEtatv(EtatVisibilite)
	 * @see eNIGME.ENIGMEPackage#getPersonne_Etatv()
	 * @model
	 * @generated
	 */
	EtatVisibilite getEtatv();

	/**
	 * Sets the value of the '{@link eNIGME.Personne#getEtatv <em>Etatv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Etatv</em>' attribute.
	 * @see eNIGME.EtatVisibilite
	 * @see #getEtatv()
	 * @generated
	 */
	void setEtatv(EtatVisibilite value);

	/**
	 * Returns the value of the '<em><b>Conditionv</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditionv</em>' reference.
	 * @see #setConditionv(Condition)
	 * @see eNIGME.ENIGMEPackage#getPersonne_Conditionv()
	 * @model
	 * @generated
	 */
	Condition getConditionv();

	/**
	 * Sets the value of the '{@link eNIGME.Personne#getConditionv <em>Conditionv</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conditionv</em>' reference.
	 * @see #getConditionv()
	 * @generated
	 */
	void setConditionv(Condition value);

	/**
	 * Returns the value of the '<em><b>Texte</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Texte</em>' reference.
	 * @see #setTexte(Qualification)
	 * @see eNIGME.ENIGMEPackage#getPersonne_Texte()
	 * @model
	 * @generated
	 */
	Qualification getTexte();

	/**
	 * Sets the value of the '{@link eNIGME.Personne#getTexte <em>Texte</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Texte</em>' reference.
	 * @see #getTexte()
	 * @generated
	 */
	void setTexte(Qualification value);

	/**
	 * Returns the value of the '<em><b>Interaction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interaction</em>' reference.
	 * @see #setInteraction(Interaction)
	 * @see eNIGME.ENIGMEPackage#getPersonne_Interaction()
	 * @model
	 * @generated
	 */
	Interaction getInteraction();

	/**
	 * Sets the value of the '{@link eNIGME.Personne#getInteraction <em>Interaction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interaction</em>' reference.
	 * @see #getInteraction()
	 * @generated
	 */
	void setInteraction(Interaction value);

} // Personne
