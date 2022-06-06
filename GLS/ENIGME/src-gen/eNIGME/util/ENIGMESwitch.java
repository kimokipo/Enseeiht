/**
 */
package eNIGME.util;

import eNIGME.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see eNIGME.ENIGMEPackage
 * @generated
 */
public class ENIGMESwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ENIGMEPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ENIGMESwitch() {
		if (modelPackage == null) {
			modelPackage = ENIGMEPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case ENIGMEPackage.JEU: {
			Jeu jeu = (Jeu) theEObject;
			T result = caseJeu(jeu);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ENIGMEPackage.JEU_ELEMENT: {
			JeuElement jeuElement = (JeuElement) theEObject;
			T result = caseJeuElement(jeuElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ENIGMEPackage.JOUEUR: {
			Joueur joueur = (Joueur) theEObject;
			T result = caseJoueur(joueur);
			if (result == null)
				result = caseJeuElement(joueur);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ENIGMEPackage.CONNAISSANCE: {
			Connaissance connaissance = (Connaissance) theEObject;
			T result = caseConnaissance(connaissance);
			if (result == null)
				result = caseJeuElement(connaissance);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ENIGMEPackage.OBJET: {
			Objet objet = (Objet) theEObject;
			T result = caseObjet(objet);
			if (result == null)
				result = caseJeuElement(objet);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ENIGMEPackage.TERRITOIRE: {
			Territoire territoire = (Territoire) theEObject;
			T result = caseTerritoire(territoire);
			if (result == null)
				result = caseJeuElement(territoire);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ENIGMEPackage.CHOIX: {
			Choix choix = (Choix) theEObject;
			T result = caseChoix(choix);
			if (result == null)
				result = caseJeuElement(choix);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ENIGMEPackage.INTERACTION: {
			Interaction interaction = (Interaction) theEObject;
			T result = caseInteraction(interaction);
			if (result == null)
				result = caseJeuElement(interaction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ENIGMEPackage.PERSONNE: {
			Personne personne = (Personne) theEObject;
			T result = casePersonne(personne);
			if (result == null)
				result = caseJeuElement(personne);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ENIGMEPackage.LIEU: {
			Lieu lieu = (Lieu) theEObject;
			T result = caseLieu(lieu);
			if (result == null)
				result = caseJeuElement(lieu);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ENIGMEPackage.CHEMIN: {
			Chemin chemin = (Chemin) theEObject;
			T result = caseChemin(chemin);
			if (result == null)
				result = caseJeuElement(chemin);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ENIGMEPackage.QUALIFICATION: {
			Qualification qualification = (Qualification) theEObject;
			T result = caseQualification(qualification);
			if (result == null)
				result = caseJeuElement(qualification);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ENIGMEPackage.ACTION: {
			Action action = (Action) theEObject;
			T result = caseAction(action);
			if (result == null)
				result = caseJeuElement(action);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ENIGMEPackage.REPONSE: {
			Reponse reponse = (Reponse) theEObject;
			T result = caseReponse(reponse);
			if (result == null)
				result = caseJeuElement(reponse);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ENIGMEPackage.CONDITION: {
			Condition condition = (Condition) theEObject;
			T result = caseCondition(condition);
			if (result == null)
				result = caseJeuElement(condition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jeu</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jeu</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJeu(Jeu object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jeu Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jeu Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJeuElement(JeuElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Joueur</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Joueur</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJoueur(Joueur object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connaissance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connaissance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnaissance(Connaissance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Objet</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Objet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjet(Objet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Territoire</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Territoire</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerritoire(Territoire object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Choix</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choix</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoix(Choix object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInteraction(Interaction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Personne</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Personne</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePersonne(Personne object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lieu</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lieu</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLieu(Lieu object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Chemin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Chemin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChemin(Chemin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Qualification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qualification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQualification(Qualification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reponse</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reponse</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReponse(Reponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCondition(Condition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ENIGMESwitch
