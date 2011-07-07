/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.services;

import ELearning.dao.impl.PessoaDAOImpl;
import ELearning.dao.interfaces.PessoaDAO;
import ELearning.model.Pessoa;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Acessa SP
 */
@WebService(serviceName = "PessoaService")
public class PessoaService {
    PessoaDAO dao = new PessoaDAOImpl();
    
    @WebMethod(operationName = "cadastrarPessoa")
    public boolean cadastrarPessoa(@WebParam(name = "newPerson")
    Pessoa newPerson) {
        //TODO write your implementation code here:
        //cadastra a pessoa
        return dao.cadastrar(newPerson);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "editarPessoa")
    public Pessoa editarPessoa(@WebParam(name = "oldPerson")
    Pessoa oldPerson, @WebParam(name = "newPerson")
    Pessoa newPerson) {
        //TODO write your implementation code here:
        return dao.editar(oldPerson,newPerson);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "deletarPessoa")
    public boolean deletarPessoa(@WebParam(name = "person")
    Pessoa person) {
        //TODO write your implementation code here:
        return dao.deletar(person);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "procurarPessoa")
    public List<Pessoa> procurarPessoa(@WebParam(name = "person")
    Pessoa person) {
        //TODO write your implementation code here:
        return dao.procurar(person);
    }
}
