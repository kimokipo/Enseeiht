/**
 * generated by Xtext 2.23.0
 */
package fr.n7.gAME.impl;

import fr.n7.gAME.Activite;
import fr.n7.gAME.Condition;
import fr.n7.gAME.GAMEPackage;
import fr.n7.gAME.Interaction;
import fr.n7.gAME.Personne;
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
 * An implementation of the model object '<em><b>Personne</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.n7.gAME.impl.PersonneImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.n7.gAME.impl.PersonneImpl#getActivite <em>Activite</em>}</li>
 *   <li>{@link fr.n7.gAME.impl.PersonneImpl#getConditionsVisible <em>Conditions Visible</em>}</li>
 *   <li>{@link fr.n7.gAME.impl.PersonneImpl#getConditionsObligation <em>Conditions Obligation</em>}</li>
 *   <li>{@link fr.n7.gAME.impl.PersonneImpl#getInteraction <em>Interaction</em>}</li>
 *   <li>{@link fr.n7.gAME.impl.PersonneImpl#getQualification <em>Qualification</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PersonneImpl extends MinimalEObjectImpl.Container implements Personne
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
   * The default value of the '{@link #getActivite() <em>Activite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivite()
   * @generated
   * @ordered
   */
  protected static final Activite ACTIVITE_EDEFAULT = Activite.ACTIF;

  /**
   * The cached value of the '{@link #getActivite() <em>Activite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivite()
   * @generated
   * @ordered
   */
  protected Activite activite = ACTIVITE_EDEFAULT;

  /**
   * The cached value of the '{@link #getConditionsVisible() <em>Conditions Visible</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditionsVisible()
   * @generated
   * @ordered
   */
  protected Condition conditionsVisible;

  /**
   * The cached value of the '{@link #getConditionsObligation() <em>Conditions Obligation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditionsObligation()
   * @generated
   * @ordered
   */
  protected Condition conditionsObligation;

  /**
   * The cached value of the '{@link #getInteraction() <em>Interaction</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInteraction()
   * @generated
   * @ordered
   */
  protected Interaction interaction;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PersonneImpl()
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
    return GAMEPackage.Literals.PERSONNE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GAMEPackage.PERSONNE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Activite getActivite()
  {
    return activite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setActivite(Activite newActivite)
  {
    Activite oldActivite = activite;
    activite = newActivite == null ? ACTIVITE_EDEFAULT : newActivite;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GAMEPackage.PERSONNE__ACTIVITE, oldActivite, activite));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Condition getConditionsVisible()
  {
    return conditionsVisible;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConditionsVisible(Condition newConditionsVisible, NotificationChain msgs)
  {
    Condition oldConditionsVisible = conditionsVisible;
    conditionsVisible = newConditionsVisible;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GAMEPackage.PERSONNE__CONDITIONS_VISIBLE, oldConditionsVisible, newConditionsVisible);
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
  public void setConditionsVisible(Condition newConditionsVisible)
  {
    if (newConditionsVisible != conditionsVisible)
    {
      NotificationChain msgs = null;
      if (conditionsVisible != null)
        msgs = ((InternalEObject)conditionsVisible).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GAMEPackage.PERSONNE__CONDITIONS_VISIBLE, null, msgs);
      if (newConditionsVisible != null)
        msgs = ((InternalEObject)newConditionsVisible).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GAMEPackage.PERSONNE__CONDITIONS_VISIBLE, null, msgs);
      msgs = basicSetConditionsVisible(newConditionsVisible, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GAMEPackage.PERSONNE__CONDITIONS_VISIBLE, newConditionsVisible, newConditionsVisible));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Condition getConditionsObligation()
  {
    return conditionsObligation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConditionsObligation(Condition newConditionsObligation, NotificationChain msgs)
  {
    Condition oldConditionsObligation = conditionsObligation;
    conditionsObligation = newConditionsObligation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GAMEPackage.PERSONNE__CONDITIONS_OBLIGATION, oldConditionsObligation, newConditionsObligation);
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
  public void setConditionsObligation(Condition newConditionsObligation)
  {
    if (newConditionsObligation != conditionsObligation)
    {
      NotificationChain msgs = null;
      if (conditionsObligation != null)
        msgs = ((InternalEObject)conditionsObligation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GAMEPackage.PERSONNE__CONDITIONS_OBLIGATION, null, msgs);
      if (newConditionsObligation != null)
        msgs = ((InternalEObject)newConditionsObligation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GAMEPackage.PERSONNE__CONDITIONS_OBLIGATION, null, msgs);
      msgs = basicSetConditionsObligation(newConditionsObligation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GAMEPackage.PERSONNE__CONDITIONS_OBLIGATION, newConditionsObligation, newConditionsObligation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Interaction getInteraction()
  {
    return interaction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInteraction(Interaction newInteraction, NotificationChain msgs)
  {
    Interaction oldInteraction = interaction;
    interaction = newInteraction;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GAMEPackage.PERSONNE__INTERACTION, oldInteraction, newInteraction);
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
  public void setInteraction(Interaction newInteraction)
  {
    if (newInteraction != interaction)
    {
      NotificationChain msgs = null;
      if (interaction != null)
        msgs = ((InternalEObject)interaction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GAMEPackage.PERSONNE__INTERACTION, null, msgs);
      if (newInteraction != null)
        msgs = ((InternalEObject)newInteraction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GAMEPackage.PERSONNE__INTERACTION, null, msgs);
      msgs = basicSetInteraction(newInteraction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GAMEPackage.PERSONNE__INTERACTION, newInteraction, newInteraction));
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
      qualification = new EObjectContainmentEList<Qualification>(Qualification.class, this, GAMEPackage.PERSONNE__QUALIFICATION);
    }
    return qualification;
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
      case GAMEPackage.PERSONNE__CONDITIONS_VISIBLE:
        return basicSetConditionsVisible(null, msgs);
      case GAMEPackage.PERSONNE__CONDITIONS_OBLIGATION:
        return basicSetConditionsObligation(null, msgs);
      case GAMEPackage.PERSONNE__INTERACTION:
        return basicSetInteraction(null, msgs);
      case GAMEPackage.PERSONNE__QUALIFICATION:
        return ((InternalEList<?>)getQualification()).basicRemove(otherEnd, msgs);
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
      case GAMEPackage.PERSONNE__NAME:
        return getName();
      case GAMEPackage.PERSONNE__ACTIVITE:
        return getActivite();
      case GAMEPackage.PERSONNE__CONDITIONS_VISIBLE:
        return getConditionsVisible();
      case GAMEPackage.PERSONNE__CONDITIONS_OBLIGATION:
        return getConditionsObligation();
      case GAMEPackage.PERSONNE__INTERACTION:
        return getInteraction();
      case GAMEPackage.PERSONNE__QUALIFICATION:
        return getQualification();
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
      case GAMEPackage.PERSONNE__NAME:
        setName((String)newValue);
        return;
      case GAMEPackage.PERSONNE__ACTIVITE:
        setActivite((Activite)newValue);
        return;
      case GAMEPackage.PERSONNE__CONDITIONS_VISIBLE:
        setConditionsVisible((Condition)newValue);
        return;
      case GAMEPackage.PERSONNE__CONDITIONS_OBLIGATION:
        setConditionsObligation((Condition)newValue);
        return;
      case GAMEPackage.PERSONNE__INTERACTION:
        setInteraction((Interaction)newValue);
        return;
      case GAMEPackage.PERSONNE__QUALIFICATION:
        getQualification().clear();
        getQualification().addAll((Collection<? extends Qualification>)newValue);
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
      case GAMEPackage.PERSONNE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GAMEPackage.PERSONNE__ACTIVITE:
        setActivite(ACTIVITE_EDEFAULT);
        return;
      case GAMEPackage.PERSONNE__CONDITIONS_VISIBLE:
        setConditionsVisible((Condition)null);
        return;
      case GAMEPackage.PERSONNE__CONDITIONS_OBLIGATION:
        setConditionsObligation((Condition)null);
        return;
      case GAMEPackage.PERSONNE__INTERACTION:
        setInteraction((Interaction)null);
        return;
      case GAMEPackage.PERSONNE__QUALIFICATION:
        getQualification().clear();
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
      case GAMEPackage.PERSONNE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GAMEPackage.PERSONNE__ACTIVITE:
        return activite != ACTIVITE_EDEFAULT;
      case GAMEPackage.PERSONNE__CONDITIONS_VISIBLE:
        return conditionsVisible != null;
      case GAMEPackage.PERSONNE__CONDITIONS_OBLIGATION:
        return conditionsObligation != null;
      case GAMEPackage.PERSONNE__INTERACTION:
        return interaction != null;
      case GAMEPackage.PERSONNE__QUALIFICATION:
        return qualification != null && !qualification.isEmpty();
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
    result.append(", activite: ");
    result.append(activite);
    result.append(')');
    return result.toString();
  }

} //PersonneImpl
