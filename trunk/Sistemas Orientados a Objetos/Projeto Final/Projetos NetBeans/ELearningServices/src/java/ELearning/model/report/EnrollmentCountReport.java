/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.model.report;

import java.io.Serializable;

/**
 *
 * @author Acessa SP
 */
public class EnrollmentCountReport implements Serializable{
    private static long serialVersionUID = 1L;
    private String nomeDisciplina;
    private Integer countDisciplina;

    public Integer getCountDisciplina() {
        return countDisciplina;
    }

    public void setCountDisciplina(Integer countDisciplina) {
        this.countDisciplina = countDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
    
}
