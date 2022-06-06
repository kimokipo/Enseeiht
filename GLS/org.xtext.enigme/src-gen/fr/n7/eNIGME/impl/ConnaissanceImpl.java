/**
 * generated by Xtext 2.23.0
 */
package fr.n7.eNIGME.impl;

import fr.n7.eNIGME.Connaissance;
import fr.n7.eNIGME.ENIGMEPackage;
import fr.n7.eNIGME.EtatPossession;
import fr.n7.eNIGME.EtatVisibilite;
import fr.n7.eNIGME.Qualification;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connaissance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.n7.eNIGME.impl.ConnaissanceImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.n7.eNIGME.impl.ConnaissanceImpl#getNomConnaissance <em>Nom Connaissance</em>}</li>
 *   <li>{@link fr.n7.eNIGME.impl.ConnaissanceImpl#getQualification <em>Qualification</em>}</li>
 *   <li>{@link fr.n7.eNIGME.impl.ConnaissanceImpl#getEtatv <em>Etatv</em>}</li>
 *   <li>{@link fr.n7.eNIGME.impl.ConnaissanceImpl#getEtatp <em>Etatp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnaissanceImpl extends JeuElementImpl implements Connaissance
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
	 * The default value of the '{@link #getNomConnaissance() <em>Nom Connaissance</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNomConnaissance()
	 * @generated
	 * @ordered
	 */
  protected static final String NOM_CONNAISSANCE_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getNomConnaissance() <em>Nom Connaissance</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNomConnaissance()
	 * @generated
	 * @ordered
	 */
  protected String nomConnaissance = NOM_CONNAISSANCE_EDEFAULT;

  /**
	 * The cached value of the '{@link #getQualification() <em>Qualification</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getQualification()
	 * @generated
	 * @ordered
	 */
  protected Qualification qualification;

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
	 * The default value of the '{@link #getEtatp() <em>Etatp</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getEtatp()
	 * @generated
	 * @ordered
	 */
  protected static final EtatPossession ETATP_EDEFAULT = EtatPossession.POSSEDE;

  /**
	 * The cached value of the '{@link #getEtatp() <em>Etatp</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getEtatp()
	 * @generated
	 * @ordered
	 */
  protected EtatPossession etatp = ETATP_EDEFAULT;

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
		return ENIGMEPackage.Literals.CONNAISSANCE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.CONNAISSANCE__NAME, oldName, name));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String getNomConnaissance()
  {
		return nomConnaissance;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setNomConnaissance(String newNomConnaissance)
  {
		String oldNomConnaissance = nomConnaissance;
		nomConnaissance = newNomConnaissance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.CONNAISSANCE__NOM_CONNAISSANCE, oldNomConnaissance, nomConnaissance));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Qualification getQualification()
  {
		if (qualification != null && qualification.eIsProxy()) {
			InternalEObject oldQualification = (InternalEObject)qualification;
			qualification = (Qualification)eResolveProxy(oldQualification);
			if (qualification != oldQualification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ENIGMEPackage.CONNAISSANCE__QUALIFICATION, oldQualification, qualification));
			}
		}
		return qualification;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Qualification basicGetQualification()
  {
		return qualification;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setQualification(Qualification newQualification)
  {
		Qualification oldQualification = qualification;
		qualification = newQualification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.CONNAISSANCE__QUALIFICATION, oldQualification, qualification));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EtatVisibilite getEtatv()
  {
		return etatv;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setEtatv(EtatVisibilite newEtatv)
  {
		EtatVisibilite oldEtatv = etatv;
		etatv = newEtatv == null ? ETATV_EDEFAULT : newEtatv;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.CONNAISSANCE__ETATV, oldEtatv, etatv));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EtatPossession getEtatp()
  {
		return etatp;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setEtatp(EtatPossession newEtatp)
  {
		EtatPossession oldEtatp = etatp;
		etatp = newEtatp == null ? ETATP_EDEFAULT : newEtatp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENIGMEPackage.CONNAISSANCE__ETATP, oldEtatp, etatp));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case ENIGMEPackage.CONNAISSANCE__NAME:
				return getName();
			case ENIGMEPackage.CONNAISSANCE__NOM_CONNAISSANCE:
				return getNomConnaissance();
			case ENIGMEPackage.CONNAISSANCE__QUALIFICATION:
				if (resolve) return getQualification();
				return basicGetQualification();
			case ENIGMEPackage.CONNAISSANCE__ETATV:
				return getEtatv();
			case ENIGMEPackage.CONNAISSANCE__ETATP:
				return getEtatp();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case ENIGMEPackage.CONNAISSANCE__NAME:
				setName((String)newValue);
				return;
			case ENIGMEPackage.CONNAISSANCE__NOM_CONNAISSANCE:
				setNomConnaissance((String)newValue);
				return;
			case ENIGMEPackage.CONNAISSANCE__QUALIFICATION:
				setQualification((Qualification)newValue);
				return;
			case ENIGMEPackage.CONNAISSANCE__ETATV:
				setEtatv((EtatVisibilite)newValue);
				return;
			case ENIGMEPackage.CONNAISSANCE__ETATP:
				setEtatp((EtatPossession)newValue);
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
		switch (featureID) {
			case ENIGMEPackage.CONNAISSANCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ENIGMEPackage.CONNAISSANCE__NOM_CONNAISSANCE:
				setNomConnaissance(NOM_CONNAISSANCE_EDEFAULT);
				return;
			case ENIGMEPackage.CONNAISSANCE__QUALIFICATION:
				setQualification((Qualification)null);
				return;
			case ENIGMEPackage.CONNAISSANCE__ETATV:
				setEtatv(ETATV_EDEFAULT);
				return;
			case ENIGMEPackage.CONNAISSANCE__ETATP:
				setEtatp(ETATP_EDEFAULT);
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
		switch (featureID) {
			case ENIGMEPackage.CONNAISSANCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ENIGMEPackage.CONNAISSANCE__NOM_CONNAISSANCE:
				return NOM_CONNAISSANCE_EDEFAULT == null ? nomConnaissance != null : !NOM_CONNAISSANCE_EDEFAULT.equals(nomConnaissance);
			case ENIGMEPackage.CONNAISSANCE__QUALIFICATION:
				return qualification != null;
			case ENIGMEPackage.CONNAISSANCE__ETATV:
				return etatv != ETATV_EDEFAULT;
			case ENIGMEPackage.CONNAISSANCE__ETATP:
				return etatp != ETATP_EDEFAULT;
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
		result.append(", nomConnaissance: ");
		result.append(nomConnaissance);
		result.append(", etatv: ");
		result.append(etatv);
		result.append(", etatp: ");
		result.append(etatp);
		result.append(')');
		return result.toString();
	}

} //ConnaissanceImpl
