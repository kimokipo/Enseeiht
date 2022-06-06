/**
 */
package eNIGME.impl;

import eNIGME.Condition;
import eNIGME.ENIGMEPackage;
import eNIGME.EtatObligation;
import eNIGME.EtatVisibilite;
import eNIGME.Interaction;
import eNIGME.Personne;
import eNIGME.Qualification;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Personne</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eNIGME.impl.PersonneImpl#getName <em>Name</em>}</li>
 *   <li>{@link eNIGME.impl.PersonneImpl#getEtato <em>Etato</em>}</li>
 *   <li>{@link eNIGME.impl.PersonneImpl#getConditiono <em>Conditiono</em>}</li>
 *   <li>{@link eNIGME.impl.PersonneImpl#getEtatv <em>Etatv</em>}</li>
 *   <li>{@link eNIGME.impl.PersonneImpl#getConditionv <em>Conditionv</em>}</li>
 *   <li>{@link eNIGME.impl.PersonneImpl#getTexte <em>Texte</em>}</li>
 *   <li>{@link eNIGME.impl.PersonneImpl#getInteraction <em>Interaction</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PersonneImpl extends JeuElementImpl implements Personne {
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
	 * The cached value of the '{@link #getTexte() <em>Texte</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTexte()
	 * @generated
	 * @ordered
	 */
	protected Qualification texte;

	/**
	 * The cached value of the '{@link #getInteraction() <em>Interaction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteraction()
	 * @generated
	 * @ordered
	 */
	protected Interaction interaction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonneImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ENIGMEPackage.Literals.PERSONNE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.PERSONNE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.PERSONNE__ETATO, oldEtato, etato));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ENIGMEPackage.PERSONNE__CONDITIONO,
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
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.PERSONNE__CONDITIONO, oldConditiono,
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
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.PERSONNE__ETATV, oldEtatv, etatv));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ENIGMEPackage.PERSONNE__CONDITIONV,
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
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.PERSONNE__CONDITIONV, oldConditionv,
					conditionv));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ENIGMEPackage.PERSONNE__TEXTE, oldTexte,
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
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.PERSONNE__TEXTE, oldTexte, texte));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interaction getInteraction() {
		if (interaction != null && interaction.eIsProxy()) {
			InternalEObject oldInteraction = (InternalEObject) interaction;
			interaction = (Interaction) eResolveProxy(oldInteraction);
			if (interaction != oldInteraction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ENIGMEPackage.PERSONNE__INTERACTION,
							oldInteraction, interaction));
			}
		}
		return interaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interaction basicGetInteraction() {
		return interaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInteraction(Interaction newInteraction) {
		Interaction oldInteraction = interaction;
		interaction = newInteraction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.PERSONNE__INTERACTION, oldInteraction,
					interaction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ENIGMEPackage.PERSONNE__NAME:
			return getName();
		case ENIGMEPackage.PERSONNE__ETATO:
			return getEtato();
		case ENIGMEPackage.PERSONNE__CONDITIONO:
			if (resolve)
				return getConditiono();
			return basicGetConditiono();
		case ENIGMEPackage.PERSONNE__ETATV:
			return getEtatv();
		case ENIGMEPackage.PERSONNE__CONDITIONV:
			if (resolve)
				return getConditionv();
			return basicGetConditionv();
		case ENIGMEPackage.PERSONNE__TEXTE:
			if (resolve)
				return getTexte();
			return basicGetTexte();
		case ENIGMEPackage.PERSONNE__INTERACTION:
			if (resolve)
				return getInteraction();
			return basicGetInteraction();
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
		case ENIGMEPackage.PERSONNE__NAME:
			setName((String) newValue);
			return;
		case ENIGMEPackage.PERSONNE__ETATO:
			setEtato((EtatObligation) newValue);
			return;
		case ENIGMEPackage.PERSONNE__CONDITIONO:
			setConditiono((Condition) newValue);
			return;
		case ENIGMEPackage.PERSONNE__ETATV:
			setEtatv((EtatVisibilite) newValue);
			return;
		case ENIGMEPackage.PERSONNE__CONDITIONV:
			setConditionv((Condition) newValue);
			return;
		case ENIGMEPackage.PERSONNE__TEXTE:
			setTexte((Qualification) newValue);
			return;
		case ENIGMEPackage.PERSONNE__INTERACTION:
			setInteraction((Interaction) newValue);
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
		case ENIGMEPackage.PERSONNE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ENIGMEPackage.PERSONNE__ETATO:
			setEtato(ETATO_EDEFAULT);
			return;
		case ENIGMEPackage.PERSONNE__CONDITIONO:
			setConditiono((Condition) null);
			return;
		case ENIGMEPackage.PERSONNE__ETATV:
			setEtatv(ETATV_EDEFAULT);
			return;
		case ENIGMEPackage.PERSONNE__CONDITIONV:
			setConditionv((Condition) null);
			return;
		case ENIGMEPackage.PERSONNE__TEXTE:
			setTexte((Qualification) null);
			return;
		case ENIGMEPackage.PERSONNE__INTERACTION:
			setInteraction((Interaction) null);
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
		case ENIGMEPackage.PERSONNE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ENIGMEPackage.PERSONNE__ETATO:
			return etato != ETATO_EDEFAULT;
		case ENIGMEPackage.PERSONNE__CONDITIONO:
			return conditiono != null;
		case ENIGMEPackage.PERSONNE__ETATV:
			return etatv != ETATV_EDEFAULT;
		case ENIGMEPackage.PERSONNE__CONDITIONV:
			return conditionv != null;
		case ENIGMEPackage.PERSONNE__TEXTE:
			return texte != null;
		case ENIGMEPackage.PERSONNE__INTERACTION:
			return interaction != null;
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
		result.append(", etato: ");
		result.append(etato);
		result.append(", etatv: ");
		result.append(etatv);
		result.append(')');
		return result.toString();
	}

} //PersonneImpl
