/**
 */
package eNIGME.impl;

import eNIGME.Connaissance;
import eNIGME.ENIGMEPackage;
import eNIGME.Joueur;
import eNIGME.Objet;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Joueur</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eNIGME.impl.JoueurImpl#getName <em>Name</em>}</li>
 *   <li>{@link eNIGME.impl.JoueurImpl#getLimite <em>Limite</em>}</li>
 *   <li>{@link eNIGME.impl.JoueurImpl#getObjets <em>Objets</em>}</li>
 *   <li>{@link eNIGME.impl.JoueurImpl#getConnaissances <em>Connaissances</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JoueurImpl extends JeuElementImpl implements Joueur {
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
	 * The default value of the '{@link #getLimite() <em>Limite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLimite()
	 * @generated
	 * @ordered
	 */
	protected static final int LIMITE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLimite() <em>Limite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLimite()
	 * @generated
	 * @ordered
	 */
	protected int limite = LIMITE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getObjets() <em>Objets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjets()
	 * @generated
	 * @ordered
	 */
	protected EList<Objet> objets;

	/**
	 * The cached value of the '{@link #getConnaissances() <em>Connaissances</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnaissances()
	 * @generated
	 * @ordered
	 */
	protected EList<Connaissance> connaissances;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JoueurImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ENIGMEPackage.Literals.JOUEUR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.JOUEUR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLimite() {
		return limite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLimite(int newLimite) {
		int oldLimite = limite;
		limite = newLimite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.JOUEUR__LIMITE, oldLimite, limite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Objet> getObjets() {
		if (objets == null) {
			objets = new EObjectResolvingEList<Objet>(Objet.class, this, ENIGMEPackage.JOUEUR__OBJETS);
		}
		return objets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Connaissance> getConnaissances() {
		if (connaissances == null) {
			connaissances = new EObjectResolvingEList<Connaissance>(Connaissance.class, this,
					ENIGMEPackage.JOUEUR__CONNAISSANCES);
		}
		return connaissances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ENIGMEPackage.JOUEUR__NAME:
			return getName();
		case ENIGMEPackage.JOUEUR__LIMITE:
			return getLimite();
		case ENIGMEPackage.JOUEUR__OBJETS:
			return getObjets();
		case ENIGMEPackage.JOUEUR__CONNAISSANCES:
			return getConnaissances();
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
		case ENIGMEPackage.JOUEUR__NAME:
			setName((String) newValue);
			return;
		case ENIGMEPackage.JOUEUR__LIMITE:
			setLimite((Integer) newValue);
			return;
		case ENIGMEPackage.JOUEUR__OBJETS:
			getObjets().clear();
			getObjets().addAll((Collection<? extends Objet>) newValue);
			return;
		case ENIGMEPackage.JOUEUR__CONNAISSANCES:
			getConnaissances().clear();
			getConnaissances().addAll((Collection<? extends Connaissance>) newValue);
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
		case ENIGMEPackage.JOUEUR__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ENIGMEPackage.JOUEUR__LIMITE:
			setLimite(LIMITE_EDEFAULT);
			return;
		case ENIGMEPackage.JOUEUR__OBJETS:
			getObjets().clear();
			return;
		case ENIGMEPackage.JOUEUR__CONNAISSANCES:
			getConnaissances().clear();
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
		case ENIGMEPackage.JOUEUR__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ENIGMEPackage.JOUEUR__LIMITE:
			return limite != LIMITE_EDEFAULT;
		case ENIGMEPackage.JOUEUR__OBJETS:
			return objets != null && !objets.isEmpty();
		case ENIGMEPackage.JOUEUR__CONNAISSANCES:
			return connaissances != null && !connaissances.isEmpty();
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
		result.append(", limite: ");
		result.append(limite);
		result.append(')');
		return result.toString();
	}

} //JoueurImpl
