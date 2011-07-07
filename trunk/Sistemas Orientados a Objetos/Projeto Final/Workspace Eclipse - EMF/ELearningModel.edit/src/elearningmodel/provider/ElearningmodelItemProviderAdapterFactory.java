/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package elearningmodel.provider;

import elearningmodel.util.ElearningmodelAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ElearningmodelItemProviderAdapterFactory extends ElearningmodelAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElearningmodelItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link elearningmodel.Usuario} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UsuarioItemProvider usuarioItemProvider;

	/**
	 * This creates an adapter for a {@link elearningmodel.Usuario}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUsuarioAdapter() {
		if (usuarioItemProvider == null) {
			usuarioItemProvider = new UsuarioItemProvider(this);
		}

		return usuarioItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link elearningmodel.Pessoa} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PessoaItemProvider pessoaItemProvider;

	/**
	 * This creates an adapter for a {@link elearningmodel.Pessoa}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPessoaAdapter() {
		if (pessoaItemProvider == null) {
			pessoaItemProvider = new PessoaItemProvider(this);
		}

		return pessoaItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link elearningmodel.Professor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProfessorItemProvider professorItemProvider;

	/**
	 * This creates an adapter for a {@link elearningmodel.Professor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createProfessorAdapter() {
		if (professorItemProvider == null) {
			professorItemProvider = new ProfessorItemProvider(this);
		}

		return professorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link elearningmodel.Aluno} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlunoItemProvider alunoItemProvider;

	/**
	 * This creates an adapter for a {@link elearningmodel.Aluno}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAlunoAdapter() {
		if (alunoItemProvider == null) {
			alunoItemProvider = new AlunoItemProvider(this);
		}

		return alunoItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link elearningmodel.Disciplina} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DisciplinaItemProvider disciplinaItemProvider;

	/**
	 * This creates an adapter for a {@link elearningmodel.Disciplina}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDisciplinaAdapter() {
		if (disciplinaItemProvider == null) {
			disciplinaItemProvider = new DisciplinaItemProvider(this);
		}

		return disciplinaItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link elearningmodel.CriterioAvaliacao} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CriterioAvaliacaoItemProvider criterioAvaliacaoItemProvider;

	/**
	 * This creates an adapter for a {@link elearningmodel.CriterioAvaliacao}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCriterioAvaliacaoAdapter() {
		if (criterioAvaliacaoItemProvider == null) {
			criterioAvaliacaoItemProvider = new CriterioAvaliacaoItemProvider(this);
		}

		return criterioAvaliacaoItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link elearningmodel.Matricula} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MatriculaItemProvider matriculaItemProvider;

	/**
	 * This creates an adapter for a {@link elearningmodel.Matricula}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMatriculaAdapter() {
		if (matriculaItemProvider == null) {
			matriculaItemProvider = new MatriculaItemProvider(this);
		}

		return matriculaItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link elearningmodel.Nota} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotaItemProvider notaItemProvider;

	/**
	 * This creates an adapter for a {@link elearningmodel.Nota}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNotaAdapter() {
		if (notaItemProvider == null) {
			notaItemProvider = new NotaItemProvider(this);
		}

		return notaItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (usuarioItemProvider != null) usuarioItemProvider.dispose();
		if (pessoaItemProvider != null) pessoaItemProvider.dispose();
		if (professorItemProvider != null) professorItemProvider.dispose();
		if (alunoItemProvider != null) alunoItemProvider.dispose();
		if (disciplinaItemProvider != null) disciplinaItemProvider.dispose();
		if (criterioAvaliacaoItemProvider != null) criterioAvaliacaoItemProvider.dispose();
		if (matriculaItemProvider != null) matriculaItemProvider.dispose();
		if (notaItemProvider != null) notaItemProvider.dispose();
	}

}