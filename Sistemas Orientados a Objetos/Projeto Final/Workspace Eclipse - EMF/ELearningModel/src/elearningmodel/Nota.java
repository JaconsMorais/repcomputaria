/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel;

import java.math.BigInteger;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nota</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link elearningmodel.Nota#getIdNota <em>Id Nota</em>}</li>
 *   <li>{@link elearningmodel.Nota#getIdCriterioAvaliacao <em>Id Criterio Avaliacao</em>}</li>
 *   <li>{@link elearningmodel.Nota#getNotaCriterio <em>Nota Criterio</em>}</li>
 * </ul>
 * </p>
 *
 * @see elearningmodel.ElearningmodelPackage#getNota()
 * @model
 * @generated
 */
public interface Nota extends EObject {
	/**
	 * Returns the value of the '<em><b>Id Nota</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Nota</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Nota</em>' attribute.
	 * @see #setIdNota(Long)
	 * @see elearningmodel.ElearningmodelPackage#getNota_IdNota()
	 * @model
	 * @generated
	 */
	Long getIdNota();

	/**
	 * Sets the value of the '{@link elearningmodel.Nota#getIdNota <em>Id Nota</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Nota</em>' attribute.
	 * @see #getIdNota()
	 * @generated
	 */
	void setIdNota(Long value);

	/**
	 * Returns the value of the '<em><b>Id Criterio Avaliacao</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Criterio Avaliacao</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Criterio Avaliacao</em>' attribute.
	 * @see #setIdCriterioAvaliacao(BigInteger)
	 * @see elearningmodel.ElearningmodelPackage#getNota_IdCriterioAvaliacao()
	 * @model
	 * @generated
	 */
	BigInteger getIdCriterioAvaliacao();

	/**
	 * Sets the value of the '{@link elearningmodel.Nota#getIdCriterioAvaliacao <em>Id Criterio Avaliacao</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Criterio Avaliacao</em>' attribute.
	 * @see #getIdCriterioAvaliacao()
	 * @generated
	 */
	void setIdCriterioAvaliacao(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Nota Criterio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nota Criterio</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nota Criterio</em>' attribute.
	 * @see #setNotaCriterio(Double)
	 * @see elearningmodel.ElearningmodelPackage#getNota_NotaCriterio()
	 * @model
	 * @generated
	 */
	Double getNotaCriterio();

	/**
	 * Sets the value of the '{@link elearningmodel.Nota#getNotaCriterio <em>Nota Criterio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nota Criterio</em>' attribute.
	 * @see #getNotaCriterio()
	 * @generated
	 */
	void setNotaCriterio(Double value);

} // Nota
