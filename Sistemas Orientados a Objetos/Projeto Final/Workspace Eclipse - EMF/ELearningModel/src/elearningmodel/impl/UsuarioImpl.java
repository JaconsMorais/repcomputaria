/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel.impl;

import elearningmodel.ElearningmodelPackage;
import elearningmodel.Usuario;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Usuario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link elearningmodel.impl.UsuarioImpl#getIdUsuario <em>Id Usuario</em>}</li>
 *   <li>{@link elearningmodel.impl.UsuarioImpl#getLogin <em>Login</em>}</li>
 *   <li>{@link elearningmodel.impl.UsuarioImpl#getSenha <em>Senha</em>}</li>
 *   <li>{@link elearningmodel.impl.UsuarioImpl#getTipoUsuario <em>Tipo Usuario</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UsuarioImpl extends EObjectImpl implements Usuario {
	/**
	 * The default value of the '{@link #getIdUsuario() <em>Id Usuario</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdUsuario()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger ID_USUARIO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdUsuario() <em>Id Usuario</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdUsuario()
	 * @generated
	 * @ordered
	 */
	protected BigInteger idUsuario = ID_USUARIO_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogin() <em>Login</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogin()
	 * @generated
	 * @ordered
	 */
	protected static final String LOGIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogin() <em>Login</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogin()
	 * @generated
	 * @ordered
	 */
	protected String login = LOGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getSenha() <em>Senha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSenha()
	 * @generated
	 * @ordered
	 */
	protected static final String SENHA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSenha() <em>Senha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSenha()
	 * @generated
	 * @ordered
	 */
	protected String senha = SENHA_EDEFAULT;

	/**
	 * The default value of the '{@link #getTipoUsuario() <em>Tipo Usuario</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTipoUsuario()
	 * @generated
	 * @ordered
	 */
	protected static final Integer TIPO_USUARIO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTipoUsuario() <em>Tipo Usuario</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTipoUsuario()
	 * @generated
	 * @ordered
	 */
	protected Integer tipoUsuario = TIPO_USUARIO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UsuarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ElearningmodelPackage.Literals.USUARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getIdUsuario() {
		return idUsuario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdUsuario(BigInteger newIdUsuario) {
		BigInteger oldIdUsuario = idUsuario;
		idUsuario = newIdUsuario;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.USUARIO__ID_USUARIO, oldIdUsuario, idUsuario));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogin(String newLogin) {
		String oldLogin = login;
		login = newLogin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.USUARIO__LOGIN, oldLogin, login));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSenha(String newSenha) {
		String oldSenha = senha;
		senha = newSenha;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.USUARIO__SENHA, oldSenha, senha));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTipoUsuario(Integer newTipoUsuario) {
		Integer oldTipoUsuario = tipoUsuario;
		tipoUsuario = newTipoUsuario;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.USUARIO__TIPO_USUARIO, oldTipoUsuario, tipoUsuario));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElearningmodelPackage.USUARIO__ID_USUARIO:
				return getIdUsuario();
			case ElearningmodelPackage.USUARIO__LOGIN:
				return getLogin();
			case ElearningmodelPackage.USUARIO__SENHA:
				return getSenha();
			case ElearningmodelPackage.USUARIO__TIPO_USUARIO:
				return getTipoUsuario();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ElearningmodelPackage.USUARIO__ID_USUARIO:
				setIdUsuario((BigInteger)newValue);
				return;
			case ElearningmodelPackage.USUARIO__LOGIN:
				setLogin((String)newValue);
				return;
			case ElearningmodelPackage.USUARIO__SENHA:
				setSenha((String)newValue);
				return;
			case ElearningmodelPackage.USUARIO__TIPO_USUARIO:
				setTipoUsuario((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ElearningmodelPackage.USUARIO__ID_USUARIO:
				setIdUsuario(ID_USUARIO_EDEFAULT);
				return;
			case ElearningmodelPackage.USUARIO__LOGIN:
				setLogin(LOGIN_EDEFAULT);
				return;
			case ElearningmodelPackage.USUARIO__SENHA:
				setSenha(SENHA_EDEFAULT);
				return;
			case ElearningmodelPackage.USUARIO__TIPO_USUARIO:
				setTipoUsuario(TIPO_USUARIO_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ElearningmodelPackage.USUARIO__ID_USUARIO:
				return ID_USUARIO_EDEFAULT == null ? idUsuario != null : !ID_USUARIO_EDEFAULT.equals(idUsuario);
			case ElearningmodelPackage.USUARIO__LOGIN:
				return LOGIN_EDEFAULT == null ? login != null : !LOGIN_EDEFAULT.equals(login);
			case ElearningmodelPackage.USUARIO__SENHA:
				return SENHA_EDEFAULT == null ? senha != null : !SENHA_EDEFAULT.equals(senha);
			case ElearningmodelPackage.USUARIO__TIPO_USUARIO:
				return TIPO_USUARIO_EDEFAULT == null ? tipoUsuario != null : !TIPO_USUARIO_EDEFAULT.equals(tipoUsuario);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (idUsuario: ");
		result.append(idUsuario);
		result.append(", login: ");
		result.append(login);
		result.append(", senha: ");
		result.append(senha);
		result.append(", tipoUsuario: ");
		result.append(tipoUsuario);
		result.append(')');
		return result.toString();
	}

} //UsuarioImpl
