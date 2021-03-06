/**
 * generated by Xtext 2.23.0
 */
package fr.n7.gAME;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Objet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.n7.gAME.Objet#getName <em>Name</em>}</li>
 *   <li>{@link fr.n7.gAME.Objet#getInitVal <em>Init Val</em>}</li>
 *   <li>{@link fr.n7.gAME.Objet#getTaille <em>Taille</em>}</li>
 *   <li>{@link fr.n7.gAME.Objet#getEtat <em>Etat</em>}</li>
 *   <li>{@link fr.n7.gAME.Objet#getCondition <em>Condition</em>}</li>
 *   <li>{@link fr.n7.gAME.Objet#getQualification <em>Qualification</em>}</li>
 * </ul>
 *
 * @see fr.n7.gAME.GAMEPackage#getObjet()
 * @model
 * @generated
 */
public interface Objet extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see fr.n7.gAME.GAMEPackage#getObjet_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link fr.n7.gAME.Objet#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Init Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init Val</em>' attribute.
   * @see #setInitVal(int)
   * @see fr.n7.gAME.GAMEPackage#getObjet_InitVal()
   * @model
   * @generated
   */
  int getInitVal();

  /**
   * Sets the value of the '{@link fr.n7.gAME.Objet#getInitVal <em>Init Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Init Val</em>' attribute.
   * @see #getInitVal()
   * @generated
   */
  void setInitVal(int value);

  /**
   * Returns the value of the '<em><b>Taille</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Taille</em>' attribute.
   * @see #setTaille(int)
   * @see fr.n7.gAME.GAMEPackage#getObjet_Taille()
   * @model
   * @generated
   */
  int getTaille();

  /**
   * Sets the value of the '{@link fr.n7.gAME.Objet#getTaille <em>Taille</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Taille</em>' attribute.
   * @see #getTaille()
   * @generated
   */
  void setTaille(int value);

  /**
   * Returns the value of the '<em><b>Etat</b></em>' attribute.
   * The literals are from the enumeration {@link fr.n7.gAME.EtatVisibilite}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Etat</em>' attribute.
   * @see fr.n7.gAME.EtatVisibilite
   * @see #setEtat(EtatVisibilite)
   * @see fr.n7.gAME.GAMEPackage#getObjet_Etat()
   * @model
   * @generated
   */
  EtatVisibilite getEtat();

  /**
   * Sets the value of the '{@link fr.n7.gAME.Objet#getEtat <em>Etat</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Etat</em>' attribute.
   * @see fr.n7.gAME.EtatVisibilite
   * @see #getEtat()
   * @generated
   */
  void setEtat(EtatVisibilite value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Condition)
   * @see fr.n7.gAME.GAMEPackage#getObjet_Condition()
   * @model containment="true"
   * @generated
   */
  Condition getCondition();

  /**
   * Sets the value of the '{@link fr.n7.gAME.Objet#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Condition value);

  /**
   * Returns the value of the '<em><b>Qualification</b></em>' containment reference list.
   * The list contents are of type {@link fr.n7.gAME.Qualification}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualification</em>' containment reference list.
   * @see fr.n7.gAME.GAMEPackage#getObjet_Qualification()
   * @model containment="true"
   * @generated
   */
  EList<Qualification> getQualification();

} // Objet
