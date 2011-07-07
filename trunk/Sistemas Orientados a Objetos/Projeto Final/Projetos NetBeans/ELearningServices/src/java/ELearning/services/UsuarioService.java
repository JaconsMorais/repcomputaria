/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.services;

import ELearning.dao.impl.UsuarioDAOImpl;
import ELearning.dao.interfaces.UsuarioDAO;
import ELearning.model.Usuario;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Acessa SP
 */
@WebService(serviceName = "UsuarioService")
public class UsuarioService {
    UsuarioDAO dao = new UsuarioDAOImpl();

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "validaLogin")
    public Usuario validaLogin(@WebParam(name = "loginUser")
    Usuario loginUser) {
        //TODO write your implementation code here:
        //select do login
        //se achar, retorna o usuario correspondente
        return dao.validaLogin(loginUser);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "cadastrarUsuario")
    public boolean cadastrarUsuario(@WebParam(name = "newUser")
    Usuario newUser) {
        //TODO write your implementation code here:
        //cadastra o usuário, pessoa e (aluno ou professor)
        return dao.cadastrar(newUser);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "editarUsuario")
    public Usuario editarUsuario(@WebParam(name = "oldUser")
    Usuario oldPessoa,  @WebParam(name = "newUser")
    Usuario newPessoa) {
        //TODO write your implementation code here:
        return dao.editar(oldPessoa,newPessoa);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "deletarUsuario")
    public boolean deletarUsuario(@WebParam(name = "user")
    Usuario user) {
        //TODO write your implementation code here:
        return dao.deletar(user);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "procurarUsuario")
    public List<Usuario> procurarUsuario(@WebParam(name = "user")
    Usuario user) {
        //TODO write your implementation code here:
        return dao.procurar(user);
    }
    
    
}
