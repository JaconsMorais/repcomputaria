/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.services;

import ELearning.dao.impl.NotaDAOImpl;
import ELearning.dao.interfaces.NotaDAO;
import ELearning.model.Nota;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Acessa SP
 */
@WebService(serviceName = "NotaService")
public class NotaService {
    NotaDAO dao = new NotaDAOImpl();

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "cadastrarNota")
    public boolean cadastrarNota(@WebParam(name = "newGrade")
    Nota newGrade) {
        //TODO write your implementation code here:
        return dao.cadastrar(newGrade);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "procurarNota")
    public List<Nota> procurarNota(@WebParam(name = "grade")
    Nota grade) {
        //TODO write your implementation code here:
        return dao.procurar(grade);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "editarNota")
    public Nota editarNota(@WebParam(name = "oldGrade")
    Nota oldGrade, @WebParam(name = "newGrade")
    Nota newGrade) {
        //TODO write your implementation code here:
        return dao.editar(oldGrade,newGrade);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "deletarNota")
    public boolean deletarNota(@WebParam(name = "grade")
    Nota grade) {
        //TODO write your implementation code here:
        return dao.deletar(grade);
    }
}
