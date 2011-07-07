/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel.tests;

import elearningmodel.ElearningmodelFactory;
import elearningmodel.Pessoa;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Pessoa</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PessoaTest extends UsuarioTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PessoaTest.class);
	}

	/**
	 * Constructs a new Pessoa test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PessoaTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Pessoa test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Pessoa getFixture() {
		return (Pessoa)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ElearningmodelFactory.eINSTANCE.createPessoa());
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

} //PessoaTest
