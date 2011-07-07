/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package atarefatorcompevolutiva.model;

/**
 *
 * @author Thales
 */
public class ScoreMatch {
    private int idTarefa;
    private double fitness;
    private double match;

    public ScoreMatch(){

    }

    public ScoreMatch(int idTarefa, double fitness, double match){
        setIdTarefa(idTarefa);
        setFitness(fitness);
        setMatch(match);
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public int getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public double getMatch() {
        return match;
    }

    public void setMatch(double match) {
        this.match = match;
    }
}
