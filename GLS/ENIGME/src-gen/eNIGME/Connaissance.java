/**
 */
package eNIGME;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connaissance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eNIGME.Connaissance#getName <em>Name</em>}</li>
 *   <li>{@link eNIGME.Connaissance#getNomConnaissance <em>Nom Connaissance</em>}</li>
 *   <li>{@link eNIGME.Connaissance#getQualification <em>Qualification</em>}</li>
 *   <li>{@link eNIGME.Connaissance#getEtatv <em>Etatv</em>}</li>
 *   <li>{@link eNIGME.Connaissance#getEtatp <em>Etatp</em>}</li>
 * </ul>
 *
 * @see eNIGME.ENIGMEPackage#getConnaissance()
 * @model
 * @generated
 */
public interface Connaissance extends JeuElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eNIGME.ENIGMEPackage#getConnaissance_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eNIGME.Connaissance#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Nom Connaissance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nom Connaissance</em>' attribute.
	 * @see #setNomConnaissance(String)
	 * @see eNIGME.ENIGMEPackage#getConnaissance_NomConnaissance()
	 * @model
	 * @generated
	 */
	String getNomConnaissance();

	/**
	 * Sets the value of the '{@link eNIGME.Connaissance#getNomConnaissance <em>Nom Connaissance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nom Connaissance</em>' attribute.
	 * @see #getNomConnaissance()
	 * @generated
	 */
	void setNomConnaissance(String value);

	/**
	 * Returns the value of the '<em><b>Qualification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualification</em>' reference.
	 * @see #setQualification(Qualification)
	 * @see eNIGME.ENIGMEPackage#getConnaissance_Qualification()
	 * @model
	 * @generated
	 */
	Qualification getQualification();

	/**
	 * Sets the value of the '{@link eNIGME.Connaissance#getQualification <em>Qualification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualification</em>' reference.
	 * @see #getQualification()
	 * @generated
	 */
	void setQualification(Qualification value);

	/**
	 * Returns the value of the '<em><b>Etatv</b></em>' attribute.
	 * The literals are from the enumeration {@link eNIGME.EtatVisibilite}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Etatv</em>' attribute.
	 * @see eNIGME.EtatVisibilite
	 * @see #setEtatv(EtatVisibilite)
	 * @see eNIGME.ENIGMEPackage#getConnaissance_Etatv()
	 * @model
	 * @generated
	 */
	EtatVisibilite getEtatv();

	/**
	 * Sets the value of the '{@link eNIGME.Connaissance#getEtatv <em>Etatv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Etatv</em>' attribute.
	 * @see eNIGME.EtatVisibilite
	 * @see #getEtatv()
	 * @generated
	 */
	void setEtatv(EtatVisibilite value);

	/**
	 * Returns the value of the '<em><b>Etatp</b></em>' attribute.
	 * The literals are from the enumeration {@link eNIGME.EtatPossession}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Etatp</em>' attribute.
	 * @see eNIGME.EtatPossession
	 * @see #setEtatp(EtatPossession)
	 * @see eNIGME.ENIGMEPackage#getConnaissance_Etatp()
	 * @model
	 * @generated
	 */
	EtatPossession getEtatp();

	/**
	 * Sets the value of the '{@link eNIGME.Connaissance#getEtatp <em>Etatp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Etatp</em>' attribute.
	 * @see eNIGME.EtatPossession
	 * @see #getEtatp()
	 * @generated
	 */
	void setEtatp(EtatPossession value);

} // Connaissance
