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
public class DisciplineGradeReport implements Serializable{
    private static long serialVersionUID = 1L;
    private String login;
    private String nomeDisciplina;
    private Float notaFinal;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
    
    public Float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Float notaFinal) {
        this.notaFinal = notaFinal;
    }
    
}
