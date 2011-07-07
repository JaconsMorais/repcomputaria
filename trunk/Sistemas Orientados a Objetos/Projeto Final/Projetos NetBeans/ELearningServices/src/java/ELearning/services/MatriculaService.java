/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.services;

import ELearning.dao.impl.MatriculaDAOImpl;
import ELearning.dao.interfaces.MatriculaDAO;
import ELearning.model.Matricula;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Acessa SP
 */
@WebService(serviceName = "MatriculaService")
public class MatriculaService {
    MatriculaDAO dao = new MatriculaDAOImpl();

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "cadastrarMatricula")
    public boolean cadastrarMatricula(@WebParam(name = "newEnrollment")
    Matricula newEnrollment) {
        //TODO write your implementation code here:
        return dao.cadastrar(newEnrollment);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "procurarMatricula")
    public List<Matricula> procurarMatricula(@WebParam(name = "enrollment")
    Matricula enrollment) {
        //TODO write your implementation code here:
        return dao.procurar(enrollment);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "editarMatricula")
    public Matricula editarMatricula(@WebParam(name = "oldEnrollment")
    Matricula oldEnrollment, @WebParam(name = "newEnrollment")
    Matricula newEnrollment) {
        //TODO write your implementation code here:
        return dao.editar(oldEnrollment,newEnrollment);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "deletarMatricula")
    public boolean deletarMatricula(@WebParam(name = "enrollment")
    Matricula enrollment) {
        //TODO write your implementation code here:
        return dao.deletar(enrollment);
    }
}
