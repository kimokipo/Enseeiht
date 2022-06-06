/**
 */
package eNIGME;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eNIGME.ENIGMEFactory
 * @model kind="package"
 * @generated
 */
public interface ENIGMEPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "eNIGME";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.n7.fr/ENIGME";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "eNIGME";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ENIGMEPackage eINSTANCE = eNIGME.impl.ENIGMEPackageImpl.init();

	/**
	 * The meta object id for the '{@link eNIGME.impl.JeuImpl <em>Jeu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.impl.JeuImpl
	 * @see eNIGME.impl.ENIGMEPackageImpl#getJeu()
	 * @generated
	 */
	int JEU = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JEU__NAME = 0;

	/**
	 * The feature id for the '<em><b>Jeuelement</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JEU__JEUELEMENT = 1;

	/**
	 * The number of structural features of the '<em>Jeu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JEU_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Jeu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JEU_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eNIGME.impl.JeuElementImpl <em>Jeu Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.impl.JeuElementImpl
	 * @see eNIGME.impl.ENIGMEPackageImpl#getJeuElement()
	 * @generated
	 */
	int JEU_ELEMENT = 1;

	/**
	 * The number of structural features of the '<em>Jeu Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JEU_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Jeu Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JEU_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eNIGME.impl.JoueurImpl <em>Joueur</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.impl.JoueurImpl
	 * @see eNIGME.impl.ENIGMEPackageImpl#getJoueur()
	 * @generated
	 */
	int JOUEUR = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOUEUR__NAME = JEU_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Limite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOUEUR__LIMITE = JEU_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Objets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOUEUR__OBJETS = JEU_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Connaissances</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOUEUR__CONNAISSANCES = JEU_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Joueur</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOUEUR_FEATURE_COUNT = JEU_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Joueur</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOUEUR_OPERATION_COUNT = JEU_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eNIGME.impl.ConnaissanceImpl <em>Connaissance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.impl.ConnaissanceImpl
	 * @see eNIGME.impl.ENIGMEPackageImpl#getConnaissance()
	 * @generated
	 */
	int CONNAISSANCE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNAISSANCE__NAME = JEU_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nom Connaissance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNAISSANCE__NOM_CONNAISSANCE = JEU_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Qualification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNAISSANCE__QUALIFICATION = JEU_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Etatv</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNAISSANCE__ETATV = JEU_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Etatp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNAISSANCE__ETATP = JEU_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Connaissance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNAISSANCE_FEATURE_COUNT = JEU_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Connaissance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNAISSANCE_OPERATION_COUNT = JEU_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eNIGME.impl.ObjetImpl <em>Objet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.impl.ObjetImpl
	 * @see eNIGME.impl.ENIGMEPackageImpl#getObjet()
	 * @generated
	 */
	int OBJET = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJET__NAME = JEU_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nom Objet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJET__NOM_OBJET = JEU_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJET__OCCURRENCE = JEU_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Taille</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJET__TAILLE = JEU_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Etatv</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJET__ETATV = JEU_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Etatp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJET__ETATP = JEU_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Objet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJET_FEATURE_COUNT = JEU_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Objet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJET_OPERATION_COUNT = JEU_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eNIGME.impl.TerritoireImpl <em>Territoire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.impl.TerritoireImpl
	 * @see eNIGME.impl.ENIGMEPackageImpl#getTerritoire()
	 * @generated
	 */
	int TERRITOIRE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERRITOIRE__NAME = JEU_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lieu Debut</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERRITOIRE__LIEU_DEBUT = JEU_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lieuxintermediaires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERRITOIRE__LIEUXINTERMEDIAIRES = JEU_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Lieux Fin</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERRITOIRE__LIEUX_FIN = JEU_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Chemins</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERRITOIRE__CHEMINS = JEU_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Territoire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERRITOIRE_FEATURE_COUNT = JEU_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Territoire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERRITOIRE_OPERATION_COUNT = JEU_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eNIGME.impl.ChoixImpl <em>Choix</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.impl.ChoixImpl
	 * @see eNIGME.impl.ENIGMEPackageImpl#getChoix()
	 * @generated
	 */
	int CHOIX = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOIX__NAME = JEU_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reponses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOIX__REPONSES = JEU_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOIX__CONDITIONS = JEU_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Choix</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOIX_FEATURE_COUNT = JEU_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Choix</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOIX_OPERATION_COUNT = JEU_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eNIGME.impl.InteractionImpl <em>Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.impl.InteractionImpl
	 * @see eNIGME.impl.ENIGMEPackageImpl#getInteraction()
	 * @generated
	 */
	int INTERACTION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__NAME = JEU_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Choix</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__CHOIX = JEU_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Choix Fin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__CHOIX_FIN = JEU_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FEATURE_COUNT = JEU_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_OPERATION_COUNT = JEU_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eNIGME.impl.PersonneImpl <em>Personne</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.impl.PersonneImpl
	 * @see eNIGME.impl.ENIGMEPackageImpl#getPersonne()
	 * @generated
	 */
	int PERSONNE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNE__NAME = JEU_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Etato</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNE__ETATO = JEU_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Conditiono</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNE__CONDITIONO = JEU_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Etatv</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNE__ETATV = JEU_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Conditionv</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNE__CONDITIONV = JEU_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Texte</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNE__TEXTE = JEU_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Interaction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNE__INTERACTION = JEU_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Personne</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNE_FEATURE_COUNT = JEU_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Personne</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNE_OPERATION_COUNT = JEU_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eNIGME.impl.LieuImpl <em>Lieu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.impl.LieuImpl
	 * @see eNIGME.impl.ENIGMEPackageImpl#getLieu()
	 * @generated
	 */
	int LIEU = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIEU__NAME = JEU_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Personnes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIEU__PERSONNES = JEU_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Lieu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIEU_FEATURE_COUNT = JEU_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Lieu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIEU_OPERATION_COUNT = JEU_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eNIGME.impl.CheminImpl <em>Chemin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.impl.CheminImpl
	 * @see eNIGME.impl.ENIGMEPackageImpl#getChemin()
	 * @generated
	 */
	int CHEMIN = 10;

	/**
	 * The feature id for the '<em><b>Etatc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHEMIN__ETATC = JEU_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Conditionc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHEMIN__CONDITIONC = JEU_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Etato</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHEMIN__ETATO = JEU_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Conditiono</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHEMIN__CONDITIONO = JEU_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Etatv</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHEMIN__ETATV = JEU_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Conditionv</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHEMIN__CONDITIONV = JEU_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Precedent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHEMIN__PRECEDENT = JEU_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Suivant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHEMIN__SUIVANT = JEU_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Chemin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHEMIN_FEATURE_COUNT = JEU_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Chemin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHEMIN_OPERATION_COUNT = JEU_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eNIGME.impl.QualificationImpl <em>Qualification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.impl.QualificationImpl
	 * @see eNIGME.impl.ENIGMEPackageImpl#getQualification()
	 * @generated
	 */
	int QUALIFICATION = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFICATION__ID = JEU_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Qualification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFICATION__QUALIFICATION = JEU_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Qualification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFICATION_FEATURE_COUNT = JEU_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Qualification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFICATION_OPERATION_COUNT = JEU_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eNIGME.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.impl.ActionImpl
	 * @see eNIGME.impl.ENIGMEPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = JEU_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Objetsconsommables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__OBJETSCONSOMMABLES = JEU_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Objetsattribuables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__OBJETSATTRIBUABLES = JEU_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Connaissancesattribuables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__CONNAISSANCESATTRIBUABLES = JEU_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = JEU_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = JEU_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eNIGME.impl.ReponseImpl <em>Reponse</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.impl.ReponseImpl
	 * @see eNIGME.impl.ENIGMEPackageImpl#getReponse()
	 * @generated
	 */
	int REPONSE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPONSE__NAME = JEU_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Etat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPONSE__ETAT = JEU_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Texte</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPONSE__TEXTE = JEU_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPONSE__ACTION = JEU_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Reponse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPONSE_FEATURE_COUNT = JEU_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Reponse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPONSE_OPERATION_COUNT = JEU_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eNIGME.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.impl.ConditionImpl
	 * @see eNIGME.impl.ENIGMEPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__NAME = JEU_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Objets Requis</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__OBJETS_REQUIS = JEU_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Connaissances Requises</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__CONNAISSANCES_REQUISES = JEU_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = JEU_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_OPERATION_COUNT = JEU_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eNIGME.EtatReponse <em>Etat Reponse</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.EtatReponse
	 * @see eNIGME.impl.ENIGMEPackageImpl#getEtatReponse()
	 * @generated
	 */
	int ETAT_REPONSE = 15;

	/**
	 * The meta object id for the '{@link eNIGME.EtatPossession <em>Etat Possession</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.EtatPossession
	 * @see eNIGME.impl.ENIGMEPackageImpl#getEtatPossession()
	 * @generated
	 */
	int ETAT_POSSESSION = 16;

	/**
	 * The meta object id for the '{@link eNIGME.EtatVisibilite <em>Etat Visibilite</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.EtatVisibilite
	 * @see eNIGME.impl.ENIGMEPackageImpl#getEtatVisibilite()
	 * @generated
	 */
	int ETAT_VISIBILITE = 17;

	/**
	 * The meta object id for the '{@link eNIGME.EtatObligation <em>Etat Obligation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.EtatObligation
	 * @see eNIGME.impl.ENIGMEPackageImpl#getEtatObligation()
	 * @generated
	 */
	int ETAT_OBLIGATION = 18;

	/**
	 * The meta object id for the '{@link eNIGME.EtatChemin <em>Etat Chemin</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eNIGME.EtatChemin
	 * @see eNIGME.impl.ENIGMEPackageImpl#getEtatChemin()
	 * @generated
	 */
	int ETAT_CHEMIN = 19;

	/**
	 * Returns the meta object for class '{@link eNIGME.Jeu <em>Jeu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jeu</em>'.
	 * @see eNIGME.Jeu
	 * @generated
	 */
	EClass getJeu();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Jeu#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eNIGME.Jeu#getName()
	 * @see #getJeu()
	 * @generated
	 */
	EAttribute getJeu_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link eNIGME.Jeu#getJeuelement <em>Jeuelement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Jeuelement</em>'.
	 * @see eNIGME.Jeu#getJeuelement()
	 * @see #getJeu()
	 * @generated
	 */
	EReference getJeu_Jeuelement();

	/**
	 * Returns the meta object for class '{@link eNIGME.JeuElement <em>Jeu Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jeu Element</em>'.
	 * @see eNIGME.JeuElement
	 * @generated
	 */
	EClass getJeuElement();

	/**
	 * Returns the meta object for class '{@link eNIGME.Joueur <em>Joueur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Joueur</em>'.
	 * @see eNIGME.Joueur
	 * @generated
	 */
	EClass getJoueur();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Joueur#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eNIGME.Joueur#getName()
	 * @see #getJoueur()
	 * @generated
	 */
	EAttribute getJoueur_Name();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Joueur#getLimite <em>Limite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Limite</em>'.
	 * @see eNIGME.Joueur#getLimite()
	 * @see #getJoueur()
	 * @generated
	 */
	EAttribute getJoueur_Limite();

	/**
	 * Returns the meta object for the reference list '{@link eNIGME.Joueur#getObjets <em>Objets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Objets</em>'.
	 * @see eNIGME.Joueur#getObjets()
	 * @see #getJoueur()
	 * @generated
	 */
	EReference getJoueur_Objets();

	/**
	 * Returns the meta object for the reference list '{@link eNIGME.Joueur#getConnaissances <em>Connaissances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connaissances</em>'.
	 * @see eNIGME.Joueur#getConnaissances()
	 * @see #getJoueur()
	 * @generated
	 */
	EReference getJoueur_Connaissances();

	/**
	 * Returns the meta object for class '{@link eNIGME.Connaissance <em>Connaissance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connaissance</em>'.
	 * @see eNIGME.Connaissance
	 * @generated
	 */
	EClass getConnaissance();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Connaissance#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eNIGME.Connaissance#getName()
	 * @see #getConnaissance()
	 * @generated
	 */
	EAttribute getConnaissance_Name();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Connaissance#getNomConnaissance <em>Nom Connaissance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nom Connaissance</em>'.
	 * @see eNIGME.Connaissance#getNomConnaissance()
	 * @see #getConnaissance()
	 * @generated
	 */
	EAttribute getConnaissance_NomConnaissance();

	/**
	 * Returns the meta object for the reference '{@link eNIGME.Connaissance#getQualification <em>Qualification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Qualification</em>'.
	 * @see eNIGME.Connaissance#getQualification()
	 * @see #getConnaissance()
	 * @generated
	 */
	EReference getConnaissance_Qualification();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Connaissance#getEtatv <em>Etatv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Etatv</em>'.
	 * @see eNIGME.Connaissance#getEtatv()
	 * @see #getConnaissance()
	 * @generated
	 */
	EAttribute getConnaissance_Etatv();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Connaissance#getEtatp <em>Etatp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Etatp</em>'.
	 * @see eNIGME.Connaissance#getEtatp()
	 * @see #getConnaissance()
	 * @generated
	 */
	EAttribute getConnaissance_Etatp();

	/**
	 * Returns the meta object for class '{@link eNIGME.Objet <em>Objet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Objet</em>'.
	 * @see eNIGME.Objet
	 * @generated
	 */
	EClass getObjet();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Objet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eNIGME.Objet#getName()
	 * @see #getObjet()
	 * @generated
	 */
	EAttribute getObjet_Name();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Objet#getNomObjet <em>Nom Objet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nom Objet</em>'.
	 * @see eNIGME.Objet#getNomObjet()
	 * @see #getObjet()
	 * @generated
	 */
	EAttribute getObjet_NomObjet();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Objet#getOccurrence <em>Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Occurrence</em>'.
	 * @see eNIGME.Objet#getOccurrence()
	 * @see #getObjet()
	 * @generated
	 */
	EAttribute getObjet_Occurrence();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Objet#getTaille <em>Taille</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Taille</em>'.
	 * @see eNIGME.Objet#getTaille()
	 * @see #getObjet()
	 * @generated
	 */
	EAttribute getObjet_Taille();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Objet#getEtatv <em>Etatv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Etatv</em>'.
	 * @see eNIGME.Objet#getEtatv()
	 * @see #getObjet()
	 * @generated
	 */
	EAttribute getObjet_Etatv();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Objet#getEtatp <em>Etatp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Etatp</em>'.
	 * @see eNIGME.Objet#getEtatp()
	 * @see #getObjet()
	 * @generated
	 */
	EAttribute getObjet_Etatp();

	/**
	 * Returns the meta object for class '{@link eNIGME.Territoire <em>Territoire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Territoire</em>'.
	 * @see eNIGME.Territoire
	 * @generated
	 */
	EClass getTerritoire();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Territoire#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eNIGME.Territoire#getName()
	 * @see #getTerritoire()
	 * @generated
	 */
	EAttribute getTerritoire_Name();

	/**
	 * Returns the meta object for the containment reference '{@link eNIGME.Territoire#getLieuDebut <em>Lieu Debut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lieu Debut</em>'.
	 * @see eNIGME.Territoire#getLieuDebut()
	 * @see #getTerritoire()
	 * @generated
	 */
	EReference getTerritoire_LieuDebut();

	/**
	 * Returns the meta object for the containment reference list '{@link eNIGME.Territoire#getLieuxintermediaires <em>Lieuxintermediaires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lieuxintermediaires</em>'.
	 * @see eNIGME.Territoire#getLieuxintermediaires()
	 * @see #getTerritoire()
	 * @generated
	 */
	EReference getTerritoire_Lieuxintermediaires();

	/**
	 * Returns the meta object for the containment reference list '{@link eNIGME.Territoire#getLieuxFin <em>Lieux Fin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lieux Fin</em>'.
	 * @see eNIGME.Territoire#getLieuxFin()
	 * @see #getTerritoire()
	 * @generated
	 */
	EReference getTerritoire_LieuxFin();

	/**
	 * Returns the meta object for the containment reference list '{@link eNIGME.Territoire#getChemins <em>Chemins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Chemins</em>'.
	 * @see eNIGME.Territoire#getChemins()
	 * @see #getTerritoire()
	 * @generated
	 */
	EReference getTerritoire_Chemins();

	/**
	 * Returns the meta object for class '{@link eNIGME.Choix <em>Choix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choix</em>'.
	 * @see eNIGME.Choix
	 * @generated
	 */
	EClass getChoix();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Choix#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eNIGME.Choix#getName()
	 * @see #getChoix()
	 * @generated
	 */
	EAttribute getChoix_Name();

	/**
	 * Returns the meta object for the reference list '{@link eNIGME.Choix#getReponses <em>Reponses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Reponses</em>'.
	 * @see eNIGME.Choix#getReponses()
	 * @see #getChoix()
	 * @generated
	 */
	EReference getChoix_Reponses();

	/**
	 * Returns the meta object for the reference list '{@link eNIGME.Choix#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conditions</em>'.
	 * @see eNIGME.Choix#getConditions()
	 * @see #getChoix()
	 * @generated
	 */
	EReference getChoix_Conditions();

	/**
	 * Returns the meta object for class '{@link eNIGME.Interaction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interaction</em>'.
	 * @see eNIGME.Interaction
	 * @generated
	 */
	EClass getInteraction();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Interaction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eNIGME.Interaction#getName()
	 * @see #getInteraction()
	 * @generated
	 */
	EAttribute getInteraction_Name();

	/**
	 * Returns the meta object for the reference '{@link eNIGME.Interaction#getChoix <em>Choix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Choix</em>'.
	 * @see eNIGME.Interaction#getChoix()
	 * @see #getInteraction()
	 * @generated
	 */
	EReference getInteraction_Choix();

	/**
	 * Returns the meta object for the reference '{@link eNIGME.Interaction#getChoixFin <em>Choix Fin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Choix Fin</em>'.
	 * @see eNIGME.Interaction#getChoixFin()
	 * @see #getInteraction()
	 * @generated
	 */
	EReference getInteraction_ChoixFin();

	/**
	 * Returns the meta object for class '{@link eNIGME.Personne <em>Personne</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Personne</em>'.
	 * @see eNIGME.Personne
	 * @generated
	 */
	EClass getPersonne();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Personne#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eNIGME.Personne#getName()
	 * @see #getPersonne()
	 * @generated
	 */
	EAttribute getPersonne_Name();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Personne#getEtato <em>Etato</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Etato</em>'.
	 * @see eNIGME.Personne#getEtato()
	 * @see #getPersonne()
	 * @generated
	 */
	EAttribute getPersonne_Etato();

	/**
	 * Returns the meta object for the reference '{@link eNIGME.Personne#getConditiono <em>Conditiono</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Conditiono</em>'.
	 * @see eNIGME.Personne#getConditiono()
	 * @see #getPersonne()
	 * @generated
	 */
	EReference getPersonne_Conditiono();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Personne#getEtatv <em>Etatv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Etatv</em>'.
	 * @see eNIGME.Personne#getEtatv()
	 * @see #getPersonne()
	 * @generated
	 */
	EAttribute getPersonne_Etatv();

	/**
	 * Returns the meta object for the reference '{@link eNIGME.Personne#getConditionv <em>Conditionv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Conditionv</em>'.
	 * @see eNIGME.Personne#getConditionv()
	 * @see #getPersonne()
	 * @generated
	 */
	EReference getPersonne_Conditionv();

	/**
	 * Returns the meta object for the reference '{@link eNIGME.Personne#getTexte <em>Texte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Texte</em>'.
	 * @see eNIGME.Personne#getTexte()
	 * @see #getPersonne()
	 * @generated
	 */
	EReference getPersonne_Texte();

	/**
	 * Returns the meta object for the reference '{@link eNIGME.Personne#getInteraction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Interaction</em>'.
	 * @see eNIGME.Personne#getInteraction()
	 * @see #getPersonne()
	 * @generated
	 */
	EReference getPersonne_Interaction();

	/**
	 * Returns the meta object for class '{@link eNIGME.Lieu <em>Lieu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lieu</em>'.
	 * @see eNIGME.Lieu
	 * @generated
	 */
	EClass getLieu();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Lieu#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eNIGME.Lieu#getName()
	 * @see #getLieu()
	 * @generated
	 */
	EAttribute getLieu_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link eNIGME.Lieu#getPersonnes <em>Personnes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Personnes</em>'.
	 * @see eNIGME.Lieu#getPersonnes()
	 * @see #getLieu()
	 * @generated
	 */
	EReference getLieu_Personnes();

	/**
	 * Returns the meta object for class '{@link eNIGME.Chemin <em>Chemin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Chemin</em>'.
	 * @see eNIGME.Chemin
	 * @generated
	 */
	EClass getChemin();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Chemin#getEtatc <em>Etatc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Etatc</em>'.
	 * @see eNIGME.Chemin#getEtatc()
	 * @see #getChemin()
	 * @generated
	 */
	EAttribute getChemin_Etatc();

	/**
	 * Returns the meta object for the reference '{@link eNIGME.Chemin#getConditionc <em>Conditionc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Conditionc</em>'.
	 * @see eNIGME.Chemin#getConditionc()
	 * @see #getChemin()
	 * @generated
	 */
	EReference getChemin_Conditionc();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Chemin#getEtato <em>Etato</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Etato</em>'.
	 * @see eNIGME.Chemin#getEtato()
	 * @see #getChemin()
	 * @generated
	 */
	EAttribute getChemin_Etato();

	/**
	 * Returns the meta object for the reference '{@link eNIGME.Chemin#getConditiono <em>Conditiono</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Conditiono</em>'.
	 * @see eNIGME.Chemin#getConditiono()
	 * @see #getChemin()
	 * @generated
	 */
	EReference getChemin_Conditiono();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Chemin#getEtatv <em>Etatv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Etatv</em>'.
	 * @see eNIGME.Chemin#getEtatv()
	 * @see #getChemin()
	 * @generated
	 */
	EAttribute getChemin_Etatv();

	/**
	 * Returns the meta object for the reference '{@link eNIGME.Chemin#getConditionv <em>Conditionv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Conditionv</em>'.
	 * @see eNIGME.Chemin#getConditionv()
	 * @see #getChemin()
	 * @generated
	 */
	EReference getChemin_Conditionv();

	/**
	 * Returns the meta object for the reference '{@link eNIGME.Chemin#getPrecedent <em>Precedent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Precedent</em>'.
	 * @see eNIGME.Chemin#getPrecedent()
	 * @see #getChemin()
	 * @generated
	 */
	EReference getChemin_Precedent();

	/**
	 * Returns the meta object for the reference '{@link eNIGME.Chemin#getSuivant <em>Suivant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Suivant</em>'.
	 * @see eNIGME.Chemin#getSuivant()
	 * @see #getChemin()
	 * @generated
	 */
	EReference getChemin_Suivant();

	/**
	 * Returns the meta object for class '{@link eNIGME.Qualification <em>Qualification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qualification</em>'.
	 * @see eNIGME.Qualification
	 * @generated
	 */
	EClass getQualification();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Qualification#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eNIGME.Qualification#getId()
	 * @see #getQualification()
	 * @generated
	 */
	EAttribute getQualification_Id();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Qualification#getQualification <em>Qualification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualification</em>'.
	 * @see eNIGME.Qualification#getQualification()
	 * @see #getQualification()
	 * @generated
	 */
	EAttribute getQualification_Qualification();

	/**
	 * Returns the meta object for class '{@link eNIGME.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see eNIGME.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Action#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eNIGME.Action#getName()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Name();

	/**
	 * Returns the meta object for the reference list '{@link eNIGME.Action#getObjetsconsommables <em>Objetsconsommables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Objetsconsommables</em>'.
	 * @see eNIGME.Action#getObjetsconsommables()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Objetsconsommables();

	/**
	 * Returns the meta object for the reference list '{@link eNIGME.Action#getObjetsattribuables <em>Objetsattribuables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Objetsattribuables</em>'.
	 * @see eNIGME.Action#getObjetsattribuables()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Objetsattribuables();

	/**
	 * Returns the meta object for the reference list '{@link eNIGME.Action#getConnaissancesattribuables <em>Connaissancesattribuables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connaissancesattribuables</em>'.
	 * @see eNIGME.Action#getConnaissancesattribuables()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Connaissancesattribuables();

	/**
	 * Returns the meta object for class '{@link eNIGME.Reponse <em>Reponse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reponse</em>'.
	 * @see eNIGME.Reponse
	 * @generated
	 */
	EClass getReponse();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Reponse#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eNIGME.Reponse#getName()
	 * @see #getReponse()
	 * @generated
	 */
	EAttribute getReponse_Name();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Reponse#getEtat <em>Etat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Etat</em>'.
	 * @see eNIGME.Reponse#getEtat()
	 * @see #getReponse()
	 * @generated
	 */
	EAttribute getReponse_Etat();

	/**
	 * Returns the meta object for the reference '{@link eNIGME.Reponse#getTexte <em>Texte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Texte</em>'.
	 * @see eNIGME.Reponse#getTexte()
	 * @see #getReponse()
	 * @generated
	 */
	EReference getReponse_Texte();

	/**
	 * Returns the meta object for the reference '{@link eNIGME.Reponse#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see eNIGME.Reponse#getAction()
	 * @see #getReponse()
	 * @generated
	 */
	EReference getReponse_Action();

	/**
	 * Returns the meta object for class '{@link eNIGME.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see eNIGME.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for the attribute '{@link eNIGME.Condition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eNIGME.Condition#getName()
	 * @see #getCondition()
	 * @generated
	 */
	EAttribute getCondition_Name();

	/**
	 * Returns the meta object for the reference list '{@link eNIGME.Condition#getObjetsRequis <em>Objets Requis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Objets Requis</em>'.
	 * @see eNIGME.Condition#getObjetsRequis()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_ObjetsRequis();

	/**
	 * Returns the meta object for the reference list '{@link eNIGME.Condition#getConnaissancesRequises <em>Connaissances Requises</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connaissances Requises</em>'.
	 * @see eNIGME.Condition#getConnaissancesRequises()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_ConnaissancesRequises();

	/**
	 * Returns the meta object for enum '{@link eNIGME.EtatReponse <em>Etat Reponse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Etat Reponse</em>'.
	 * @see eNIGME.EtatReponse
	 * @generated
	 */
	EEnum getEtatReponse();

	/**
	 * Returns the meta object for enum '{@link eNIGME.EtatPossession <em>Etat Possession</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Etat Possession</em>'.
	 * @see eNIGME.EtatPossession
	 * @generated
	 */
	EEnum getEtatPossession();

	/**
	 * Returns the meta object for enum '{@link eNIGME.EtatVisibilite <em>Etat Visibilite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Etat Visibilite</em>'.
	 * @see eNIGME.EtatVisibilite
	 * @generated
	 */
	EEnum getEtatVisibilite();

	/**
	 * Returns the meta object for enum '{@link eNIGME.EtatObligation <em>Etat Obligation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Etat Obligation</em>'.
	 * @see eNIGME.EtatObligation
	 * @generated
	 */
	EEnum getEtatObligation();

	/**
	 * Returns the meta object for enum '{@link eNIGME.EtatChemin <em>Etat Chemin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Etat Chemin</em>'.
	 * @see eNIGME.EtatChemin
	 * @generated
	 */
	EEnum getEtatChemin();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ENIGMEFactory getENIGMEFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link eNIGME.impl.JeuImpl <em>Jeu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.impl.JeuImpl
		 * @see eNIGME.impl.ENIGMEPackageImpl#getJeu()
		 * @generated
		 */
		EClass JEU = eINSTANCE.getJeu();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JEU__NAME = eINSTANCE.getJeu_Name();

		/**
		 * The meta object literal for the '<em><b>Jeuelement</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JEU__JEUELEMENT = eINSTANCE.getJeu_Jeuelement();

		/**
		 * The meta object literal for the '{@link eNIGME.impl.JeuElementImpl <em>Jeu Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.impl.JeuElementImpl
		 * @see eNIGME.impl.ENIGMEPackageImpl#getJeuElement()
		 * @generated
		 */
		EClass JEU_ELEMENT = eINSTANCE.getJeuElement();

		/**
		 * The meta object literal for the '{@link eNIGME.impl.JoueurImpl <em>Joueur</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.impl.JoueurImpl
		 * @see eNIGME.impl.ENIGMEPackageImpl#getJoueur()
		 * @generated
		 */
		EClass JOUEUR = eINSTANCE.getJoueur();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOUEUR__NAME = eINSTANCE.getJoueur_Name();

		/**
		 * The meta object literal for the '<em><b>Limite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOUEUR__LIMITE = eINSTANCE.getJoueur_Limite();

		/**
		 * The meta object literal for the '<em><b>Objets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOUEUR__OBJETS = eINSTANCE.getJoueur_Objets();

		/**
		 * The meta object literal for the '<em><b>Connaissances</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOUEUR__CONNAISSANCES = eINSTANCE.getJoueur_Connaissances();

		/**
		 * The meta object literal for the '{@link eNIGME.impl.ConnaissanceImpl <em>Connaissance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.impl.ConnaissanceImpl
		 * @see eNIGME.impl.ENIGMEPackageImpl#getConnaissance()
		 * @generated
		 */
		EClass CONNAISSANCE = eINSTANCE.getConnaissance();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNAISSANCE__NAME = eINSTANCE.getConnaissance_Name();

		/**
		 * The meta object literal for the '<em><b>Nom Connaissance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNAISSANCE__NOM_CONNAISSANCE = eINSTANCE.getConnaissance_NomConnaissance();

		/**
		 * The meta object literal for the '<em><b>Qualification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNAISSANCE__QUALIFICATION = eINSTANCE.getConnaissance_Qualification();

		/**
		 * The meta object literal for the '<em><b>Etatv</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNAISSANCE__ETATV = eINSTANCE.getConnaissance_Etatv();

		/**
		 * The meta object literal for the '<em><b>Etatp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNAISSANCE__ETATP = eINSTANCE.getConnaissance_Etatp();

		/**
		 * The meta object literal for the '{@link eNIGME.impl.ObjetImpl <em>Objet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.impl.ObjetImpl
		 * @see eNIGME.impl.ENIGMEPackageImpl#getObjet()
		 * @generated
		 */
		EClass OBJET = eINSTANCE.getObjet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJET__NAME = eINSTANCE.getObjet_Name();

		/**
		 * The meta object literal for the '<em><b>Nom Objet</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJET__NOM_OBJET = eINSTANCE.getObjet_NomObjet();

		/**
		 * The meta object literal for the '<em><b>Occurrence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJET__OCCURRENCE = eINSTANCE.getObjet_Occurrence();

		/**
		 * The meta object literal for the '<em><b>Taille</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJET__TAILLE = eINSTANCE.getObjet_Taille();

		/**
		 * The meta object literal for the '<em><b>Etatv</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJET__ETATV = eINSTANCE.getObjet_Etatv();

		/**
		 * The meta object literal for the '<em><b>Etatp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJET__ETATP = eINSTANCE.getObjet_Etatp();

		/**
		 * The meta object literal for the '{@link eNIGME.impl.TerritoireImpl <em>Territoire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.impl.TerritoireImpl
		 * @see eNIGME.impl.ENIGMEPackageImpl#getTerritoire()
		 * @generated
		 */
		EClass TERRITOIRE = eINSTANCE.getTerritoire();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERRITOIRE__NAME = eINSTANCE.getTerritoire_Name();

		/**
		 * The meta object literal for the '<em><b>Lieu Debut</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERRITOIRE__LIEU_DEBUT = eINSTANCE.getTerritoire_LieuDebut();

		/**
		 * The meta object literal for the '<em><b>Lieuxintermediaires</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERRITOIRE__LIEUXINTERMEDIAIRES = eINSTANCE.getTerritoire_Lieuxintermediaires();

		/**
		 * The meta object literal for the '<em><b>Lieux Fin</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERRITOIRE__LIEUX_FIN = eINSTANCE.getTerritoire_LieuxFin();

		/**
		 * The meta object literal for the '<em><b>Chemins</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERRITOIRE__CHEMINS = eINSTANCE.getTerritoire_Chemins();

		/**
		 * The meta object literal for the '{@link eNIGME.impl.ChoixImpl <em>Choix</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.impl.ChoixImpl
		 * @see eNIGME.impl.ENIGMEPackageImpl#getChoix()
		 * @generated
		 */
		EClass CHOIX = eINSTANCE.getChoix();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHOIX__NAME = eINSTANCE.getChoix_Name();

		/**
		 * The meta object literal for the '<em><b>Reponses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOIX__REPONSES = eINSTANCE.getChoix_Reponses();

		/**
		 * The meta object literal for the '<em><b>Conditions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOIX__CONDITIONS = eINSTANCE.getChoix_Conditions();

		/**
		 * The meta object literal for the '{@link eNIGME.impl.InteractionImpl <em>Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.impl.InteractionImpl
		 * @see eNIGME.impl.ENIGMEPackageImpl#getInteraction()
		 * @generated
		 */
		EClass INTERACTION = eINSTANCE.getInteraction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERACTION__NAME = eINSTANCE.getInteraction_Name();

		/**
		 * The meta object literal for the '<em><b>Choix</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION__CHOIX = eINSTANCE.getInteraction_Choix();

		/**
		 * The meta object literal for the '<em><b>Choix Fin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION__CHOIX_FIN = eINSTANCE.getInteraction_ChoixFin();

		/**
		 * The meta object literal for the '{@link eNIGME.impl.PersonneImpl <em>Personne</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.impl.PersonneImpl
		 * @see eNIGME.impl.ENIGMEPackageImpl#getPersonne()
		 * @generated
		 */
		EClass PERSONNE = eINSTANCE.getPersonne();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSONNE__NAME = eINSTANCE.getPersonne_Name();

		/**
		 * The meta object literal for the '<em><b>Etato</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSONNE__ETATO = eINSTANCE.getPersonne_Etato();

		/**
		 * The meta object literal for the '<em><b>Conditiono</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSONNE__CONDITIONO = eINSTANCE.getPersonne_Conditiono();

		/**
		 * The meta object literal for the '<em><b>Etatv</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSONNE__ETATV = eINSTANCE.getPersonne_Etatv();

		/**
		 * The meta object literal for the '<em><b>Conditionv</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSONNE__CONDITIONV = eINSTANCE.getPersonne_Conditionv();

		/**
		 * The meta object literal for the '<em><b>Texte</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSONNE__TEXTE = eINSTANCE.getPersonne_Texte();

		/**
		 * The meta object literal for the '<em><b>Interaction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSONNE__INTERACTION = eINSTANCE.getPersonne_Interaction();

		/**
		 * The meta object literal for the '{@link eNIGME.impl.LieuImpl <em>Lieu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.impl.LieuImpl
		 * @see eNIGME.impl.ENIGMEPackageImpl#getLieu()
		 * @generated
		 */
		EClass LIEU = eINSTANCE.getLieu();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIEU__NAME = eINSTANCE.getLieu_Name();

		/**
		 * The meta object literal for the '<em><b>Personnes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIEU__PERSONNES = eINSTANCE.getLieu_Personnes();

		/**
		 * The meta object literal for the '{@link eNIGME.impl.CheminImpl <em>Chemin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.impl.CheminImpl
		 * @see eNIGME.impl.ENIGMEPackageImpl#getChemin()
		 * @generated
		 */
		EClass CHEMIN = eINSTANCE.getChemin();

		/**
		 * The meta object literal for the '<em><b>Etatc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHEMIN__ETATC = eINSTANCE.getChemin_Etatc();

		/**
		 * The meta object literal for the '<em><b>Conditionc</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHEMIN__CONDITIONC = eINSTANCE.getChemin_Conditionc();

		/**
		 * The meta object literal for the '<em><b>Etato</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHEMIN__ETATO = eINSTANCE.getChemin_Etato();

		/**
		 * The meta object literal for the '<em><b>Conditiono</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHEMIN__CONDITIONO = eINSTANCE.getChemin_Conditiono();

		/**
		 * The meta object literal for the '<em><b>Etatv</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHEMIN__ETATV = eINSTANCE.getChemin_Etatv();

		/**
		 * The meta object literal for the '<em><b>Conditionv</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHEMIN__CONDITIONV = eINSTANCE.getChemin_Conditionv();

		/**
		 * The meta object literal for the '<em><b>Precedent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHEMIN__PRECEDENT = eINSTANCE.getChemin_Precedent();

		/**
		 * The meta object literal for the '<em><b>Suivant</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHEMIN__SUIVANT = eINSTANCE.getChemin_Suivant();

		/**
		 * The meta object literal for the '{@link eNIGME.impl.QualificationImpl <em>Qualification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.impl.QualificationImpl
		 * @see eNIGME.impl.ENIGMEPackageImpl#getQualification()
		 * @generated
		 */
		EClass QUALIFICATION = eINSTANCE.getQualification();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUALIFICATION__ID = eINSTANCE.getQualification_Id();

		/**
		 * The meta object literal for the '<em><b>Qualification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUALIFICATION__QUALIFICATION = eINSTANCE.getQualification_Qualification();

		/**
		 * The meta object literal for the '{@link eNIGME.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.impl.ActionImpl
		 * @see eNIGME.impl.ENIGMEPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__NAME = eINSTANCE.getAction_Name();

		/**
		 * The meta object literal for the '<em><b>Objetsconsommables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__OBJETSCONSOMMABLES = eINSTANCE.getAction_Objetsconsommables();

		/**
		 * The meta object literal for the '<em><b>Objetsattribuables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__OBJETSATTRIBUABLES = eINSTANCE.getAction_Objetsattribuables();

		/**
		 * The meta object literal for the '<em><b>Connaissancesattribuables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__CONNAISSANCESATTRIBUABLES = eINSTANCE.getAction_Connaissancesattribuables();

		/**
		 * The meta object literal for the '{@link eNIGME.impl.ReponseImpl <em>Reponse</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.impl.ReponseImpl
		 * @see eNIGME.impl.ENIGMEPackageImpl#getReponse()
		 * @generated
		 */
		EClass REPONSE = eINSTANCE.getReponse();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPONSE__NAME = eINSTANCE.getReponse_Name();

		/**
		 * The meta object literal for the '<em><b>Etat</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPONSE__ETAT = eINSTANCE.getReponse_Etat();

		/**
		 * The meta object literal for the '<em><b>Texte</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPONSE__TEXTE = eINSTANCE.getReponse_Texte();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPONSE__ACTION = eINSTANCE.getReponse_Action();

		/**
		 * The meta object literal for the '{@link eNIGME.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.impl.ConditionImpl
		 * @see eNIGME.impl.ENIGMEPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION__NAME = eINSTANCE.getCondition_Name();

		/**
		 * The meta object literal for the '<em><b>Objets Requis</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION__OBJETS_REQUIS = eINSTANCE.getCondition_ObjetsRequis();

		/**
		 * The meta object literal for the '<em><b>Connaissances Requises</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION__CONNAISSANCES_REQUISES = eINSTANCE.getCondition_ConnaissancesRequises();

		/**
		 * The meta object literal for the '{@link eNIGME.EtatReponse <em>Etat Reponse</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.EtatReponse
		 * @see eNIGME.impl.ENIGMEPackageImpl#getEtatReponse()
		 * @generated
		 */
		EEnum ETAT_REPONSE = eINSTANCE.getEtatReponse();

		/**
		 * The meta object literal for the '{@link eNIGME.EtatPossession <em>Etat Possession</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.EtatPossession
		 * @see eNIGME.impl.ENIGMEPackageImpl#getEtatPossession()
		 * @generated
		 */
		EEnum ETAT_POSSESSION = eINSTANCE.getEtatPossession();

		/**
		 * The meta object literal for the '{@link eNIGME.EtatVisibilite <em>Etat Visibilite</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.EtatVisibilite
		 * @see eNIGME.impl.ENIGMEPackageImpl#getEtatVisibilite()
		 * @generated
		 */
		EEnum ETAT_VISIBILITE = eINSTANCE.getEtatVisibilite();

		/**
		 * The meta object literal for the '{@link eNIGME.EtatObligation <em>Etat Obligation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.EtatObligation
		 * @see eNIGME.impl.ENIGMEPackageImpl#getEtatObligation()
		 * @generated
		 */
		EEnum ETAT_OBLIGATION = eINSTANCE.getEtatObligation();

		/**
		 * The meta object literal for the '{@link eNIGME.EtatChemin <em>Etat Chemin</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eNIGME.EtatChemin
		 * @see eNIGME.impl.ENIGMEPackageImpl#getEtatChemin()
		 * @generated
		 */
		EEnum ETAT_CHEMIN = eINSTANCE.getEtatChemin();

	}

} //ENIGMEPackage
