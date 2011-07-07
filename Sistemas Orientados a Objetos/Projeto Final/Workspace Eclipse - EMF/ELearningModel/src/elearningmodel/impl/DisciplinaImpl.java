/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel.impl;

import elearningmodel.CriterioAvaliacao;
import elearningmodel.Disciplina;
import elearningmodel.ElearningmodelPackage;
import elearningmodel.Matricula;

import java.math.BigInteger;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Disciplina</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link elearningmodel.impl.DisciplinaImpl#getIdDisciplina <em>Id Disciplina</em>}</li>
 *   <li>{@link elearningmodel.impl.DisciplinaImpl#getIdProfessor <em>Id Professor</em>}</li>
 *   <li>{@link elearningmodel.impl.DisciplinaImpl#getNomeDisciplina <em>Nome Disciplina</em>}</li>
 *   <li>{@link elearningmodel.impl.DisciplinaImpl#getNumNotas <em>Num Notas</em>}</li>
 *   <li>{@link elearningmodel.impl.DisciplinaImpl#getPossui <em>Possui</em>}</li>
 *   <li>{@link elearningmodel.impl.DisciplinaImpl#getTem <em>Tem</em>}</li>
 *   <li>{@link elearningmodel.impl.DisciplinaImpl#getDataInicio <em>Data Inicio</em>}</li>
 *   <li>{@link elearningmodel.impl.DisciplinaImpl#getDataFim <em>Data Fim</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DisciplinaImpl extends EObjectImpl implements Disciplina {
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
	 * The default value of the '{@link #getIdProfessor() <em>Id Professor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdProfessor()
	 * @generated
	 * @ordered
	 */
	protected static final Long ID_PROFESSOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdProfessor() <em>Id Professor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdProfessor()
	 * @generated
	 * @ordered
	 */
	protected Long idProfessor = ID_PROFESSOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getNomeDisciplina() <em>Nome Disciplina</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNomeDisciplina()
	 * @generated
	 * @ordered
	 */
	protected static final String NOME_DISCIPLINA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNomeDisciplina() <em>Nome Disciplina</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNomeDisciplina()
	 * @generated
	 * @ordered
	 */
	protected String nomeDisciplina = NOME_DISCIPLINA_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumNotas() <em>Num Notas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumNotas()
	 * @generated
	 * @ordered
	 */
	protected static final Integer NUM_NOTAS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumNotas() <em>Num Notas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumNotas()
	 * @generated
	 * @ordered
	 */
	protected Integer numNotas = NUM_NOTAS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPossui() <em>Possui</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPossui()
	 * @generated
	 * @ordered
	 */
	protected EList<CriterioAvaliacao> possui;

	/**
	 * The cached value of the '{@link #getTem() <em>Tem</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTem()
	 * @generated
	 * @ordered
	 */
	protected EList<Matricula> tem;

	/**
	 * The default value of the '{@link #getDataInicio() <em>Data Inicio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataInicio()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATA_INICIO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataInicio() <em>Data Inicio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataInicio()
	 * @generated
	 * @ordered
	 */
	protected Date dataInicio = DATA_INICIO_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataFim() <em>Data Fim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataFim()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATA_FIM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataFim() <em>Data Fim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataFim()
	 * @generated
	 * @ordered
	 */
	protected Date dataFim = DATA_FIM_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DisciplinaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ElearningmodelPackage.Literals.DISCIPLINA;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.DISCIPLINA__ID_DISCIPLINA, oldIdDisciplina, idDisciplina));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getIdProfessor() {
		return idProfessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdProfessor(Long newIdProfessor) {
		Long oldIdProfessor = idProfessor;
		idProfessor = newIdProfessor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.DISCIPLINA__ID_PROFESSOR, oldIdProfessor, idProfessor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNomeDisciplina(String newNomeDisciplina) {
		String oldNomeDisciplina = nomeDisciplina;
		nomeDisciplina = newNomeDisciplina;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.DISCIPLINA__NOME_DISCIPLINA, oldNomeDisciplina, nomeDisciplina));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getNumNotas() {
		return numNotas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumNotas(Integer newNumNotas) {
		Integer oldNumNotas = numNotas;
		numNotas = newNumNotas;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.DISCIPLINA__NUM_NOTAS, oldNumNotas, numNotas));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CriterioAvaliacao> getPossui() {
		if (possui == null) {
			possui = new EObjectResolvingEList<CriterioAvaliacao>(CriterioAvaliacao.class, this, ElearningmodelPackage.DISCIPLINA__POSSUI);
		}
		return possui;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Matricula> getTem() {
		if (tem == null) {
			tem = new EObjectResolvingEList<Matricula>(Matricula.class, this, ElearningmodelPackage.DISCIPLINA__TEM);
		}
		return tem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDataInicio() {
		return dataInicio;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataInicio(Date newDataInicio) {
		Date oldDataInicio = dataInicio;
		dataInicio = newDataInicio;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.DISCIPLINA__DATA_INICIO, oldDataInicio, dataInicio));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDataFim() {
		return dataFim;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataFim(Date newDataFim) {
		Date oldDataFim = dataFim;
		dataFim = newDataFim;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.DISCIPLINA__DATA_FIM, oldDataFim, dataFim));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElearningmodelPackage.DISCIPLINA__ID_DISCIPLINA:
				return getIdDisciplina();
			case ElearningmodelPackage.DISCIPLINA__ID_PROFESSOR:
				return getIdProfessor();
			case ElearningmodelPackage.DISCIPLINA__NOME_DISCIPLINA:
				return getNomeDisciplina();
			case ElearningmodelPackage.DISCIPLINA__NUM_NOTAS:
				return getNumNotas();
			case ElearningmodelPackage.DISCIPLINA__POSSUI:
				return getPossui();
			case ElearningmodelPackage.DISCIPLINA__TEM:
				return getTem();
			case ElearningmodelPackage.DISCIPLINA__DATA_INICIO:
				return getDataInicio();
			case ElearningmodelPackage.DISCIPLINA__DATA_FIM:
				return getDataFim();
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
			case ElearningmodelPackage.DISCIPLINA__ID_DISCIPLINA:
				setIdDisciplina((Long)newValue);
				return;
			case ElearningmodelPackage.DISCIPLINA__ID_PROFESSOR:
				setIdProfessor((Long)newValue);
				return;
			case ElearningmodelPackage.DISCIPLINA__NOME_DISCIPLINA:
				setNomeDisciplina((String)newValue);
				return;
			case ElearningmodelPackage.DISCIPLINA__NUM_NOTAS:
				setNumNotas((Integer)newValue);
				return;
			case ElearningmodelPackage.DISCIPLINA__POSSUI:
				getPossui().clear();
				getPossui().addAll((Collection<? extends CriterioAvaliacao>)newValue);
				return;
			case ElearningmodelPackage.DISCIPLINA__TEM:
				getTem().clear();
				getTem().addAll((Collection<? extends Matricula>)newValue);
				return;
			case ElearningmodelPackage.DISCIPLINA__DATA_INICIO:
				setDataInicio((Date)newValue);
				return;
			case ElearningmodelPackage.DISCIPLINA__DATA_FIM:
				setDataFim((Date)newValue);
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
			case ElearningmodelPackage.DISCIPLINA__ID_DISCIPLINA:
				setIdDisciplina(ID_DISCIPLINA_EDEFAULT);
				return;
			case ElearningmodelPackage.DISCIPLINA__ID_PROFESSOR:
				setIdProfessor(ID_PROFESSOR_EDEFAULT);
				return;
			case ElearningmodelPackage.DISCIPLINA__NOME_DISCIPLINA:
				setNomeDisciplina(NOME_DISCIPLINA_EDEFAULT);
				return;
			case ElearningmodelPackage.DISCIPLINA__NUM_NOTAS:
				setNumNotas(NUM_NOTAS_EDEFAULT);
				return;
			case ElearningmodelPackage.DISCIPLINA__POSSUI:
				getPossui().clear();
				return;
			case ElearningmodelPackage.DISCIPLINA__TEM:
				getTem().clear();
				return;
			case ElearningmodelPackage.DISCIPLINA__DATA_INICIO:
				setDataInicio(DATA_INICIO_EDEFAULT);
				return;
			case ElearningmodelPackage.DISCIPLINA__DATA_FIM:
				setDataFim(DATA_FIM_EDEFAULT);
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
			case ElearningmodelPackage.DISCIPLINA__ID_DISCIPLINA:
				return ID_DISCIPLINA_EDEFAULT == null ? idDisciplina != null : !ID_DISCIPLINA_EDEFAULT.equals(idDisciplina);
			case ElearningmodelPackage.DISCIPLINA__ID_PROFESSOR:
				return ID_PROFESSOR_EDEFAULT == null ? idProfessor != null : !ID_PROFESSOR_EDEFAULT.equals(idProfessor);
			case ElearningmodelPackage.DISCIPLINA__NOME_DISCIPLINA:
				return NOME_DISCIPLINA_EDEFAULT == null ? nomeDisciplina != null : !NOME_DISCIPLINA_EDEFAULT.equals(nomeDisciplina);
			case ElearningmodelPackage.DISCIPLINA__NUM_NOTAS:
				return NUM_NOTAS_EDEFAULT == null ? numNotas != null : !NUM_NOTAS_EDEFAULT.equals(numNotas);
			case ElearningmodelPackage.DISCIPLINA__POSSUI:
				return possui != null && !possui.isEmpty();
			case ElearningmodelPackage.DISCIPLINA__TEM:
				return tem != null && !tem.isEmpty();
			case ElearningmodelPackage.DISCIPLINA__DATA_INICIO:
				return DATA_INICIO_EDEFAULT == null ? dataInicio != null : !DATA_INICIO_EDEFAULT.equals(dataInicio);
			case ElearningmodelPackage.DISCIPLINA__DATA_FIM:
				return DATA_FIM_EDEFAULT == null ? dataFim != null : !DATA_FIM_EDEFAULT.equals(dataFim);
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
		result.append(" (idDisciplina: ");
		result.append(idDisciplina);
		result.append(", idProfessor: ");
		result.append(idProfessor);
		result.append(", nomeDisciplina: ");
		result.append(nomeDisciplina);
		result.append(", numNotas: ");
		result.append(numNotas);
		result.append(", dataInicio: ");
		result.append(dataInicio);
		result.append(", dataFim: ");
		result.append(dataFim);
		result.append(')');
		return result.toString();
	}

} //DisciplinaImpl
