/**
 */
package eNIGME.impl;

import eNIGME.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ENIGMEFactoryImpl extends EFactoryImpl implements ENIGMEFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ENIGMEFactory init() {
		try {
			ENIGMEFactory theENIGMEFactory = (ENIGMEFactory) EPackage.Registry.INSTANCE
					.getEFactory(ENIGMEPackage.eNS_URI);
			if (theENIGMEFactory != null) {
				return theENIGMEFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ENIGMEFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ENIGMEFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ENIGMEPackage.JEU:
			return createJeu();
		case ENIGMEPackage.JEU_ELEMENT:
			return createJeuElement();
		case ENIGMEPackage.JOUEUR:
			return createJoueur();
		case ENIGMEPackage.CONNAISSANCE:
			return createConnaissance();
		case ENIGMEPackage.OBJET:
			return createObjet();
		case ENIGMEPackage.TERRITOIRE:
			return createTerritoire();
		case ENIGMEPackage.CHOIX:
			return createChoix();
		case ENIGMEPackage.INTERACTION:
			return createInteraction();
		case ENIGMEPackage.PERSONNE:
			return createPersonne();
		case ENIGMEPackage.LIEU:
			return createLieu();
		case ENIGMEPackage.CHEMIN:
			return createChemin();
		case ENIGMEPackage.QUALIFICATION:
			return createQualification();
		case ENIGMEPackage.ACTION:
			return createAction();
		case ENIGMEPackage.REPONSE:
			return createReponse();
		case ENIGMEPackage.CONDITION:
			return createCondition();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case ENIGMEPackage.ETAT_REPONSE:
			return createEtatReponseFromString(eDataType, initialValue);
		case ENIGMEPackage.ETAT_POSSESSION:
			return createEtatPossessionFromString(eDataType, initialValue);
		case ENIGMEPackage.ETAT_VISIBILITE:
			return createEtatVisibiliteFromString(eDataType, initialValue);
		case ENIGMEPackage.ETAT_OBLIGATION:
			return createEtatObligationFromString(eDataType, initialValue);
		case ENIGMEPackage.ETAT_CHEMIN:
			return createEtatCheminFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case ENIGMEPackage.ETAT_REPONSE:
			return convertEtatReponseToString(eDataType, instanceValue);
		case ENIGMEPackage.ETAT_POSSESSION:
			return convertEtatPossessionToString(eDataType, instanceValue);
		case ENIGMEPackage.ETAT_VISIBILITE:
			return convertEtatVisibiliteToString(eDataType, instanceValue);
		case ENIGMEPackage.ETAT_OBLIGATION:
			return convertEtatObligationToString(eDataType, instanceValue);
		case ENIGMEPackage.ETAT_CHEMIN:
			return convertEtatCheminToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Jeu createJeu() {
		JeuImpl jeu = new JeuImpl();
		return jeu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JeuElement createJeuElement() {
		JeuElementImpl jeuElement = new JeuElementImpl();
		return jeuElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Joueur createJoueur() {
		JoueurImpl joueur = new JoueurImpl();
		return joueur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connaissance createConnaissance() {
		ConnaissanceImpl connaissance = new ConnaissanceImpl();
		return connaissance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Objet createObjet() {
		ObjetImpl objet = new ObjetImpl();
		return objet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Territoire createTerritoire() {
		TerritoireImpl territoire = new TerritoireImpl();
		return territoire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choix createChoix() {
		ChoixImpl choix = new ChoixImpl();
		return choix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interaction createInteraction() {
		InteractionImpl interaction = new InteractionImpl();
		return interaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Personne createPersonne() {
		PersonneImpl personne = new PersonneImpl();
		return personne;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lieu createLieu() {
		LieuImpl lieu = new LieuImpl();
		return lieu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Chemin createChemin() {
		CheminImpl chemin = new CheminImpl();
		return chemin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Qualification createQualification() {
		QualificationImpl qualification = new QualificationImpl();
		return qualification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action createAction() {
		ActionImpl action = new ActionImpl();
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reponse createReponse() {
		ReponseImpl reponse = new ReponseImpl();
		return reponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition createCondition() {
		ConditionImpl condition = new ConditionImpl();
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtatReponse createEtatReponseFromString(EDataType eDataType, String initialValue) {
		EtatReponse result = EtatReponse.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEtatReponseToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtatPossession createEtatPossessionFromString(EDataType eDataType, String initialValue) {
		EtatPossession result = EtatPossession.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEtatPossessionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtatVisibilite createEtatVisibiliteFromString(EDataType eDataType, String initialValue) {
		EtatVisibilite result = EtatVisibilite.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEtatVisibiliteToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtatObligation createEtatObligationFromString(EDataType eDataType, String initialValue) {
		EtatObligation result = EtatObligation.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEtatObligationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtatChemin createEtatCheminFromString(EDataType eDataType, String initialValue) {
		EtatChemin result = EtatChemin.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEtatCheminToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ENIGMEPackage getENIGMEPackage() {
		return (ENIGMEPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ENIGMEPackage getPackage() {
		return ENIGMEPackage.eINSTANCE;
	}

} //ENIGMEFactoryImpl
