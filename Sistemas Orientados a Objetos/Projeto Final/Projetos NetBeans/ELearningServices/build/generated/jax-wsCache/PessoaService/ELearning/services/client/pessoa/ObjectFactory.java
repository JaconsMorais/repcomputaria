
package ELearning.services.client.pessoa;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ELearning.services.client.pessoa package. 
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

    private final static QName _CadastrarPessoa_QNAME = new QName("http://services.ELearning/", "cadastrarPessoa");
    private final static QName _EditarPessoaResponse_QNAME = new QName("http://services.ELearning/", "editarPessoaResponse");
    private final static QName _ProcurarPessoa_QNAME = new QName("http://services.ELearning/", "procurarPessoa");
    private final static QName _ProcurarPessoaResponse_QNAME = new QName("http://services.ELearning/", "procurarPessoaResponse");
    private final static QName _CadastrarPessoaResponse_QNAME = new QName("http://services.ELearning/", "cadastrarPessoaResponse");
    private final static QName _DeletarPessoa_QNAME = new QName("http://services.ELearning/", "deletarPessoa");
    private final static QName _DeletarPessoaResponse_QNAME = new QName("http://services.ELearning/", "deletarPessoaResponse");
    private final static QName _EditarPessoa_QNAME = new QName("http://services.ELearning/", "editarPessoa");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ELearning.services.client.pessoa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EditarPessoa }
     * 
     */
    public EditarPessoa createEditarPessoa() {
        return new EditarPessoa();
    }

    /**
     * Create an instance of {@link ProcurarPessoa }
     * 
     */
    public ProcurarPessoa createProcurarPessoa() {
        return new ProcurarPessoa();
    }

    /**
     * Create an instance of {@link CadastrarPessoaResponse }
     * 
     */
    public CadastrarPessoaResponse createCadastrarPessoaResponse() {
        return new CadastrarPessoaResponse();
    }

    /**
     * Create an instance of {@link Pessoa }
     * 
     */
    public Pessoa createPessoa() {
        return new Pessoa();
    }

    /**
     * Create an instance of {@link DeletarPessoa }
     * 
     */
    public DeletarPessoa createDeletarPessoa() {
        return new DeletarPessoa();
    }

    /**
     * Create an instance of {@link CadastrarPessoa }
     * 
     */
    public CadastrarPessoa createCadastrarPessoa() {
        return new CadastrarPessoa();
    }

    /**
     * Create an instance of {@link ProcurarPessoaResponse }
     * 
     */
    public ProcurarPessoaResponse createProcurarPessoaResponse() {
        return new ProcurarPessoaResponse();
    }

    /**
     * Create an instance of {@link EditarPessoaResponse }
     * 
     */
    public EditarPessoaResponse createEditarPessoaResponse() {
        return new EditarPessoaResponse();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link DeletarPessoaResponse }
     * 
     */
    public DeletarPessoaResponse createDeletarPessoaResponse() {
        return new DeletarPessoaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarPessoa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "cadastrarPessoa")
    public JAXBElement<CadastrarPessoa> createCadastrarPessoa(CadastrarPessoa value) {
        return new JAXBElement<CadastrarPessoa>(_CadastrarPessoa_QNAME, CadastrarPessoa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarPessoaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "editarPessoaResponse")
    public JAXBElement<EditarPessoaResponse> createEditarPessoaResponse(EditarPessoaResponse value) {
        return new JAXBElement<EditarPessoaResponse>(_EditarPessoaResponse_QNAME, EditarPessoaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcurarPessoa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "procurarPessoa")
    public JAXBElement<ProcurarPessoa> createProcurarPessoa(ProcurarPessoa value) {
        return new JAXBElement<ProcurarPessoa>(_ProcurarPessoa_QNAME, ProcurarPessoa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcurarPessoaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "procurarPessoaResponse")
    public JAXBElement<ProcurarPessoaResponse> createProcurarPessoaResponse(ProcurarPessoaResponse value) {
        return new JAXBElement<ProcurarPessoaResponse>(_ProcurarPessoaResponse_QNAME, ProcurarPessoaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarPessoaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "cadastrarPessoaResponse")
    public JAXBElement<CadastrarPessoaResponse> createCadastrarPessoaResponse(CadastrarPessoaResponse value) {
        return new JAXBElement<CadastrarPessoaResponse>(_CadastrarPessoaResponse_QNAME, CadastrarPessoaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletarPessoa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "deletarPessoa")
    public JAXBElement<DeletarPessoa> createDeletarPessoa(DeletarPessoa value) {
        return new JAXBElement<DeletarPessoa>(_DeletarPessoa_QNAME, DeletarPessoa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletarPessoaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "deletarPessoaResponse")
    public JAXBElement<DeletarPessoaResponse> createDeletarPessoaResponse(DeletarPessoaResponse value) {
        return new JAXBElement<DeletarPessoaResponse>(_DeletarPessoaResponse_QNAME, DeletarPessoaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarPessoa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "editarPessoa")
    public JAXBElement<EditarPessoa> createEditarPessoa(EditarPessoa value) {
        return new JAXBElement<EditarPessoa>(_EditarPessoa_QNAME, EditarPessoa.class, null, value);
    }

}
