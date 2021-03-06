/**
 * generated by Xtext 2.23.0
 */
package fr.n7.eNIGME;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jeu</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.n7.eNIGME.Jeu#getName <em>Name</em>}</li>
 *   <li>{@link fr.n7.eNIGME.Jeu#getJeuelement <em>Jeuelement</em>}</li>
 * </ul>
 *
 * @see fr.n7.eNIGME.ENIGMEPackage#getJeu()
 * @model
 * @generated
 */
public interface Jeu extends EObject
{
  /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.n7.eNIGME.ENIGMEPackage#getJeu_Name()
	 * @model
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link fr.n7.eNIGME.Jeu#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
  void setName(String value);

  /**
	 * Returns the value of the '<em><b>Jeuelement</b></em>' containment reference list.
	 * The list contents are of type {@link fr.n7.eNIGME.JeuElement}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Jeuelement</em>' containment reference list.
	 * @see fr.n7.eNIGME.ENIGMEPackage#getJeu_Jeuelement()
	 * @model containment="true"
	 * @generated
	 */
  EList<JeuElement> getJeuelement();

} // Jeu
