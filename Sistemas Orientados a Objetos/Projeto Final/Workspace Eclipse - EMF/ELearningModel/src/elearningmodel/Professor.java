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
 * A representation of the model object '<em><b>Professor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link elearningmodel.Professor#getLeciona <em>Leciona</em>}</li>
 * </ul>
 * </p>
 *
 * @see elearningmodel.ElearningmodelPackage#getProfessor()
 * @model
 * @generated
 */
public interface Professor extends Pessoa {
	/**
	 * Returns the value of the '<em><b>Leciona</b></em>' reference list.
	 * The list contents are of type {@link elearningmodel.Disciplina}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leciona</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leciona</em>' reference list.
	 * @see elearningmodel.ElearningmodelPackage#getProfessor_Leciona()
	 * @model
	 * @generated
	 */
	EList<Disciplina> getLeciona();

} // Professor
