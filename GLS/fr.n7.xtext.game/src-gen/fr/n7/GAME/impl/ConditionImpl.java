/**
 * generated by Xtext 2.23.0
 */
package fr.n7.gAME.impl;

import fr.n7.gAME.Condition;
import fr.n7.gAME.Connaissance;
import fr.n7.gAME.GAMEPackage;
import fr.n7.gAME.Lieu;
import fr.n7.gAME.Objet;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.n7.gAME.impl.ConditionImpl#isVal <em>Val</em>}</li>
 *   <li>{@link fr.n7.gAME.impl.ConditionImpl#getObjetsTrue <em>Objets True</em>}</li>
 *   <li>{@link fr.n7.gAME.impl.ConditionImpl#getObjetsFalse <em>Objets False</em>}</li>
 *   <li>{@link fr.n7.gAME.impl.ConditionImpl#getConnaissanceTrue <em>Connaissance True</em>}</li>
 *   <li>{@link fr.n7.gAME.impl.ConditionImpl#getConnaissanceFalse <em>Connaissance False</em>}</li>
 *   <li>{@link fr.n7.gAME.impl.ConditionImpl#getLieuxExplores <em>Lieux Explores</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConditionImpl extends MinimalEObjectImpl.Container implements Condition
{
  /**
   * The default value of the '{@link #isVal() <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVal()
   * @generated
   * @ordered
   */
  protected static final boolean VAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isVal() <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVal()
   * @generated
   * @ordered
   */
  protected boolean val = VAL_EDEFAULT;

  /**
   * The cached value of the '{@link #getObjetsTrue() <em>Objets True</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjetsTrue()
   * @generated
   * @ordered
   */
  protected EList<Objet> objetsTrue;

  /**
   * The cached value of the '{@link #getObjetsFalse() <em>Objets False</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjetsFalse()
   * @generated
   * @ordered
   */
  protected EList<Objet> objetsFalse;

  /**
   * The cached value of the '{@link #getConnaissanceTrue() <em>Connaissance True</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConnaissanceTrue()
   * @generated
   * @ordered
   */
  protected EList<Connaissance> connaissanceTrue;

  /**
   * The cached value of the '{@link #getConnaissanceFalse() <em>Connaissance False</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConnaissanceFalse()
   * @generated
   * @ordered
   */
  protected EList<Connaissance> connaissanceFalse;

  /**
   * The cached value of the '{@link #getLieuxExplores() <em>Lieux Explores</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLieuxExplores()
   * @generated
   * @ordered
   */
  protected EList<Lieu> lieuxExplores;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConditionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return GAMEPackage.Literals.CONDITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isVal()
  {
    return val;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setVal(boolean newVal)
  {
    boolean oldVal = val;
    val = newVal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GAMEPackage.CONDITION__VAL, oldVal, val));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Objet> getObjetsTrue()
  {
    if (objetsTrue == null)
    {
      objetsTrue = new EObjectResolvingEList<Objet>(Objet.class, this, GAMEPackage.CONDITION__OBJETS_TRUE);
    }
    return objetsTrue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Objet> getObjetsFalse()
  {
    if (objetsFalse == null)
    {
      objetsFalse = new EObjectResolvingEList<Objet>(Objet.class, this, GAMEPackage.CONDITION__OBJETS_FALSE);
    }
    return objetsFalse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Connaissance> getConnaissanceTrue()
  {
    if (connaissanceTrue == null)
    {
      connaissanceTrue = new EObjectResolvingEList<Connaissance>(Connaissance.class, this, GAMEPackage.CONDITION__CONNAISSANCE_TRUE);
    }
    return connaissanceTrue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Connaissance> getConnaissanceFalse()
  {
    if (connaissanceFalse == null)
    {
      connaissanceFalse = new EObjectResolvingEList<Connaissance>(Connaissance.class, this, GAMEPackage.CONDITION__CONNAISSANCE_FALSE);
    }
    return connaissanceFalse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Lieu> getLieuxExplores()
  {
    if (lieuxExplores == null)
    {
      lieuxExplores = new EObjectResolvingEList<Lieu>(Lieu.class, this, GAMEPackage.CONDITION__LIEUX_EXPLORES);
    }
    return lieuxExplores;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case GAMEPackage.CONDITION__VAL:
        return isVal();
      case GAMEPackage.CONDITION__OBJETS_TRUE:
        return getObjetsTrue();
      case GAMEPackage.CONDITION__OBJETS_FALSE:
        return getObjetsFalse();
      case GAMEPackage.CONDITION__CONNAISSANCE_TRUE:
        return getConnaissanceTrue();
      case GAMEPackage.CONDITION__CONNAISSANCE_FALSE:
        return getConnaissanceFalse();
      case GAMEPackage.CONDITION__LIEUX_EXPLORES:
        return getLieuxExplores();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GAMEPackage.CONDITION__VAL:
        setVal((Boolean)newValue);
        return;
      case GAMEPackage.CONDITION__OBJETS_TRUE:
        getObjetsTrue().clear();
        getObjetsTrue().addAll((Collection<? extends Objet>)newValue);
        return;
      case GAMEPackage.CONDITION__OBJETS_FALSE:
        getObjetsFalse().clear();
        getObjetsFalse().addAll((Collection<? extends Objet>)newValue);
        return;
      case GAMEPackage.CONDITION__CONNAISSANCE_TRUE:
        getConnaissanceTrue().clear();
        getConnaissanceTrue().addAll((Collection<? extends Connaissance>)newValue);
        return;
      case GAMEPackage.CONDITION__CONNAISSANCE_FALSE:
        getConnaissanceFalse().clear();
        getConnaissanceFalse().addAll((Collection<? extends Connaissance>)newValue);
        return;
      case GAMEPackage.CONDITION__LIEUX_EXPLORES:
        getLieuxExplores().clear();
        getLieuxExplores().addAll((Collection<? extends Lieu>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case GAMEPackage.CONDITION__VAL:
        setVal(VAL_EDEFAULT);
        return;
      case GAMEPackage.CONDITION__OBJETS_TRUE:
        getObjetsTrue().clear();
        return;
      case GAMEPackage.CONDITION__OBJETS_FALSE:
        getObjetsFalse().clear();
        return;
      case GAMEPackage.CONDITION__CONNAISSANCE_TRUE:
        getConnaissanceTrue().clear();
        return;
      case GAMEPackage.CONDITION__CONNAISSANCE_FALSE:
        getConnaissanceFalse().clear();
        return;
      case GAMEPackage.CONDITION__LIEUX_EXPLORES:
        getLieuxExplores().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GAMEPackage.CONDITION__VAL:
        return val != VAL_EDEFAULT;
      case GAMEPackage.CONDITION__OBJETS_TRUE:
        return objetsTrue != null && !objetsTrue.isEmpty();
      case GAMEPackage.CONDITION__OBJETS_FALSE:
        return objetsFalse != null && !objetsFalse.isEmpty();
      case GAMEPackage.CONDITION__CONNAISSANCE_TRUE:
        return connaissanceTrue != null && !connaissanceTrue.isEmpty();
      case GAMEPackage.CONDITION__CONNAISSANCE_FALSE:
        return connaissanceFalse != null && !connaissanceFalse.isEmpty();
      case GAMEPackage.CONDITION__LIEUX_EXPLORES:
        return lieuxExplores != null && !lieuxExplores.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (val: ");
    result.append(val);
    result.append(')');
    return result.toString();
  }

} //ConditionImpl
