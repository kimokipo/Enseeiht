/**
 */
package petrinet;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link petrinet.Place#getJettons <em>Jettons</em>}</li>
 * </ul>
 *
 * @see petrinet.PetrinetPackage#getPlace()
 * @model
 * @generated
 */
public interface Place extends PetriElement {
	/**
	 * Returns the value of the '<em><b>Jettons</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jettons</em>' attribute.
	 * @see #setJettons(int)
	 * @see petrinet.PetrinetPackage#getPlace_Jettons()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getJettons();

	/**
	 * Sets the value of the '{@link petrinet.Place#getJettons <em>Jettons</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jettons</em>' attribute.
	 * @see #getJettons()
	 * @generated
	 */
	void setJettons(int value);

} // Place
