/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel;

import java.math.BigInteger;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Disciplina</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link elearningmodel.Disciplina#getIdDisciplina <em>Id Disciplina</em>}</li>
 *   <li>{@link elearningmodel.Disciplina#getIdProfessor <em>Id Professor</em>}</li>
 *   <li>{@link elearningmodel.Disciplina#getNomeDisciplina <em>Nome Disciplina</em>}</li>
 *   <li>{@link elearningmodel.Disciplina#getNumNotas <em>Num Notas</em>}</li>
 *   <li>{@link elearningmodel.Disciplina#getPossui <em>Possui</em>}</li>
 *   <li>{@link elearningmodel.Disciplina#getTem <em>Tem</em>}</li>
 *   <li>{@link elearningmodel.Disciplina#getDataInicio <em>Data Inicio</em>}</li>
 *   <li>{@link elearningmodel.Disciplina#getDataFim <em>Data Fim</em>}</li>
 * </ul>
 * </p>
 *
 * @see elearningmodel.ElearningmodelPackage#getDisciplina()
 * @model
 * @generated
 */
public interface Disciplina extends EObject {
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
	 * @see elearningmodel.ElearningmodelPackage#getDisciplina_IdDisciplina()
	 * @model
	 * @generated
	 */
	Long getIdDisciplina();

	/**
	 * Sets the value of the '{@link elearningmodel.Disciplina#getIdDisciplina <em>Id Disciplina</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Disciplina</em>' attribute.
	 * @see #getIdDisciplina()
	 * @generated
	 */
	void setIdDisciplina(Long value);

	/**
	 * Returns the value of the '<em><b>Id Professor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Professor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Professor</em>' attribute.
	 * @see #setIdProfessor(Long)
	 * @see elearningmodel.ElearningmodelPackage#getDisciplina_IdProfessor()
	 * @model
	 * @generated
	 */
	Long getIdProfessor();

	/**
	 * Sets the value of the '{@link elearningmodel.Disciplina#getIdProfessor <em>Id Professor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Professor</em>' attribute.
	 * @see #getIdProfessor()
	 * @generated
	 */
	void setIdProfessor(Long value);

	/**
	 * Returns the value of the '<em><b>Nome Disciplina</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nome Disciplina</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nome Disciplina</em>' attribute.
	 * @see #setNomeDisciplina(String)
	 * @see elearningmodel.ElearningmodelPackage#getDisciplina_NomeDisciplina()
	 * @model
	 * @generated
	 */
	String getNomeDisciplina();

	/**
	 * Sets the value of the '{@link elearningmodel.Disciplina#getNomeDisciplina <em>Nome Disciplina</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nome Disciplina</em>' attribute.
	 * @see #getNomeDisciplina()
	 * @generated
	 */
	void setNomeDisciplina(String value);

	/**
	 * Returns the value of the '<em><b>Num Notas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Notas</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Notas</em>' attribute.
	 * @see #setNumNotas(Integer)
	 * @see elearningmodel.ElearningmodelPackage#getDisciplina_NumNotas()
	 * @model
	 * @generated
	 */
	Integer getNumNotas();

	/**
	 * Sets the value of the '{@link elearningmodel.Disciplina#getNumNotas <em>Num Notas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Notas</em>' attribute.
	 * @see #getNumNotas()
	 * @generated
	 */
	void setNumNotas(Integer value);

	/**
	 * Returns the value of the '<em><b>Possui</b></em>' reference list.
	 * The list contents are of type {@link elearningmodel.CriterioAvaliacao}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Possui</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Possui</em>' reference list.
	 * @see elearningmodel.ElearningmodelPackage#getDisciplina_Possui()
	 * @model required="true"
	 * @generated
	 */
	EList<CriterioAvaliacao> getPossui();

	/**
	 * Returns the value of the '<em><b>Tem</b></em>' reference list.
	 * The list contents are of type {@link elearningmodel.Matricula}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tem</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tem</em>' reference list.
	 * @see elearningmodel.ElearningmodelPackage#getDisciplina_Tem()
	 * @model
	 * @generated
	 */
	EList<Matricula> getTem();

	/**
	 * Returns the value of the '<em><b>Data Inicio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Inicio</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Inicio</em>' attribute.
	 * @see #setDataInicio(Date)
	 * @see elearningmodel.ElearningmodelPackage#getDisciplina_DataInicio()
	 * @model
	 * @generated
	 */
	Date getDataInicio();

	/**
	 * Sets the value of the '{@link elearningmodel.Disciplina#getDataInicio <em>Data Inicio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Inicio</em>' attribute.
	 * @see #getDataInicio()
	 * @generated
	 */
	void setDataInicio(Date value);

	/**
	 * Returns the value of the '<em><b>Data Fim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Fim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Fim</em>' attribute.
	 * @see #setDataFim(Date)
	 * @see elearningmodel.ElearningmodelPackage#getDisciplina_DataFim()
	 * @model
	 * @generated
	 */
	Date getDataFim();

	/**
	 * Sets the value of the '{@link elearningmodel.Disciplina#getDataFim <em>Data Fim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Fim</em>' attribute.
	 * @see #getDataFim()
	 * @generated
	 */
	void setDataFim(Date value);

} // Disciplina
