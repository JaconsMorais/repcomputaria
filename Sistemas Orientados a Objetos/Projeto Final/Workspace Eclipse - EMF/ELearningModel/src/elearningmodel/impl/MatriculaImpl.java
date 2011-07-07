/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel.impl;

import elearningmodel.ElearningmodelPackage;
import elearningmodel.Matricula;

import elearningmodel.Nota;
import java.math.BigInteger;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Matricula</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link elearningmodel.impl.MatriculaImpl#getIdMatricula <em>Id Matricula</em>}</li>
 *   <li>{@link elearningmodel.impl.MatriculaImpl#getIdAluno <em>Id Aluno</em>}</li>
 *   <li>{@link elearningmodel.impl.MatriculaImpl#getIdDisciplina <em>Id Disciplina</em>}</li>
 *   <li>{@link elearningmodel.impl.MatriculaImpl#getIdNota <em>Id Nota</em>}</li>
 *   <li>{@link elearningmodel.impl.MatriculaImpl#getNotaFinal <em>Nota Final</em>}</li>
 *   <li>{@link elearningmodel.impl.MatriculaImpl#getGanha <em>Ganha</em>}</li>
 *   <li>{@link elearningmodel.impl.MatriculaImpl#getRecebe <em>Recebe</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MatriculaImpl extends EObjectImpl implements Matricula {
	/**
	 * The default value of the '{@link #getIdMatricula() <em>Id Matricula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdMatricula()
	 * @generated
	 * @ordered
	 */
	protected static final Long ID_MATRICULA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdMatricula() <em>Id Matricula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdMatricula()
	 * @generated
	 * @ordered
	 */
	protected Long idMatricula = ID_MATRICULA_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdAluno() <em>Id Aluno</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdAluno()
	 * @generated
	 * @ordered
	 */
	protected static final Long ID_ALUNO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdAluno() <em>Id Aluno</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdAluno()
	 * @generated
	 * @ordered
	 */
	protected Long idAluno = ID_ALUNO_EDEFAULT;

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
	 * The default value of the '{@link #getIdNota() <em>Id Nota</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdNota()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger ID_NOTA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdNota() <em>Id Nota</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdNota()
	 * @generated
	 * @ordered
	 */
	protected BigInteger idNota = ID_NOTA_EDEFAULT;

	/**
	 * The default value of the '{@link #getNotaFinal() <em>Nota Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotaFinal()
	 * @generated
	 * @ordered
	 */
	protected static final Double NOTA_FINAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNotaFinal() <em>Nota Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotaFinal()
	 * @generated
	 * @ordered
	 */
	protected Double notaFinal = NOTA_FINAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGanha() <em>Ganha</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGanha()
	 * @generated
	 * @ordered
	 */
	protected EList<Nota> ganha;

	/**
	 * The cached value of the '{@link #getRecebe() <em>Recebe</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecebe()
	 * @generated
	 * @ordered
	 */
	protected EList<Nota> recebe;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MatriculaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ElearningmodelPackage.Literals.MATRICULA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getIdMatricula() {
		return idMatricula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdMatricula(Long newIdMatricula) {
		Long oldIdMatricula = idMatricula;
		idMatricula = newIdMatricula;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.MATRICULA__ID_MATRICULA, oldIdMatricula, idMatricula));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getIdAluno() {
		return idAluno;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdAluno(Long newIdAluno) {
		Long oldIdAluno = idAluno;
		idAluno = newIdAluno;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.MATRICULA__ID_ALUNO, oldIdAluno, idAluno));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.MATRICULA__ID_DISCIPLINA, oldIdDisciplina, idDisciplina));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getIdNota() {
		return idNota;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdNota(BigInteger newIdNota) {
		BigInteger oldIdNota = idNota;
		idNota = newIdNota;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.MATRICULA__ID_NOTA, oldIdNota, idNota));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getNotaFinal() {
		return notaFinal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotaFinal(Double newNotaFinal) {
		Double oldNotaFinal = notaFinal;
		notaFinal = newNotaFinal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.MATRICULA__NOTA_FINAL, oldNotaFinal, notaFinal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Nota> getGanha() {
		if (ganha == null) {
			ganha = new EObjectResolvingEList<Nota>(Nota.class, this, ElearningmodelPackage.MATRICULA__GANHA);
		}
		return ganha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Nota> getRecebe() {
		if (recebe == null) {
			recebe = new EObjectResolvingEList<Nota>(Nota.class, this, ElearningmodelPackage.MATRICULA__RECEBE);
		}
		return recebe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElearningmodelPackage.MATRICULA__ID_MATRICULA:
				return getIdMatricula();
			case ElearningmodelPackage.MATRICULA__ID_ALUNO:
				return getIdAluno();
			case ElearningmodelPackage.MATRICULA__ID_DISCIPLINA:
				return getIdDisciplina();
			case ElearningmodelPackage.MATRICULA__ID_NOTA:
				return getIdNota();
			case ElearningmodelPackage.MATRICULA__NOTA_FINAL:
				return getNotaFinal();
			case ElearningmodelPackage.MATRICULA__GANHA:
				return getGanha();
			case ElearningmodelPackage.MATRICULA__RECEBE:
				return getRecebe();
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
			case ElearningmodelPackage.MATRICULA__ID_MATRICULA:
				setIdMatricula((Long)newValue);
				return;
			case ElearningmodelPackage.MATRICULA__ID_ALUNO:
				setIdAluno((Long)newValue);
				return;
			case ElearningmodelPackage.MATRICULA__ID_DISCIPLINA:
				setIdDisciplina((Long)newValue);
				return;
			case ElearningmodelPackage.MATRICULA__ID_NOTA:
				setIdNota((BigInteger)newValue);
				return;
			case ElearningmodelPackage.MATRICULA__NOTA_FINAL:
				setNotaFinal((Double)newValue);
				return;
			case ElearningmodelPackage.MATRICULA__GANHA:
				getGanha().clear();
				getGanha().addAll((Collection<? extends Nota>)newValue);
				return;
			case ElearningmodelPackage.MATRICULA__RECEBE:
				getRecebe().clear();
				getRecebe().addAll((Collection<? extends Nota>)newValue);
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
			case ElearningmodelPackage.MATRICULA__ID_MATRICULA:
				setIdMatricula(ID_MATRICULA_EDEFAULT);
				return;
			case ElearningmodelPackage.MATRICULA__ID_ALUNO:
				setIdAluno(ID_ALUNO_EDEFAULT);
				return;
			case ElearningmodelPackage.MATRICULA__ID_DISCIPLINA:
				setIdDisciplina(ID_DISCIPLINA_EDEFAULT);
				return;
			case ElearningmodelPackage.MATRICULA__ID_NOTA:
				setIdNota(ID_NOTA_EDEFAULT);
				return;
			case ElearningmodelPackage.MATRICULA__NOTA_FINAL:
				setNotaFinal(NOTA_FINAL_EDEFAULT);
				return;
			case ElearningmodelPackage.MATRICULA__GANHA:
				getGanha().clear();
				return;
			case ElearningmodelPackage.MATRICULA__RECEBE:
				getRecebe().clear();
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
			case ElearningmodelPackage.MATRICULA__ID_MATRICULA:
				return ID_MATRICULA_EDEFAULT == null ? idMatricula != null : !ID_MATRICULA_EDEFAULT.equals(idMatricula);
			case ElearningmodelPackage.MATRICULA__ID_ALUNO:
				return ID_ALUNO_EDEFAULT == null ? idAluno != null : !ID_ALUNO_EDEFAULT.equals(idAluno);
			case ElearningmodelPackage.MATRICULA__ID_DISCIPLINA:
				return ID_DISCIPLINA_EDEFAULT == null ? idDisciplina != null : !ID_DISCIPLINA_EDEFAULT.equals(idDisciplina);
			case ElearningmodelPackage.MATRICULA__ID_NOTA:
				return ID_NOTA_EDEFAULT == null ? idNota != null : !ID_NOTA_EDEFAULT.equals(idNota);
			case ElearningmodelPackage.MATRICULA__NOTA_FINAL:
				return NOTA_FINAL_EDEFAULT == null ? notaFinal != null : !NOTA_FINAL_EDEFAULT.equals(notaFinal);
			case ElearningmodelPackage.MATRICULA__GANHA:
				return ganha != null && !ganha.isEmpty();
			case ElearningmodelPackage.MATRICULA__RECEBE:
				return recebe != null && !recebe.isEmpty();
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
		result.append(" (idMatricula: ");
		result.append(idMatricula);
		result.append(", idAluno: ");
		result.append(idAluno);
		result.append(", idDisciplina: ");
		result.append(idDisciplina);
		result.append(", idNota: ");
		result.append(idNota);
		result.append(", notaFinal: ");
		result.append(notaFinal);
		result.append(')');
		return result.toString();
	}

} //MatriculaImpl
