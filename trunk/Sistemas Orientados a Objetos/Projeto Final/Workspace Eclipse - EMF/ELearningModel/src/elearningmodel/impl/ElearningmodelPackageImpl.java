/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel.impl;

import elearningmodel.Aluno;
import elearningmodel.CriterioAvaliacao;
import elearningmodel.Disciplina;
import elearningmodel.ElearningmodelFactory;
import elearningmodel.ElearningmodelPackage;
import elearningmodel.Matricula;
import elearningmodel.Nota;
import elearningmodel.Pessoa;
import elearningmodel.Professor;
import elearningmodel.Usuario;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ElearningmodelPackageImpl extends EPackageImpl implements ElearningmodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass usuarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pessoaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass professorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alunoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass disciplinaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass criterioAvaliacaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matriculaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notaEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see elearningmodel.ElearningmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ElearningmodelPackageImpl() {
		super(eNS_URI, ElearningmodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ElearningmodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ElearningmodelPackage init() {
		if (isInited) return (ElearningmodelPackage)EPackage.Registry.INSTANCE.getEPackage(ElearningmodelPackage.eNS_URI);

		// Obtain or create and register package
		ElearningmodelPackageImpl theElearningmodelPackage = (ElearningmodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ElearningmodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ElearningmodelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theElearningmodelPackage.createPackageContents();

		// Initialize created meta-data
		theElearningmodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theElearningmodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ElearningmodelPackage.eNS_URI, theElearningmodelPackage);
		return theElearningmodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUsuario() {
		return usuarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUsuario_IdUsuario() {
		return (EAttribute)usuarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUsuario_Login() {
		return (EAttribute)usuarioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUsuario_Senha() {
		return (EAttribute)usuarioEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUsuario_TipoUsuario() {
		return (EAttribute)usuarioEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPessoa() {
		return pessoaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPessoa_Endereco() {
		return (EAttribute)pessoaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPessoa_Telefone() {
		return (EAttribute)pessoaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProfessor() {
		return professorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProfessor_Leciona() {
		return (EReference)professorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAluno() {
		return alunoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAluno_Faz() {
		return (EReference)alunoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDisciplina() {
		return disciplinaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDisciplina_IdDisciplina() {
		return (EAttribute)disciplinaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDisciplina_IdProfessor() {
		return (EAttribute)disciplinaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDisciplina_NomeDisciplina() {
		return (EAttribute)disciplinaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDisciplina_NumNotas() {
		return (EAttribute)disciplinaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDisciplina_Possui() {
		return (EReference)disciplinaEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDisciplina_Tem() {
		return (EReference)disciplinaEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDisciplina_DataInicio() {
		return (EAttribute)disciplinaEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDisciplina_DataFim() {
		return (EAttribute)disciplinaEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCriterioAvaliacao() {
		return criterioAvaliacaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCriterioAvaliacao_IdCriterioAvaliacao() {
		return (EAttribute)criterioAvaliacaoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCriterioAvaliacao_IdDisciplina() {
		return (EAttribute)criterioAvaliacaoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCriterioAvaliacao_Nome() {
		return (EAttribute)criterioAvaliacaoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCriterioAvaliacao_Peso() {
		return (EAttribute)criterioAvaliacaoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCriterioAvaliacao_Esta_em() {
		return (EReference)criterioAvaliacaoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatricula() {
		return matriculaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatricula_IdMatricula() {
		return (EAttribute)matriculaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatricula_IdAluno() {
		return (EAttribute)matriculaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatricula_IdDisciplina() {
		return (EAttribute)matriculaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatricula_IdNota() {
		return (EAttribute)matriculaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatricula_NotaFinal() {
		return (EAttribute)matriculaEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatricula_Ganha() {
		return (EReference)matriculaEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatricula_Recebe() {
		return (EReference)matriculaEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNota() {
		return notaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNota_IdNota() {
		return (EAttribute)notaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNota_IdCriterioAvaliacao() {
		return (EAttribute)notaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNota_NotaCriterio() {
		return (EAttribute)notaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElearningmodelFactory getElearningmodelFactory() {
		return (ElearningmodelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		usuarioEClass = createEClass(USUARIO);
		createEAttribute(usuarioEClass, USUARIO__ID_USUARIO);
		createEAttribute(usuarioEClass, USUARIO__LOGIN);
		createEAttribute(usuarioEClass, USUARIO__SENHA);
		createEAttribute(usuarioEClass, USUARIO__TIPO_USUARIO);

		pessoaEClass = createEClass(PESSOA);
		createEAttribute(pessoaEClass, PESSOA__ENDERECO);
		createEAttribute(pessoaEClass, PESSOA__TELEFONE);

		professorEClass = createEClass(PROFESSOR);
		createEReference(professorEClass, PROFESSOR__LECIONA);

		alunoEClass = createEClass(ALUNO);
		createEReference(alunoEClass, ALUNO__FAZ);

		disciplinaEClass = createEClass(DISCIPLINA);
		createEAttribute(disciplinaEClass, DISCIPLINA__ID_DISCIPLINA);
		createEAttribute(disciplinaEClass, DISCIPLINA__ID_PROFESSOR);
		createEAttribute(disciplinaEClass, DISCIPLINA__NOME_DISCIPLINA);
		createEAttribute(disciplinaEClass, DISCIPLINA__NUM_NOTAS);
		createEReference(disciplinaEClass, DISCIPLINA__POSSUI);
		createEReference(disciplinaEClass, DISCIPLINA__TEM);
		createEAttribute(disciplinaEClass, DISCIPLINA__DATA_INICIO);
		createEAttribute(disciplinaEClass, DISCIPLINA__DATA_FIM);

		criterioAvaliacaoEClass = createEClass(CRITERIO_AVALIACAO);
		createEAttribute(criterioAvaliacaoEClass, CRITERIO_AVALIACAO__ID_CRITERIO_AVALIACAO);
		createEAttribute(criterioAvaliacaoEClass, CRITERIO_AVALIACAO__ID_DISCIPLINA);
		createEAttribute(criterioAvaliacaoEClass, CRITERIO_AVALIACAO__NOME);
		createEAttribute(criterioAvaliacaoEClass, CRITERIO_AVALIACAO__PESO);
		createEReference(criterioAvaliacaoEClass, CRITERIO_AVALIACAO__ESTA_EM);

		matriculaEClass = createEClass(MATRICULA);
		createEAttribute(matriculaEClass, MATRICULA__ID_MATRICULA);
		createEAttribute(matriculaEClass, MATRICULA__ID_ALUNO);
		createEAttribute(matriculaEClass, MATRICULA__ID_DISCIPLINA);
		createEAttribute(matriculaEClass, MATRICULA__ID_NOTA);
		createEAttribute(matriculaEClass, MATRICULA__NOTA_FINAL);
		createEReference(matriculaEClass, MATRICULA__GANHA);
		createEReference(matriculaEClass, MATRICULA__RECEBE);

		notaEClass = createEClass(NOTA);
		createEAttribute(notaEClass, NOTA__ID_NOTA);
		createEAttribute(notaEClass, NOTA__ID_CRITERIO_AVALIACAO);
		createEAttribute(notaEClass, NOTA__NOTA_CRITERIO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		pessoaEClass.getESuperTypes().add(this.getUsuario());
		professorEClass.getESuperTypes().add(this.getPessoa());
		alunoEClass.getESuperTypes().add(this.getPessoa());

		// Initialize classes and features; add operations and parameters
		initEClass(usuarioEClass, Usuario.class, "Usuario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUsuario_IdUsuario(), ecorePackage.getEBigInteger(), "idUsuario", null, 0, 1, Usuario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUsuario_Login(), ecorePackage.getEString(), "login", null, 0, 1, Usuario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUsuario_Senha(), ecorePackage.getEString(), "senha", null, 0, 1, Usuario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUsuario_TipoUsuario(), ecorePackage.getEIntegerObject(), "tipoUsuario", null, 0, 1, Usuario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pessoaEClass, Pessoa.class, "Pessoa", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPessoa_Endereco(), ecorePackage.getEString(), "endereco", null, 0, 1, Pessoa.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPessoa_Telefone(), ecorePackage.getEString(), "telefone", null, 0, 1, Pessoa.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(professorEClass, Professor.class, "Professor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProfessor_Leciona(), this.getDisciplina(), null, "Leciona", null, 0, -1, Professor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(alunoEClass, Aluno.class, "Aluno", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAluno_Faz(), this.getMatricula(), null, "Faz", null, 0, -1, Aluno.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(disciplinaEClass, Disciplina.class, "Disciplina", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDisciplina_IdDisciplina(), ecorePackage.getELongObject(), "idDisciplina", null, 0, 1, Disciplina.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDisciplina_IdProfessor(), ecorePackage.getELongObject(), "idProfessor", null, 0, 1, Disciplina.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDisciplina_NomeDisciplina(), ecorePackage.getEString(), "nomeDisciplina", null, 0, 1, Disciplina.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDisciplina_NumNotas(), ecorePackage.getEIntegerObject(), "numNotas", null, 0, 1, Disciplina.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDisciplina_Possui(), this.getCriterioAvaliacao(), null, "Possui", null, 1, -1, Disciplina.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDisciplina_Tem(), this.getMatricula(), null, "Tem", null, 0, -1, Disciplina.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDisciplina_DataInicio(), ecorePackage.getEDate(), "dataInicio", null, 0, 1, Disciplina.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDisciplina_DataFim(), ecorePackage.getEDate(), "dataFim", null, 0, 1, Disciplina.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(criterioAvaliacaoEClass, CriterioAvaliacao.class, "CriterioAvaliacao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCriterioAvaliacao_IdCriterioAvaliacao(), ecorePackage.getELongObject(), "idCriterioAvaliacao", null, 0, 1, CriterioAvaliacao.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCriterioAvaliacao_IdDisciplina(), ecorePackage.getELongObject(), "idDisciplina", null, 0, 1, CriterioAvaliacao.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCriterioAvaliacao_Nome(), ecorePackage.getEString(), "nome", null, 0, 1, CriterioAvaliacao.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCriterioAvaliacao_Peso(), ecorePackage.getEIntegerObject(), "peso", null, 0, 1, CriterioAvaliacao.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCriterioAvaliacao_Esta_em(), this.getNota(), null, "Esta_em", null, 1, 1, CriterioAvaliacao.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(matriculaEClass, Matricula.class, "Matricula", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMatricula_IdMatricula(), ecorePackage.getELongObject(), "idMatricula", null, 0, 1, Matricula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatricula_IdAluno(), ecorePackage.getELongObject(), "idAluno", null, 0, 1, Matricula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatricula_IdDisciplina(), ecorePackage.getELongObject(), "idDisciplina", null, 0, 1, Matricula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatricula_IdNota(), ecorePackage.getEBigInteger(), "idNota", null, 0, 1, Matricula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatricula_NotaFinal(), ecorePackage.getEDoubleObject(), "notaFinal", null, 0, 1, Matricula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMatricula_Ganha(), this.getNota(), null, "Ganha", null, 1, -1, Matricula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMatricula_Recebe(), this.getNota(), null, "Recebe", null, 1, -1, Matricula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notaEClass, Nota.class, "Nota", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNota_IdNota(), ecorePackage.getELongObject(), "idNota", null, 0, 1, Nota.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNota_IdCriterioAvaliacao(), ecorePackage.getEBigInteger(), "idCriterioAvaliacao", null, 0, 1, Nota.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNota_NotaCriterio(), ecorePackage.getEDoubleObject(), "notaCriterio", null, 0, 1, Nota.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ElearningmodelPackageImpl
