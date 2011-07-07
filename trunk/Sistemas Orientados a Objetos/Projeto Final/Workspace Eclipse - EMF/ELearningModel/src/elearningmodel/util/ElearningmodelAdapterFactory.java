/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel.util;

import elearningmodel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see elearningmodel.ElearningmodelPackage
 * @generated
 */
public class ElearningmodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ElearningmodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElearningmodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ElearningmodelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElearningmodelSwitch<Adapter> modelSwitch =
		new ElearningmodelSwitch<Adapter>() {
			@Override
			public Adapter caseUsuario(Usuario object) {
				return createUsuarioAdapter();
			}
			@Override
			public Adapter casePessoa(Pessoa object) {
				return createPessoaAdapter();
			}
			@Override
			public Adapter caseProfessor(Professor object) {
				return createProfessorAdapter();
			}
			@Override
			public Adapter caseAluno(Aluno object) {
				return createAlunoAdapter();
			}
			@Override
			public Adapter caseDisciplina(Disciplina object) {
				return createDisciplinaAdapter();
			}
			@Override
			public Adapter caseCriterioAvaliacao(CriterioAvaliacao object) {
				return createCriterioAvaliacaoAdapter();
			}
			@Override
			public Adapter caseMatricula(Matricula object) {
				return createMatriculaAdapter();
			}
			@Override
			public Adapter caseNota(Nota object) {
				return createNotaAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link elearningmodel.Usuario <em>Usuario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see elearningmodel.Usuario
	 * @generated
	 */
	public Adapter createUsuarioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link elearningmodel.Pessoa <em>Pessoa</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see elearningmodel.Pessoa
	 * @generated
	 */
	public Adapter createPessoaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link elearningmodel.Professor <em>Professor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see elearningmodel.Professor
	 * @generated
	 */
	public Adapter createProfessorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link elearningmodel.Aluno <em>Aluno</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see elearningmodel.Aluno
	 * @generated
	 */
	public Adapter createAlunoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link elearningmodel.Disciplina <em>Disciplina</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see elearningmodel.Disciplina
	 * @generated
	 */
	public Adapter createDisciplinaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link elearningmodel.CriterioAvaliacao <em>Criterio Avaliacao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see elearningmodel.CriterioAvaliacao
	 * @generated
	 */
	public Adapter createCriterioAvaliacaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link elearningmodel.Matricula <em>Matricula</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see elearningmodel.Matricula
	 * @generated
	 */
	public Adapter createMatriculaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link elearningmodel.Nota <em>Nota</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see elearningmodel.Nota
	 * @generated
	 */
	public Adapter createNotaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ElearningmodelAdapterFactory
