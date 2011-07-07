/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel.util;

import elearningmodel.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see elearningmodel.ElearningmodelPackage
 * @generated
 */
public class ElearningmodelSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ElearningmodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElearningmodelSwitch() {
		if (modelPackage == null) {
			modelPackage = ElearningmodelPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ElearningmodelPackage.USUARIO: {
				Usuario usuario = (Usuario)theEObject;
				T result = caseUsuario(usuario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ElearningmodelPackage.PESSOA: {
				Pessoa pessoa = (Pessoa)theEObject;
				T result = casePessoa(pessoa);
				if (result == null) result = caseUsuario(pessoa);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ElearningmodelPackage.PROFESSOR: {
				Professor professor = (Professor)theEObject;
				T result = caseProfessor(professor);
				if (result == null) result = casePessoa(professor);
				if (result == null) result = caseUsuario(professor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ElearningmodelPackage.ALUNO: {
				Aluno aluno = (Aluno)theEObject;
				T result = caseAluno(aluno);
				if (result == null) result = casePessoa(aluno);
				if (result == null) result = caseUsuario(aluno);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ElearningmodelPackage.DISCIPLINA: {
				Disciplina disciplina = (Disciplina)theEObject;
				T result = caseDisciplina(disciplina);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ElearningmodelPackage.CRITERIO_AVALIACAO: {
				CriterioAvaliacao criterioAvaliacao = (CriterioAvaliacao)theEObject;
				T result = caseCriterioAvaliacao(criterioAvaliacao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ElearningmodelPackage.MATRICULA: {
				Matricula matricula = (Matricula)theEObject;
				T result = caseMatricula(matricula);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ElearningmodelPackage.NOTA: {
				Nota nota = (Nota)theEObject;
				T result = caseNota(nota);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Usuario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Usuario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUsuario(Usuario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pessoa</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pessoa</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePessoa(Pessoa object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Professor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Professor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProfessor(Professor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aluno</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aluno</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAluno(Aluno object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Disciplina</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Disciplina</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDisciplina(Disciplina object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Criterio Avaliacao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Criterio Avaliacao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCriterioAvaliacao(CriterioAvaliacao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Matricula</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Matricula</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatricula(Matricula object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nota</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nota</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNota(Nota object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //ElearningmodelSwitch
