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
public class StudentListReport implements Serializable{
    private static long serialVersionUID = 1L;
    private String nomeDisciplina;
    private String login;

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
    
}
