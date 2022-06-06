/**
 */
package eNIGME;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Joueur</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eNIGME.Joueur#getName <em>Name</em>}</li>
 *   <li>{@link eNIGME.Joueur#getLimite <em>Limite</em>}</li>
 *   <li>{@link eNIGME.Joueur#getObjets <em>Objets</em>}</li>
 *   <li>{@link eNIGME.Joueur#getConnaissances <em>Connaissances</em>}</li>
 * </ul>
 *
 * @see eNIGME.ENIGMEPackage#getJoueur()
 * @model
 * @generated
 */
public interface Joueur extends JeuElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eNIGME.ENIGMEPackage#getJoueur_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eNIGME.Joueur#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Limite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Limite</em>' attribute.
	 * @see #setLimite(int)
	 * @see eNIGME.ENIGMEPackage#getJoueur_Limite()
	 * @model
	 * @generated
	 */
	int getLimite();

	/**
	 * Sets the value of the '{@link eNIGME.Joueur#getLimite <em>Limite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Limite</em>' attribute.
	 * @see #getLimite()
	 * @generated
	 */
	void setLimite(int value);

	/**
	 * Returns the value of the '<em><b>Objets</b></em>' reference list.
	 * The list contents are of type {@link eNIGME.Objet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objets</em>' reference list.
	 * @see eNIGME.ENIGMEPackage#getJoueur_Objets()
	 * @model
	 * @generated
	 */
	EList<Objet> getObjets();

	/**
	 * Returns the value of the '<em><b>Connaissances</b></em>' reference list.
	 * The list contents are of type {@link eNIGME.Connaissance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connaissances</em>' reference list.
	 * @see eNIGME.ENIGMEPackage#getJoueur_Connaissances()
	 * @model
	 * @generated
	 */
	EList<Connaissance> getConnaissances();

} // Joueur
