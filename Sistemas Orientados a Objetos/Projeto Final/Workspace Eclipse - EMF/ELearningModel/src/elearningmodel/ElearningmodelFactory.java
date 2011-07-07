/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see elearningmodel.ElearningmodelPackage
 * @generated
 */
public interface ElearningmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ElearningmodelFactory eINSTANCE = elearningmodel.impl.ElearningmodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Usuario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Usuario</em>'.
	 * @generated
	 */
	Usuario createUsuario();

	/**
	 * Returns a new object of class '<em>Pessoa</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pessoa</em>'.
	 * @generated
	 */
	Pessoa createPessoa();

	/**
	 * Returns a new object of class '<em>Professor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Professor</em>'.
	 * @generated
	 */
	Professor createProfessor();

	/**
	 * Returns a new object of class '<em>Aluno</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aluno</em>'.
	 * @generated
	 */
	Aluno createAluno();

	/**
	 * Returns a new object of class '<em>Disciplina</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Disciplina</em>'.
	 * @generated
	 */
	Disciplina createDisciplina();

	/**
	 * Returns a new object of class '<em>Criterio Avaliacao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Criterio Avaliacao</em>'.
	 * @generated
	 */
	CriterioAvaliacao createCriterioAvaliacao();

	/**
	 * Returns a new object of class '<em>Matricula</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Matricula</em>'.
	 * @generated
	 */
	Matricula createMatricula();

	/**
	 * Returns a new object of class '<em>Nota</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Nota</em>'.
	 * @generated
	 */
	Nota createNota();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ElearningmodelPackage getElearningmodelPackage();

} //ElearningmodelFactory
