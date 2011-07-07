
package ELearning.services.client.disciplina;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ELearning.services.client.disciplina package. 
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

    private final static QName _DeletarDisciplina_QNAME = new QName("http://services.ELearning/", "deletarDisciplina");
    private final static QName _CadastrarDisciplina_QNAME = new QName("http://services.ELearning/", "cadastrarDisciplina");
    private final static QName _CadastrarDisciplinaResponse_QNAME = new QName("http://services.ELearning/", "cadastrarDisciplinaResponse");
    private final static QName _EditarDisciplina_QNAME = new QName("http://services.ELearning/", "editarDisciplina");
    private final static QName _ProcurarDisciplina_QNAME = new QName("http://services.ELearning/", "procurarDisciplina");
    private final static QName _ProcurarDisciplinaResponse_QNAME = new QName("http://services.ELearning/", "procurarDisciplinaResponse");
    private final static QName _DeletarDisciplinaResponse_QNAME = new QName("http://services.ELearning/", "deletarDisciplinaResponse");
    private final static QName _EditarDisciplinaResponse_QNAME = new QName("http://services.ELearning/", "editarDisciplinaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ELearning.services.client.disciplina
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Nota }
     * 
     */
    public Nota createNota() {
        return new Nota();
    }

    /**
     * Create an instance of {@link EditarDisciplinaResponse }
     * 
     */
    public EditarDisciplinaResponse createEditarDisciplinaResponse() {
        return new EditarDisciplinaResponse();
    }

    /**
     * Create an instance of {@link CadastrarDisciplinaResponse }
     * 
     */
    public CadastrarDisciplinaResponse createCadastrarDisciplinaResponse() {
        return new CadastrarDisciplinaResponse();
    }

    /**
     * Create an instance of {@link ProcurarDisciplinaResponse }
     * 
     */
    public ProcurarDisciplinaResponse createProcurarDisciplinaResponse() {
        return new ProcurarDisciplinaResponse();
    }

    /**
     * Create an instance of {@link ProcurarDisciplina }
     * 
     */
    public ProcurarDisciplina createProcurarDisciplina() {
        return new ProcurarDisciplina();
    }

    /**
     * Create an instance of {@link CriterioAvaliacao }
     * 
     */
    public CriterioAvaliacao createCriterioAvaliacao() {
        return new CriterioAvaliacao();
    }

    /**
     * Create an instance of {@link DeletarDisciplina }
     * 
     */
    public DeletarDisciplina createDeletarDisciplina() {
        return new DeletarDisciplina();
    }

    /**
     * Create an instance of {@link DeletarDisciplinaResponse }
     * 
     */
    public DeletarDisciplinaResponse createDeletarDisciplinaResponse() {
        return new DeletarDisciplinaResponse();
    }

    /**
     * Create an instance of {@link Disciplina }
     * 
     */
    public Disciplina createDisciplina() {
        return new Disciplina();
    }

    /**
     * Create an instance of {@link CadastrarDisciplina }
     * 
     */
    public CadastrarDisciplina createCadastrarDisciplina() {
        return new CadastrarDisciplina();
    }

    /**
     * Create an instance of {@link Matricula }
     * 
     */
    public Matricula createMatricula() {
        return new Matricula();
    }

    /**
     * Create an instance of {@link EditarDisciplina }
     * 
     */
    public EditarDisciplina createEditarDisciplina() {
        return new EditarDisciplina();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletarDisciplina }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "deletarDisciplina")
    public JAXBElement<DeletarDisciplina> createDeletarDisciplina(DeletarDisciplina value) {
        return new JAXBElement<DeletarDisciplina>(_DeletarDisciplina_QNAME, DeletarDisciplina.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarDisciplina }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "cadastrarDisciplina")
    public JAXBElement<CadastrarDisciplina> createCadastrarDisciplina(CadastrarDisciplina value) {
        return new JAXBElement<CadastrarDisciplina>(_CadastrarDisciplina_QNAME, CadastrarDisciplina.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarDisciplinaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "cadastrarDisciplinaResponse")
    public JAXBElement<CadastrarDisciplinaResponse> createCadastrarDisciplinaResponse(CadastrarDisciplinaResponse value) {
        return new JAXBElement<CadastrarDisciplinaResponse>(_CadastrarDisciplinaResponse_QNAME, CadastrarDisciplinaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarDisciplina }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "editarDisciplina")
    public JAXBElement<EditarDisciplina> createEditarDisciplina(EditarDisciplina value) {
        return new JAXBElement<EditarDisciplina>(_EditarDisciplina_QNAME, EditarDisciplina.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcurarDisciplina }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "procurarDisciplina")
    public JAXBElement<ProcurarDisciplina> createProcurarDisciplina(ProcurarDisciplina value) {
        return new JAXBElement<ProcurarDisciplina>(_ProcurarDisciplina_QNAME, ProcurarDisciplina.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcurarDisciplinaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "procurarDisciplinaResponse")
    public JAXBElement<ProcurarDisciplinaResponse> createProcurarDisciplinaResponse(ProcurarDisciplinaResponse value) {
        return new JAXBElement<ProcurarDisciplinaResponse>(_ProcurarDisciplinaResponse_QNAME, ProcurarDisciplinaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletarDisciplinaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "deletarDisciplinaResponse")
    public JAXBElement<DeletarDisciplinaResponse> createDeletarDisciplinaResponse(DeletarDisciplinaResponse value) {
        return new JAXBElement<DeletarDisciplinaResponse>(_DeletarDisciplinaResponse_QNAME, DeletarDisciplinaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditarDisciplinaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.ELearning/", name = "editarDisciplinaResponse")
    public JAXBElement<EditarDisciplinaResponse> createEditarDisciplinaResponse(EditarDisciplinaResponse value) {
        return new JAXBElement<EditarDisciplinaResponse>(_EditarDisciplinaResponse_QNAME, EditarDisciplinaResponse.class, null, value);
    }

}
