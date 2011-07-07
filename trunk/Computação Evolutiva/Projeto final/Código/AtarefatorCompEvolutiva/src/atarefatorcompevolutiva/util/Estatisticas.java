/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package atarefatorcompevolutiva.util;

import atarefatorcompevolutiva.model.ScoreMatch;
import java.util.List;

/**
 *
 * @author user
 */
public class Estatisticas {
//média e desvio padrão

     private double mediaScores;
     private double desvioScores;
     private double mediaScoreMatches;
     private double desvioScoreMatches;

     private List<ScoreMatch> matchScores;

     public Estatisticas(List<ScoreMatch> matchScores){
         this.matchScores = matchScores;
         medias();
         desviosPadrao();
     }

     private void medias(){
        double somaScores = 0;
        double somaScoreMatches = 0;

        for(ScoreMatch sm : matchScores){
            somaScores += sm.getFitness();
            somaScoreMatches += sm.getMatch();
        }

        mediaScores = somaScores / matchScores.size();
        mediaScoreMatches = somaScoreMatches / matchScores.size();
     }

     private void desviosPadrao(){
        double somaScores = 0;
        double somaScoreMatches = 0;

        for(ScoreMatch sm : matchScores){
            somaScores += (sm.getFitness() - mediaScores)*(sm.getFitness() - mediaScores);
            somaScoreMatches += (sm.getMatch() - mediaScoreMatches)*(sm.getMatch() - mediaScoreMatches);
        }

        desvioScores = Math.sqrt(somaScores / matchScores.size());
        desvioScoreMatches = Math.sqrt(somaScoreMatches / matchScores.size());
     }

    public double getDesvioScoreMatches() {
        return desvioScoreMatches;
    }

    public double getDesvioScores() {
        return desvioScores;
    }
    public double getMediaScoreMatches() {
        return mediaScoreMatches;
    }

    public double getMediaScores() {
        return mediaScores;
    }
}
