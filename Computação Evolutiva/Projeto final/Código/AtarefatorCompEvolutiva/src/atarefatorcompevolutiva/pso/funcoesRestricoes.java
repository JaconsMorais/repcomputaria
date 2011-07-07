/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package atarefatorcompevolutiva.pso;

/**
 *
 * @author user
 */
public class funcoesRestricoes {

    @Deprecated
    public static double getScoreTotal(double scorePrioridade, double scoreTempoRestante, double scoreTempoEsperado, double scorePorcentagemRestante, double scoreTotalHoras, double scoreHorasTrabalhadas){
        return 6*scorePrioridade+5*scoreTempoRestante+4*scoreTempoEsperado+3*scorePorcentagemRestante+2*scoreTotalHoras+scoreHorasTrabalhadas;
    }

    public static double getScoreTotal(double scorePrioridade, double scoreTempoRestante, double scoreTempoEsperado, double scorePorcentagemRestante, double scoreTotalHoras, double scoreHorasTrabalhadas,
            double pesoPrioridade, double pesoTempoRestante, double pesoTempoEsperado, double pesoPorcentagemRestante, double pesoTotalHoras, double pesoHorasTrabalhadas){
        return pesoPrioridade*scorePrioridade+pesoTempoRestante*scoreTempoRestante+pesoTempoEsperado*scoreTempoEsperado+pesoPorcentagemRestante*scorePorcentagemRestante+pesoTotalHoras*scoreTotalHoras+pesoHorasTrabalhadas*scoreHorasTrabalhadas;
    }
}
