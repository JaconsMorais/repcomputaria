
package ELearning.services.client.disciplina;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-hudson-752-
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "DisciplinaService", targetNamespace = "http://services.ELearning/", wsdlLocation = "http://localhost:9960/ELearningServices/DisciplinaService?wsdl")
public class DisciplinaService_Service
    extends Service
{

    private final static URL DISCIPLINASERVICE_WSDL_LOCATION;
    private final static WebServiceException DISCIPLINASERVICE_EXCEPTION;
    private final static QName DISCIPLINASERVICE_QNAME = new QName("http://services.ELearning/", "DisciplinaService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9960/ELearningServices/DisciplinaService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DISCIPLINASERVICE_WSDL_LOCATION = url;
        DISCIPLINASERVICE_EXCEPTION = e;
    }

    public DisciplinaService_Service() {
        super(__getWsdlLocation(), DISCIPLINASERVICE_QNAME);
    }

    public DisciplinaService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), DISCIPLINASERVICE_QNAME, features);
    }

    public DisciplinaService_Service(URL wsdlLocation) {
        super(wsdlLocation, DISCIPLINASERVICE_QNAME);
    }

    public DisciplinaService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DISCIPLINASERVICE_QNAME, features);
    }

    public DisciplinaService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DisciplinaService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DisciplinaService
     */
    @WebEndpoint(name = "DisciplinaServicePort")
    public DisciplinaService getDisciplinaServicePort() {
        return super.getPort(new QName("http://services.ELearning/", "DisciplinaServicePort"), DisciplinaService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DisciplinaService
     */
    @WebEndpoint(name = "DisciplinaServicePort")
    public DisciplinaService getDisciplinaServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.ELearning/", "DisciplinaServicePort"), DisciplinaService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DISCIPLINASERVICE_EXCEPTION!= null) {
            throw DISCIPLINASERVICE_EXCEPTION;
        }
        return DISCIPLINASERVICE_WSDL_LOCATION;
    }

}