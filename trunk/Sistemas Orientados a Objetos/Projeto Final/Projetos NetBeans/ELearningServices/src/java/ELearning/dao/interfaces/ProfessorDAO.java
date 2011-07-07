/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.dao.interfaces;

import ELearning.model.Professor;
import java.util.List;

/**
 *
 * @author Acessa SP
 */
public interface ProfessorDAO {

    public boolean cadastrar(Professor newProfessor);

    public List<Professor> procurar(Professor professor);

    public Professor editar(Professor oldProfessor, Professor newProfessor);

    public boolean deletar(Professor professor);
    
}
