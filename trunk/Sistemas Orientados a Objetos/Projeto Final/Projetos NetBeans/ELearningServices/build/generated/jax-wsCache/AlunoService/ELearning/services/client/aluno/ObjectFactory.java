
package ELearning.services.client.aluno;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ELearning.services.client.aluno package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeletarAluno_QNAME = new QName("http://services.ELearning/", "deletarAluno");
    private final static QName _ProcurarMatriculasNaoFeitas_QNAME = new QName("http://services.ELearning/", "procurarMatriculasNaoFeitas");
    private final static QName _CadastrarAluno_QNAME = new QName("http://services.ELearning/", "cadastrarAluno");
    private final static QName _EditarAluno_QNAME = new QName("http://services.ELearning/", "editarAluno");
    private final static QName _EditarAlunoResponse_QNAME = new QName("http://services.ELearning/", "editarAlunoResponse");
    private final static QName _ProcurarAlunoResponse_QNAME = new QName("http://services.ELearning/", "procurarAlunoResponse");
    private final static QName _ProcurarAluno_QNAME = new QName("http://services.ELearning/", "procurarAluno");
    private final static QName _CadastrarAlunoResponse_QNAME = new QName("http://services.ELearning/", "cadastrarAlunoResponse");
    private final static QName _DeletarAlunoResponse_QNAME = new QName("http://services.ELearning/", "deletarAlunoResponse");
    private final static QName _ProcurarMatriculasNaoFeitasResponse_QNAME = new QName("http://services.ELearning/", "procurarMatriculasNaoFeitasResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ELearning.services.client.aluno
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CadastrarAluno }
     * 
     */
    public CadastrarAluno createCadastrarAluno() {
        return new CadastrarAluno();
    }

    /**
     * Create an instance of {@link ProcurarMatriculasNaoFeitasResponse }
     * 
     */
    public ProcurarMatriculasNaoFeitasResponse createProcurarMatriculasNaoFeitasResponse() {
        return new ProcurarMatriculasNaoFeitasResponse();
    }

    /**
     * Create an instance of {@link EditarAlunoResponse }
     * 
     */
    public EditarAlunoResponse createEditarAlunoResponse() {
        return new EditarAlunoResponse();
    }

    /**
     * Create an instance of {@link EditarAluno }
     * 
     */
    public EditarAluno createEditarAluno() {
        return new EditarAluno();
    }

    /**
     * Create an instance of {@link StudentEnrollmentModel }
     * 
     */
    public StudentEnrollmentModel createStudentEnrollmentModel() {
        return new StudentEnrollmentModel();
    }

    /**
     * Create an instance of {@link Nota }
     * 
     */
    public Nota createNota() {
        return new Nota();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link Matricula }
     * 
     */
    public Matricula createMatricula() {
        return new Matricula();
    }

    /**
     * Create an instance of {@link Aluno }
     * 
     */
    public Aluno createAluno() {
        return new Aluno();
    }

    /**
     * Create an instance of {@link ProcurarAluno }
     * 
     */
    public ProcurarAluno createProcurarAluno() {
        return new ProcurarAluno();
    }

    /**
     * Create an instance of {@link Pessoa }
     * 
     */
    public Pessoa createPessoa() {
        return new Pessoa();
    }

    /**
     * Create an instance of {@link CadastrarAlunoResponse }
     * 
     */
    public CadastrarAlunoResponse createCadastrarAlunoResponse() {
        return new CadastrarAlunoResponse();
    }

    /**
     * Create an instance of {@link DeletarAlunoResponse }
     * 
     */
    public DeletarAlunoResponse createDeletarAlunoResponse() {
        return new DeletarAlunoResponse();
    }

    /**
     * Create an instance of {@link ProcurarMatriculasNaoFeitas }
     * 
     */
    public ProcurarMatriculasNaoFeitas createProcurarMatriculasNaoFeitas() {
        return new ProcurarMatriculasNaoFeitas();
    }

    /**
     * Create an instance of {@link DeletarAluno }
     * 
     */
    public DeletarAluno createDeletarAluno() {
        return new DeletarAluno();
    }

    /**
     * Create an instance of {@link ProcurarAlunoResponse }
     * 
     */
    public ProcurarAlunoResponse createProcurarAlunoResponse() {
        return new ProcurarAlunoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletarAluno }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "deletarAluno")
    public JAXBElement<DeletarAluno> createDeletarAluno(DeletarAluno value) {
        return new JAXBElement<DeletarAluno>(_DeletarAluno_QNAME, DeletarAluno.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcurarMatriculasNaoFeitas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "procurarMatriculasNaoFeitas")
    public JAXBElement<ProcurarMatriculasNaoFeitas> createProcurarMatriculasNaoFeitas(ProcurarMatriculasNaoFeitas value) {
        return new JAXBElement<ProcurarMatriculasNaoFeitas>(_ProcurarMatriculasNaoFeitas_QNAME, ProcurarMatriculasNaoFeitas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarAluno }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "cadastrarAluno")
    public JAXBElement<CadastrarAluno> createCadastrarAluno(CadastrarAluno value) {
        return new JAXBElement<CadastrarAluno>(_CadastrarAluno_QNAME, CadastrarAluno.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarAluno }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "editarAluno")
    public JAXBElement<EditarAluno> createEditarAluno(EditarAluno value) {
        return new JAXBElement<EditarAluno>(_EditarAluno_QNAME, EditarAluno.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarAlunoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "editarAlunoResponse")
    public JAXBElement<EditarAlunoResponse> createEditarAlunoResponse(EditarAlunoResponse value) {
        return new JAXBElement<EditarAlunoResponse>(_EditarAlunoResponse_QNAME, EditarAlunoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcurarAlunoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "procurarAlunoResponse")
    public JAXBElement<ProcurarAlunoResponse> createProcurarAlunoResponse(ProcurarAlunoResponse value) {
        return new JAXBElement<ProcurarAlunoResponse>(_ProcurarAlunoResponse_QNAME, ProcurarAlunoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcurarAluno }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "procurarAluno")
    public JAXBElement<ProcurarAluno> createProcurarAluno(ProcurarAluno value) {
        return new JAXBElement<ProcurarAluno>(_ProcurarAluno_QNAME, ProcurarAluno.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarAlunoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "cadastrarAlunoResponse")
    public JAXBElement<CadastrarAlunoResponse> createCadastrarAlunoResponse(CadastrarAlunoResponse value) {
        return new JAXBElement<CadastrarAlunoResponse>(_CadastrarAlunoResponse_QNAME, CadastrarAlunoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletarAlunoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "deletarAlunoResponse")
    public JAXBElement<DeletarAlunoResponse> createDeletarAlunoResponse(DeletarAlunoResponse value) {
        return new JAXBElement<DeletarAlunoResponse>(_DeletarAlunoResponse_QNAME, DeletarAlunoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcurarMatriculasNaoFeitasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "procurarMatriculasNaoFeitasResponse")
    public JAXBElement<ProcurarMatriculasNaoFeitasResponse> createProcurarMatriculasNaoFeitasResponse(ProcurarMatriculasNaoFeitasResponse value) {
        return new JAXBElement<ProcurarMatriculasNaoFeitasResponse>(_ProcurarMatriculasNaoFeitasResponse_QNAME, ProcurarMatriculasNaoFeitasResponse.class, null, value);
    }

}
