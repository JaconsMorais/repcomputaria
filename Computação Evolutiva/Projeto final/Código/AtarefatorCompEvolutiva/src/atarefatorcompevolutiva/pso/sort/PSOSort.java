/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package atarefatorcompevolutiva.pso.sort;

import atarefatorcompevolutiva.model.Parametros;
import atarefatorcompevolutiva.model.Pesos;
import atarefatorcompevolutiva.model.ScoreMatch;
import atarefatorcompevolutiva.model.ScoreTarefa;
import atarefatorcompevolutiva.model.Tarefa;
import atarefatorcompevolutiva.pso.PSO;
import atarefatorcompevolutiva.pso.funcoesRestricoes;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;


/**
 *
 * @author Thales
 */
public class PSOSort {
    ArrayList<ScoreTarefa> originalScore;
    ArrayList<ScoreTarefa> optimumScore;
    ArrayList<ScoreMatch> matchScores = new ArrayList<ScoreMatch>();
    public static final Random RND = new Random();
    Logger LogPSOSort = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public List<ScoreMatch> doPSOSort(ArrayList<ScoreTarefa> scores, Pesos pesos, Parametros parametros){
        originalScore = (ArrayList<ScoreTarefa>)scores.clone();

        PSO pso = new PSO();
        pso.setPesos(pesos);
        pso.setParametros(parametros);
        pso.setPopulation(originalScore);
        pso.doPSO();

        optimumScore = pso.getPopulation();
        double mediaScores = 0;
        for(int i = 0;i < optimumScore.size();i++){
            ScoreTarefa element = (ScoreTarefa)optimumScore.get(i);
            mediaScores += funcoesRestricoes.getScoreTotal(element.getScorePrioridade(), element.getScoreTempoRestante(), element.getScoreTempoEsperado(), element.getScorePorcentagemRestante(), element.getScoreTotalHoras(), element.getScoreHorasTrabalhadas());
        }
        mediaScores /= optimumScore.size();

        for(int i = 0;i < originalScore.size();i++){
            ScoreTarefa element = (ScoreTarefa)originalScore.get(i);
            double fitness = funcoesRestricoes.getScoreTotal(element.getScorePrioridade(), element.getScoreTempoRestante(), element.getScoreTempoEsperado(), element.getScorePorcentagemRestante(), element.getScoreTotalHoras(), element.getScoreHorasTrabalhadas(), pesos.getPesoPrioridade(), pesos.getPesoTempoRestante(), pesos.getPesoTempoEsperado(), pesos.getPesoPorcentagemRestante(),pesos.getPesoTotalHoras(), pesos.getPesoHorasTrabalhadas());
            double scoreMatch = fitness - mediaScores;
            ScoreMatch match = new ScoreMatch(element.getIdTarefa(), fitness, (scoreMatch < 0) ? scoreMatch * -1 : scoreMatch);
            matchScores.add(match);
        }

        sort(matchScores);
        for(int i = 0;i < matchScores.size();i++)
            LogPSOSort.info("" + matchScores.get(i).getIdTarefa() + " " + matchScores.get(i).getFitness() + " " + matchScores.get(i).getMatch());

        return matchScores;
    }

    private static <E> void swap(ArrayList<E> array, int i, int j) {
        E tmp = array.get(i);
        array.add(i, array.get(j));
        array.remove(i+1);
        array.add(j, tmp);
        array.remove(j+1);
    }

    private static int partition(ArrayList array, int begin, int end) {
        int index = begin + RND.nextInt(end - begin + 1);
        ScoreMatch pivot = (ScoreMatch) array.get(index);
        swap(array, index, end);
        for (int i = index = begin; i < end; ++i) {
            if (((ScoreMatch)array.get(i)).getMatch() <= pivot.getMatch()
                  || (((ScoreMatch)array.get(i)).getMatch() == pivot.getMatch()
                  && ((ScoreMatch)array.get(i)).getFitness() <= pivot.getFitness())) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end);
        return (index);
    }

    private static void qsort(ArrayList array, int begin, int end) {
        if (end > begin) {
            int index = partition(array, begin, end);
            qsort(array, begin, index - 1);
            qsort(array, index + 1, end);
        }
    }

    public static void sort(ArrayList array) {
        qsort(array, 0, array.size() - 1);
    }
}
