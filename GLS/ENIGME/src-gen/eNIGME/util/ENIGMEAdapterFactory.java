/**
 */
package eNIGME.util;

import eNIGME.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eNIGME.ENIGMEPackage
 * @generated
 */
public class ENIGMEAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ENIGMEPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ENIGMEAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ENIGMEPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ENIGMESwitch<Adapter> modelSwitch = new ENIGMESwitch<Adapter>() {
		@Override
		public Adapter caseJeu(Jeu object) {
			return createJeuAdapter();
		}

		@Override
		public Adapter caseJeuElement(JeuElement object) {
			return createJeuElementAdapter();
		}

		@Override
		public Adapter caseJoueur(Joueur object) {
			return createJoueurAdapter();
		}

		@Override
		public Adapter caseConnaissance(Connaissance object) {
			return createConnaissanceAdapter();
		}

		@Override
		public Adapter caseObjet(Objet object) {
			return createObjetAdapter();
		}

		@Override
		public Adapter caseTerritoire(Territoire object) {
			return createTerritoireAdapter();
		}

		@Override
		public Adapter caseChoix(Choix object) {
			return createChoixAdapter();
		}

		@Override
		public Adapter caseInteraction(Interaction object) {
			return createInteractionAdapter();
		}

		@Override
		public Adapter casePersonne(Personne object) {
			return createPersonneAdapter();
		}

		@Override
		public Adapter caseLieu(Lieu object) {
			return createLieuAdapter();
		}

		@Override
		public Adapter caseChemin(Chemin object) {
			return createCheminAdapter();
		}

		@Override
		public Adapter caseQualification(Qualification object) {
			return createQualificationAdapter();
		}

		@Override
		public Adapter caseAction(Action object) {
			return createActionAdapter();
		}

		@Override
		public Adapter caseReponse(Reponse object) {
			return createReponseAdapter();
		}

		@Override
		public Adapter caseCondition(Condition object) {
			return createConditionAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link eNIGME.Jeu <em>Jeu</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eNIGME.Jeu
	 * @generated
	 */
	public Adapter createJeuAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eNIGME.JeuElement <em>Jeu Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eNIGME.JeuElement
	 * @generated
	 */
	public Adapter createJeuElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eNIGME.Joueur <em>Joueur</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eNIGME.Joueur
	 * @generated
	 */
	public Adapter createJoueurAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eNIGME.Connaissance <em>Connaissance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eNIGME.Connaissance
	 * @generated
	 */
	public Adapter createConnaissanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eNIGME.Objet <em>Objet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eNIGME.Objet
	 * @generated
	 */
	public Adapter createObjetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eNIGME.Territoire <em>Territoire</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eNIGME.Territoire
	 * @generated
	 */
	public Adapter createTerritoireAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eNIGME.Choix <em>Choix</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eNIGME.Choix
	 * @generated
	 */
	public Adapter createChoixAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eNIGME.Interaction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eNIGME.Interaction
	 * @generated
	 */
	public Adapter createInteractionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eNIGME.Personne <em>Personne</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eNIGME.Personne
	 * @generated
	 */
	public Adapter createPersonneAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eNIGME.Lieu <em>Lieu</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eNIGME.Lieu
	 * @generated
	 */
	public Adapter createLieuAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eNIGME.Chemin <em>Chemin</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eNIGME.Chemin
	 * @generated
	 */
	public Adapter createCheminAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eNIGME.Qualification <em>Qualification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eNIGME.Qualification
	 * @generated
	 */
	public Adapter createQualificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eNIGME.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eNIGME.Action
	 * @generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eNIGME.Reponse <em>Reponse</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eNIGME.Reponse
	 * @generated
	 */
	public Adapter createReponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eNIGME.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eNIGME.Condition
	 * @generated
	 */
	public Adapter createConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ENIGMEAdapterFactory
