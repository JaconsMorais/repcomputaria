/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.dao.interfaces;

import ELearning.model.Nota;
import java.util.List;

/**
 *
 * @author Acessa SP
 */
public interface NotaDAO {

    public boolean cadastrar(Nota newGrade);

    public List<Nota> procurar(Nota grade);

    public Nota editar(Nota oldGrade, Nota newGrade);

    public boolean deletar(Nota grade);
    
}
