
package ELearning.services.client.professor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ELearning.services.client.professor package. 
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

    private final static QName _DeletarProfessor_QNAME = new QName("http://services.ELearning/", "deletarProfessor");
    private final static QName _CadastrarProfessorResponse_QNAME = new QName("http://services.ELearning/", "cadastrarProfessorResponse");
    private final static QName _ProcurarProfessor_QNAME = new QName("http://services.ELearning/", "procurarProfessor");
    private final static QName _EditarProfessor_QNAME = new QName("http://services.ELearning/", "editarProfessor");
    private final static QName _DeletarProfessorResponse_QNAME = new QName("http://services.ELearning/", "deletarProfessorResponse");
    private final static QName _ProcurarProfessorResponse_QNAME = new QName("http://services.ELearning/", "procurarProfessorResponse");
    private final static QName _CadastrarProfessor_QNAME = new QName("http://services.ELearning/", "cadastrarProfessor");
    private final static QName _EditarProfessorResponse_QNAME = new QName("http://services.ELearning/", "editarProfessorResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ELearning.services.client.professor
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CadastrarProfessorResponse }
     * 
     */
    public CadastrarProfessorResponse createCadastrarProfessorResponse() {
        return new CadastrarProfessorResponse();
    }

    /**
     * Create an instance of {@link DeletarProfessorResponse }
     * 
     */
    public DeletarProfessorResponse createDeletarProfessorResponse() {
        return new DeletarProfessorResponse();
    }

    /**
     * Create an instance of {@link Pessoa }
     * 
     */
    public Pessoa createPessoa() {
        return new Pessoa();
    }

    /**
     * Create an instance of {@link Nota }
     * 
     */
    public Nota createNota() {
        return new Nota();
    }

    /**
     * Create an instance of {@link ProcurarProfessorResponse }
     * 
     */
    public ProcurarProfessorResponse createProcurarProfessorResponse() {
        return new ProcurarProfessorResponse();
    }

    /**
     * Create an instance of {@link EditarProfessorResponse }
     * 
     */
    public EditarProfessorResponse createEditarProfessorResponse() {
        return new EditarProfessorResponse();
    }

    /**
     * Create an instance of {@link CadastrarProfessor }
     * 
     */
    public CadastrarProfessor createCadastrarProfessor() {
        return new CadastrarProfessor();
    }

    /**
     * Create an instance of {@link ProcurarProfessor }
     * 
     */
    public ProcurarProfessor createProcurarProfessor() {
        return new ProcurarProfessor();
    }

    /**
     * Create an instance of {@link Matricula }
     * 
     */
    public Matricula createMatricula() {
        return new Matricula();
    }

    /**
     * Create an instance of {@link CriterioAvaliacao }
     * 
     */
    public CriterioAvaliacao createCriterioAvaliacao() {
        return new CriterioAvaliacao();
    }

    /**
     * Create an instance of {@link DeletarProfessor }
     * 
     */
    public DeletarProfessor createDeletarProfessor() {
        return new DeletarProfessor();
    }

    /**
     * Create an instance of {@link Professor }
     * 
     */
    public Professor createProfessor() {
        return new Professor();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link Disciplina }
     * 
     */
    public Disciplina createDisciplina() {
        return new Disciplina();
    }

    /**
     * Create an instance of {@link EditarProfessor }
     * 
     */
    public EditarProfessor createEditarProfessor() {
        return new EditarProfessor();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletarProfessor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "deletarProfessor")
    public JAXBElement<DeletarProfessor> createDeletarProfessor(DeletarProfessor value) {
        return new JAXBElement<DeletarProfessor>(_DeletarProfessor_QNAME, DeletarProfessor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarProfessorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "cadastrarProfessorResponse")
    public JAXBElement<CadastrarProfessorResponse> createCadastrarProfessorResponse(CadastrarProfessorResponse value) {
        return new JAXBElement<CadastrarProfessorResponse>(_CadastrarProfessorResponse_QNAME, CadastrarProfessorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcurarProfessor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "procurarProfessor")
    public JAXBElement<ProcurarProfessor> createProcurarProfessor(ProcurarProfessor value) {
        return new JAXBElement<ProcurarProfessor>(_ProcurarProfessor_QNAME, ProcurarProfessor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarProfessor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "editarProfessor")
    public JAXBElement<EditarProfessor> createEditarProfessor(EditarProfessor value) {
        return new JAXBElement<EditarProfessor>(_EditarProfessor_QNAME, EditarProfessor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletarProfessorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "deletarProfessorResponse")
    public JAXBElement<DeletarProfessorResponse> createDeletarProfessorResponse(DeletarProfessorResponse value) {
        return new JAXBElement<DeletarProfessorResponse>(_DeletarProfessorResponse_QNAME, DeletarProfessorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcurarProfessorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "procurarProfessorResponse")
    public JAXBElement<ProcurarProfessorResponse> createProcurarProfessorResponse(ProcurarProfessorResponse value) {
        return new JAXBElement<ProcurarProfessorResponse>(_ProcurarProfessorResponse_QNAME, ProcurarProfessorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarProfessor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "cadastrarProfessor")
    public JAXBElement<CadastrarProfessor> createCadastrarProfessor(CadastrarProfessor value) {
        return new JAXBElement<CadastrarProfessor>(_CadastrarProfessor_QNAME, CadastrarProfessor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarProfessorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "editarProfessorResponse")
    public JAXBElement<EditarProfessorResponse> createEditarProfessorResponse(EditarProfessorResponse value) {
        return new JAXBElement<EditarProfessorResponse>(_EditarProfessorResponse_QNAME, EditarProfessorResponse.class, null, value);
    }

}
