/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel.impl;

import elearningmodel.Disciplina;
import elearningmodel.ElearningmodelPackage;
import elearningmodel.Professor;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Professor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link elearningmodel.impl.ProfessorImpl#getLeciona <em>Leciona</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProfessorImpl extends PessoaImpl implements Professor {
	/**
	 * The cached value of the '{@link #getLeciona() <em>Leciona</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeciona()
	 * @generated
	 * @ordered
	 */
	protected EList<Disciplina> leciona;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProfessorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ElearningmodelPackage.Literals.PROFESSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Disciplina> getLeciona() {
		if (leciona == null) {
			leciona = new EObjectResolvingEList<Disciplina>(Disciplina.class, this, ElearningmodelPackage.PROFESSOR__LECIONA);
		}
		return leciona;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElearningmodelPackage.PROFESSOR__LECIONA:
				return getLeciona();
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
			case ElearningmodelPackage.PROFESSOR__LECIONA:
				getLeciona().clear();
				getLeciona().addAll((Collection<? extends Disciplina>)newValue);
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
			case ElearningmodelPackage.PROFESSOR__LECIONA:
				getLeciona().clear();
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
			case ElearningmodelPackage.PROFESSOR__LECIONA:
				return leciona != null && !leciona.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ProfessorImpl
