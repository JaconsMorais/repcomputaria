
package ELearning.services.client.usuario;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ELearning.services.client.usuario package. 
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

    private final static QName _ValidaLoginResponse_QNAME = new QName("http://services.ELearning/", "validaLoginResponse");
    private final static QName _CadastrarUsuario_QNAME = new QName("http://services.ELearning/", "cadastrarUsuario");
    private final static QName _EditarUsuario_QNAME = new QName("http://services.ELearning/", "editarUsuario");
    private final static QName _CadastrarUsuarioResponse_QNAME = new QName("http://services.ELearning/", "cadastrarUsuarioResponse");
    private final static QName _DeletarUsuario_QNAME = new QName("http://services.ELearning/", "deletarUsuario");
    private final static QName _ValidaLogin_QNAME = new QName("http://services.ELearning/", "validaLogin");
    private final static QName _DeletarUsuarioResponse_QNAME = new QName("http://services.ELearning/", "deletarUsuarioResponse");
    private final static QName _EditarUsuarioResponse_QNAME = new QName("http://services.ELearning/", "editarUsuarioResponse");
    private final static QName _ProcurarUsuario_QNAME = new QName("http://services.ELearning/", "procurarUsuario");
    private final static QName _ProcurarUsuarioResponse_QNAME = new QName("http://services.ELearning/", "procurarUsuarioResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ELearning.services.client.usuario
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EditarUsuario }
     * 
     */
    public EditarUsuario createEditarUsuario() {
        return new EditarUsuario();
    }

    /**
     * Create an instance of {@link CadastrarUsuarioResponse }
     * 
     */
    public CadastrarUsuarioResponse createCadastrarUsuarioResponse() {
        return new CadastrarUsuarioResponse();
    }

    /**
     * Create an instance of {@link DeletarUsuario }
     * 
     */
    public DeletarUsuario createDeletarUsuario() {
        return new DeletarUsuario();
    }

    /**
     * Create an instance of {@link ValidaLoginResponse }
     * 
     */
    public ValidaLoginResponse createValidaLoginResponse() {
        return new ValidaLoginResponse();
    }

    /**
     * Create an instance of {@link EditarUsuarioResponse }
     * 
     */
    public EditarUsuarioResponse createEditarUsuarioResponse() {
        return new EditarUsuarioResponse();
    }

    /**
     * Create an instance of {@link ValidaLogin }
     * 
     */
    public ValidaLogin createValidaLogin() {
        return new ValidaLogin();
    }

    /**
     * Create an instance of {@link ProcurarUsuario }
     * 
     */
    public ProcurarUsuario createProcurarUsuario() {
        return new ProcurarUsuario();
    }

    /**
     * Create an instance of {@link ProcurarUsuarioResponse }
     * 
     */
    public ProcurarUsuarioResponse createProcurarUsuarioResponse() {
        return new ProcurarUsuarioResponse();
    }

    /**
     * Create an instance of {@link CadastrarUsuario }
     * 
     */
    public CadastrarUsuario createCadastrarUsuario() {
        return new CadastrarUsuario();
    }

    /**
     * Create an instance of {@link DeletarUsuarioResponse }
     * 
     */
    public DeletarUsuarioResponse createDeletarUsuarioResponse() {
        return new DeletarUsuarioResponse();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidaLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "validaLoginResponse")
    public JAXBElement<ValidaLoginResponse> createValidaLoginResponse(ValidaLoginResponse value) {
        return new JAXBElement<ValidaLoginResponse>(_ValidaLoginResponse_QNAME, ValidaLoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "cadastrarUsuario")
    public JAXBElement<CadastrarUsuario> createCadastrarUsuario(CadastrarUsuario value) {
        return new JAXBElement<CadastrarUsuario>(_CadastrarUsuario_QNAME, CadastrarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "editarUsuario")
    public JAXBElement<EditarUsuario> createEditarUsuario(EditarUsuario value) {
        return new JAXBElement<EditarUsuario>(_EditarUsuario_QNAME, EditarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "cadastrarUsuarioResponse")
    public JAXBElement<CadastrarUsuarioResponse> createCadastrarUsuarioResponse(CadastrarUsuarioResponse value) {
        return new JAXBElement<CadastrarUsuarioResponse>(_CadastrarUsuarioResponse_QNAME, CadastrarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "deletarUsuario")
    public JAXBElement<DeletarUsuario> createDeletarUsuario(DeletarUsuario value) {
        return new JAXBElement<DeletarUsuario>(_DeletarUsuario_QNAME, DeletarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidaLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "validaLogin")
    public JAXBElement<ValidaLogin> createValidaLogin(ValidaLogin value) {
        return new JAXBElement<ValidaLogin>(_ValidaLogin_QNAME, ValidaLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "deletarUsuarioResponse")
    public JAXBElement<DeletarUsuarioResponse> createDeletarUsuarioResponse(DeletarUsuarioResponse value) {
        return new JAXBElement<DeletarUsuarioResponse>(_DeletarUsuarioResponse_QNAME, DeletarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "editarUsuarioResponse")
    public JAXBElement<EditarUsuarioResponse> createEditarUsuarioResponse(EditarUsuarioResponse value) {
        return new JAXBElement<EditarUsuarioResponse>(_EditarUsuarioResponse_QNAME, EditarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcurarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "procurarUsuario")
    public JAXBElement<ProcurarUsuario> createProcurarUsuario(ProcurarUsuario value) {
        return new JAXBElement<ProcurarUsuario>(_ProcurarUsuario_QNAME, ProcurarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcurarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "procurarUsuarioResponse")
    public JAXBElement<ProcurarUsuarioResponse> createProcurarUsuarioResponse(ProcurarUsuarioResponse value) {
        return new JAXBElement<ProcurarUsuarioResponse>(_ProcurarUsuarioResponse_QNAME, ProcurarUsuarioResponse.class, null, value);
    }

}
