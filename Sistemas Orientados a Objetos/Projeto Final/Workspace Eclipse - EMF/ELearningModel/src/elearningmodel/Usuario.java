/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel;

import java.math.BigInteger;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Usuario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link elearningmodel.Usuario#getIdUsuario <em>Id Usuario</em>}</li>
 *   <li>{@link elearningmodel.Usuario#getLogin <em>Login</em>}</li>
 *   <li>{@link elearningmodel.Usuario#getSenha <em>Senha</em>}</li>
 *   <li>{@link elearningmodel.Usuario#getTipoUsuario <em>Tipo Usuario</em>}</li>
 * </ul>
 * </p>
 *
 * @see elearningmodel.ElearningmodelPackage#getUsuario()
 * @model
 * @generated
 */
public interface Usuario extends EObject {
	/**
	 * Returns the value of the '<em><b>Id Usuario</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Usuario</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Usuario</em>' attribute.
	 * @see #setIdUsuario(BigInteger)
	 * @see elearningmodel.ElearningmodelPackage#getUsuario_IdUsuario()
	 * @model
	 * @generated
	 */
	BigInteger getIdUsuario();

	/**
	 * Sets the value of the '{@link elearningmodel.Usuario#getIdUsuario <em>Id Usuario</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Usuario</em>' attribute.
	 * @see #getIdUsuario()
	 * @generated
	 */
	void setIdUsuario(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Login</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Login</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Login</em>' attribute.
	 * @see #setLogin(String)
	 * @see elearningmodel.ElearningmodelPackage#getUsuario_Login()
	 * @model
	 * @generated
	 */
	String getLogin();

	/**
	 * Sets the value of the '{@link elearningmodel.Usuario#getLogin <em>Login</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Login</em>' attribute.
	 * @see #getLogin()
	 * @generated
	 */
	void setLogin(String value);

	/**
	 * Returns the value of the '<em><b>Senha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Senha</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Senha</em>' attribute.
	 * @see #setSenha(String)
	 * @see elearningmodel.ElearningmodelPackage#getUsuario_Senha()
	 * @model
	 * @generated
	 */
	String getSenha();

	/**
	 * Sets the value of the '{@link elearningmodel.Usuario#getSenha <em>Senha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Senha</em>' attribute.
	 * @see #getSenha()
	 * @generated
	 */
	void setSenha(String value);

	/**
	 * Returns the value of the '<em><b>Tipo Usuario</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tipo Usuario</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tipo Usuario</em>' attribute.
	 * @see #setTipoUsuario(Integer)
	 * @see elearningmodel.ElearningmodelPackage#getUsuario_TipoUsuario()
	 * @model
	 * @generated
	 */
	Integer getTipoUsuario();

	/**
	 * Sets the value of the '{@link elearningmodel.Usuario#getTipoUsuario <em>Tipo Usuario</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tipo Usuario</em>' attribute.
	 * @see #getTipoUsuario()
	 * @generated
	 */
	void setTipoUsuario(Integer value);

} // Usuario
