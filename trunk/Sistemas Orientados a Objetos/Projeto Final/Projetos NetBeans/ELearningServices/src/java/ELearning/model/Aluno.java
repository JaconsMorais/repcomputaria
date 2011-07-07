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
public class Aluno extends Pessoa implements Serializable{
    private static long serialVersionUID = 1L;
    private List<Matricula> matriculas;

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
    
}
