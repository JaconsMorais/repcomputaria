/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.services;

import ELearning.dao.impl.DisciplinaDAOImpl;
import ELearning.dao.interfaces.DisciplinaDAO;
import ELearning.model.Disciplina;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Acessa SP
 */
@WebService(serviceName = "DisciplinaService")
public class DisciplinaService {
    DisciplinaDAO dao = new DisciplinaDAOImpl();

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "cadastrarDisciplina")
    public boolean cadastrarDisciplina(@WebParam(name = "newDiscipline")
    Disciplina newDiscipline) {
        //TODO write your implementation code here:
        return dao.cadastrar(newDiscipline);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "procurarDisciplina")
    public List<Disciplina> procurarDisciplina(@WebParam(name = "discipline")
    Disciplina discipline) {
        //TODO write your implementation code here:
        return dao.procurar(discipline);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "editarDisciplina")
    public Disciplina editarDisciplina(@WebParam(name = "oldDiscipline")
    Disciplina oldDiscipline, @WebParam(name = "newDiscipline")
    Disciplina newDiscipline) {
        //TODO write your implementation code here:
        return dao.editar(oldDiscipline,newDiscipline);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "deletarDisciplina")
    public boolean deletarDisciplina(@WebParam(name = "discipline")
    Disciplina discipline) {
        //TODO write your implementation code here:
        return dao.deletar(discipline);
    }
}
