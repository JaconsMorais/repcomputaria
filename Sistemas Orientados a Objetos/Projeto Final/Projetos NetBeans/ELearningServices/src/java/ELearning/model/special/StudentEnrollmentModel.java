/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.model.special;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Acessa SP
 */
public class StudentEnrollmentModel implements Serializable{
    private static long serialVersionUID = 1L;
    private Long idDisciplina;
    private String nomeDisciplina;
    private String login;
    private Date dataInicio;
    private Date dataFim;

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Long getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Long idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
}
