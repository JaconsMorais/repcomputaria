/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel.impl;

import elearningmodel.ElearningmodelPackage;
import elearningmodel.Nota;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nota</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link elearningmodel.impl.NotaImpl#getIdNota <em>Id Nota</em>}</li>
 *   <li>{@link elearningmodel.impl.NotaImpl#getIdCriterioAvaliacao <em>Id Criterio Avaliacao</em>}</li>
 *   <li>{@link elearningmodel.impl.NotaImpl#getNotaCriterio <em>Nota Criterio</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NotaImpl extends EObjectImpl implements Nota {
	/**
	 * The default value of the '{@link #getIdNota() <em>Id Nota</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdNota()
	 * @generated
	 * @ordered
	 */
	protected static final Long ID_NOTA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdNota() <em>Id Nota</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdNota()
	 * @generated
	 * @ordered
	 */
	protected Long idNota = ID_NOTA_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdCriterioAvaliacao() <em>Id Criterio Avaliacao</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdCriterioAvaliacao()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger ID_CRITERIO_AVALIACAO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdCriterioAvaliacao() <em>Id Criterio Avaliacao</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdCriterioAvaliacao()
	 * @generated
	 * @ordered
	 */
	protected BigInteger idCriterioAvaliacao = ID_CRITERIO_AVALIACAO_EDEFAULT;

	/**
	 * The default value of the '{@link #getNotaCriterio() <em>Nota Criterio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotaCriterio()
	 * @generated
	 * @ordered
	 */
	protected static final Double NOTA_CRITERIO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNotaCriterio() <em>Nota Criterio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotaCriterio()
	 * @generated
	 * @ordered
	 */
	protected Double notaCriterio = NOTA_CRITERIO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ElearningmodelPackage.Literals.NOTA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getIdNota() {
		return idNota;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdNota(Long newIdNota) {
		Long oldIdNota = idNota;
		idNota = newIdNota;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.NOTA__ID_NOTA, oldIdNota, idNota));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getIdCriterioAvaliacao() {
		return idCriterioAvaliacao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdCriterioAvaliacao(BigInteger newIdCriterioAvaliacao) {
		BigInteger oldIdCriterioAvaliacao = idCriterioAvaliacao;
		idCriterioAvaliacao = newIdCriterioAvaliacao;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.NOTA__ID_CRITERIO_AVALIACAO, oldIdCriterioAvaliacao, idCriterioAvaliacao));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getNotaCriterio() {
		return notaCriterio;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotaCriterio(Double newNotaCriterio) {
		Double oldNotaCriterio = notaCriterio;
		notaCriterio = newNotaCriterio;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElearningmodelPackage.NOTA__NOTA_CRITERIO, oldNotaCriterio, notaCriterio));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElearningmodelPackage.NOTA__ID_NOTA:
				return getIdNota();
			case ElearningmodelPackage.NOTA__ID_CRITERIO_AVALIACAO:
				return getIdCriterioAvaliacao();
			case ElearningmodelPackage.NOTA__NOTA_CRITERIO:
				return getNotaCriterio();
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
			case ElearningmodelPackage.NOTA__ID_NOTA:
				setIdNota((Long)newValue);
				return;
			case ElearningmodelPackage.NOTA__ID_CRITERIO_AVALIACAO:
				setIdCriterioAvaliacao((BigInteger)newValue);
				return;
			case ElearningmodelPackage.NOTA__NOTA_CRITERIO:
				setNotaCriterio((Double)newValue);
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
			case ElearningmodelPackage.NOTA__ID_NOTA:
				setIdNota(ID_NOTA_EDEFAULT);
				return;
			case ElearningmodelPackage.NOTA__ID_CRITERIO_AVALIACAO:
				setIdCriterioAvaliacao(ID_CRITERIO_AVALIACAO_EDEFAULT);
				return;
			case ElearningmodelPackage.NOTA__NOTA_CRITERIO:
				setNotaCriterio(NOTA_CRITERIO_EDEFAULT);
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
			case ElearningmodelPackage.NOTA__ID_NOTA:
				return ID_NOTA_EDEFAULT == null ? idNota != null : !ID_NOTA_EDEFAULT.equals(idNota);
			case ElearningmodelPackage.NOTA__ID_CRITERIO_AVALIACAO:
				return ID_CRITERIO_AVALIACAO_EDEFAULT == null ? idCriterioAvaliacao != null : !ID_CRITERIO_AVALIACAO_EDEFAULT.equals(idCriterioAvaliacao);
			case ElearningmodelPackage.NOTA__NOTA_CRITERIO:
				return NOTA_CRITERIO_EDEFAULT == null ? notaCriterio != null : !NOTA_CRITERIO_EDEFAULT.equals(notaCriterio);
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
		result.append(" (idNota: ");
		result.append(idNota);
		result.append(", idCriterioAvaliacao: ");
		result.append(idCriterioAvaliacao);
		result.append(", notaCriterio: ");
		result.append(notaCriterio);
		result.append(')');
		return result.toString();
	}

} //NotaImpl
