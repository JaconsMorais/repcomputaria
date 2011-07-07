
package ELearning.services.client.criterioavaliacao;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ELearning.services.client.criterioavaliacao package. 
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

    private final static QName _ProcurarCriterioResponse_QNAME = new QName("http://services.ELearning/", "procurarCriterioResponse");
    private final static QName _ProcurarCriterio_QNAME = new QName("http://services.ELearning/", "procurarCriterio");
    private final static QName _CadastrarCriterioResponse_QNAME = new QName("http://services.ELearning/", "cadastrarCriterioResponse");
    private final static QName _EditarCriterio_QNAME = new QName("http://services.ELearning/", "editarCriterio");
    private final static QName _DeletarCriterio_QNAME = new QName("http://services.ELearning/", "deletarCriterio");
    private final static QName _EditarCriterioResponse_QNAME = new QName("http://services.ELearning/", "editarCriterioResponse");
    private final static QName _CadastrarCriterio_QNAME = new QName("http://services.ELearning/", "cadastrarCriterio");
    private final static QName _DeletarCriterioResponse_QNAME = new QName("http://services.ELearning/", "deletarCriterioResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ELearning.services.client.criterioavaliacao
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeletarCriterio }
     * 
     */
    public DeletarCriterio createDeletarCriterio() {
        return new DeletarCriterio();
    }

    /**
     * Create an instance of {@link CriterioAvaliacao }
     * 
     */
    public CriterioAvaliacao createCriterioAvaliacao() {
        return new CriterioAvaliacao();
    }

    /**
     * Create an instance of {@link DeletarCriterioResponse }
     * 
     */
    public DeletarCriterioResponse createDeletarCriterioResponse() {
        return new DeletarCriterioResponse();
    }

    /**
     * Create an instance of {@link EditarCriterioResponse }
     * 
     */
    public EditarCriterioResponse createEditarCriterioResponse() {
        return new EditarCriterioResponse();
    }

    /**
     * Create an instance of {@link CadastrarCriterioResponse }
     * 
     */
    public CadastrarCriterioResponse createCadastrarCriterioResponse() {
        return new CadastrarCriterioResponse();
    }

    /**
     * Create an instance of {@link EditarCriterio }
     * 
     */
    public EditarCriterio createEditarCriterio() {
        return new EditarCriterio();
    }

    /**
     * Create an instance of {@link ProcurarCriterio }
     * 
     */
    public ProcurarCriterio createProcurarCriterio() {
        return new ProcurarCriterio();
    }

    /**
     * Create an instance of {@link ProcurarCriterioResponse }
     * 
     */
    public ProcurarCriterioResponse createProcurarCriterioResponse() {
        return new ProcurarCriterioResponse();
    }

    /**
     * Create an instance of {@link CadastrarCriterio }
     * 
     */
    public CadastrarCriterio createCadastrarCriterio() {
        return new CadastrarCriterio();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcurarCriterioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "procurarCriterioResponse")
    public JAXBElement<ProcurarCriterioResponse> createProcurarCriterioResponse(ProcurarCriterioResponse value) {
        return new JAXBElement<ProcurarCriterioResponse>(_ProcurarCriterioResponse_QNAME, ProcurarCriterioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcurarCriterio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "procurarCriterio")
    public JAXBElement<ProcurarCriterio> createProcurarCriterio(ProcurarCriterio value) {
        return new JAXBElement<ProcurarCriterio>(_ProcurarCriterio_QNAME, ProcurarCriterio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarCriterioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "cadastrarCriterioResponse")
    public JAXBElement<CadastrarCriterioResponse> createCadastrarCriterioResponse(CadastrarCriterioResponse value) {
        return new JAXBElement<CadastrarCriterioResponse>(_CadastrarCriterioResponse_QNAME, CadastrarCriterioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarCriterio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "editarCriterio")
    public JAXBElement<EditarCriterio> createEditarCriterio(EditarCriterio value) {
        return new JAXBElement<EditarCriterio>(_EditarCriterio_QNAME, EditarCriterio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletarCriterio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "deletarCriterio")
    public JAXBElement<DeletarCriterio> createDeletarCriterio(DeletarCriterio value) {
        return new JAXBElement<DeletarCriterio>(_DeletarCriterio_QNAME, DeletarCriterio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarCriterioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "editarCriterioResponse")
    public JAXBElement<EditarCriterioResponse> createEditarCriterioResponse(EditarCriterioResponse value) {
        return new JAXBElement<EditarCriterioResponse>(_EditarCriterioResponse_QNAME, EditarCriterioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarCriterio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "cadastrarCriterio")
    public JAXBElement<CadastrarCriterio> createCadastrarCriterio(CadastrarCriterio value) {
        return new JAXBElement<CadastrarCriterio>(_CadastrarCriterio_QNAME, CadastrarCriterio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletarCriterioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "deletarCriterioResponse")
    public JAXBElement<DeletarCriterioResponse> createDeletarCriterioResponse(DeletarCriterioResponse value) {
        return new JAXBElement<DeletarCriterioResponse>(_DeletarCriterioResponse_QNAME, DeletarCriterioResponse.class, null, value);
    }

}
