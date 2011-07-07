/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Acessa SP
 */
public class Disciplina implements Serializable{
    private static long serialVersionUID = 1L;
    private Long idDisciplina;
    private Long idProfessor;
    private String nomeDisciplina;
    private Integer numNotas;
    private Date dataInicio;
    private Date dataFim;
    private List<CriterioAvaliacao> criteria;
    private List<Matricula> matriculas;

    public List<CriterioAvaliacao> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<CriterioAvaliacao> criteria) {
        this.criteria = criteria;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
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

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public Integer getNumNotas() {
        return numNotas;
    }

    public void setNumNotas(Integer numNotas) {
        this.numNotas = numNotas;
    }
    
}
