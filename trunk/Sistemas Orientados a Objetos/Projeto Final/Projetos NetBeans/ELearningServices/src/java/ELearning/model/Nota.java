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
public class Nota implements Serializable{
    private static long serialVersionUID = 1L;
    private Long idNota;
    private Long idMatricula;
    private Long idCriterion;
    private Float notaCriterio;

    public Long getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
    }
    
    public Long getIdCriterion() {
        return idCriterion;
    }

    public void setIdCriterion(Long idCriterion) {
        this.idCriterion = idCriterion;
    }

    public Long getIdNota() {
        return idNota;
    }

    public void setIdNota(Long idNota) {
        this.idNota = idNota;
    }

    public Float getNotaCriterio() {
        return notaCriterio;
    }

    public void setNotaCriterio(Float notaCriterio) {
        this.notaCriterio = notaCriterio;
    }
    
}
