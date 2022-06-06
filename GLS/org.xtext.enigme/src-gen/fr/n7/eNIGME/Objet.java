/**
 * generated by Xtext 2.23.0
 */
package fr.n7.eNIGME;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Objet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.n7.eNIGME.Objet#getName <em>Name</em>}</li>
 *   <li>{@link fr.n7.eNIGME.Objet#getNomObjet <em>Nom Objet</em>}</li>
 *   <li>{@link fr.n7.eNIGME.Objet#getOccurrence <em>Occurrence</em>}</li>
 *   <li>{@link fr.n7.eNIGME.Objet#getTaille <em>Taille</em>}</li>
 *   <li>{@link fr.n7.eNIGME.Objet#getEtatv <em>Etatv</em>}</li>
 *   <li>{@link fr.n7.eNIGME.Objet#getEtatp <em>Etatp</em>}</li>
 * </ul>
 *
 * @see fr.n7.eNIGME.ENIGMEPackage#getObjet()
 * @model
 * @generated
 */
public interface Objet extends JeuElement
{
  /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.n7.eNIGME.ENIGMEPackage#getObjet_Name()
	 * @model
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link fr.n7.eNIGME.Objet#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
  void setName(String value);

  /**
	 * Returns the value of the '<em><b>Nom Objet</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Nom Objet</em>' attribute.
	 * @see #setNomObjet(String)
	 * @see fr.n7.eNIGME.ENIGMEPackage#getObjet_NomObjet()
	 * @model
	 * @generated
	 */
  String getNomObjet();

  /**
	 * Sets the value of the '{@link fr.n7.eNIGME.Objet#getNomObjet <em>Nom Objet</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nom Objet</em>' attribute.
	 * @see #getNomObjet()
	 * @generated
	 */
  void setNomObjet(String value);

  /**
	 * Returns the value of the '<em><b>Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Occurrence</em>' attribute.
	 * @see #setOccurrence(int)
	 * @see fr.n7.eNIGME.ENIGMEPackage#getObjet_Occurrence()
	 * @model
	 * @generated
	 */
  int getOccurrence();

  /**
	 * Sets the value of the '{@link fr.n7.eNIGME.Objet#getOccurrence <em>Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Occurrence</em>' attribute.
	 * @see #getOccurrence()
	 * @generated
	 */
  void setOccurrence(int value);

  /**
	 * Returns the value of the '<em><b>Taille</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Taille</em>' attribute.
	 * @see #setTaille(int)
	 * @see fr.n7.eNIGME.ENIGMEPackage#getObjet_Taille()
	 * @model
	 * @generated
	 */
  int getTaille();

  /**
	 * Sets the value of the '{@link fr.n7.eNIGME.Objet#getTaille <em>Taille</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Taille</em>' attribute.
	 * @see #getTaille()
	 * @generated
	 */
  void setTaille(int value);

  /**
	 * Returns the value of the '<em><b>Etatv</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.n7.eNIGME.EtatVisibilite}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Etatv</em>' attribute.
	 * @see fr.n7.eNIGME.EtatVisibilite
	 * @see #setEtatv(EtatVisibilite)
	 * @see fr.n7.eNIGME.ENIGMEPackage#getObjet_Etatv()
	 * @model
	 * @generated
	 */
  EtatVisibilite getEtatv();

  /**
	 * Sets the value of the '{@link fr.n7.eNIGME.Objet#getEtatv <em>Etatv</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Etatv</em>' attribute.
	 * @see fr.n7.eNIGME.EtatVisibilite
	 * @see #getEtatv()
	 * @generated
	 */
  void setEtatv(EtatVisibilite value);

  /**
	 * Returns the value of the '<em><b>Etatp</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.n7.eNIGME.EtatPossession}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Etatp</em>' attribute.
	 * @see fr.n7.eNIGME.EtatPossession
	 * @see #setEtatp(EtatPossession)
	 * @see fr.n7.eNIGME.ENIGMEPackage#getObjet_Etatp()
	 * @model
	 * @generated
	 */
  EtatPossession getEtatp();

  /**
	 * Sets the value of the '{@link fr.n7.eNIGME.Objet#getEtatp <em>Etatp</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Etatp</em>' attribute.
	 * @see fr.n7.eNIGME.EtatPossession
	 * @see #getEtatp()
	 * @generated
	 */
  void setEtatp(EtatPossession value);

} // Objet