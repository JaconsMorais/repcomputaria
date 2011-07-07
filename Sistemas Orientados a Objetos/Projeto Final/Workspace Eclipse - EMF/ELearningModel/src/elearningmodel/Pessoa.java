/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pessoa</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link elearningmodel.Pessoa#getEndereco <em>Endereco</em>}</li>
 *   <li>{@link elearningmodel.Pessoa#getTelefone <em>Telefone</em>}</li>
 * </ul>
 * </p>
 *
 * @see elearningmodel.ElearningmodelPackage#getPessoa()
 * @model
 * @generated
 */
public interface Pessoa extends Usuario {
	/**
	 * Returns the value of the '<em><b>Endereco</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endereco</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endereco</em>' attribute.
	 * @see #setEndereco(String)
	 * @see elearningmodel.ElearningmodelPackage#getPessoa_Endereco()
	 * @model
	 * @generated
	 */
	String getEndereco();

	/**
	 * Sets the value of the '{@link elearningmodel.Pessoa#getEndereco <em>Endereco</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endereco</em>' attribute.
	 * @see #getEndereco()
	 * @generated
	 */
	void setEndereco(String value);

	/**
	 * Returns the value of the '<em><b>Telefone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Telefone</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Telefone</em>' attribute.
	 * @see #setTelefone(String)
	 * @see elearningmodel.ElearningmodelPackage#getPessoa_Telefone()
	 * @model
	 * @generated
	 */
	String getTelefone();

	/**
	 * Sets the value of the '{@link elearningmodel.Pessoa#getTelefone <em>Telefone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Telefone</em>' attribute.
	 * @see #getTelefone()
	 * @generated
	 */
	void setTelefone(String value);

} // Pessoa
