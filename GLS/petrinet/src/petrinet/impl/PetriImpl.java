/**
 */
package petrinet.impl;

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

import petrinet.EArc;
import petrinet.Petri;
import petrinet.PetriElement;
import petrinet.PetrinetPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Petri</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link petrinet.impl.PetriImpl#getPetriElements <em>Petri Elements</em>}</li>
 *   <li>{@link petrinet.impl.PetriImpl#getEarc <em>Earc</em>}</li>
 *   <li>{@link petrinet.impl.PetriImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PetriImpl extends MinimalEObjectImpl.Container implements Petri {
	/**
	 * The cached value of the '{@link #getPetriElements() <em>Petri Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPetriElements()
	 * @generated
	 * @ordered
	 */
	protected EList<PetriElement> petriElements;

	/**
	 * The cached value of the '{@link #getEarc() <em>Earc</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEarc()
	 * @generated
	 * @ordered
	 */
	protected EList<EArc> earc;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PetriImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PetrinetPackage.Literals.PETRI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PetriElement> getPetriElements() {
		if (petriElements == null) {
			petriElements = new EObjectContainmentEList<PetriElement>(PetriElement.class, this, PetrinetPackage.PETRI__PETRI_ELEMENTS);
		}
		return petriElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EArc> getEarc() {
		if (earc == null) {
			earc = new EObjectContainmentEList<EArc>(EArc.class, this, PetrinetPackage.PETRI__EARC);
		}
		return earc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PetrinetPackage.PETRI__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PetrinetPackage.PETRI__PETRI_ELEMENTS:
				return ((InternalEList<?>)getPetriElements()).basicRemove(otherEnd, msgs);
			case PetrinetPackage.PETRI__EARC:
				return ((InternalEList<?>)getEarc()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PetrinetPackage.PETRI__PETRI_ELEMENTS:
				return getPetriElements();
			case PetrinetPackage.PETRI__EARC:
				return getEarc();
			case PetrinetPackage.PETRI__NAME:
				return getName();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PetrinetPackage.PETRI__PETRI_ELEMENTS:
				getPetriElements().clear();
				getPetriElements().addAll((Collection<? extends PetriElement>)newValue);
				return;
			case PetrinetPackage.PETRI__EARC:
				getEarc().clear();
				getEarc().addAll((Collection<? extends EArc>)newValue);
				return;
			case PetrinetPackage.PETRI__NAME:
				setName((String)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case PetrinetPackage.PETRI__PETRI_ELEMENTS:
				getPetriElements().clear();
				return;
			case PetrinetPackage.PETRI__EARC:
				getEarc().clear();
				return;
			case PetrinetPackage.PETRI__NAME:
				setName(NAME_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PetrinetPackage.PETRI__PETRI_ELEMENTS:
				return petriElements != null && !petriElements.isEmpty();
			case PetrinetPackage.PETRI__EARC:
				return earc != null && !earc.isEmpty();
			case PetrinetPackage.PETRI__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //PetriImpl
