/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel.tests;

import elearningmodel.Disciplina;
import elearningmodel.ElearningmodelFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Disciplina</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DisciplinaTest extends TestCase {

	/**
	 * The fixture for this Disciplina test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Disciplina fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DisciplinaTest.class);
	}

	/**
	 * Constructs a new Disciplina test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DisciplinaTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Disciplina test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Disciplina fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Disciplina test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Disciplina getFixture() {
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
		setFixture(ElearningmodelFactory.eINSTANCE.createDisciplina());
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

} //DisciplinaTest
