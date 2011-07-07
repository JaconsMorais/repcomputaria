/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel.impl;

import elearningmodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ElearningmodelFactoryImpl extends EFactoryImpl implements ElearningmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ElearningmodelFactory init() {
		try {
			ElearningmodelFactory theElearningmodelFactory = (ElearningmodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://elearningmodel/1.0"); 
			if (theElearningmodelFactory != null) {
				return theElearningmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ElearningmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElearningmodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ElearningmodelPackage.USUARIO: return createUsuario();
			case ElearningmodelPackage.PESSOA: return createPessoa();
			case ElearningmodelPackage.PROFESSOR: return createProfessor();
			case ElearningmodelPackage.ALUNO: return createAluno();
			case ElearningmodelPackage.DISCIPLINA: return createDisciplina();
			case ElearningmodelPackage.CRITERIO_AVALIACAO: return createCriterioAvaliacao();
			case ElearningmodelPackage.MATRICULA: return createMatricula();
			case ElearningmodelPackage.NOTA: return createNota();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Usuario createUsuario() {
		UsuarioImpl usuario = new UsuarioImpl();
		return usuario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pessoa createPessoa() {
		PessoaImpl pessoa = new PessoaImpl();
		return pessoa;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Professor createProfessor() {
		ProfessorImpl professor = new ProfessorImpl();
		return professor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aluno createAluno() {
		AlunoImpl aluno = new AlunoImpl();
		return aluno;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Disciplina createDisciplina() {
		DisciplinaImpl disciplina = new DisciplinaImpl();
		return disciplina;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CriterioAvaliacao createCriterioAvaliacao() {
		CriterioAvaliacaoImpl criterioAvaliacao = new CriterioAvaliacaoImpl();
		return criterioAvaliacao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Matricula createMatricula() {
		MatriculaImpl matricula = new MatriculaImpl();
		return matricula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Nota createNota() {
		NotaImpl nota = new NotaImpl();
		return nota;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElearningmodelPackage getElearningmodelPackage() {
		return (ElearningmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ElearningmodelPackage getPackage() {
		return ElearningmodelPackage.eINSTANCE;
	}

} //ElearningmodelFactoryImpl
