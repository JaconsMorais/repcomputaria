
package ELearning.services.client.nota;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ELearning.services.client.nota package. 
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

    private final static QName _CadastrarNotaResponse_QNAME = new QName("http://services.ELearning/", "cadastrarNotaResponse");
    private final static QName _CadastrarNota_QNAME = new QName("http://services.ELearning/", "cadastrarNota");
    private final static QName _DeletarNotaResponse_QNAME = new QName("http://services.ELearning/", "deletarNotaResponse");
    private final static QName _ProcurarNota_QNAME = new QName("http://services.ELearning/", "procurarNota");
    private final static QName _EditarNota_QNAME = new QName("http://services.ELearning/", "editarNota");
    private final static QName _EditarNotaResponse_QNAME = new QName("http://services.ELearning/", "editarNotaResponse");
    private final static QName _ProcurarNotaResponse_QNAME = new QName("http://services.ELearning/", "procurarNotaResponse");
    private final static QName _DeletarNota_QNAME = new QName("http://services.ELearning/", "deletarNota");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ELearning.services.client.nota
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeletarNotaResponse }
     * 
     */
    public DeletarNotaResponse createDeletarNotaResponse() {
        return new DeletarNotaResponse();
    }

    /**
     * Create an instance of {@link EditarNota }
     * 
     */
    public EditarNota createEditarNota() {
        return new EditarNota();
    }

    /**
     * Create an instance of {@link EditarNotaResponse }
     * 
     */
    public EditarNotaResponse createEditarNotaResponse() {
        return new EditarNotaResponse();
    }

    /**
     * Create an instance of {@link CadastrarNota }
     * 
     */
    public CadastrarNota createCadastrarNota() {
        return new CadastrarNota();
    }

    /**
     * Create an instance of {@link ProcurarNotaResponse }
     * 
     */
    public ProcurarNotaResponse createProcurarNotaResponse() {
        return new ProcurarNotaResponse();
    }

    /**
     * Create an instance of {@link Nota }
     * 
     */
    public Nota createNota() {
        return new Nota();
    }

    /**
     * Create an instance of {@link DeletarNota }
     * 
     */
    public DeletarNota createDeletarNota() {
        return new DeletarNota();
    }

    /**
     * Create an instance of {@link ProcurarNota }
     * 
     */
    public ProcurarNota createProcurarNota() {
        return new ProcurarNota();
    }

    /**
     * Create an instance of {@link CadastrarNotaResponse }
     * 
     */
    public CadastrarNotaResponse createCadastrarNotaResponse() {
        return new CadastrarNotaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarNotaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "cadastrarNotaResponse")
    public JAXBElement<CadastrarNotaResponse> createCadastrarNotaResponse(CadastrarNotaResponse value) {
        return new JAXBElement<CadastrarNotaResponse>(_CadastrarNotaResponse_QNAME, CadastrarNotaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarNota }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "cadastrarNota")
    public JAXBElement<CadastrarNota> createCadastrarNota(CadastrarNota value) {
        return new JAXBElement<CadastrarNota>(_CadastrarNota_QNAME, CadastrarNota.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletarNotaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "deletarNotaResponse")
    public JAXBElement<DeletarNotaResponse> createDeletarNotaResponse(DeletarNotaResponse value) {
        return new JAXBElement<DeletarNotaResponse>(_DeletarNotaResponse_QNAME, DeletarNotaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcurarNota }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "procurarNota")
    public JAXBElement<ProcurarNota> createProcurarNota(ProcurarNota value) {
        return new JAXBElement<ProcurarNota>(_ProcurarNota_QNAME, ProcurarNota.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarNota }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "editarNota")
    public JAXBElement<EditarNota> createEditarNota(EditarNota value) {
        return new JAXBElement<EditarNota>(_EditarNota_QNAME, EditarNota.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarNotaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "editarNotaResponse")
    public JAXBElement<EditarNotaResponse> createEditarNotaResponse(EditarNotaResponse value) {
        return new JAXBElement<EditarNotaResponse>(_EditarNotaResponse_QNAME, EditarNotaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcurarNotaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "procurarNotaResponse")
    public JAXBElement<ProcurarNotaResponse> createProcurarNotaResponse(ProcurarNotaResponse value) {
        return new JAXBElement<ProcurarNotaResponse>(_ProcurarNotaResponse_QNAME, ProcurarNotaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletarNota }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "deletarNota")
    public JAXBElement<DeletarNota> createDeletarNota(DeletarNota value) {
        return new JAXBElement<DeletarNota>(_DeletarNota_QNAME, DeletarNota.class, null, value);
    }

}
