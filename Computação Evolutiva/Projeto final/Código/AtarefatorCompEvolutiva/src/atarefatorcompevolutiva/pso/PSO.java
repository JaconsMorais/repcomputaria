/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package atarefatorcompevolutiva.pso;

import atarefatorcompevolutiva.model.Parametros;
import atarefatorcompevolutiva.model.Pesos;
import atarefatorcompevolutiva.model.ScoreTarefa;
import atarefatorcompevolutiva.model.VelScoreTarefa;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class PSO {

    private double initialWeight = 0.9; //fator de inércia inicial
    private double c1 = 2; //termo cognitivo
    private double c2 = 2; //termo social
    private int maximumGeneration; //número de gerações
    private double maximumVelocity = 10.0;
    private double minimumPosition = 0.0;
    private double maximumPosition = 1000.0;
    private double[] pBest;
    private double fitness;
    private int gBest = 0;
    private double weight;
    private Pesos pesos;
    private Parametros parametros;
    private ArrayList population;
    private ArrayList pBestPop;
    private ArrayList velocity;
    private Logger LogPSO;

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public ArrayList getPopulation() {
        return population;
    }

    public void setPopulation(ArrayList scores) {
        this.population = scores;
    }

    public void setPopulation(List scores) {
        this.population = (ArrayList)scores;
    }

    public Parametros getParametros() {
        return parametros;
    }

    public void setParametros(Parametros parametros) {
        this.parametros = parametros;
    }

    public Pesos getPesos() {
        return pesos;
    }

    public void setPesos(Pesos pesos) {
        this.pesos = pesos;
    }

    public void doPSO(){
        //population = Populacoes.getPop(/*fazer o XML*/);
        LogPSO = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        pBestPop = (ArrayList) population.clone();
        velocity = Populacoes.getVel(population.size());
        maximumGeneration = parametros.getMaximumGeneration();
        c1 = parametros.getC1();
        c2 = parametros.getC2();
        weight = parametros.getInitialWeight();
        pBest = new double[population.size()];
        for (int i = 0; i < population.size();i++){
            pBest[i] = 0;
        }

        LogPSO.info("Geração, Agente: Scores(prioridade - tempo restante - tempo esperado - porcentagem restante - total de horas - horas trabalhadas - total)");

        for(int i = 0; i < maximumGeneration;i++){
            //weight = (initialWeight-0.4) * (maximumGeneration - i) /maximumGeneration +0.4;//variação de 0.4 a 0.9
            for(int j = 0; j < population.size(); j++){
                ScoreTarefa element = (ScoreTarefa)population.get(j);
                VelScoreTarefa v = (VelScoreTarefa)velocity.get(j);

                //System.out.println(element.getQtdArroz() + " " + element.getQtdFeijao() + " " + element.getQtdLeite() + " " + element.getQtdOvos());

                fitness = funcoesRestricoes.getScoreTotal(element.getScorePrioridade(), element.getScoreTempoRestante(), element.getScoreTempoEsperado(), element.getScorePorcentagemRestante(), element.getScoreTotalHoras(), element.getScoreHorasTrabalhadas(),pesos.getPesoPrioridade(), pesos.getPesoTempoRestante(), pesos.getPesoTempoEsperado(), pesos.getPesoPorcentagemRestante(), pesos.getPesoTotalHoras(), pesos.getPesoHorasTrabalhadas());
                if(j == 0) pBest[j] = fitness;
                if(fitness < pBest[j]){
                    pBest[j] = fitness;
                    pBestPop.add(j, element);
                    pBestPop.remove(j+1);
                    if (pBest[j] < pBest[gBest])
                    {
                        gBest=j;
                    }
                }

                v = updateVel(weight,v,(ScoreTarefa)pBestPop.get(j),(ScoreTarefa)pBestPop.get(gBest),element);
                element = updatePos(v,element);

                LogPSO.info("Geração " + (i+1) + ", Agente " + (j+1) + ":" + element.getScorePrioridade() + " - " + element.getScoreTempoRestante() + " - " + element.getScoreTempoEsperado() + " - " + element.getScorePorcentagemRestante() + " - " + element.getScoreTotalHoras() + " - " + element.getScoreHorasTrabalhadas() + " - " + fitness);
                velocity.add(j,v);
                velocity.remove(j+1);
                population.add(j,element);
                population.remove(j+1);
            }
        }
    }

    private double getVelocity(double vel){
        if(vel > maximumVelocity){
            vel = maximumVelocity;
        }else if(vel < -maximumVelocity){
            vel = -maximumVelocity;
        }

        return vel;
    }

    private double getPosition(double pos){
        if(pos > maximumPosition){
            pos = maximumPosition;
        }else if (pos < minimumPosition){
            pos = minimumPosition;
        }


        return pos;
    }

    private VelScoreTarefa updateVel(double weight,VelScoreTarefa v, ScoreTarefa pBest, ScoreTarefa gBest, ScoreTarefa element) {
        v.setVelScorePrioridade(getVelocity(weight*v.getVelScorePrioridade() + c1*Math.random()*(pBest.getScorePrioridade() - element.getScorePrioridade())
                 + c2*Math.random()*(gBest.getScorePrioridade() - element.getScorePrioridade())));
        v.setVelScoreTempoRestante(getVelocity(weight*v.getVelScoreTempoRestante() + c1*Math.random()*(pBest.getScoreTempoRestante() - element.getScoreTempoRestante())
                 + c2*Math.random()*(gBest.getScoreTempoRestante() - element.getScoreTempoRestante())));
        v.setVelScoreTempoEsperado(getVelocity(weight*v.getVelScoreTempoEsperado() + c1*Math.random()*(pBest.getScoreTempoEsperado() - element.getScoreTempoEsperado())
                 + c2*Math.random()*(gBest.getScoreTempoEsperado() - element.getScoreTempoEsperado())));
        v.setVelScorePorcentagemRestante(getVelocity(weight*v.getVelScorePorcentagemRestante() + c1*Math.random()*(pBest.getScorePorcentagemRestante() - element.getScorePorcentagemRestante())
                 + c2*Math.random()*(gBest.getScorePorcentagemRestante() - element.getScorePorcentagemRestante())));
        v.setVelScoreTotalHoras(getVelocity(weight*v.getVelScoreTotalHoras() + c1*Math.random()*(pBest.getScoreTotalHoras() - element.getScoreTotalHoras())
                 + c2*Math.random()*(gBest.getScoreTotalHoras() - element.getScoreTotalHoras())));
        v.setVelScoreHorasTrabalhadas(getVelocity(weight*v.getVelScoreHorasTrabalhadas() + c1*Math.random()*(pBest.getScoreHorasTrabalhadas() - element.getScoreHorasTrabalhadas())
                 + c2*Math.random()*(gBest.getScoreHorasTrabalhadas() - element.getScoreHorasTrabalhadas())));

        return v;
    }

    private ScoreTarefa updatePos(VelScoreTarefa v, ScoreTarefa element) {
        element.setScorePrioridade(getPosition(element.getScorePrioridade() + v.getVelScorePrioridade()));
        element.setScoreTempoRestante(getPosition(element.getScoreTempoRestante() + v.getVelScoreTempoRestante()));
        element.setScoreTempoEsperado(getPosition(element.getScoreTempoEsperado() + v.getVelScoreTempoEsperado()));
        element.setScorePorcentagemRestante(getPosition(element.getScorePorcentagemRestante() + v.getVelScorePorcentagemRestante()));
        element.setScoreTotalHoras(getPosition(element.getScoreTotalHoras() + v.getVelScoreTotalHoras()));
        element.setScoreHorasTrabalhadas(getPosition(element.getScoreHorasTrabalhadas() + v.getVelScorePorcentagemRestante()));

        return element;
    }

}
