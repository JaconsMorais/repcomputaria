/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.services;

import ELearning.dao.impl.ProfessorDAOImpl;
import ELearning.dao.interfaces.ProfessorDAO;
import ELearning.model.Professor;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Acessa SP
 */
@WebService(serviceName = "ProfessorService")
public class ProfessorService {
    ProfessorDAO dao = new ProfessorDAOImpl();
    
    @WebMethod(operationName = "cadastrarProfessor")
    public boolean cadastrarProfessor(@WebParam(name = "newProfessor")
    Professor newProfessor) {
        //TODO write your implementation code here:
        //cadastra o aluno
        return dao.cadastrar(newProfessor);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "procurarProfessor")
    public List<Professor> procurarProfessor(@WebParam(name = "professor")
    Professor professor) {
        //TODO write your implementation code here:
        return dao.procurar(professor);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "editarProfessor")
    public Professor editarProfessor(@WebParam(name = "oldProfessor")
    Professor oldProfessor, @WebParam(name = "newProfessor")
    Professor newProfessor) {
        //TODO write your implementation code here:
        return dao.editar(oldProfessor,newProfessor);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "deletarProfessor")
    public boolean deletarProfessor(@WebParam(name = "professor")
    Professor professor) {
        //TODO write your implementation code here:
        return dao.deletar(professor);
    }
}
