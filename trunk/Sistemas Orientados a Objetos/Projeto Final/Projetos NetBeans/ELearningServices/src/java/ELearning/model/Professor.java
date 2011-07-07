/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Acessa SP
 */
public class Professor extends Pessoa implements Serializable{
    private static long serialVersionUID = 1L;
    private List<Disciplina> disciplinas;

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
}
