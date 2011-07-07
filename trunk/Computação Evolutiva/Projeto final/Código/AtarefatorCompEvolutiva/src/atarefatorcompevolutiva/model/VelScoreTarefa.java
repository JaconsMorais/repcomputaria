/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package atarefatorcompevolutiva.model;

/**
 *
 * @author Thales
 */
public class VelScoreTarefa {
    private double velScorePrioridade;
    private double velScoreTempoRestante;
    private double velScoreTempoEsperado;
    private double velScorePorcentagemRestante;
    private double velScoreTotalHoras;
    private double velScoreHorasTrabalhadas;

    public VelScoreTarefa(){
        setVelScorePrioridade(0);
        setVelScoreTempoRestante(0);
        setVelScoreTempoEsperado(0);
        setVelScorePorcentagemRestante(0);
        setVelScoreTotalHoras(0);
        setVelScoreHorasTrabalhadas(0);
    }
    
    public double getVelScoreHorasTrabalhadas() {
        return velScoreHorasTrabalhadas;
    }

    public void setVelScoreHorasTrabalhadas(double velScoreHorasTrabalhadas) {
        this.velScoreHorasTrabalhadas = velScoreHorasTrabalhadas;
    }

    public double getVelScoreTotalHoras() {
        return velScoreTotalHoras;
    }

    public void setVelScoreTotalHoras(double velScoreTotalHoras) {
        this.velScoreTotalHoras = velScoreTotalHoras;
    }

    public double getVelScorePorcentagemRestante() {
        return velScorePorcentagemRestante;
    }

    public void setVelScorePorcentagemRestante(double velScorePorcentagemRestante) {
        this.velScorePorcentagemRestante = velScorePorcentagemRestante;
    }

    public double getVelScorePrioridade() {
        return velScorePrioridade;
    }

    public void setVelScorePrioridade(double velScorePrioridade) {
        this.velScorePrioridade = velScorePrioridade;
    }

    public double getVelScoreTempoEsperado() {
        return velScoreTempoEsperado;
    }

    public void setVelScoreTempoEsperado(double velScoreTempoEsperado) {
        this.velScoreTempoEsperado = velScoreTempoEsperado;
    }

    public double getVelScoreTempoRestante() {
        return velScoreTempoRestante;
    }

    public void setVelScoreTempoRestante(double velScoreTempoRestante) {
        this.velScoreTempoRestante = velScoreTempoRestante;
    }

    
}
