/**
 */
package eNIGME.impl;

import eNIGME.Condition;
import eNIGME.Connaissance;
import eNIGME.ENIGMEPackage;
import eNIGME.Objet;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eNIGME.impl.ConditionImpl#getName <em>Name</em>}</li>
 *   <li>{@link eNIGME.impl.ConditionImpl#getObjetsRequis <em>Objets Requis</em>}</li>
 *   <li>{@link eNIGME.impl.ConditionImpl#getConnaissancesRequises <em>Connaissances Requises</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConditionImpl extends JeuElementImpl implements Condition {
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
	 * The cached value of the '{@link #getObjetsRequis() <em>Objets Requis</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjetsRequis()
	 * @generated
	 * @ordered
	 */
	protected EList<Objet> objetsRequis;

	/**
	 * The cached value of the '{@link #getConnaissancesRequises() <em>Connaissances Requises</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnaissancesRequises()
	 * @generated
	 * @ordered
	 */
	protected EList<Connaissance> connaissancesRequises;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ENIGMEPackage.Literals.CONDITION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.CONDITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Objet> getObjetsRequis() {
		if (objetsRequis == null) {
			objetsRequis = new EObjectResolvingEList<Objet>(Objet.class, this, ENIGMEPackage.CONDITION__OBJETS_REQUIS);
		}
		return objetsRequis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Connaissance> getConnaissancesRequises() {
		if (connaissancesRequises == null) {
			connaissancesRequises = new EObjectResolvingEList<Connaissance>(Connaissance.class, this,
					ENIGMEPackage.CONDITION__CONNAISSANCES_REQUISES);
		}
		return connaissancesRequises;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ENIGMEPackage.CONDITION__NAME:
			return getName();
		case ENIGMEPackage.CONDITION__OBJETS_REQUIS:
			return getObjetsRequis();
		case ENIGMEPackage.CONDITION__CONNAISSANCES_REQUISES:
			return getConnaissancesRequises();
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
		case ENIGMEPackage.CONDITION__NAME:
			setName((String) newValue);
			return;
		case ENIGMEPackage.CONDITION__OBJETS_REQUIS:
			getObjetsRequis().clear();
			getObjetsRequis().addAll((Collection<? extends Objet>) newValue);
			return;
		case ENIGMEPackage.CONDITION__CONNAISSANCES_REQUISES:
			getConnaissancesRequises().clear();
			getConnaissancesRequises().addAll((Collection<? extends Connaissance>) newValue);
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
		case ENIGMEPackage.CONDITION__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ENIGMEPackage.CONDITION__OBJETS_REQUIS:
			getObjetsRequis().clear();
			return;
		case ENIGMEPackage.CONDITION__CONNAISSANCES_REQUISES:
			getConnaissancesRequises().clear();
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
		case ENIGMEPackage.CONDITION__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ENIGMEPackage.CONDITION__OBJETS_REQUIS:
			return objetsRequis != null && !objetsRequis.isEmpty();
		case ENIGMEPackage.CONDITION__CONNAISSANCES_REQUISES:
			return connaissancesRequises != null && !connaissancesRequises.isEmpty();
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
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ConditionImpl
