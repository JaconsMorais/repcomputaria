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
 * A representation of the model object '<em><b>Criterio Avaliacao</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link elearningmodel.CriterioAvaliacao#getIdCriterioAvaliacao <em>Id Criterio Avaliacao</em>}</li>
 *   <li>{@link elearningmodel.CriterioAvaliacao#getIdDisciplina <em>Id Disciplina</em>}</li>
 *   <li>{@link elearningmodel.CriterioAvaliacao#getNome <em>Nome</em>}</li>
 *   <li>{@link elearningmodel.CriterioAvaliacao#getPeso <em>Peso</em>}</li>
 *   <li>{@link elearningmodel.CriterioAvaliacao#getEsta_em <em>Esta em</em>}</li>
 * </ul>
 * </p>
 *
 * @see elearningmodel.ElearningmodelPackage#getCriterioAvaliacao()
 * @model
 * @generated
 */
public interface CriterioAvaliacao extends EObject {
	/**
	 * Returns the value of the '<em><b>Id Criterio Avaliacao</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Criterio Avaliacao</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Criterio Avaliacao</em>' attribute.
	 * @see #setIdCriterioAvaliacao(Long)
	 * @see elearningmodel.ElearningmodelPackage#getCriterioAvaliacao_IdCriterioAvaliacao()
	 * @model
	 * @generated
	 */
	Long getIdCriterioAvaliacao();

	/**
	 * Sets the value of the '{@link elearningmodel.CriterioAvaliacao#getIdCriterioAvaliacao <em>Id Criterio Avaliacao</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Criterio Avaliacao</em>' attribute.
	 * @see #getIdCriterioAvaliacao()
	 * @generated
	 */
	void setIdCriterioAvaliacao(Long value);

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
	 * @see elearningmodel.ElearningmodelPackage#getCriterioAvaliacao_IdDisciplina()
	 * @model
	 * @generated
	 */
	Long getIdDisciplina();

	/**
	 * Sets the value of the '{@link elearningmodel.CriterioAvaliacao#getIdDisciplina <em>Id Disciplina</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Disciplina</em>' attribute.
	 * @see #getIdDisciplina()
	 * @generated
	 */
	void setIdDisciplina(Long value);

	/**
	 * Returns the value of the '<em><b>Nome</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nome</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nome</em>' attribute.
	 * @see #setNome(String)
	 * @see elearningmodel.ElearningmodelPackage#getCriterioAvaliacao_Nome()
	 * @model
	 * @generated
	 */
	String getNome();

	/**
	 * Sets the value of the '{@link elearningmodel.CriterioAvaliacao#getNome <em>Nome</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nome</em>' attribute.
	 * @see #getNome()
	 * @generated
	 */
	void setNome(String value);

	/**
	 * Returns the value of the '<em><b>Peso</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Peso</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Peso</em>' attribute.
	 * @see #setPeso(Integer)
	 * @see elearningmodel.ElearningmodelPackage#getCriterioAvaliacao_Peso()
	 * @model
	 * @generated
	 */
	Integer getPeso();

	/**
	 * Sets the value of the '{@link elearningmodel.CriterioAvaliacao#getPeso <em>Peso</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Peso</em>' attribute.
	 * @see #getPeso()
	 * @generated
	 */
	void setPeso(Integer value);

	/**
	 * Returns the value of the '<em><b>Esta em</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Esta em</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Esta em</em>' reference.
	 * @see #setEsta_em(Nota)
	 * @see elearningmodel.ElearningmodelPackage#getCriterioAvaliacao_Esta_em()
	 * @model required="true"
	 * @generated
	 */
	Nota getEsta_em();

	/**
	 * Sets the value of the '{@link elearningmodel.CriterioAvaliacao#getEsta_em <em>Esta em</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Esta em</em>' reference.
	 * @see #getEsta_em()
	 * @generated
	 */
	void setEsta_em(Nota value);

} // CriterioAvaliacao
