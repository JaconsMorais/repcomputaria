/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package atarefatorcompevolutiva.model;

import java.util.Date;

/**
 *
 * @author Thales
 */
public class ScoreTarefa {
    private int idTarefa;
    private double scorePrioridade;
    private double scoreTempoRestante;
    private double scoreTempoEsperado;
    private double scorePorcentagemRestante;
    private double scoreTotalHoras;
    private double scoreHorasTrabalhadas;

    public ScoreTarefa(){

    }

    public ScoreTarefa(int idTarefa, int prioridade, Date dataAtual, Date dataInicio, Date dataFinal,int porcentagem, double totalHoras, double horasTrabalhadas){
        double tempoRestante, tempoEsperado, porcentagemRestante;

        setIdTarefa(idTarefa);

        setScorePrioridade(1000 / prioridade);
        tempoRestante = (dataAtual.getTime() - dataInicio.getTime())/3600000; //1 hora = 3600000 milisegundos
        if(tempoRestante < 1) tempoRestante = 1;
        setScoreTempoRestante(1000 / tempoRestante);
        tempoEsperado = (dataFinal.getTime() - dataInicio.getTime())/3600000; //1 hora = 3600000 milisegundos
        if(tempoEsperado < 1) tempoEsperado = 1;
        setScoreTempoEsperado(1000 / tempoEsperado);
        porcentagemRestante = 100 - porcentagem;
        if(porcentagemRestante < 1) porcentagemRestante = 1;
        setScorePorcentagemRestante(1000 / (10*porcentagemRestante));
        if(totalHoras < 1) totalHoras = 1;
        setScoreTotalHoras(1000 / totalHoras);
        if(horasTrabalhadas < 1) horasTrabalhadas = 1;
        setScoreHorasTrabalhadas(1000 / horasTrabalhadas);

    }

    public double getScoreHorasTrabalhadas() {
        return scoreHorasTrabalhadas;
    }

    public void setScoreHorasTrabalhadas(double scoreHorasTrabalhadas) {
        this.scoreHorasTrabalhadas = scoreHorasTrabalhadas;
    }

    public double getScoreTotalHoras() {
        return scoreTotalHoras;
    }

    public void setScoreTotalHoras(double scoreTotalHoras) {
        this.scoreTotalHoras = scoreTotalHoras;
    }

    public double getScorePorcentagemRestante() {
        return scorePorcentagemRestante;
    }

    public void setScorePorcentagemRestante(double scorePorcentagemRestante) {
        this.scorePorcentagemRestante = scorePorcentagemRestante;
    }

    public double getScorePrioridade() {
        return scorePrioridade;
    }

    public void setScorePrioridade(double scorePrioridade) {
        this.scorePrioridade = scorePrioridade;
    }

    public double getScoreTempoEsperado() {
        return scoreTempoEsperado;
    }

    public void setScoreTempoEsperado(double scoreTempoEsperado) {
        this.scoreTempoEsperado = scoreTempoEsperado;
    }

    public double getScoreTempoRestante() {
        return scoreTempoRestante;
    }

    public void setScoreTempoRestante(double scoreTempoRestante) {
        this.scoreTempoRestante = scoreTempoRestante;
    }

    public int getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }
    
}
