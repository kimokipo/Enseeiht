/**
 */
package petrinet;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EArc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link petrinet.EArc#getPoids <em>Poids</em>}</li>
 *   <li>{@link petrinet.EArc#getSource <em>Source</em>}</li>
 *   <li>{@link petrinet.EArc#getDestination <em>Destination</em>}</li>
 * </ul>
 *
 * @see petrinet.PetrinetPackage#getEArc()
 * @model
 * @generated
 */
public interface EArc extends EObject {
	/**
	 * Returns the value of the '<em><b>Poids</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Poids</em>' attribute.
	 * @see #setPoids(int)
	 * @see petrinet.PetrinetPackage#getEArc_Poids()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getPoids();

	/**
	 * Sets the value of the '{@link petrinet.EArc#getPoids <em>Poids</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Poids</em>' attribute.
	 * @see #getPoids()
	 * @generated
	 */
	void setPoids(int value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link petrinet.PetriElement#getEarcsortants <em>Earcsortants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(PetriElement)
	 * @see petrinet.PetrinetPackage#getEArc_Source()
	 * @see petrinet.PetriElement#getEarcsortants
	 * @model opposite="earcsortants" required="true"
	 * @generated
	 */
	PetriElement getSource();

	/**
	 * Sets the value of the '{@link petrinet.EArc#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(PetriElement value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link petrinet.PetriElement#getEarcentrants <em>Earcentrants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(PetriElement)
	 * @see petrinet.PetrinetPackage#getEArc_Destination()
	 * @see petrinet.PetriElement#getEarcentrants
	 * @model opposite="earcentrants" required="true"
	 * @generated
	 */
	PetriElement getDestination();

	/**
	 * Sets the value of the '{@link petrinet.EArc#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(PetriElement value);

} // EArc
