/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package atarefatorcompevolutiva.pso;

import atarefatorcompevolutiva.model.ScoreTarefa;
import atarefatorcompevolutiva.model.Tarefa;
import atarefatorcompevolutiva.model.VelScoreTarefa;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class Populacoes {
    public static ArrayList<ScoreTarefa> getPop(List<Tarefa> tarefas){
        ArrayList<ScoreTarefa> list = new ArrayList<ScoreTarefa>();

        for(Tarefa tarefa : tarefas){
            ScoreTarefa score = new ScoreTarefa(tarefa.getIdTarefa(), tarefa.getPrioridade(), new Date(), tarefa.getDataInicio(), tarefa.getDataFinal(), tarefa.getPorcentagem(), tarefa.getTotalHoras(), tarefa.getHorasTrabalhadas());
            list.add(score);
        }

        return list;
    }

    public static ArrayList getVel(int numAgents){
        ArrayList list = new ArrayList();

        int i = 0;

        while(i < numAgents){
            VelScoreTarefa vel = new VelScoreTarefa();
            list.add(vel);
            i++;
        }

        return list;
    }
}
