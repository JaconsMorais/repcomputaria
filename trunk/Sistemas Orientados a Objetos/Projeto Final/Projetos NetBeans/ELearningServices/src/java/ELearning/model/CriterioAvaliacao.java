/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.model;

import java.io.Serializable;

/**
 *
 * @author Acessa SP
 */
public class CriterioAvaliacao implements Serializable{
    private static long serialVersionUID = 1L;
    private Long idCriterioAvaliacao;
    private Long idDisciplina;
    private String nome;
    private Integer peso;

    public Long getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Long idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Long getIdCriterioAvaliacao() {
        return idCriterioAvaliacao;
    }

    public void setIdCriterioAvaliacao(Long idCriterioAvaliacao) {
        this.idCriterioAvaliacao = idCriterioAvaliacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }
    
}
