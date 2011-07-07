/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.dao.interfaces;

import ELearning.model.Aluno;
import ELearning.model.special.StudentEnrollmentModel;
import java.util.List;

/**
 *
 * @author Acessa SP
 */
public interface AlunoDAO {

    public boolean cadastrar(Aluno newStudent);

    public List<Aluno> procurar(Aluno student);

    public Aluno editar(Aluno oldStudent, Aluno newStudent);

    public boolean deletar(Aluno student);

    public List<StudentEnrollmentModel> procurarMatriculasNaoFeitas(Aluno student);
    
}
