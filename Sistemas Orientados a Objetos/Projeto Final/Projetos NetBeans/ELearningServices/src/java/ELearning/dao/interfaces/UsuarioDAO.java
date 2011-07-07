/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.dao.interfaces;

import ELearning.model.Usuario;
import java.util.List;

/**
 *
 * @author Acessa SP
 */
public interface UsuarioDAO {

    public Usuario validaLogin(Usuario loginUser);

    public boolean cadastrar(Usuario newUser);

    public Usuario editar(Usuario oldPessoa, Usuario newPessoa);

    public boolean deletar(Usuario user);

    public List<Usuario> procurar(Usuario user);
    
}
