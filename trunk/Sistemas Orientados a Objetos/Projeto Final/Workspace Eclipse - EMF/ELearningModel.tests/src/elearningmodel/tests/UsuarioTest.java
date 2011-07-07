/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel.tests;

import elearningmodel.ElearningmodelFactory;
import elearningmodel.Usuario;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Usuario</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class UsuarioTest extends TestCase {

	/**
	 * The fixture for this Usuario test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Usuario fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(UsuarioTest.class);
	}

	/**
	 * Constructs a new Usuario test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsuarioTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Usuario test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Usuario fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Usuario test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Usuario getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ElearningmodelFactory.eINSTANCE.createUsuario());
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

} //UsuarioTest
