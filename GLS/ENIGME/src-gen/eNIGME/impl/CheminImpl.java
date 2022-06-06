/**
 */
package eNIGME.impl;

import eNIGME.Chemin;
import eNIGME.Condition;
import eNIGME.ENIGMEPackage;
import eNIGME.EtatChemin;
import eNIGME.EtatObligation;
import eNIGME.EtatVisibilite;
import eNIGME.Lieu;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Chemin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eNIGME.impl.CheminImpl#getEtatc <em>Etatc</em>}</li>
 *   <li>{@link eNIGME.impl.CheminImpl#getConditionc <em>Conditionc</em>}</li>
 *   <li>{@link eNIGME.impl.CheminImpl#getEtato <em>Etato</em>}</li>
 *   <li>{@link eNIGME.impl.CheminImpl#getConditiono <em>Conditiono</em>}</li>
 *   <li>{@link eNIGME.impl.CheminImpl#getEtatv <em>Etatv</em>}</li>
 *   <li>{@link eNIGME.impl.CheminImpl#getConditionv <em>Conditionv</em>}</li>
 *   <li>{@link eNIGME.impl.CheminImpl#getPrecedent <em>Precedent</em>}</li>
 *   <li>{@link eNIGME.impl.CheminImpl#getSuivant <em>Suivant</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CheminImpl extends JeuElementImpl implements Chemin {
	/**
	 * The default value of the '{@link #getEtatc() <em>Etatc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEtatc()
	 * @generated
	 * @ordered
	 */
	protected static final EtatChemin ETATC_EDEFAULT = EtatChemin.OUVERT;

	/**
	 * The cached value of the '{@link #getEtatc() <em>Etatc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEtatc()
	 * @generated
	 * @ordered
	 */
	protected EtatChemin etatc = ETATC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConditionc() <em>Conditionc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionc()
	 * @generated
	 * @ordered
	 */
	protected Condition conditionc;

	/**
	 * The default value of the '{@link #getEtato() <em>Etato</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEtato()
	 * @generated
	 * @ordered
	 */
	protected static final EtatObligation ETATO_EDEFAULT = EtatObligation.OBLIGATOIRE;

	/**
	 * The cached value of the '{@link #getEtato() <em>Etato</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEtato()
	 * @generated
	 * @ordered
	 */
	protected EtatObligation etato = ETATO_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConditiono() <em>Conditiono</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditiono()
	 * @generated
	 * @ordered
	 */
	protected Condition conditiono;

	/**
	 * The default value of the '{@link #getEtatv() <em>Etatv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEtatv()
	 * @generated
	 * @ordered
	 */
	protected static final EtatVisibilite ETATV_EDEFAULT = EtatVisibilite.VISIBLE;

	/**
	 * The cached value of the '{@link #getEtatv() <em>Etatv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEtatv()
	 * @generated
	 * @ordered
	 */
	protected EtatVisibilite etatv = ETATV_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConditionv() <em>Conditionv</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionv()
	 * @generated
	 * @ordered
	 */
	protected Condition conditionv;

	/**
	 * The cached value of the '{@link #getPrecedent() <em>Precedent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecedent()
	 * @generated
	 * @ordered
	 */
	protected Lieu precedent;

	/**
	 * The cached value of the '{@link #getSuivant() <em>Suivant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuivant()
	 * @generated
	 * @ordered
	 */
	protected Lieu suivant;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CheminImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ENIGMEPackage.Literals.CHEMIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtatChemin getEtatc() {
		return etatc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEtatc(EtatChemin newEtatc) {
		EtatChemin oldEtatc = etatc;
		etatc = newEtatc == null ? ETATC_EDEFAULT : newEtatc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.CHEMIN__ETATC, oldEtatc, etatc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getConditionc() {
		if (conditionc != null && conditionc.eIsProxy()) {
			InternalEObject oldConditionc = (InternalEObject) conditionc;
			conditionc = (Condition) eResolveProxy(oldConditionc);
			if (conditionc != oldConditionc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ENIGMEPackage.CHEMIN__CONDITIONC,
							oldConditionc, conditionc));
			}
		}
		return conditionc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition basicGetConditionc() {
		return conditionc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionc(Condition newConditionc) {
		Condition oldConditionc = conditionc;
		conditionc = newConditionc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.CHEMIN__CONDITIONC, oldConditionc,
					conditionc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtatObligation getEtato() {
		return etato;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEtato(EtatObligation newEtato) {
		EtatObligation oldEtato = etato;
		etato = newEtato == null ? ETATO_EDEFAULT : newEtato;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.CHEMIN__ETATO, oldEtato, etato));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getConditiono() {
		if (conditiono != null && conditiono.eIsProxy()) {
			InternalEObject oldConditiono = (InternalEObject) conditiono;
			conditiono = (Condition) eResolveProxy(oldConditiono);
			if (conditiono != oldConditiono) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ENIGMEPackage.CHEMIN__CONDITIONO,
							oldConditiono, conditiono));
			}
		}
		return conditiono;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition basicGetConditiono() {
		return conditiono;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditiono(Condition newConditiono) {
		Condition oldConditiono = conditiono;
		conditiono = newConditiono;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.CHEMIN__CONDITIONO, oldConditiono,
					conditiono));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtatVisibilite getEtatv() {
		return etatv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEtatv(EtatVisibilite newEtatv) {
		EtatVisibilite oldEtatv = etatv;
		etatv = newEtatv == null ? ETATV_EDEFAULT : newEtatv;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.CHEMIN__ETATV, oldEtatv, etatv));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getConditionv() {
		if (conditionv != null && conditionv.eIsProxy()) {
			InternalEObject oldConditionv = (InternalEObject) conditionv;
			conditionv = (Condition) eResolveProxy(oldConditionv);
			if (conditionv != oldConditionv) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ENIGMEPackage.CHEMIN__CONDITIONV,
							oldConditionv, conditionv));
			}
		}
		return conditionv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition basicGetConditionv() {
		return conditionv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionv(Condition newConditionv) {
		Condition oldConditionv = conditionv;
		conditionv = newConditionv;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.CHEMIN__CONDITIONV, oldConditionv,
					conditionv));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lieu getPrecedent() {
		if (precedent != null && precedent.eIsProxy()) {
			InternalEObject oldPrecedent = (InternalEObject) precedent;
			precedent = (Lieu) eResolveProxy(oldPrecedent);
			if (precedent != oldPrecedent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ENIGMEPackage.CHEMIN__PRECEDENT,
							oldPrecedent, precedent));
			}
		}
		return precedent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lieu basicGetPrecedent() {
		return precedent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrecedent(Lieu newPrecedent) {
		Lieu oldPrecedent = precedent;
		precedent = newPrecedent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.CHEMIN__PRECEDENT, oldPrecedent,
					precedent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lieu getSuivant() {
		if (suivant != null && suivant.eIsProxy()) {
			InternalEObject oldSuivant = (InternalEObject) suivant;
			suivant = (Lieu) eResolveProxy(oldSuivant);
			if (suivant != oldSuivant) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ENIGMEPackage.CHEMIN__SUIVANT, oldSuivant,
							suivant));
			}
		}
		return suivant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lieu basicGetSuivant() {
		return suivant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuivant(Lieu newSuivant) {
		Lieu oldSuivant = suivant;
		suivant = newSuivant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.CHEMIN__SUIVANT, oldSuivant, suivant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ENIGMEPackage.CHEMIN__ETATC:
			return getEtatc();
		case ENIGMEPackage.CHEMIN__CONDITIONC:
			if (resolve)
				return getConditionc();
			return basicGetConditionc();
		case ENIGMEPackage.CHEMIN__ETATO:
			return getEtato();
		case ENIGMEPackage.CHEMIN__CONDITIONO:
			if (resolve)
				return getConditiono();
			return basicGetConditiono();
		case ENIGMEPackage.CHEMIN__ETATV:
			return getEtatv();
		case ENIGMEPackage.CHEMIN__CONDITIONV:
			if (resolve)
				return getConditionv();
			return basicGetConditionv();
		case ENIGMEPackage.CHEMIN__PRECEDENT:
			if (resolve)
				return getPrecedent();
			return basicGetPrecedent();
		case ENIGMEPackage.CHEMIN__SUIVANT:
			if (resolve)
				return getSuivant();
			return basicGetSuivant();
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
		case ENIGMEPackage.CHEMIN__ETATC:
			setEtatc((EtatChemin) newValue);
			return;
		case ENIGMEPackage.CHEMIN__CONDITIONC:
			setConditionc((Condition) newValue);
			return;
		case ENIGMEPackage.CHEMIN__ETATO:
			setEtato((EtatObligation) newValue);
			return;
		case ENIGMEPackage.CHEMIN__CONDITIONO:
			setConditiono((Condition) newValue);
			return;
		case ENIGMEPackage.CHEMIN__ETATV:
			setEtatv((EtatVisibilite) newValue);
			return;
		case ENIGMEPackage.CHEMIN__CONDITIONV:
			setConditionv((Condition) newValue);
			return;
		case ENIGMEPackage.CHEMIN__PRECEDENT:
			setPrecedent((Lieu) newValue);
			return;
		case ENIGMEPackage.CHEMIN__SUIVANT:
			setSuivant((Lieu) newValue);
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
		case ENIGMEPackage.CHEMIN__ETATC:
			setEtatc(ETATC_EDEFAULT);
			return;
		case ENIGMEPackage.CHEMIN__CONDITIONC:
			setConditionc((Condition) null);
			return;
		case ENIGMEPackage.CHEMIN__ETATO:
			setEtato(ETATO_EDEFAULT);
			return;
		case ENIGMEPackage.CHEMIN__CONDITIONO:
			setConditiono((Condition) null);
			return;
		case ENIGMEPackage.CHEMIN__ETATV:
			setEtatv(ETATV_EDEFAULT);
			return;
		case ENIGMEPackage.CHEMIN__CONDITIONV:
			setConditionv((Condition) null);
			return;
		case ENIGMEPackage.CHEMIN__PRECEDENT:
			setPrecedent((Lieu) null);
			return;
		case ENIGMEPackage.CHEMIN__SUIVANT:
			setSuivant((Lieu) null);
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
		case ENIGMEPackage.CHEMIN__ETATC:
			return etatc != ETATC_EDEFAULT;
		case ENIGMEPackage.CHEMIN__CONDITIONC:
			return conditionc != null;
		case ENIGMEPackage.CHEMIN__ETATO:
			return etato != ETATO_EDEFAULT;
		case ENIGMEPackage.CHEMIN__CONDITIONO:
			return conditiono != null;
		case ENIGMEPackage.CHEMIN__ETATV:
			return etatv != ETATV_EDEFAULT;
		case ENIGMEPackage.CHEMIN__CONDITIONV:
			return conditionv != null;
		case ENIGMEPackage.CHEMIN__PRECEDENT:
			return precedent != null;
		case ENIGMEPackage.CHEMIN__SUIVANT:
			return suivant != null;
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
		result.append(" (etatc: ");
		result.append(etatc);
		result.append(", etato: ");
		result.append(etato);
		result.append(", etatv: ");
		result.append(etatv);
		result.append(')');
		return result.toString();
	}

} //CheminImpl
