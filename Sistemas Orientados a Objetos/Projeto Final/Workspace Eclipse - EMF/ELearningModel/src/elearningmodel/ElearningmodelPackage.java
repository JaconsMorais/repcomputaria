/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see elearningmodel.ElearningmodelFactory
 * @model kind="package"
 * @generated
 */
public interface ElearningmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "elearningmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://elearningmodel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "elearningmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ElearningmodelPackage eINSTANCE = elearningmodel.impl.ElearningmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link elearningmodel.impl.ProfessorImpl <em>Professor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see elearningmodel.impl.ProfessorImpl
	 * @see elearningmodel.impl.ElearningmodelPackageImpl#getProfessor()
	 * @generated
	 */
	int PROFESSOR = 2;

	/**
	 * The meta object id for the '{@link elearningmodel.impl.PessoaImpl <em>Pessoa</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see elearningmodel.impl.PessoaImpl
	 * @see elearningmodel.impl.ElearningmodelPackageImpl#getPessoa()
	 * @generated
	 */
	int PESSOA = 1;

	/**
	 * The meta object id for the '{@link elearningmodel.impl.UsuarioImpl <em>Usuario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see elearningmodel.impl.UsuarioImpl
	 * @see elearningmodel.impl.ElearningmodelPackageImpl#getUsuario()
	 * @generated
	 */
	int USUARIO = 0;

	/**
	 * The feature id for the '<em><b>Id Usuario</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USUARIO__ID_USUARIO = 0;

	/**
	 * The feature id for the '<em><b>Login</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USUARIO__LOGIN = 1;

	/**
	 * The feature id for the '<em><b>Senha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USUARIO__SENHA = 2;

	/**
	 * The feature id for the '<em><b>Tipo Usuario</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USUARIO__TIPO_USUARIO = 3;

	/**
	 * The number of structural features of the '<em>Usuario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USUARIO_FEATURE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Id Usuario</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PESSOA__ID_USUARIO = USUARIO__ID_USUARIO;

	/**
	 * The feature id for the '<em><b>Login</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PESSOA__LOGIN = USUARIO__LOGIN;

	/**
	 * The feature id for the '<em><b>Senha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PESSOA__SENHA = USUARIO__SENHA;

	/**
	 * The feature id for the '<em><b>Tipo Usuario</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PESSOA__TIPO_USUARIO = USUARIO__TIPO_USUARIO;

	/**
	 * The feature id for the '<em><b>Endereco</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PESSOA__ENDERECO = USUARIO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Telefone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PESSOA__TELEFONE = USUARIO_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pessoa</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PESSOA_FEATURE_COUNT = USUARIO_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id Usuario</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR__ID_USUARIO = PESSOA__ID_USUARIO;

	/**
	 * The feature id for the '<em><b>Login</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR__LOGIN = PESSOA__LOGIN;

	/**
	 * The feature id for the '<em><b>Senha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR__SENHA = PESSOA__SENHA;

	/**
	 * The feature id for the '<em><b>Tipo Usuario</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR__TIPO_USUARIO = PESSOA__TIPO_USUARIO;

	/**
	 * The feature id for the '<em><b>Endereco</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR__ENDERECO = PESSOA__ENDERECO;

	/**
	 * The feature id for the '<em><b>Telefone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR__TELEFONE = PESSOA__TELEFONE;

	/**
	 * The feature id for the '<em><b>Leciona</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR__LECIONA = PESSOA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Professor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR_FEATURE_COUNT = PESSOA_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link elearningmodel.impl.AlunoImpl <em>Aluno</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see elearningmodel.impl.AlunoImpl
	 * @see elearningmodel.impl.ElearningmodelPackageImpl#getAluno()
	 * @generated
	 */
	int ALUNO = 3;

	/**
	 * The feature id for the '<em><b>Id Usuario</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALUNO__ID_USUARIO = PESSOA__ID_USUARIO;

	/**
	 * The feature id for the '<em><b>Login</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALUNO__LOGIN = PESSOA__LOGIN;

	/**
	 * The feature id for the '<em><b>Senha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALUNO__SENHA = PESSOA__SENHA;

	/**
	 * The feature id for the '<em><b>Tipo Usuario</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALUNO__TIPO_USUARIO = PESSOA__TIPO_USUARIO;

	/**
	 * The feature id for the '<em><b>Endereco</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALUNO__ENDERECO = PESSOA__ENDERECO;

	/**
	 * The feature id for the '<em><b>Telefone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALUNO__TELEFONE = PESSOA__TELEFONE;

	/**
	 * The feature id for the '<em><b>Faz</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALUNO__FAZ = PESSOA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Aluno</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALUNO_FEATURE_COUNT = PESSOA_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link elearningmodel.impl.DisciplinaImpl <em>Disciplina</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see elearningmodel.impl.DisciplinaImpl
	 * @see elearningmodel.impl.ElearningmodelPackageImpl#getDisciplina()
	 * @generated
	 */
	int DISCIPLINA = 4;

	/**
	 * The feature id for the '<em><b>Id Disciplina</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCIPLINA__ID_DISCIPLINA = 0;

	/**
	 * The feature id for the '<em><b>Id Professor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCIPLINA__ID_PROFESSOR = 1;

	/**
	 * The feature id for the '<em><b>Nome Disciplina</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCIPLINA__NOME_DISCIPLINA = 2;

	/**
	 * The feature id for the '<em><b>Num Notas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCIPLINA__NUM_NOTAS = 3;

	/**
	 * The feature id for the '<em><b>Possui</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCIPLINA__POSSUI = 4;

	/**
	 * The feature id for the '<em><b>Tem</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCIPLINA__TEM = 5;

	/**
	 * The feature id for the '<em><b>Data Inicio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCIPLINA__DATA_INICIO = 6;

	/**
	 * The feature id for the '<em><b>Data Fim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCIPLINA__DATA_FIM = 7;

	/**
	 * The number of structural features of the '<em>Disciplina</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCIPLINA_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link elearningmodel.impl.CriterioAvaliacaoImpl <em>Criterio Avaliacao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see elearningmodel.impl.CriterioAvaliacaoImpl
	 * @see elearningmodel.impl.ElearningmodelPackageImpl#getCriterioAvaliacao()
	 * @generated
	 */
	int CRITERIO_AVALIACAO = 5;

	/**
	 * The feature id for the '<em><b>Id Criterio Avaliacao</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIO_AVALIACAO__ID_CRITERIO_AVALIACAO = 0;

	/**
	 * The feature id for the '<em><b>Id Disciplina</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIO_AVALIACAO__ID_DISCIPLINA = 1;

	/**
	 * The feature id for the '<em><b>Nome</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIO_AVALIACAO__NOME = 2;

	/**
	 * The feature id for the '<em><b>Peso</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIO_AVALIACAO__PESO = 3;

	/**
	 * The feature id for the '<em><b>Esta em</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIO_AVALIACAO__ESTA_EM = 4;

	/**
	 * The number of structural features of the '<em>Criterio Avaliacao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIO_AVALIACAO_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link elearningmodel.impl.MatriculaImpl <em>Matricula</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see elearningmodel.impl.MatriculaImpl
	 * @see elearningmodel.impl.ElearningmodelPackageImpl#getMatricula()
	 * @generated
	 */
	int MATRICULA = 6;

	/**
	 * The feature id for the '<em><b>Id Matricula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRICULA__ID_MATRICULA = 0;

	/**
	 * The feature id for the '<em><b>Id Aluno</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRICULA__ID_ALUNO = 1;

	/**
	 * The feature id for the '<em><b>Id Disciplina</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRICULA__ID_DISCIPLINA = 2;

	/**
	 * The feature id for the '<em><b>Id Nota</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRICULA__ID_NOTA = 3;

	/**
	 * The feature id for the '<em><b>Nota Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRICULA__NOTA_FINAL = 4;

	/**
	 * The feature id for the '<em><b>Ganha</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRICULA__GANHA = 5;

	/**
	 * The feature id for the '<em><b>Recebe</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRICULA__RECEBE = 6;

	/**
	 * The number of structural features of the '<em>Matricula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRICULA_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link elearningmodel.impl.NotaImpl <em>Nota</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see elearningmodel.impl.NotaImpl
	 * @see elearningmodel.impl.ElearningmodelPackageImpl#getNota()
	 * @generated
	 */
	int NOTA = 7;

	/**
	 * The feature id for the '<em><b>Id Nota</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTA__ID_NOTA = 0;

	/**
	 * The feature id for the '<em><b>Id Criterio Avaliacao</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTA__ID_CRITERIO_AVALIACAO = 1;

	/**
	 * The feature id for the '<em><b>Nota Criterio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTA__NOTA_CRITERIO = 2;

	/**
	 * The number of structural features of the '<em>Nota</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTA_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link elearningmodel.Usuario <em>Usuario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Usuario</em>'.
	 * @see elearningmodel.Usuario
	 * @generated
	 */
	EClass getUsuario();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Usuario#getIdUsuario <em>Id Usuario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Usuario</em>'.
	 * @see elearningmodel.Usuario#getIdUsuario()
	 * @see #getUsuario()
	 * @generated
	 */
	EAttribute getUsuario_IdUsuario();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Usuario#getLogin <em>Login</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Login</em>'.
	 * @see elearningmodel.Usuario#getLogin()
	 * @see #getUsuario()
	 * @generated
	 */
	EAttribute getUsuario_Login();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Usuario#getSenha <em>Senha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Senha</em>'.
	 * @see elearningmodel.Usuario#getSenha()
	 * @see #getUsuario()
	 * @generated
	 */
	EAttribute getUsuario_Senha();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Usuario#getTipoUsuario <em>Tipo Usuario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tipo Usuario</em>'.
	 * @see elearningmodel.Usuario#getTipoUsuario()
	 * @see #getUsuario()
	 * @generated
	 */
	EAttribute getUsuario_TipoUsuario();

	/**
	 * Returns the meta object for class '{@link elearningmodel.Pessoa <em>Pessoa</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pessoa</em>'.
	 * @see elearningmodel.Pessoa
	 * @generated
	 */
	EClass getPessoa();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Pessoa#getEndereco <em>Endereco</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Endereco</em>'.
	 * @see elearningmodel.Pessoa#getEndereco()
	 * @see #getPessoa()
	 * @generated
	 */
	EAttribute getPessoa_Endereco();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Pessoa#getTelefone <em>Telefone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Telefone</em>'.
	 * @see elearningmodel.Pessoa#getTelefone()
	 * @see #getPessoa()
	 * @generated
	 */
	EAttribute getPessoa_Telefone();

	/**
	 * Returns the meta object for class '{@link elearningmodel.Professor <em>Professor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Professor</em>'.
	 * @see elearningmodel.Professor
	 * @generated
	 */
	EClass getProfessor();

	/**
	 * Returns the meta object for the reference list '{@link elearningmodel.Professor#getLeciona <em>Leciona</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Leciona</em>'.
	 * @see elearningmodel.Professor#getLeciona()
	 * @see #getProfessor()
	 * @generated
	 */
	EReference getProfessor_Leciona();

	/**
	 * Returns the meta object for class '{@link elearningmodel.Aluno <em>Aluno</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aluno</em>'.
	 * @see elearningmodel.Aluno
	 * @generated
	 */
	EClass getAluno();

	/**
	 * Returns the meta object for the reference list '{@link elearningmodel.Aluno#getFaz <em>Faz</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Faz</em>'.
	 * @see elearningmodel.Aluno#getFaz()
	 * @see #getAluno()
	 * @generated
	 */
	EReference getAluno_Faz();

	/**
	 * Returns the meta object for class '{@link elearningmodel.Disciplina <em>Disciplina</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disciplina</em>'.
	 * @see elearningmodel.Disciplina
	 * @generated
	 */
	EClass getDisciplina();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Disciplina#getIdDisciplina <em>Id Disciplina</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Disciplina</em>'.
	 * @see elearningmodel.Disciplina#getIdDisciplina()
	 * @see #getDisciplina()
	 * @generated
	 */
	EAttribute getDisciplina_IdDisciplina();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Disciplina#getIdProfessor <em>Id Professor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Professor</em>'.
	 * @see elearningmodel.Disciplina#getIdProfessor()
	 * @see #getDisciplina()
	 * @generated
	 */
	EAttribute getDisciplina_IdProfessor();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Disciplina#getNomeDisciplina <em>Nome Disciplina</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nome Disciplina</em>'.
	 * @see elearningmodel.Disciplina#getNomeDisciplina()
	 * @see #getDisciplina()
	 * @generated
	 */
	EAttribute getDisciplina_NomeDisciplina();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Disciplina#getNumNotas <em>Num Notas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Notas</em>'.
	 * @see elearningmodel.Disciplina#getNumNotas()
	 * @see #getDisciplina()
	 * @generated
	 */
	EAttribute getDisciplina_NumNotas();

	/**
	 * Returns the meta object for the reference list '{@link elearningmodel.Disciplina#getPossui <em>Possui</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Possui</em>'.
	 * @see elearningmodel.Disciplina#getPossui()
	 * @see #getDisciplina()
	 * @generated
	 */
	EReference getDisciplina_Possui();

	/**
	 * Returns the meta object for the reference list '{@link elearningmodel.Disciplina#getTem <em>Tem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tem</em>'.
	 * @see elearningmodel.Disciplina#getTem()
	 * @see #getDisciplina()
	 * @generated
	 */
	EReference getDisciplina_Tem();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Disciplina#getDataInicio <em>Data Inicio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Inicio</em>'.
	 * @see elearningmodel.Disciplina#getDataInicio()
	 * @see #getDisciplina()
	 * @generated
	 */
	EAttribute getDisciplina_DataInicio();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Disciplina#getDataFim <em>Data Fim</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Fim</em>'.
	 * @see elearningmodel.Disciplina#getDataFim()
	 * @see #getDisciplina()
	 * @generated
	 */
	EAttribute getDisciplina_DataFim();

	/**
	 * Returns the meta object for class '{@link elearningmodel.CriterioAvaliacao <em>Criterio Avaliacao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Criterio Avaliacao</em>'.
	 * @see elearningmodel.CriterioAvaliacao
	 * @generated
	 */
	EClass getCriterioAvaliacao();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.CriterioAvaliacao#getIdCriterioAvaliacao <em>Id Criterio Avaliacao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Criterio Avaliacao</em>'.
	 * @see elearningmodel.CriterioAvaliacao#getIdCriterioAvaliacao()
	 * @see #getCriterioAvaliacao()
	 * @generated
	 */
	EAttribute getCriterioAvaliacao_IdCriterioAvaliacao();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.CriterioAvaliacao#getIdDisciplina <em>Id Disciplina</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Disciplina</em>'.
	 * @see elearningmodel.CriterioAvaliacao#getIdDisciplina()
	 * @see #getCriterioAvaliacao()
	 * @generated
	 */
	EAttribute getCriterioAvaliacao_IdDisciplina();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.CriterioAvaliacao#getNome <em>Nome</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nome</em>'.
	 * @see elearningmodel.CriterioAvaliacao#getNome()
	 * @see #getCriterioAvaliacao()
	 * @generated
	 */
	EAttribute getCriterioAvaliacao_Nome();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.CriterioAvaliacao#getPeso <em>Peso</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Peso</em>'.
	 * @see elearningmodel.CriterioAvaliacao#getPeso()
	 * @see #getCriterioAvaliacao()
	 * @generated
	 */
	EAttribute getCriterioAvaliacao_Peso();

	/**
	 * Returns the meta object for the reference '{@link elearningmodel.CriterioAvaliacao#getEsta_em <em>Esta em</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Esta em</em>'.
	 * @see elearningmodel.CriterioAvaliacao#getEsta_em()
	 * @see #getCriterioAvaliacao()
	 * @generated
	 */
	EReference getCriterioAvaliacao_Esta_em();

	/**
	 * Returns the meta object for class '{@link elearningmodel.Matricula <em>Matricula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Matricula</em>'.
	 * @see elearningmodel.Matricula
	 * @generated
	 */
	EClass getMatricula();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Matricula#getIdMatricula <em>Id Matricula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Matricula</em>'.
	 * @see elearningmodel.Matricula#getIdMatricula()
	 * @see #getMatricula()
	 * @generated
	 */
	EAttribute getMatricula_IdMatricula();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Matricula#getIdAluno <em>Id Aluno</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Aluno</em>'.
	 * @see elearningmodel.Matricula#getIdAluno()
	 * @see #getMatricula()
	 * @generated
	 */
	EAttribute getMatricula_IdAluno();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Matricula#getIdDisciplina <em>Id Disciplina</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Disciplina</em>'.
	 * @see elearningmodel.Matricula#getIdDisciplina()
	 * @see #getMatricula()
	 * @generated
	 */
	EAttribute getMatricula_IdDisciplina();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Matricula#getIdNota <em>Id Nota</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Nota</em>'.
	 * @see elearningmodel.Matricula#getIdNota()
	 * @see #getMatricula()
	 * @generated
	 */
	EAttribute getMatricula_IdNota();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Matricula#getNotaFinal <em>Nota Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nota Final</em>'.
	 * @see elearningmodel.Matricula#getNotaFinal()
	 * @see #getMatricula()
	 * @generated
	 */
	EAttribute getMatricula_NotaFinal();

	/**
	 * Returns the meta object for the reference list '{@link elearningmodel.Matricula#getGanha <em>Ganha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ganha</em>'.
	 * @see elearningmodel.Matricula#getGanha()
	 * @see #getMatricula()
	 * @generated
	 */
	EReference getMatricula_Ganha();

	/**
	 * Returns the meta object for the reference list '{@link elearningmodel.Matricula#getRecebe <em>Recebe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Recebe</em>'.
	 * @see elearningmodel.Matricula#getRecebe()
	 * @see #getMatricula()
	 * @generated
	 */
	EReference getMatricula_Recebe();

	/**
	 * Returns the meta object for class '{@link elearningmodel.Nota <em>Nota</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nota</em>'.
	 * @see elearningmodel.Nota
	 * @generated
	 */
	EClass getNota();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Nota#getIdNota <em>Id Nota</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Nota</em>'.
	 * @see elearningmodel.Nota#getIdNota()
	 * @see #getNota()
	 * @generated
	 */
	EAttribute getNota_IdNota();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Nota#getIdCriterioAvaliacao <em>Id Criterio Avaliacao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Criterio Avaliacao</em>'.
	 * @see elearningmodel.Nota#getIdCriterioAvaliacao()
	 * @see #getNota()
	 * @generated
	 */
	EAttribute getNota_IdCriterioAvaliacao();

	/**
	 * Returns the meta object for the attribute '{@link elearningmodel.Nota#getNotaCriterio <em>Nota Criterio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nota Criterio</em>'.
	 * @see elearningmodel.Nota#getNotaCriterio()
	 * @see #getNota()
	 * @generated
	 */
	EAttribute getNota_NotaCriterio();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ElearningmodelFactory getElearningmodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link elearningmodel.impl.UsuarioImpl <em>Usuario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see elearningmodel.impl.UsuarioImpl
		 * @see elearningmodel.impl.ElearningmodelPackageImpl#getUsuario()
		 * @generated
		 */
		EClass USUARIO = eINSTANCE.getUsuario();

		/**
		 * The meta object literal for the '<em><b>Id Usuario</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USUARIO__ID_USUARIO = eINSTANCE.getUsuario_IdUsuario();

		/**
		 * The meta object literal for the '<em><b>Login</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USUARIO__LOGIN = eINSTANCE.getUsuario_Login();

		/**
		 * The meta object literal for the '<em><b>Senha</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USUARIO__SENHA = eINSTANCE.getUsuario_Senha();

		/**
		 * The meta object literal for the '<em><b>Tipo Usuario</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USUARIO__TIPO_USUARIO = eINSTANCE.getUsuario_TipoUsuario();

		/**
		 * The meta object literal for the '{@link elearningmodel.impl.PessoaImpl <em>Pessoa</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see elearningmodel.impl.PessoaImpl
		 * @see elearningmodel.impl.ElearningmodelPackageImpl#getPessoa()
		 * @generated
		 */
		EClass PESSOA = eINSTANCE.getPessoa();

		/**
		 * The meta object literal for the '<em><b>Endereco</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PESSOA__ENDERECO = eINSTANCE.getPessoa_Endereco();

		/**
		 * The meta object literal for the '<em><b>Telefone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PESSOA__TELEFONE = eINSTANCE.getPessoa_Telefone();

		/**
		 * The meta object literal for the '{@link elearningmodel.impl.ProfessorImpl <em>Professor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see elearningmodel.impl.ProfessorImpl
		 * @see elearningmodel.impl.ElearningmodelPackageImpl#getProfessor()
		 * @generated
		 */
		EClass PROFESSOR = eINSTANCE.getProfessor();

		/**
		 * The meta object literal for the '<em><b>Leciona</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFESSOR__LECIONA = eINSTANCE.getProfessor_Leciona();

		/**
		 * The meta object literal for the '{@link elearningmodel.impl.AlunoImpl <em>Aluno</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see elearningmodel.impl.AlunoImpl
		 * @see elearningmodel.impl.ElearningmodelPackageImpl#getAluno()
		 * @generated
		 */
		EClass ALUNO = eINSTANCE.getAluno();

		/**
		 * The meta object literal for the '<em><b>Faz</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALUNO__FAZ = eINSTANCE.getAluno_Faz();

		/**
		 * The meta object literal for the '{@link elearningmodel.impl.DisciplinaImpl <em>Disciplina</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see elearningmodel.impl.DisciplinaImpl
		 * @see elearningmodel.impl.ElearningmodelPackageImpl#getDisciplina()
		 * @generated
		 */
		EClass DISCIPLINA = eINSTANCE.getDisciplina();

		/**
		 * The meta object literal for the '<em><b>Id Disciplina</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISCIPLINA__ID_DISCIPLINA = eINSTANCE.getDisciplina_IdDisciplina();

		/**
		 * The meta object literal for the '<em><b>Id Professor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISCIPLINA__ID_PROFESSOR = eINSTANCE.getDisciplina_IdProfessor();

		/**
		 * The meta object literal for the '<em><b>Nome Disciplina</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISCIPLINA__NOME_DISCIPLINA = eINSTANCE.getDisciplina_NomeDisciplina();

		/**
		 * The meta object literal for the '<em><b>Num Notas</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISCIPLINA__NUM_NOTAS = eINSTANCE.getDisciplina_NumNotas();

		/**
		 * The meta object literal for the '<em><b>Possui</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISCIPLINA__POSSUI = eINSTANCE.getDisciplina_Possui();

		/**
		 * The meta object literal for the '<em><b>Tem</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISCIPLINA__TEM = eINSTANCE.getDisciplina_Tem();

		/**
		 * The meta object literal for the '<em><b>Data Inicio</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISCIPLINA__DATA_INICIO = eINSTANCE.getDisciplina_DataInicio();

		/**
		 * The meta object literal for the '<em><b>Data Fim</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISCIPLINA__DATA_FIM = eINSTANCE.getDisciplina_DataFim();

		/**
		 * The meta object literal for the '{@link elearningmodel.impl.CriterioAvaliacaoImpl <em>Criterio Avaliacao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see elearningmodel.impl.CriterioAvaliacaoImpl
		 * @see elearningmodel.impl.ElearningmodelPackageImpl#getCriterioAvaliacao()
		 * @generated
		 */
		EClass CRITERIO_AVALIACAO = eINSTANCE.getCriterioAvaliacao();

		/**
		 * The meta object literal for the '<em><b>Id Criterio Avaliacao</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CRITERIO_AVALIACAO__ID_CRITERIO_AVALIACAO = eINSTANCE.getCriterioAvaliacao_IdCriterioAvaliacao();

		/**
		 * The meta object literal for the '<em><b>Id Disciplina</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CRITERIO_AVALIACAO__ID_DISCIPLINA = eINSTANCE.getCriterioAvaliacao_IdDisciplina();

		/**
		 * The meta object literal for the '<em><b>Nome</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CRITERIO_AVALIACAO__NOME = eINSTANCE.getCriterioAvaliacao_Nome();

		/**
		 * The meta object literal for the '<em><b>Peso</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CRITERIO_AVALIACAO__PESO = eINSTANCE.getCriterioAvaliacao_Peso();

		/**
		 * The meta object literal for the '<em><b>Esta em</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CRITERIO_AVALIACAO__ESTA_EM = eINSTANCE.getCriterioAvaliacao_Esta_em();

		/**
		 * The meta object literal for the '{@link elearningmodel.impl.MatriculaImpl <em>Matricula</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see elearningmodel.impl.MatriculaImpl
		 * @see elearningmodel.impl.ElearningmodelPackageImpl#getMatricula()
		 * @generated
		 */
		EClass MATRICULA = eINSTANCE.getMatricula();

		/**
		 * The meta object literal for the '<em><b>Id Matricula</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATRICULA__ID_MATRICULA = eINSTANCE.getMatricula_IdMatricula();

		/**
		 * The meta object literal for the '<em><b>Id Aluno</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATRICULA__ID_ALUNO = eINSTANCE.getMatricula_IdAluno();

		/**
		 * The meta object literal for the '<em><b>Id Disciplina</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATRICULA__ID_DISCIPLINA = eINSTANCE.getMatricula_IdDisciplina();

		/**
		 * The meta object literal for the '<em><b>Id Nota</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATRICULA__ID_NOTA = eINSTANCE.getMatricula_IdNota();

		/**
		 * The meta object literal for the '<em><b>Nota Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATRICULA__NOTA_FINAL = eINSTANCE.getMatricula_NotaFinal();

		/**
		 * The meta object literal for the '<em><b>Ganha</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATRICULA__GANHA = eINSTANCE.getMatricula_Ganha();

		/**
		 * The meta object literal for the '<em><b>Recebe</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATRICULA__RECEBE = eINSTANCE.getMatricula_Recebe();

		/**
		 * The meta object literal for the '{@link elearningmodel.impl.NotaImpl <em>Nota</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see elearningmodel.impl.NotaImpl
		 * @see elearningmodel.impl.ElearningmodelPackageImpl#getNota()
		 * @generated
		 */
		EClass NOTA = eINSTANCE.getNota();

		/**
		 * The meta object literal for the '<em><b>Id Nota</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTA__ID_NOTA = eINSTANCE.getNota_IdNota();

		/**
		 * The meta object literal for the '<em><b>Id Criterio Avaliacao</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTA__ID_CRITERIO_AVALIACAO = eINSTANCE.getNota_IdCriterioAvaliacao();

		/**
		 * The meta object literal for the '<em><b>Nota Criterio</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTA__NOTA_CRITERIO = eINSTANCE.getNota_NotaCriterio();

	}

} //ElearningmodelPackage
