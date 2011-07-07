/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aluno</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link elearningmodel.Aluno#getFaz <em>Faz</em>}</li>
 * </ul>
 * </p>
 *
 * @see elearningmodel.ElearningmodelPackage#getAluno()
 * @model
 * @generated
 */
public interface Aluno extends Pessoa {
	/**
	 * Returns the value of the '<em><b>Faz</b></em>' reference list.
	 * The list contents are of type {@link elearningmodel.Matricula}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Faz</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Faz</em>' reference list.
	 * @see elearningmodel.ElearningmodelPackage#getAluno_Faz()
	 * @model
	 * @generated
	 */
	EList<Matricula> getFaz();

} // Aluno
