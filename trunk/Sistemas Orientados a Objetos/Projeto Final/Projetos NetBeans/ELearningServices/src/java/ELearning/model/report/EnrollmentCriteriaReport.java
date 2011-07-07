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
public class EnrollmentCriteriaReport implements Serializable{
    private static long serialVersionUID = 1L;
    private String nomeDisciplina;
    private String nome;
    private Integer peso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }
    
}
