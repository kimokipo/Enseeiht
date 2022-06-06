/**
 * generated by Xtext 2.23.0
 */
package fr.n7.gAME;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Territoire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.n7.gAME.Territoire#getLieuDepart <em>Lieu Depart</em>}</li>
 *   <li>{@link fr.n7.gAME.Territoire#getLieux <em>Lieux</em>}</li>
 *   <li>{@link fr.n7.gAME.Territoire#getLieuxFin <em>Lieux Fin</em>}</li>
 *   <li>{@link fr.n7.gAME.Territoire#getChemins <em>Chemins</em>}</li>
 * </ul>
 *
 * @see fr.n7.gAME.GAMEPackage#getTerritoire()
 * @model
 * @generated
 */
public interface Territoire extends EObject
{
  /**
   * Returns the value of the '<em><b>Lieu Depart</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lieu Depart</em>' containment reference.
   * @see #setLieuDepart(Lieu)
   * @see fr.n7.gAME.GAMEPackage#getTerritoire_LieuDepart()
   * @model containment="true"
   * @generated
   */
  Lieu getLieuDepart();

  /**
   * Sets the value of the '{@link fr.n7.gAME.Territoire#getLieuDepart <em>Lieu Depart</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lieu Depart</em>' containment reference.
   * @see #getLieuDepart()
   * @generated
   */
  void setLieuDepart(Lieu value);

  /**
   * Returns the value of the '<em><b>Lieux</b></em>' containment reference list.
   * The list contents are of type {@link fr.n7.gAME.Lieu}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lieux</em>' containment reference list.
   * @see fr.n7.gAME.GAMEPackage#getTerritoire_Lieux()
   * @model containment="true"
   * @generated
   */
  EList<Lieu> getLieux();

  /**
   * Returns the value of the '<em><b>Lieux Fin</b></em>' containment reference list.
   * The list contents are of type {@link fr.n7.gAME.Lieu}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lieux Fin</em>' containment reference list.
   * @see fr.n7.gAME.GAMEPackage#getTerritoire_LieuxFin()
   * @model containment="true"
   * @generated
   */
  EList<Lieu> getLieuxFin();

  /**
   * Returns the value of the '<em><b>Chemins</b></em>' containment reference list.
   * The list contents are of type {@link fr.n7.gAME.Chemin}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Chemins</em>' containment reference list.
   * @see fr.n7.gAME.GAMEPackage#getTerritoire_Chemins()
   * @model containment="true"
   * @generated
   */
  EList<Chemin> getChemins();

} // Territoire
