/**
 */
package eNIGME.impl;

import eNIGME.Action;
import eNIGME.Chemin;
import eNIGME.Choix;
import eNIGME.Condition;
import eNIGME.Connaissance;
import eNIGME.ENIGMEFactory;
import eNIGME.ENIGMEPackage;
import eNIGME.EtatChemin;
import eNIGME.EtatObligation;
import eNIGME.EtatPossession;
import eNIGME.EtatReponse;
import eNIGME.EtatVisibilite;
import eNIGME.Interaction;
import eNIGME.Jeu;
import eNIGME.JeuElement;
import eNIGME.Joueur;
import eNIGME.Lieu;
import eNIGME.Objet;
import eNIGME.Personne;
import eNIGME.Qualification;
import eNIGME.Reponse;
import eNIGME.Territoire;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ENIGMEPackageImpl extends EPackageImpl implements ENIGMEPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jeuEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jeuElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass joueurEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connaissanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass territoireEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choixEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interactionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lieuEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cheminEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum etatReponseEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum etatPossessionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum etatVisibiliteEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum etatObligationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum etatCheminEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see eNIGME.ENIGMEPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ENIGMEPackageImpl() {
		super(eNS_URI, ENIGMEFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link ENIGMEPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ENIGMEPackage init() {
		if (isInited)
			return (ENIGMEPackage) EPackage.Registry.INSTANCE.getEPackage(ENIGMEPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredENIGMEPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ENIGMEPackageImpl theENIGMEPackage = registeredENIGMEPackage instanceof ENIGMEPackageImpl
				? (ENIGMEPackageImpl) registeredENIGMEPackage
				: new ENIGMEPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theENIGMEPackage.createPackageContents();

		// Initialize created meta-data
		theENIGMEPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theENIGMEPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ENIGMEPackage.eNS_URI, theENIGMEPackage);
		return theENIGMEPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJeu() {
		return jeuEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJeu_Name() {
		return (EAttribute) jeuEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJeu_Jeuelement() {
		return (EReference) jeuEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJeuElement() {
		return jeuElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJoueur() {
		return joueurEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoueur_Name() {
		return (EAttribute) joueurEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoueur_Limite() {
		return (EAttribute) joueurEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJoueur_Objets() {
		return (EReference) joueurEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJoueur_Connaissances() {
		return (EReference) joueurEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnaissance() {
		return connaissanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnaissance_Name() {
		return (EAttribute) connaissanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnaissance_NomConnaissance() {
		return (EAttribute) connaissanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnaissance_Qualification() {
		return (EReference) connaissanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnaissance_Etatv() {
		return (EAttribute) connaissanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnaissance_Etatp() {
		return (EAttribute) connaissanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjet() {
		return objetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjet_Name() {
		return (EAttribute) objetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjet_NomObjet() {
		return (EAttribute) objetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjet_Occurrence() {
		return (EAttribute) objetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjet_Taille() {
		return (EAttribute) objetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjet_Etatv() {
		return (EAttribute) objetEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjet_Etatp() {
		return (EAttribute) objetEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerritoire() {
		return territoireEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTerritoire_Name() {
		return (EAttribute) territoireEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerritoire_LieuDebut() {
		return (EReference) territoireEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerritoire_Lieuxintermediaires() {
		return (EReference) territoireEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerritoire_LieuxFin() {
		return (EReference) territoireEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerritoire_Chemins() {
		return (EReference) territoireEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoix() {
		return choixEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChoix_Name() {
		return (EAttribute) choixEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoix_Reponses() {
		return (EReference) choixEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoix_Conditions() {
		return (EReference) choixEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInteraction() {
		return interactionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInteraction_Name() {
		return (EAttribute) interactionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteraction_Choix() {
		return (EReference) interactionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteraction_ChoixFin() {
		return (EReference) interactionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPersonne() {
		return personneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPersonne_Name() {
		return (EAttribute) personneEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPersonne_Etato() {
		return (EAttribute) personneEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPersonne_Conditiono() {
		return (EReference) personneEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPersonne_Etatv() {
		return (EAttribute) personneEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPersonne_Conditionv() {
		return (EReference) personneEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPersonne_Texte() {
		return (EReference) personneEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPersonne_Interaction() {
		return (EReference) personneEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLieu() {
		return lieuEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLieu_Name() {
		return (EAttribute) lieuEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLieu_Personnes() {
		return (EReference) lieuEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChemin() {
		return cheminEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChemin_Etatc() {
		return (EAttribute) cheminEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChemin_Conditionc() {
		return (EReference) cheminEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChemin_Etato() {
		return (EAttribute) cheminEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChemin_Conditiono() {
		return (EReference) cheminEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChemin_Etatv() {
		return (EAttribute) cheminEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChemin_Conditionv() {
		return (EReference) cheminEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChemin_Precedent() {
		return (EReference) cheminEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChemin_Suivant() {
		return (EReference) cheminEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualification() {
		return qualificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQualification_Id() {
		return (EAttribute) qualificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQualification_Qualification() {
		return (EAttribute) qualificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAction_Name() {
		return (EAttribute) actionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_Objetsconsommables() {
		return (EReference) actionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_Objetsattribuables() {
		return (EReference) actionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_Connaissancesattribuables() {
		return (EReference) actionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReponse() {
		return reponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReponse_Name() {
		return (EAttribute) reponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReponse_Etat() {
		return (EAttribute) reponseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReponse_Texte() {
		return (EReference) reponseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReponse_Action() {
		return (EReference) reponseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCondition() {
		return conditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCondition_Name() {
		return (EAttribute) conditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCondition_ObjetsRequis() {
		return (EReference) conditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCondition_ConnaissancesRequises() {
		return (EReference) conditionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEtatReponse() {
		return etatReponseEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEtatPossession() {
		return etatPossessionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEtatVisibilite() {
		return etatVisibiliteEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEtatObligation() {
		return etatObligationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEtatChemin() {
		return etatCheminEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ENIGMEFactory getENIGMEFactory() {
		return (ENIGMEFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		jeuEClass = createEClass(JEU);
		createEAttribute(jeuEClass, JEU__NAME);
		createEReference(jeuEClass, JEU__JEUELEMENT);

		jeuElementEClass = createEClass(JEU_ELEMENT);

		joueurEClass = createEClass(JOUEUR);
		createEAttribute(joueurEClass, JOUEUR__NAME);
		createEAttribute(joueurEClass, JOUEUR__LIMITE);
		createEReference(joueurEClass, JOUEUR__OBJETS);
		createEReference(joueurEClass, JOUEUR__CONNAISSANCES);

		connaissanceEClass = createEClass(CONNAISSANCE);
		createEAttribute(connaissanceEClass, CONNAISSANCE__NAME);
		createEAttribute(connaissanceEClass, CONNAISSANCE__NOM_CONNAISSANCE);
		createEReference(connaissanceEClass, CONNAISSANCE__QUALIFICATION);
		createEAttribute(connaissanceEClass, CONNAISSANCE__ETATV);
		createEAttribute(connaissanceEClass, CONNAISSANCE__ETATP);

		objetEClass = createEClass(OBJET);
		createEAttribute(objetEClass, OBJET__NAME);
		createEAttribute(objetEClass, OBJET__NOM_OBJET);
		createEAttribute(objetEClass, OBJET__OCCURRENCE);
		createEAttribute(objetEClass, OBJET__TAILLE);
		createEAttribute(objetEClass, OBJET__ETATV);
		createEAttribute(objetEClass, OBJET__ETATP);

		territoireEClass = createEClass(TERRITOIRE);
		createEAttribute(territoireEClass, TERRITOIRE__NAME);
		createEReference(territoireEClass, TERRITOIRE__LIEU_DEBUT);
		createEReference(territoireEClass, TERRITOIRE__LIEUXINTERMEDIAIRES);
		createEReference(territoireEClass, TERRITOIRE__LIEUX_FIN);
		createEReference(territoireEClass, TERRITOIRE__CHEMINS);

		choixEClass = createEClass(CHOIX);
		createEAttribute(choixEClass, CHOIX__NAME);
		createEReference(choixEClass, CHOIX__REPONSES);
		createEReference(choixEClass, CHOIX__CONDITIONS);

		interactionEClass = createEClass(INTERACTION);
		createEAttribute(interactionEClass, INTERACTION__NAME);
		createEReference(interactionEClass, INTERACTION__CHOIX);
		createEReference(interactionEClass, INTERACTION__CHOIX_FIN);

		personneEClass = createEClass(PERSONNE);
		createEAttribute(personneEClass, PERSONNE__NAME);
		createEAttribute(personneEClass, PERSONNE__ETATO);
		createEReference(personneEClass, PERSONNE__CONDITIONO);
		createEAttribute(personneEClass, PERSONNE__ETATV);
		createEReference(personneEClass, PERSONNE__CONDITIONV);
		createEReference(personneEClass, PERSONNE__TEXTE);
		createEReference(personneEClass, PERSONNE__INTERACTION);

		lieuEClass = createEClass(LIEU);
		createEAttribute(lieuEClass, LIEU__NAME);
		createEReference(lieuEClass, LIEU__PERSONNES);

		cheminEClass = createEClass(CHEMIN);
		createEAttribute(cheminEClass, CHEMIN__ETATC);
		createEReference(cheminEClass, CHEMIN__CONDITIONC);
		createEAttribute(cheminEClass, CHEMIN__ETATO);
		createEReference(cheminEClass, CHEMIN__CONDITIONO);
		createEAttribute(cheminEClass, CHEMIN__ETATV);
		createEReference(cheminEClass, CHEMIN__CONDITIONV);
		createEReference(cheminEClass, CHEMIN__PRECEDENT);
		createEReference(cheminEClass, CHEMIN__SUIVANT);

		qualificationEClass = createEClass(QUALIFICATION);
		createEAttribute(qualificationEClass, QUALIFICATION__ID);
		createEAttribute(qualificationEClass, QUALIFICATION__QUALIFICATION);

		actionEClass = createEClass(ACTION);
		createEAttribute(actionEClass, ACTION__NAME);
		createEReference(actionEClass, ACTION__OBJETSCONSOMMABLES);
		createEReference(actionEClass, ACTION__OBJETSATTRIBUABLES);
		createEReference(actionEClass, ACTION__CONNAISSANCESATTRIBUABLES);

		reponseEClass = createEClass(REPONSE);
		createEAttribute(reponseEClass, REPONSE__NAME);
		createEAttribute(reponseEClass, REPONSE__ETAT);
		createEReference(reponseEClass, REPONSE__TEXTE);
		createEReference(reponseEClass, REPONSE__ACTION);

		conditionEClass = createEClass(CONDITION);
		createEAttribute(conditionEClass, CONDITION__NAME);
		createEReference(conditionEClass, CONDITION__OBJETS_REQUIS);
		createEReference(conditionEClass, CONDITION__CONNAISSANCES_REQUISES);

		// Create enums
		etatReponseEEnum = createEEnum(ETAT_REPONSE);
		etatPossessionEEnum = createEEnum(ETAT_POSSESSION);
		etatVisibiliteEEnum = createEEnum(ETAT_VISIBILITE);
		etatObligationEEnum = createEEnum(ETAT_OBLIGATION);
		etatCheminEEnum = createEEnum(ETAT_CHEMIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		joueurEClass.getESuperTypes().add(this.getJeuElement());
		connaissanceEClass.getESuperTypes().add(this.getJeuElement());
		objetEClass.getESuperTypes().add(this.getJeuElement());
		territoireEClass.getESuperTypes().add(this.getJeuElement());
		choixEClass.getESuperTypes().add(this.getJeuElement());
		interactionEClass.getESuperTypes().add(this.getJeuElement());
		personneEClass.getESuperTypes().add(this.getJeuElement());
		lieuEClass.getESuperTypes().add(this.getJeuElement());
		cheminEClass.getESuperTypes().add(this.getJeuElement());
		qualificationEClass.getESuperTypes().add(this.getJeuElement());
		actionEClass.getESuperTypes().add(this.getJeuElement());
		reponseEClass.getESuperTypes().add(this.getJeuElement());
		conditionEClass.getESuperTypes().add(this.getJeuElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(jeuEClass, Jeu.class, "Jeu", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJeu_Name(), ecorePackage.getEString(), "name", null, 0, 1, Jeu.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJeu_Jeuelement(), this.getJeuElement(), null, "jeuelement", null, 0, -1, Jeu.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jeuElementEClass, JeuElement.class, "JeuElement", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(joueurEClass, Joueur.class, "Joueur", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJoueur_Name(), ecorePackage.getEString(), "name", null, 0, 1, Joueur.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoueur_Limite(), ecorePackage.getEInt(), "limite", null, 0, 1, Joueur.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJoueur_Objets(), this.getObjet(), null, "objets", null, 0, -1, Joueur.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getJoueur_Connaissances(), this.getConnaissance(), null, "connaissances", null, 0, -1,
				Joueur.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connaissanceEClass, Connaissance.class, "Connaissance", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnaissance_Name(), ecorePackage.getEString(), "name", null, 0, 1, Connaissance.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnaissance_NomConnaissance(), ecorePackage.getEString(), "nomConnaissance", null, 0, 1,
				Connaissance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getConnaissance_Qualification(), this.getQualification(), null, "qualification", null, 0, 1,
				Connaissance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnaissance_Etatv(), this.getEtatVisibilite(), "etatv", null, 0, 1, Connaissance.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnaissance_Etatp(), this.getEtatPossession(), "etatp", null, 0, 1, Connaissance.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objetEClass, Objet.class, "Objet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getObjet_Name(), ecorePackage.getEString(), "name", null, 0, 1, Objet.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObjet_NomObjet(), ecorePackage.getEString(), "nomObjet", null, 0, 1, Objet.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObjet_Occurrence(), ecorePackage.getEInt(), "occurrence", null, 0, 1, Objet.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObjet_Taille(), ecorePackage.getEInt(), "taille", null, 0, 1, Objet.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObjet_Etatv(), this.getEtatVisibilite(), "etatv", null, 0, 1, Objet.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObjet_Etatp(), this.getEtatPossession(), "etatp", null, 0, 1, Objet.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(territoireEClass, Territoire.class, "Territoire", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTerritoire_Name(), ecorePackage.getEString(), "name", null, 0, 1, Territoire.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerritoire_LieuDebut(), this.getLieu(), null, "lieuDebut", null, 0, 1, Territoire.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerritoire_Lieuxintermediaires(), this.getLieu(), null, "lieuxintermediaires", null, 0, -1,
				Territoire.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerritoire_LieuxFin(), this.getLieu(), null, "lieuxFin", null, 0, -1, Territoire.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerritoire_Chemins(), this.getChemin(), null, "chemins", null, 0, -1, Territoire.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(choixEClass, Choix.class, "Choix", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChoix_Name(), ecorePackage.getEString(), "name", null, 0, 1, Choix.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChoix_Reponses(), this.getReponse(), null, "reponses", null, 0, -1, Choix.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChoix_Conditions(), this.getCondition(), null, "conditions", null, 0, -1, Choix.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interactionEClass, Interaction.class, "Interaction", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInteraction_Name(), ecorePackage.getEString(), "name", null, 0, 1, Interaction.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInteraction_Choix(), this.getChoix(), null, "choix", null, 0, 1, Interaction.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInteraction_ChoixFin(), this.getChoix(), null, "choixFin", null, 0, 1, Interaction.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(personneEClass, Personne.class, "Personne", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPersonne_Name(), ecorePackage.getEString(), "name", null, 0, 1, Personne.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPersonne_Etato(), this.getEtatObligation(), "etato", null, 0, 1, Personne.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPersonne_Conditiono(), this.getCondition(), null, "conditiono", null, 0, 1, Personne.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPersonne_Etatv(), this.getEtatVisibilite(), "etatv", null, 0, 1, Personne.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPersonne_Conditionv(), this.getCondition(), null, "conditionv", null, 0, 1, Personne.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPersonne_Texte(), this.getQualification(), null, "texte", null, 0, 1, Personne.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPersonne_Interaction(), this.getInteraction(), null, "interaction", null, 0, 1,
				Personne.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lieuEClass, Lieu.class, "Lieu", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLieu_Name(), ecorePackage.getEString(), "name", null, 0, 1, Lieu.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLieu_Personnes(), this.getPersonne(), null, "personnes", null, 0, -1, Lieu.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cheminEClass, Chemin.class, "Chemin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChemin_Etatc(), this.getEtatChemin(), "etatc", null, 0, 1, Chemin.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChemin_Conditionc(), this.getCondition(), null, "conditionc", null, 0, 1, Chemin.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getChemin_Etato(), this.getEtatObligation(), "etato", null, 0, 1, Chemin.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChemin_Conditiono(), this.getCondition(), null, "conditiono", null, 0, 1, Chemin.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getChemin_Etatv(), this.getEtatVisibilite(), "etatv", null, 0, 1, Chemin.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChemin_Conditionv(), this.getCondition(), null, "conditionv", null, 0, 1, Chemin.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChemin_Precedent(), this.getLieu(), null, "precedent", null, 0, 1, Chemin.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChemin_Suivant(), this.getLieu(), null, "suivant", null, 0, 1, Chemin.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(qualificationEClass, Qualification.class, "Qualification", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQualification_Id(), ecorePackage.getEInt(), "id", null, 0, 1, Qualification.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQualification_Qualification(), ecorePackage.getEString(), "qualification", null, 0, 1,
				Qualification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(actionEClass, Action.class, "Action", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAction_Name(), ecorePackage.getEString(), "name", null, 0, 1, Action.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAction_Objetsconsommables(), this.getObjet(), null, "objetsconsommables", null, 0, -1,
				Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAction_Objetsattribuables(), this.getObjet(), null, "objetsattribuables", null, 0, -1,
				Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAction_Connaissancesattribuables(), this.getConnaissance(), null, "connaissancesattribuables",
				null, 0, -1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(reponseEClass, Reponse.class, "Reponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReponse_Name(), ecorePackage.getEString(), "name", null, 0, 1, Reponse.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReponse_Etat(), this.getEtatReponse(), "etat", null, 0, 1, Reponse.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReponse_Texte(), this.getQualification(), null, "texte", null, 0, 1, Reponse.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReponse_Action(), this.getAction(), null, "action", null, 0, 1, Reponse.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(conditionEClass, Condition.class, "Condition", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCondition_Name(), ecorePackage.getEString(), "name", null, 0, 1, Condition.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCondition_ObjetsRequis(), this.getObjet(), null, "objetsRequis", null, 0, -1, Condition.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCondition_ConnaissancesRequises(), this.getConnaissance(), null, "connaissancesRequises",
				null, 0, -1, Condition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(etatReponseEEnum, EtatReponse.class, "EtatReponse");
		addEEnumLiteral(etatReponseEEnum, EtatReponse.BONNE);
		addEEnumLiteral(etatReponseEEnum, EtatReponse.MAUVAISE);

		initEEnum(etatPossessionEEnum, EtatPossession.class, "EtatPossession");
		addEEnumLiteral(etatPossessionEEnum, EtatPossession.POSSEDE);
		addEEnumLiteral(etatPossessionEEnum, EtatPossession.NPOSSEDE);

		initEEnum(etatVisibiliteEEnum, EtatVisibilite.class, "EtatVisibilite");
		addEEnumLiteral(etatVisibiliteEEnum, EtatVisibilite.VISIBLE);
		addEEnumLiteral(etatVisibiliteEEnum, EtatVisibilite.NVISIBLE);

		initEEnum(etatObligationEEnum, EtatObligation.class, "EtatObligation");
		addEEnumLiteral(etatObligationEEnum, EtatObligation.OBLIGATOIRE);
		addEEnumLiteral(etatObligationEEnum, EtatObligation.NOBLIGATOIRE);

		initEEnum(etatCheminEEnum, EtatChemin.class, "EtatChemin");
		addEEnumLiteral(etatCheminEEnum, EtatChemin.OUVERT);
		addEEnumLiteral(etatCheminEEnum, EtatChemin.FERME);

		// Create resource
		createResource(eNS_URI);
	}

} //ENIGMEPackageImpl
