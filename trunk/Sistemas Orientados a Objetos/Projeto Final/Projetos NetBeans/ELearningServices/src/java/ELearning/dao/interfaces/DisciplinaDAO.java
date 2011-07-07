/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.dao.interfaces;

import ELearning.model.Disciplina;
import java.util.List;

/**
 *
 * @author Acessa SP
 */
public interface DisciplinaDAO {

    public boolean cadastrar(Disciplina newDiscipline);

    public List<Disciplina> procurar(Disciplina discipline);

    public Disciplina editar(Disciplina oldDiscipline, Disciplina newDiscipline);

    public boolean deletar(Disciplina discipline);
    
}
