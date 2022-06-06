/**
 * generated by Xtext 2.23.0
 */
package fr.n7.gAME;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Game</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.n7.gAME.Game#getName <em>Name</em>}</li>
 *   <li>{@link fr.n7.gAME.Game#getExplorateur <em>Explorateur</em>}</li>
 *   <li>{@link fr.n7.gAME.Game#getTerritoire <em>Territoire</em>}</li>
 * </ul>
 *
 * @see fr.n7.gAME.GAMEPackage#getGame()
 * @model
 * @generated
 */
public interface Game extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see fr.n7.gAME.GAMEPackage#getGame_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link fr.n7.gAME.Game#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Explorateur</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Explorateur</em>' containment reference.
   * @see #setExplorateur(Explorateur)
   * @see fr.n7.gAME.GAMEPackage#getGame_Explorateur()
   * @model containment="true"
   * @generated
   */
  Explorateur getExplorateur();

  /**
   * Sets the value of the '{@link fr.n7.gAME.Game#getExplorateur <em>Explorateur</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Explorateur</em>' containment reference.
   * @see #getExplorateur()
   * @generated
   */
  void setExplorateur(Explorateur value);

  /**
   * Returns the value of the '<em><b>Territoire</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Territoire</em>' containment reference.
   * @see #setTerritoire(Territoire)
   * @see fr.n7.gAME.GAMEPackage#getGame_Territoire()
   * @model containment="true"
   * @generated
   */
  Territoire getTerritoire();

  /**
   * Sets the value of the '{@link fr.n7.gAME.Game#getTerritoire <em>Territoire</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Territoire</em>' containment reference.
   * @see #getTerritoire()
   * @generated
   */
  void setTerritoire(Territoire value);

} // Game