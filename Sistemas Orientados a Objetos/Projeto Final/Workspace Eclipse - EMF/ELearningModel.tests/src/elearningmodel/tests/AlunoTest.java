/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel.tests;

import elearningmodel.Aluno;
import elearningmodel.ElearningmodelFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Aluno</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlunoTest extends PessoaTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AlunoTest.class);
	}

	/**
	 * Constructs a new Aluno test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlunoTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Aluno test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Aluno getFixture() {
		return (Aluno)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ElearningmodelFactory.eINSTANCE.createAluno());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //AlunoTest
