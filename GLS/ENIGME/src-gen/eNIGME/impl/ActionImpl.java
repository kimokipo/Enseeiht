/**
 */
package eNIGME.impl;

import eNIGME.Action;
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
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eNIGME.impl.ActionImpl#getName <em>Name</em>}</li>
 *   <li>{@link eNIGME.impl.ActionImpl#getObjetsconsommables <em>Objetsconsommables</em>}</li>
 *   <li>{@link eNIGME.impl.ActionImpl#getObjetsattribuables <em>Objetsattribuables</em>}</li>
 *   <li>{@link eNIGME.impl.ActionImpl#getConnaissancesattribuables <em>Connaissancesattribuables</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActionImpl extends JeuElementImpl implements Action {
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
	 * The cached value of the '{@link #getObjetsconsommables() <em>Objetsconsommables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjetsconsommables()
	 * @generated
	 * @ordered
	 */
	protected EList<Objet> objetsconsommables;

	/**
	 * The cached value of the '{@link #getObjetsattribuables() <em>Objetsattribuables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjetsattribuables()
	 * @generated
	 * @ordered
	 */
	protected EList<Objet> objetsattribuables;

	/**
	 * The cached value of the '{@link #getConnaissancesattribuables() <em>Connaissancesattribuables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnaissancesattribuables()
	 * @generated
	 * @ordered
	 */
	protected EList<Connaissance> connaissancesattribuables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ENIGMEPackage.Literals.ACTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.ACTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Objet> getObjetsconsommables() {
		if (objetsconsommables == null) {
			objetsconsommables = new EObjectResolvingEList<Objet>(Objet.class, this,
					ENIGMEPackage.ACTION__OBJETSCONSOMMABLES);
		}
		return objetsconsommables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Objet> getObjetsattribuables() {
		if (objetsattribuables == null) {
			objetsattribuables = new EObjectResolvingEList<Objet>(Objet.class, this,
					ENIGMEPackage.ACTION__OBJETSATTRIBUABLES);
		}
		return objetsattribuables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Connaissance> getConnaissancesattribuables() {
		if (connaissancesattribuables == null) {
			connaissancesattribuables = new EObjectResolvingEList<Connaissance>(Connaissance.class, this,
					ENIGMEPackage.ACTION__CONNAISSANCESATTRIBUABLES);
		}
		return connaissancesattribuables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ENIGMEPackage.ACTION__NAME:
			return getName();
		case ENIGMEPackage.ACTION__OBJETSCONSOMMABLES:
			return getObjetsconsommables();
		case ENIGMEPackage.ACTION__OBJETSATTRIBUABLES:
			return getObjetsattribuables();
		case ENIGMEPackage.ACTION__CONNAISSANCESATTRIBUABLES:
			return getConnaissancesattribuables();
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
		case ENIGMEPackage.ACTION__NAME:
			setName((String) newValue);
			return;
		case ENIGMEPackage.ACTION__OBJETSCONSOMMABLES:
			getObjetsconsommables().clear();
			getObjetsconsommables().addAll((Collection<? extends Objet>) newValue);
			return;
		case ENIGMEPackage.ACTION__OBJETSATTRIBUABLES:
			getObjetsattribuables().clear();
			getObjetsattribuables().addAll((Collection<? extends Objet>) newValue);
			return;
		case ENIGMEPackage.ACTION__CONNAISSANCESATTRIBUABLES:
			getConnaissancesattribuables().clear();
			getConnaissancesattribuables().addAll((Collection<? extends Connaissance>) newValue);
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
		case ENIGMEPackage.ACTION__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ENIGMEPackage.ACTION__OBJETSCONSOMMABLES:
			getObjetsconsommables().clear();
			return;
		case ENIGMEPackage.ACTION__OBJETSATTRIBUABLES:
			getObjetsattribuables().clear();
			return;
		case ENIGMEPackage.ACTION__CONNAISSANCESATTRIBUABLES:
			getConnaissancesattribuables().clear();
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
		case ENIGMEPackage.ACTION__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ENIGMEPackage.ACTION__OBJETSCONSOMMABLES:
			return objetsconsommables != null && !objetsconsommables.isEmpty();
		case ENIGMEPackage.ACTION__OBJETSATTRIBUABLES:
			return objetsattribuables != null && !objetsattribuables.isEmpty();
		case ENIGMEPackage.ACTION__CONNAISSANCESATTRIBUABLES:
			return connaissancesattribuables != null && !connaissancesattribuables.isEmpty();
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

} //ActionImpl
