
package ELearning.services.client.matricula;

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
@WebServiceClient(name = "MatriculaService", targetNamespace = "http://services.ELearning/", wsdlLocation = "http://localhost:9960/ELearningServices/MatriculaService?wsdl")
public class MatriculaService_Service
    extends Service
{

    private final static URL MATRICULASERVICE_WSDL_LOCATION;
    private final static WebServiceException MATRICULASERVICE_EXCEPTION;
    private final static QName MATRICULASERVICE_QNAME = new QName("http://services.ELearning/", "MatriculaService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9960/ELearningServices/MatriculaService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MATRICULASERVICE_WSDL_LOCATION = url;
        MATRICULASERVICE_EXCEPTION = e;
    }

    public MatriculaService_Service() {
        super(__getWsdlLocation(), MATRICULASERVICE_QNAME);
    }

    public MatriculaService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), MATRICULASERVICE_QNAME, features);
    }

    public MatriculaService_Service(URL wsdlLocation) {
        super(wsdlLocation, MATRICULASERVICE_QNAME);
    }

    public MatriculaService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MATRICULASERVICE_QNAME, features);
    }

    public MatriculaService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MatriculaService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MatriculaService
     */
    @WebEndpoint(name = "MatriculaServicePort")
    public MatriculaService getMatriculaServicePort() {
        return super.getPort(new QName("http://services.ELearning/", "MatriculaServicePort"), MatriculaService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MatriculaService
     */
    @WebEndpoint(name = "MatriculaServicePort")
    public MatriculaService getMatriculaServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.ELearning/", "MatriculaServicePort"), MatriculaService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MATRICULASERVICE_EXCEPTION!= null) {
            throw MATRICULASERVICE_EXCEPTION;
        }
        return MATRICULASERVICE_WSDL_LOCATION;
    }

}
