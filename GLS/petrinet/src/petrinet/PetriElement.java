/**
 */
package petrinet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Petri Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link petrinet.PetriElement#getEarcentrants <em>Earcentrants</em>}</li>
 *   <li>{@link petrinet.PetriElement#getEarcsortants <em>Earcsortants</em>}</li>
 *   <li>{@link petrinet.PetriElement#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see petrinet.PetrinetPackage#getPetriElement()
 * @model
 * @generated
 */
public interface PetriElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Earcentrants</b></em>' reference list.
	 * The list contents are of type {@link petrinet.EArc}.
	 * It is bidirectional and its opposite is '{@link petrinet.EArc#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Earcentrants</em>' reference list.
	 * @see petrinet.PetrinetPackage#getPetriElement_Earcentrants()
	 * @see petrinet.EArc#getDestination
	 * @model opposite="Destination"
	 * @generated
	 */
	EList<EArc> getEarcentrants();

	/**
	 * Returns the value of the '<em><b>Earcsortants</b></em>' reference list.
	 * The list contents are of type {@link petrinet.EArc}.
	 * It is bidirectional and its opposite is '{@link petrinet.EArc#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Earcsortants</em>' reference list.
	 * @see petrinet.PetrinetPackage#getPetriElement_Earcsortants()
	 * @see petrinet.EArc#getSource
	 * @model opposite="Source"
	 * @generated
	 */
	EList<EArc> getEarcsortants();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see petrinet.PetrinetPackage#getPetriElement_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link petrinet.PetriElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // PetriElement
