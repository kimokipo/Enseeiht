/**
 * generated by Xtext 2.23.0
 */
package fr.n7.gAME.impl;

import fr.n7.gAME.Condition;
import fr.n7.gAME.Connaissance;
import fr.n7.gAME.EtatVisibilite;
import fr.n7.gAME.GAMEPackage;
import fr.n7.gAME.Qualification;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connaissance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.n7.gAME.impl.ConnaissanceImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.n7.gAME.impl.ConnaissanceImpl#getQualification <em>Qualification</em>}</li>
 *   <li>{@link fr.n7.gAME.impl.ConnaissanceImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link fr.n7.gAME.impl.ConnaissanceImpl#getEtat <em>Etat</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnaissanceImpl extends MinimalEObjectImpl.Container implements Connaissance
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getQualification() <em>Qualification</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualification()
   * @generated
   * @ordered
   */
  protected EList<Qualification> qualification;

  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected Condition condition;

  /**
   * The default value of the '{@link #getEtat() <em>Etat</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEtat()
   * @generated
   * @ordered
   */
  protected static final EtatVisibilite ETAT_EDEFAULT = EtatVisibilite.VISIBLE;

  /**
   * The cached value of the '{@link #getEtat() <em>Etat</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEtat()
   * @generated
   * @ordered
   */
  protected EtatVisibilite etat = ETAT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConnaissanceImpl()
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
    return GAMEPackage.Literals.CONNAISSANCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GAMEPackage.CONNAISSANCE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Qualification> getQualification()
  {
    if (qualification == null)
    {
      qualification = new EObjectContainmentEList<Qualification>(Qualification.class, this, GAMEPackage.CONNAISSANCE__QUALIFICATION);
    }
    return qualification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Condition getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(Condition newCondition, NotificationChain msgs)
  {
    Condition oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GAMEPackage.CONNAISSANCE__CONDITION, oldCondition, newCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCondition(Condition newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GAMEPackage.CONNAISSANCE__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GAMEPackage.CONNAISSANCE__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GAMEPackage.CONNAISSANCE__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EtatVisibilite getEtat()
  {
    return etat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setEtat(EtatVisibilite newEtat)
  {
    EtatVisibilite oldEtat = etat;
    etat = newEtat == null ? ETAT_EDEFAULT : newEtat;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GAMEPackage.CONNAISSANCE__ETAT, oldEtat, etat));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GAMEPackage.CONNAISSANCE__QUALIFICATION:
        return ((InternalEList<?>)getQualification()).basicRemove(otherEnd, msgs);
      case GAMEPackage.CONNAISSANCE__CONDITION:
        return basicSetCondition(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case GAMEPackage.CONNAISSANCE__NAME:
        return getName();
      case GAMEPackage.CONNAISSANCE__QUALIFICATION:
        return getQualification();
      case GAMEPackage.CONNAISSANCE__CONDITION:
        return getCondition();
      case GAMEPackage.CONNAISSANCE__ETAT:
        return getEtat();
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
      case GAMEPackage.CONNAISSANCE__NAME:
        setName((String)newValue);
        return;
      case GAMEPackage.CONNAISSANCE__QUALIFICATION:
        getQualification().clear();
        getQualification().addAll((Collection<? extends Qualification>)newValue);
        return;
      case GAMEPackage.CONNAISSANCE__CONDITION:
        setCondition((Condition)newValue);
        return;
      case GAMEPackage.CONNAISSANCE__ETAT:
        setEtat((EtatVisibilite)newValue);
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
      case GAMEPackage.CONNAISSANCE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GAMEPackage.CONNAISSANCE__QUALIFICATION:
        getQualification().clear();
        return;
      case GAMEPackage.CONNAISSANCE__CONDITION:
        setCondition((Condition)null);
        return;
      case GAMEPackage.CONNAISSANCE__ETAT:
        setEtat(ETAT_EDEFAULT);
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
      case GAMEPackage.CONNAISSANCE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GAMEPackage.CONNAISSANCE__QUALIFICATION:
        return qualification != null && !qualification.isEmpty();
      case GAMEPackage.CONNAISSANCE__CONDITION:
        return condition != null;
      case GAMEPackage.CONNAISSANCE__ETAT:
        return etat != ETAT_EDEFAULT;
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
    result.append(" (name: ");
    result.append(name);
    result.append(", etat: ");
    result.append(etat);
    result.append(')');
    return result.toString();
  }

} //ConnaissanceImpl