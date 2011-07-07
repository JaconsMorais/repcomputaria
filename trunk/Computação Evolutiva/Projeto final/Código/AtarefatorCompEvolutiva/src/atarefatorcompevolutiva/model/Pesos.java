/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package atarefatorcompevolutiva.model;

/**
 *
 * @author Thales
 */
public class Pesos {
    private double pesoPrioridade = 6;
    private double pesoTempoRestante = 5;
    private double pesoTempoEsperado = 4;
    private double pesoPorcentagemRestante = 3;
    private double pesoTotalHoras = 2;
    private double pesoHorasTrabalhadas = 1;

    public double getPesoHorasTrabalhadas() {
        return pesoHorasTrabalhadas;
    }

    public void setPesoHorasTrabalhadas(double pesoHorasTrabalhadas) {
        this.pesoHorasTrabalhadas = pesoHorasTrabalhadas;
    }

    public double getPesoPorcentagemRestante() {
        return pesoPorcentagemRestante;
    }

    public void setPesoPorcentagemRestante(double pesoPorcentagemRestante) {
        this.pesoPorcentagemRestante = pesoPorcentagemRestante;
    }

    public double getPesoPrioridade() {
        return pesoPrioridade;
    }

    public void setPesoPrioridade(double pesoPrioridade) {
        this.pesoPrioridade = pesoPrioridade;
    }

    public double getPesoTempoEsperado() {
        return pesoTempoEsperado;
    }

    public void setPesoTempoEsperado(double pesoTempoEsperado) {
        this.pesoTempoEsperado = pesoTempoEsperado;
    }

    public double getPesoTempoRestante() {
        return pesoTempoRestante;
    }

    public void setPesoTempoRestante(double pesoTempoRestante) {
        this.pesoTempoRestante = pesoTempoRestante;
    }

    public double getPesoTotalHoras() {
        return pesoTotalHoras;
    }

    public void setPesoTotalHoras(double pesoTotalHoras) {
        this.pesoTotalHoras = pesoTotalHoras;
    }
    
}
