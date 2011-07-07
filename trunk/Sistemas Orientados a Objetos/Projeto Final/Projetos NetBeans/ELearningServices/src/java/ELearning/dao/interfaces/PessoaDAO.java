/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.dao.interfaces;

import ELearning.model.Pessoa;
import java.util.List;

/**
 *
 * @author Acessa SP
 */
public interface PessoaDAO {

    public boolean cadastrar(Pessoa newPerson);

    public Pessoa editar(Pessoa oldPerson, Pessoa newPerson);

    public boolean deletar(Pessoa person);

    public List<Pessoa> procurar(Pessoa person);
    
}
