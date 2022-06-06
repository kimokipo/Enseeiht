/**
 */
package eNIGME;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eNIGME.Qualification#getId <em>Id</em>}</li>
 *   <li>{@link eNIGME.Qualification#getQualification <em>Qualification</em>}</li>
 * </ul>
 *
 * @see eNIGME.ENIGMEPackage#getQualification()
 * @model
 * @generated
 */
public interface Qualification extends JeuElement {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see eNIGME.ENIGMEPackage#getQualification_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link eNIGME.Qualification#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Qualification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualification</em>' attribute.
	 * @see #setQualification(String)
	 * @see eNIGME.ENIGMEPackage#getQualification_Qualification()
	 * @model
	 * @generated
	 */
	String getQualification();

	/**
	 * Sets the value of the '{@link eNIGME.Qualification#getQualification <em>Qualification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualification</em>' attribute.
	 * @see #getQualification()
	 * @generated
	 */
	void setQualification(String value);

} // Qualification
