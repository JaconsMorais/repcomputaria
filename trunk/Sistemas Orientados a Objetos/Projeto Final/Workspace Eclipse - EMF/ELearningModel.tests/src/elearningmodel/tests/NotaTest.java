/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel.tests;

import elearningmodel.ElearningmodelFactory;
import elearningmodel.Nota;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Nota</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NotaTest extends TestCase {

	/**
	 * The fixture for this Nota test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Nota fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NotaTest.class);
	}

	/**
	 * Constructs a new Nota test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotaTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Nota test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Nota fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Nota test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Nota getFixture() {
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
		setFixture(ElearningmodelFactory.eINSTANCE.createNota());
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

} //NotaTest
