/**
 */
package eNIGME.impl;

import eNIGME.Action;
import eNIGME.ENIGMEPackage;
import eNIGME.EtatReponse;
import eNIGME.Qualification;
import eNIGME.Reponse;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reponse</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eNIGME.impl.ReponseImpl#getName <em>Name</em>}</li>
 *   <li>{@link eNIGME.impl.ReponseImpl#getEtat <em>Etat</em>}</li>
 *   <li>{@link eNIGME.impl.ReponseImpl#getTexte <em>Texte</em>}</li>
 *   <li>{@link eNIGME.impl.ReponseImpl#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReponseImpl extends JeuElementImpl implements Reponse {
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
	 * The default value of the '{@link #getEtat() <em>Etat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEtat()
	 * @generated
	 * @ordered
	 */
	protected static final EtatReponse ETAT_EDEFAULT = EtatReponse.BONNE;

	/**
	 * The cached value of the '{@link #getEtat() <em>Etat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEtat()
	 * @generated
	 * @ordered
	 */
	protected EtatReponse etat = ETAT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTexte() <em>Texte</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTexte()
	 * @generated
	 * @ordered
	 */
	protected Qualification texte;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected Action action;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReponseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ENIGMEPackage.Literals.REPONSE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.REPONSE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtatReponse getEtat() {
		return etat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEtat(EtatReponse newEtat) {
		EtatReponse oldEtat = etat;
		etat = newEtat == null ? ETAT_EDEFAULT : newEtat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.REPONSE__ETAT, oldEtat, etat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Qualification getTexte() {
		if (texte != null && texte.eIsProxy()) {
			InternalEObject oldTexte = (InternalEObject) texte;
			texte = (Qualification) eResolveProxy(oldTexte);
			if (texte != oldTexte) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ENIGMEPackage.REPONSE__TEXTE, oldTexte,
							texte));
			}
		}
		return texte;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Qualification basicGetTexte() {
		return texte;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTexte(Qualification newTexte) {
		Qualification oldTexte = texte;
		texte = newTexte;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.REPONSE__TEXTE, oldTexte, texte));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getAction() {
		if (action != null && action.eIsProxy()) {
			InternalEObject oldAction = (InternalEObject) action;
			action = (Action) eResolveProxy(oldAction);
			if (action != oldAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ENIGMEPackage.REPONSE__ACTION, oldAction,
							action));
			}
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Action newAction) {
		Action oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.REPONSE__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ENIGMEPackage.REPONSE__NAME:
			return getName();
		case ENIGMEPackage.REPONSE__ETAT:
			return getEtat();
		case ENIGMEPackage.REPONSE__TEXTE:
			if (resolve)
				return getTexte();
			return basicGetTexte();
		case ENIGMEPackage.REPONSE__ACTION:
			if (resolve)
				return getAction();
			return basicGetAction();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ENIGMEPackage.REPONSE__NAME:
			setName((String) newValue);
			return;
		case ENIGMEPackage.REPONSE__ETAT:
			setEtat((EtatReponse) newValue);
			return;
		case ENIGMEPackage.REPONSE__TEXTE:
			setTexte((Qualification) newValue);
			return;
		case ENIGMEPackage.REPONSE__ACTION:
			setAction((Action) newValue);
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
		case ENIGMEPackage.REPONSE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ENIGMEPackage.REPONSE__ETAT:
			setEtat(ETAT_EDEFAULT);
			return;
		case ENIGMEPackage.REPONSE__TEXTE:
			setTexte((Qualification) null);
			return;
		case ENIGMEPackage.REPONSE__ACTION:
			setAction((Action) null);
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
		case ENIGMEPackage.REPONSE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ENIGMEPackage.REPONSE__ETAT:
			return etat != ETAT_EDEFAULT;
		case ENIGMEPackage.REPONSE__TEXTE:
			return texte != null;
		case ENIGMEPackage.REPONSE__ACTION:
			return action != null;
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
		result.append(", etat: ");
		result.append(etat);
		result.append(')');
		return result.toString();
	}

} //ReponseImpl
