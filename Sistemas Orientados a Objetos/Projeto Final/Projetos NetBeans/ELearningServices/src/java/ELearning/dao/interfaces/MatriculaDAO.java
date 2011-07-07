/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.dao.interfaces;

import ELearning.model.Matricula;
import java.util.List;

/**
 *
 * @author Acessa SP
 */
public interface MatriculaDAO {

    public boolean cadastrar(Matricula newEnrollment);

    public List<Matricula> procurar(Matricula enrollment);

    public Matricula editar(Matricula oldEnrollment, Matricula newEnrollment);

    public boolean deletar(Matricula enrollment);
    
}
