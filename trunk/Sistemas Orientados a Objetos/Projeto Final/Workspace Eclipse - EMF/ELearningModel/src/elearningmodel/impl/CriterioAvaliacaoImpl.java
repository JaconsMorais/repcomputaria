/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel.impl;

import elearningmodel.CriterioAvaliacao;
import elearningmodel.ElearningmodelPackage;
import elearningmodel.Nota;

import java.math.BigInteger;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Criterio Avaliacao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link elearningmodel.impl.CriterioAvaliacaoImpl#getIdCriterioAvaliacao <em>Id Criterio Avaliacao</em>}</li>
 *   <li>{@link elearningmodel.impl.CriterioAvaliacaoImpl#getIdDisciplina <em>Id Disciplina</em>}</li>
 *   <li>{@link elearningmodel.impl.CriterioAvaliacaoImpl#getNome <em>Nome</em>}</li>
 *   <li>{@link elearningmodel.impl.CriterioAvaliacaoImpl#getPeso <em>Peso</em>}</li>
 *   <li>{@link elearningmodel.impl.CriterioAvaliacaoImpl#getEsta_em <em>Esta em</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CriterioAvaliacaoImpl extends EObjectImpl implements CriterioAvaliacao {
	/**
	 * The default value of the '{@link #getIdCriterioAvaliacao() <em>Id Criterio Avaliacao</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdCriterioAvaliacao()
	 * @generated
	 * @ordered
	 */
	protected static final Long ID_CRITERIO_AVALIACAO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdCriterioAvaliacao() <em>Id Criterio Avaliacao</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdCriterioAvaliacao()
	 * @generated
	 * @ordered
	 */
	protected Long idCriterioAvaliacao = ID_CRITERIO_AVALIACAO_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdDisciplina() <em>Id Disciplina</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdDisciplina()
	 * @generated
	 * @ordered
	 */
	protected static final Long ID_DISCIPLINA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdDisciplina() <em>Id Disciplina</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdDisciplina()
	 * @generated
	 * @ordered
	 */
	protected Long idDisciplina = ID_DISCIPLINA_EDEFAULT;

	/**
	 * The default value of the '{@link #getNome() <em>Nome</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNome()
	 * @generated
	 * @ordered
	 */
	protected static final String NOME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNome() <em>Nome</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNome()
	 * @generated
	 * @ordered
	 */
	protected String nome = NOME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPeso() <em>Peso</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeso()
	 * @generated
	 * @ordered
	 */
	protected static final Integer PESO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPeso() <em>Peso</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeso()
	 * @generated
	 * @ordered
	 */
	protected Integer peso = PESO_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEsta_em() <em>Esta em</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEsta_em()
	 * @generated
	 * @ordered
	 */
	protected Nota esta_em;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CriterioAvaliacaoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ElearningmodelPackage.Literals.CRITERIO_AVALIACAO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getIdCriterioAvaliacao() {
		return idCriterioAvaliacao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdCriterioAvaliacao(Long newIdCriterioAvaliacao) {
		Long oldIdCriterioAvaliacao = idCriterioAvaliacao;
		idCriterioAvaliacao = newIdCriterioAvaliacao;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.CRITERIO_AVALIACAO__ID_CRITERIO_AVALIACAO, oldIdCriterioAvaliacao, idCriterioAvaliacao));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getIdDisciplina() {
		return idDisciplina;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdDisciplina(Long newIdDisciplina) {
		Long oldIdDisciplina = idDisciplina;
		idDisciplina = newIdDisciplina;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.CRITERIO_AVALIACAO__ID_DISCIPLINA, oldIdDisciplina, idDisciplina));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNome(String newNome) {
		String oldNome = nome;
		nome = newNome;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.CRITERIO_AVALIACAO__NOME, oldNome, nome));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getPeso() {
		return peso;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeso(Integer newPeso) {
		Integer oldPeso = peso;
		peso = newPeso;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.CRITERIO_AVALIACAO__PESO, oldPeso, peso));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Nota getEsta_em() {
		if (esta_em != null && esta_em.eIsProxy()) {
			InternalEObject oldEsta_em = (InternalEObject)esta_em;
			esta_em = (Nota)eResolveProxy(oldEsta_em);
			if (esta_em != oldEsta_em) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElearningmodelPackage.CRITERIO_AVALIACAO__ESTA_EM, oldEsta_em, esta_em));
			}
		}
		return esta_em;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Nota basicGetEsta_em() {
		return esta_em;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEsta_em(Nota newEsta_em) {
		Nota oldEsta_em = esta_em;
		esta_em = newEsta_em;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.CRITERIO_AVALIACAO__ESTA_EM, oldEsta_em, esta_em));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElearningmodelPackage.CRITERIO_AVALIACAO__ID_CRITERIO_AVALIACAO:
				return getIdCriterioAvaliacao();
			case ElearningmodelPackage.CRITERIO_AVALIACAO__ID_DISCIPLINA:
				return getIdDisciplina();
			case ElearningmodelPackage.CRITERIO_AVALIACAO__NOME:
				return getNome();
			case ElearningmodelPackage.CRITERIO_AVALIACAO__PESO:
				return getPeso();
			case ElearningmodelPackage.CRITERIO_AVALIACAO__ESTA_EM:
				if (resolve) return getEsta_em();
				return basicGetEsta_em();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ElearningmodelPackage.CRITERIO_AVALIACAO__ID_CRITERIO_AVALIACAO:
				setIdCriterioAvaliacao((Long)newValue);
				return;
			case ElearningmodelPackage.CRITERIO_AVALIACAO__ID_DISCIPLINA:
				setIdDisciplina((Long)newValue);
				return;
			case ElearningmodelPackage.CRITERIO_AVALIACAO__NOME:
				setNome((String)newValue);
				return;
			case ElearningmodelPackage.CRITERIO_AVALIACAO__PESO:
				setPeso((Integer)newValue);
				return;
			case ElearningmodelPackage.CRITERIO_AVALIACAO__ESTA_EM:
				setEsta_em((Nota)newValue);
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
			case ElearningmodelPackage.CRITERIO_AVALIACAO__ID_CRITERIO_AVALIACAO:
				setIdCriterioAvaliacao(ID_CRITERIO_AVALIACAO_EDEFAULT);
				return;
			case ElearningmodelPackage.CRITERIO_AVALIACAO__ID_DISCIPLINA:
				setIdDisciplina(ID_DISCIPLINA_EDEFAULT);
				return;
			case ElearningmodelPackage.CRITERIO_AVALIACAO__NOME:
				setNome(NOME_EDEFAULT);
				return;
			case ElearningmodelPackage.CRITERIO_AVALIACAO__PESO:
				setPeso(PESO_EDEFAULT);
				return;
			case ElearningmodelPackage.CRITERIO_AVALIACAO__ESTA_EM:
				setEsta_em((Nota)null);
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
			case ElearningmodelPackage.CRITERIO_AVALIACAO__ID_CRITERIO_AVALIACAO:
				return ID_CRITERIO_AVALIACAO_EDEFAULT == null ? idCriterioAvaliacao != null : !ID_CRITERIO_AVALIACAO_EDEFAULT.equals(idCriterioAvaliacao);
			case ElearningmodelPackage.CRITERIO_AVALIACAO__ID_DISCIPLINA:
				return ID_DISCIPLINA_EDEFAULT == null ? idDisciplina != null : !ID_DISCIPLINA_EDEFAULT.equals(idDisciplina);
			case ElearningmodelPackage.CRITERIO_AVALIACAO__NOME:
				return NOME_EDEFAULT == null ? nome != null : !NOME_EDEFAULT.equals(nome);
			case ElearningmodelPackage.CRITERIO_AVALIACAO__PESO:
				return PESO_EDEFAULT == null ? peso != null : !PESO_EDEFAULT.equals(peso);
			case ElearningmodelPackage.CRITERIO_AVALIACAO__ESTA_EM:
				return esta_em != null;
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
		result.append(" (idCriterioAvaliacao: ");
		result.append(idCriterioAvaliacao);
		result.append(", idDisciplina: ");
		result.append(idDisciplina);
		result.append(", nome: ");
		result.append(nome);
		result.append(", peso: ");
		result.append(peso);
		result.append(')');
		return result.toString();
	}

} //CriterioAvaliacaoImpl
