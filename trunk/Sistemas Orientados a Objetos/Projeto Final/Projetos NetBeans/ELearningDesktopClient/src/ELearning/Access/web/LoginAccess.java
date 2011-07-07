/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ELearning.Access.web;

import ELearning.services.client.usuario.Usuario;
import ELearning.services.client.usuario.UsuarioService;
import ELearning.services.client.usuario.UsuarioService_Service;

/**
 *
 * @author Acessa SP
 */
public class LoginAccess {
    public static Usuario validaLogin(Usuario user){
            UsuarioService_Service service = new UsuarioService_Service();
            UsuarioService port = service.getUsuarioServicePort();

            user = port.validaLogin(user);

            return user;
    }
}
