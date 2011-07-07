/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.services;

import ELearning.dao.impl.CriterioAvaliacaoDAOImpl;
import ELearning.dao.interfaces.CriterioAvaliacaoDAO;
import ELearning.model.CriterioAvaliacao;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Acessa SP
 */
@WebService(serviceName = "CriterioAvaliacaoService")
public class CriterioAvaliacaoService {
    CriterioAvaliacaoDAO dao = new CriterioAvaliacaoDAOImpl();

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "cadastrarCriterio")
    public boolean cadastrarCriterio(@WebParam(name = "newCriterion")
    CriterioAvaliacao newCriterion) {
        //TODO write your implementation code here:
        return dao.cadastrar(newCriterion);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "procurarCriterio")
    public List<CriterioAvaliacao> procurarCriterio(@WebParam(name = "criterion")
    CriterioAvaliacao criterion) {
        //TODO write your implementation code here:
        return dao.procurar(criterion);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "editarCriterio")
    public CriterioAvaliacao editarCriterio(@WebParam(name = "oldCriterion")
    CriterioAvaliacao oldCriterion, @WebParam(name = "newCriterion")
    CriterioAvaliacao newCriterion) {
        //TODO write your implementation code here:
        return dao.editar(oldCriterion,newCriterion);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "deletarCriterio")
    public boolean deletarCriterio(@WebParam(name = "criterion")
    CriterioAvaliacao criterion) {
        //TODO write your implementation code here:
        return dao.deletar(criterion);
    }
}
