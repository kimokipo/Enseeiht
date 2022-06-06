/**
 * generated by Xtext 2.23.0
 */
package fr.n7.gAME;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.n7.gAME.Condition#isVal <em>Val</em>}</li>
 *   <li>{@link fr.n7.gAME.Condition#getObjetsTrue <em>Objets True</em>}</li>
 *   <li>{@link fr.n7.gAME.Condition#getObjetsFalse <em>Objets False</em>}</li>
 *   <li>{@link fr.n7.gAME.Condition#getConnaissanceTrue <em>Connaissance True</em>}</li>
 *   <li>{@link fr.n7.gAME.Condition#getConnaissanceFalse <em>Connaissance False</em>}</li>
 *   <li>{@link fr.n7.gAME.Condition#getLieuxExplores <em>Lieux Explores</em>}</li>
 * </ul>
 *
 * @see fr.n7.gAME.GAMEPackage#getCondition()
 * @model
 * @generated
 */
public interface Condition extends EObject
{
  /**
   * Returns the value of the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val</em>' attribute.
   * @see #setVal(boolean)
   * @see fr.n7.gAME.GAMEPackage#getCondition_Val()
   * @model
   * @generated
   */
  boolean isVal();

  /**
   * Sets the value of the '{@link fr.n7.gAME.Condition#isVal <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val</em>' attribute.
   * @see #isVal()
   * @generated
   */
  void setVal(boolean value);

  /**
   * Returns the value of the '<em><b>Objets True</b></em>' reference list.
   * The list contents are of type {@link fr.n7.gAME.Objet}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Objets True</em>' reference list.
   * @see fr.n7.gAME.GAMEPackage#getCondition_ObjetsTrue()
   * @model
   * @generated
   */
  EList<Objet> getObjetsTrue();

  /**
   * Returns the value of the '<em><b>Objets False</b></em>' reference list.
   * The list contents are of type {@link fr.n7.gAME.Objet}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Objets False</em>' reference list.
   * @see fr.n7.gAME.GAMEPackage#getCondition_ObjetsFalse()
   * @model
   * @generated
   */
  EList<Objet> getObjetsFalse();

  /**
   * Returns the value of the '<em><b>Connaissance True</b></em>' reference list.
   * The list contents are of type {@link fr.n7.gAME.Connaissance}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connaissance True</em>' reference list.
   * @see fr.n7.gAME.GAMEPackage#getCondition_ConnaissanceTrue()
   * @model
   * @generated
   */
  EList<Connaissance> getConnaissanceTrue();

  /**
   * Returns the value of the '<em><b>Connaissance False</b></em>' reference list.
   * The list contents are of type {@link fr.n7.gAME.Connaissance}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connaissance False</em>' reference list.
   * @see fr.n7.gAME.GAMEPackage#getCondition_ConnaissanceFalse()
   * @model
   * @generated
   */
  EList<Connaissance> getConnaissanceFalse();

  /**
   * Returns the value of the '<em><b>Lieux Explores</b></em>' reference list.
   * The list contents are of type {@link fr.n7.gAME.Lieu}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lieux Explores</em>' reference list.
   * @see fr.n7.gAME.GAMEPackage#getCondition_LieuxExplores()
   * @model
   * @generated
   */
  EList<Lieu> getLieuxExplores();

} // Condition
