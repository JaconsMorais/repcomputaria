
package ELearning.services.client.matricula;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ELearning.services.client.matricula package. 
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

    private final static QName _CadastrarMatricula_QNAME = new QName("http://services.ELearning/", "cadastrarMatricula");
    private final static QName _ProcurarMatricula_QNAME = new QName("http://services.ELearning/", "procurarMatricula");
    private final static QName _DeletarMatricula_QNAME = new QName("http://services.ELearning/", "deletarMatricula");
    private final static QName _ProcurarMatriculaResponse_QNAME = new QName("http://services.ELearning/", "procurarMatriculaResponse");
    private final static QName _CadastrarMatriculaResponse_QNAME = new QName("http://services.ELearning/", "cadastrarMatriculaResponse");
    private final static QName _EditarMatricula_QNAME = new QName("http://services.ELearning/", "editarMatricula");
    private final static QName _DeletarMatriculaResponse_QNAME = new QName("http://services.ELearning/", "deletarMatriculaResponse");
    private final static QName _EditarMatriculaResponse_QNAME = new QName("http://services.ELearning/", "editarMatriculaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ELearning.services.client.matricula
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EditarMatricula }
     * 
     */
    public EditarMatricula createEditarMatricula() {
        return new EditarMatricula();
    }

    /**
     * Create an instance of {@link DeletarMatricula }
     * 
     */
    public DeletarMatricula createDeletarMatricula() {
        return new DeletarMatricula();
    }

    /**
     * Create an instance of {@link Nota }
     * 
     */
    public Nota createNota() {
        return new Nota();
    }

    /**
     * Create an instance of {@link EditarMatriculaResponse }
     * 
     */
    public EditarMatriculaResponse createEditarMatriculaResponse() {
        return new EditarMatriculaResponse();
    }

    /**
     * Create an instance of {@link DeletarMatriculaResponse }
     * 
     */
    public DeletarMatriculaResponse createDeletarMatriculaResponse() {
        return new DeletarMatriculaResponse();
    }

    /**
     * Create an instance of {@link CadastrarMatricula }
     * 
     */
    public CadastrarMatricula createCadastrarMatricula() {
        return new CadastrarMatricula();
    }

    /**
     * Create an instance of {@link ProcurarMatricula }
     * 
     */
    public ProcurarMatricula createProcurarMatricula() {
        return new ProcurarMatricula();
    }

    /**
     * Create an instance of {@link ProcurarMatriculaResponse }
     * 
     */
    public ProcurarMatriculaResponse createProcurarMatriculaResponse() {
        return new ProcurarMatriculaResponse();
    }

    /**
     * Create an instance of {@link Matricula }
     * 
     */
    public Matricula createMatricula() {
        return new Matricula();
    }

    /**
     * Create an instance of {@link CadastrarMatriculaResponse }
     * 
     */
    public CadastrarMatriculaResponse createCadastrarMatriculaResponse() {
        return new CadastrarMatriculaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarMatricula }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "cadastrarMatricula")
    public JAXBElement<CadastrarMatricula> createCadastrarMatricula(CadastrarMatricula value) {
        return new JAXBElement<CadastrarMatricula>(_CadastrarMatricula_QNAME, CadastrarMatricula.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcurarMatricula }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "procurarMatricula")
    public JAXBElement<ProcurarMatricula> createProcurarMatricula(ProcurarMatricula value) {
        return new JAXBElement<ProcurarMatricula>(_ProcurarMatricula_QNAME, ProcurarMatricula.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletarMatricula }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "deletarMatricula")
    public JAXBElement<DeletarMatricula> createDeletarMatricula(DeletarMatricula value) {
        return new JAXBElement<DeletarMatricula>(_DeletarMatricula_QNAME, DeletarMatricula.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcurarMatriculaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "procurarMatriculaResponse")
    public JAXBElement<ProcurarMatriculaResponse> createProcurarMatriculaResponse(ProcurarMatriculaResponse value) {
        return new JAXBElement<ProcurarMatriculaResponse>(_ProcurarMatriculaResponse_QNAME, ProcurarMatriculaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarMatriculaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "cadastrarMatriculaResponse")
    public JAXBElement<CadastrarMatriculaResponse> createCadastrarMatriculaResponse(CadastrarMatriculaResponse value) {
        return new JAXBElement<CadastrarMatriculaResponse>(_CadastrarMatriculaResponse_QNAME, CadastrarMatriculaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarMatricula }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "editarMatricula")
    public JAXBElement<EditarMatricula> createEditarMatricula(EditarMatricula value) {
        return new JAXBElement<EditarMatricula>(_EditarMatricula_QNAME, EditarMatricula.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletarMatriculaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "deletarMatriculaResponse")
    public JAXBElement<DeletarMatriculaResponse> createDeletarMatriculaResponse(DeletarMatriculaResponse value) {
        return new JAXBElement<DeletarMatriculaResponse>(_DeletarMatriculaResponse_QNAME, DeletarMatriculaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarMatriculaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "editarMatriculaResponse")
    public JAXBElement<EditarMatriculaResponse> createEditarMatriculaResponse(EditarMatriculaResponse value) {
        return new JAXBElement<EditarMatriculaResponse>(_EditarMatriculaResponse_QNAME, EditarMatriculaResponse.class, null, value);
    }

}
