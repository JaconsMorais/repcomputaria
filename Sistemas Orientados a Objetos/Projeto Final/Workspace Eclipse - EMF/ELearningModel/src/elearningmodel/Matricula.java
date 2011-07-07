/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel;

import java.math.BigInteger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Matricula</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link elearningmodel.Matricula#getIdMatricula <em>Id Matricula</em>}</li>
 *   <li>{@link elearningmodel.Matricula#getIdAluno <em>Id Aluno</em>}</li>
 *   <li>{@link elearningmodel.Matricula#getIdDisciplina <em>Id Disciplina</em>}</li>
 *   <li>{@link elearningmodel.Matricula#getIdNota <em>Id Nota</em>}</li>
 *   <li>{@link elearningmodel.Matricula#getNotaFinal <em>Nota Final</em>}</li>
 *   <li>{@link elearningmodel.Matricula#getGanha <em>Ganha</em>}</li>
 *   <li>{@link elearningmodel.Matricula#getRecebe <em>Recebe</em>}</li>
 * </ul>
 * </p>
 *
 * @see elearningmodel.ElearningmodelPackage#getMatricula()
 * @model
 * @generated
 */
public interface Matricula extends EObject {
	/**
	 * Returns the value of the '<em><b>Id Matricula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Matricula</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Matricula</em>' attribute.
	 * @see #setIdMatricula(Long)
	 * @see elearningmodel.ElearningmodelPackage#getMatricula_IdMatricula()
	 * @model
	 * @generated
	 */
	Long getIdMatricula();

	/**
	 * Sets the value of the '{@link elearningmodel.Matricula#getIdMatricula <em>Id Matricula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Matricula</em>' attribute.
	 * @see #getIdMatricula()
	 * @generated
	 */
	void setIdMatricula(Long value);

	/**
	 * Returns the value of the '<em><b>Id Aluno</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Aluno</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Aluno</em>' attribute.
	 * @see #setIdAluno(Long)
	 * @see elearningmodel.ElearningmodelPackage#getMatricula_IdAluno()
	 * @model
	 * @generated
	 */
	Long getIdAluno();

	/**
	 * Sets the value of the '{@link elearningmodel.Matricula#getIdAluno <em>Id Aluno</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Aluno</em>' attribute.
	 * @see #getIdAluno()
	 * @generated
	 */
	void setIdAluno(Long value);

	/**
	 * Returns the value of the '<em><b>Id Disciplina</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Disciplina</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Disciplina</em>' attribute.
	 * @see #setIdDisciplina(Long)
	 * @see elearningmodel.ElearningmodelPackage#getMatricula_IdDisciplina()
	 * @model
	 * @generated
	 */
	Long getIdDisciplina();

	/**
	 * Sets the value of the '{@link elearningmodel.Matricula#getIdDisciplina <em>Id Disciplina</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Disciplina</em>' attribute.
	 * @see #getIdDisciplina()
	 * @generated
	 */
	void setIdDisciplina(Long value);

	/**
	 * Returns the value of the '<em><b>Id Nota</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Nota</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Nota</em>' attribute.
	 * @see #setIdNota(BigInteger)
	 * @see elearningmodel.ElearningmodelPackage#getMatricula_IdNota()
	 * @model
	 * @generated
	 */
	BigInteger getIdNota();

	/**
	 * Sets the value of the '{@link elearningmodel.Matricula#getIdNota <em>Id Nota</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Nota</em>' attribute.
	 * @see #getIdNota()
	 * @generated
	 */
	void setIdNota(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Nota Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nota Final</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nota Final</em>' attribute.
	 * @see #setNotaFinal(Double)
	 * @see elearningmodel.ElearningmodelPackage#getMatricula_NotaFinal()
	 * @model
	 * @generated
	 */
	Double getNotaFinal();

	/**
	 * Sets the value of the '{@link elearningmodel.Matricula#getNotaFinal <em>Nota Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nota Final</em>' attribute.
	 * @see #getNotaFinal()
	 * @generated
	 */
	void setNotaFinal(Double value);

	/**
	 * Returns the value of the '<em><b>Ganha</b></em>' reference list.
	 * The list contents are of type {@link elearningmodel.Nota}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ganha</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ganha</em>' reference list.
	 * @see elearningmodel.ElearningmodelPackage#getMatricula_Ganha()
	 * @model required="true"
	 * @generated
	 */
	EList<Nota> getGanha();

	/**
	 * Returns the value of the '<em><b>Recebe</b></em>' reference list.
	 * The list contents are of type {@link elearningmodel.Nota}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recebe</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recebe</em>' reference list.
	 * @see elearningmodel.ElearningmodelPackage#getMatricula_Recebe()
	 * @model required="true"
	 * @generated
	 */
	EList<Nota> getRecebe();

} // Matricula
