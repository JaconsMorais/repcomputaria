/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package atarefatorcompevolutiva.util;

import atarefatorcompevolutiva.model.Pesos;
import atarefatorcompevolutiva.model.ScoreTarefa;
import atarefatorcompevolutiva.model.Tarefa;
import atarefatorcompevolutiva.pso.funcoesRestricoes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Thales
 */
public class Bases {
    public static List<Tarefa> base1(){
        List<Tarefa> base = new ArrayList();
        Tarefa tarefa = new Tarefa();

        tarefa.setNomeTarefa("Levar o cachorro no veterinário");
        tarefa.setIdTarefa(1);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Cachorro perneta");
        tarefa.setLocalTarefa("Por aí");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Estudar para a prova");
        tarefa.setIdTarefa(2);
        tarefa.setCategoria("Estudos");
        tarefa.setComentários("Prova chata, tem que estudar");
        tarefa.setLocalTarefa("Sala de aula");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Fazer trabalho escolar");
        tarefa.setIdTarefa(3);
        tarefa.setCategoria("Estudos");
        tarefa.setComentários("Trabalho trabalhoso");
        tarefa.setLocalTarefa("Casa");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Ir no supermercado");
        tarefa.setIdTarefa(4);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Comprar pão, ovos, salsicha, catchup e maionese para o cachorro-quente");
        tarefa.setLocalTarefa("Supermercado");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Festa!!!");
        tarefa.setIdTarefa(5);
        tarefa.setCategoria("Festas");
        tarefa.setComentários("Festa legal");
        tarefa.setLocalTarefa("Boate");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Maratona do ano");
        tarefa.setIdTarefa(6);
        tarefa.setCategoria("Esportes");
        tarefa.setComentários("Treinar");
        tarefa.setLocalTarefa("Por aí");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Futebol com os amigos");
        tarefa.setIdTarefa(7);
        tarefa.setCategoria("Esportes");
        tarefa.setComentários("Futebol é bom");
        tarefa.setLocalTarefa("Campo de futebol");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Cerveja com os amigos");
        tarefa.setIdTarefa(8);
        tarefa.setCategoria("Amigos");
        tarefa.setComentários("Uma cervejinha de vez em quando...");
        tarefa.setLocalTarefa("Bar");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Pagar dívida");
        tarefa.setIdTarefa(9);
        tarefa.setCategoria("Pagamentos");
        tarefa.setComentários("10 reáu!");
        tarefa.setLocalTarefa("Por aí");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Trocar pneu do carro");
        tarefa.setIdTarefa(10);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Tá murcho");
        tarefa.setLocalTarefa("Por aí");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Andar de bicicleta");
        tarefa.setIdTarefa(11);
        tarefa.setCategoria("Esportes");
        tarefa.setComentários("Dar uma corrida no camelo");
        tarefa.setLocalTarefa("Por aí");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Sair com a namorada");
        tarefa.setIdTarefa(12);
        tarefa.setCategoria("Namoro");
        tarefa.setComentários("Um namoro de vez em quando");
        tarefa.setLocalTarefa("Por aí");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Comprar presente de natal");
        tarefa.setIdTarefa(13);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Comprar para amigo secreto e para o próprio natal");
        tarefa.setLocalTarefa("Por aí");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Pagar contas");
        tarefa.setIdTarefa(14);
        tarefa.setCategoria("Pagamentos");
        tarefa.setComentários("Contas de água e luz");
        tarefa.setLocalTarefa("Por aí");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Comprar presente de dia das mães");
        tarefa.setIdTarefa(15);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Comprar aquele presente esperto que a mamãe queria tanto");
        tarefa.setLocalTarefa("Por aí");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Comprar presente de dia dos namorados");
        tarefa.setIdTarefa(16);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Namorada tá cobrando...");
        tarefa.setLocalTarefa("Por aí");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Levar pai no hospital");
        tarefa.setIdTarefa(17);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Pai tá com saúde ruim depois do cigarro");
        tarefa.setLocalTarefa("Hospital");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Churrasco do trabalho");
        tarefa.setIdTarefa(18);
        tarefa.setCategoria("Festas");
        tarefa.setComentários("Churrasco!!!");
        tarefa.setLocalTarefa("Chácara");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Churrasco da classe");
        tarefa.setIdTarefa(19);
        tarefa.setCategoria("Festas");
        tarefa.setComentários("Churrasco!!!");
        tarefa.setLocalTarefa("Chácara");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Assistir o Brasiliense no campeonato estadual");
        tarefa.setIdTarefa(20);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Campeonato Candango, o melhor do Brasil!!!");
        tarefa.setLocalTarefa("Boca do Jacaré");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Negócios da empresa");
        tarefa.setIdTarefa(21);
        tarefa.setCategoria("Trabalho");
        tarefa.setComentários("Viagem pra Goiânia");
        tarefa.setLocalTarefa("Goiânia");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Outra festa");
        tarefa.setIdTarefa(22);
        tarefa.setCategoria("Festas");
        tarefa.setComentários("Tá cheio de festa por aí");
        tarefa.setLocalTarefa("Boate");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Aniversário do Jaimão");
        tarefa.setIdTarefa(23);
        tarefa.setCategoria("Amigos");
        tarefa.setComentários("Melhor amigo do mundo");
        tarefa.setLocalTarefa("Por aí");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Campeonato do trampo");
        tarefa.setIdTarefa(24);
        tarefa.setCategoria("Esportes");
        tarefa.setComentários("Vamo pra ganhar!");
        tarefa.setLocalTarefa("Campo de futebol do trampo");
        setRandomValues(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Tirar carta de Van");
        tarefa.setIdTarefa(25);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Ver se consigo uma grana por fora");
        tarefa.setLocalTarefa("Auto-escola");
        setRandomValues(tarefa);
        base.add(tarefa);

        return base;
    }

    public static List<Tarefa> base2(){
        List<Tarefa> base = new ArrayList();
        Tarefa tarefa = new Tarefa();

        tarefa.setNomeTarefa("Levar o cachorro no veterinário");
        tarefa.setIdTarefa(1);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Cachorro perneta");
        tarefa.setLocalTarefa("Por aí");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Estudar para a prova");
        tarefa.setIdTarefa(2);
        tarefa.setCategoria("Estudos");
        tarefa.setComentários("Prova chata, tem que estudar");
        tarefa.setLocalTarefa("Sala de aula");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Fazer trabalho escolar");
        tarefa.setIdTarefa(3);
        tarefa.setCategoria("Estudos");
        tarefa.setComentários("Trabalho trabalhoso");
        tarefa.setLocalTarefa("Casa");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Ir no supermercado");
        tarefa.setIdTarefa(4);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Comprar pão, ovos, salsicha, catchup e maionese para o cachorro-quente");
        tarefa.setLocalTarefa("Supermercado");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Festa!!!");
        tarefa.setIdTarefa(5);
        tarefa.setCategoria("Festas");
        tarefa.setComentários("Festa legal");
        tarefa.setLocalTarefa("Boate");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Maratona do ano");
        tarefa.setIdTarefa(6);
        tarefa.setCategoria("Esportes");
        tarefa.setComentários("Treinar");
        tarefa.setLocalTarefa("Por aí");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Futebol com os amigos");
        tarefa.setIdTarefa(7);
        tarefa.setCategoria("Esportes");
        tarefa.setComentários("Futebol é bom");
        tarefa.setLocalTarefa("Campo de futebol");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Cerveja com os amigos");
        tarefa.setIdTarefa(8);
        tarefa.setCategoria("Amigos");
        tarefa.setComentários("Uma cervejinha de vez em quando...");
        tarefa.setLocalTarefa("Bar");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Pagar dívida");
        tarefa.setIdTarefa(9);
        tarefa.setCategoria("Pagamentos");
        tarefa.setComentários("10 reáu!");
        tarefa.setLocalTarefa("Por aí");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Trocar pneu do carro");
        tarefa.setIdTarefa(10);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Tá murcho");
        tarefa.setLocalTarefa("Por aí");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Andar de bicicleta");
        tarefa.setIdTarefa(11);
        tarefa.setCategoria("Esportes");
        tarefa.setComentários("Dar uma corrida no camelo");
        tarefa.setLocalTarefa("Por aí");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Sair com a namorada");
        tarefa.setIdTarefa(12);
        tarefa.setCategoria("Namoro");
        tarefa.setComentários("Um namoro de vez em quando");
        tarefa.setLocalTarefa("Por aí");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Comprar presente de natal");
        tarefa.setIdTarefa(13);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Comprar para amigo secreto e para o próprio natal");
        tarefa.setLocalTarefa("Por aí");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Pagar contas");
        tarefa.setIdTarefa(14);
        tarefa.setCategoria("Pagamentos");
        tarefa.setComentários("Contas de água e luz");
        tarefa.setLocalTarefa("Por aí");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Comprar presente de dia das mães");
        tarefa.setIdTarefa(15);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Comprar aquele presente esperto que a mamãe queria tanto");
        tarefa.setLocalTarefa("Por aí");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Comprar presente de dia dos namorados");
        tarefa.setIdTarefa(16);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Namorada tá cobrando...");
        tarefa.setLocalTarefa("Por aí");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Levar pai no hospital");
        tarefa.setIdTarefa(17);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Pai tá com saúde ruim depois do cigarro");
        tarefa.setLocalTarefa("Hospital");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Churrasco do trabalho");
        tarefa.setIdTarefa(18);
        tarefa.setCategoria("Festas");
        tarefa.setComentários("Churrasco!!!");
        tarefa.setLocalTarefa("Chácara");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Churrasco da classe");
        tarefa.setIdTarefa(19);
        tarefa.setCategoria("Festas");
        tarefa.setComentários("Churrasco!!!");
        tarefa.setLocalTarefa("Chácara");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Assistir o Brasiliense no campeonato estadual");
        tarefa.setIdTarefa(20);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Campeonato Candango, o melhor do Brasil!!!");
        tarefa.setLocalTarefa("Boca do Jacaré");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Negócios da empresa");
        tarefa.setIdTarefa(21);
        tarefa.setCategoria("Trabalho");
        tarefa.setComentários("Viagem pra Goiânia");
        tarefa.setLocalTarefa("Goiânia");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Outra festa");
        tarefa.setIdTarefa(22);
        tarefa.setCategoria("Festas");
        tarefa.setComentários("Tá cheio de festa por aí");
        tarefa.setLocalTarefa("Boate");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Aniversário do Jaimão");
        tarefa.setIdTarefa(23);
        tarefa.setCategoria("Amigos");
        tarefa.setComentários("Melhor amigo do mundo");
        tarefa.setLocalTarefa("Por aí");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Campeonato do trampo");
        tarefa.setIdTarefa(24);
        tarefa.setCategoria("Esportes");
        tarefa.setComentários("Vamo pra ganhar!");
        tarefa.setLocalTarefa("Campo de futebol do trampo");
        setBase2Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Tirar carta de Van");
        tarefa.setIdTarefa(25);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Ver se consigo uma grana por fora");
        tarefa.setLocalTarefa("Auto-escola");
        setBase2Values(tarefa);
        base.add(tarefa);

        return base;
    }

    public static List<Tarefa> base3(){
        List<Tarefa> base = new ArrayList();
        Tarefa tarefa = new Tarefa();

        tarefa.setNomeTarefa("Levar o cachorro no veterinário");
        tarefa.setIdTarefa(1);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Cachorro perneta");
        tarefa.setLocalTarefa("Por aí");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Estudar para a prova");
        tarefa.setIdTarefa(2);
        tarefa.setCategoria("Estudos");
        tarefa.setComentários("Prova chata, tem que estudar");
        tarefa.setLocalTarefa("Sala de aula");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Fazer trabalho escolar");
        tarefa.setIdTarefa(3);
        tarefa.setCategoria("Estudos");
        tarefa.setComentários("Trabalho trabalhoso");
        tarefa.setLocalTarefa("Casa");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Ir no supermercado");
        tarefa.setIdTarefa(4);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Comprar pão, ovos, salsicha, catchup e maionese para o cachorro-quente");
        tarefa.setLocalTarefa("Supermercado");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Festa!!!");
        tarefa.setIdTarefa(5);
        tarefa.setCategoria("Festas");
        tarefa.setComentários("Festa legal");
        tarefa.setLocalTarefa("Boate");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Maratona do ano");
        tarefa.setIdTarefa(6);
        tarefa.setCategoria("Esportes");
        tarefa.setComentários("Treinar");
        tarefa.setLocalTarefa("Por aí");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Futebol com os amigos");
        tarefa.setIdTarefa(7);
        tarefa.setCategoria("Esportes");
        tarefa.setComentários("Futebol é bom");
        tarefa.setLocalTarefa("Campo de futebol");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Cerveja com os amigos");
        tarefa.setIdTarefa(8);
        tarefa.setCategoria("Amigos");
        tarefa.setComentários("Uma cervejinha de vez em quando...");
        tarefa.setLocalTarefa("Bar");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Pagar dívida");
        tarefa.setIdTarefa(9);
        tarefa.setCategoria("Pagamentos");
        tarefa.setComentários("10 reáu!");
        tarefa.setLocalTarefa("Por aí");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Trocar pneu do carro");
        tarefa.setIdTarefa(10);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Tá murcho");
        tarefa.setLocalTarefa("Por aí");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Andar de bicicleta");
        tarefa.setIdTarefa(11);
        tarefa.setCategoria("Esportes");
        tarefa.setComentários("Dar uma corrida no camelo");
        tarefa.setLocalTarefa("Por aí");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Sair com a namorada");
        tarefa.setIdTarefa(12);
        tarefa.setCategoria("Namoro");
        tarefa.setComentários("Um namoro de vez em quando");
        tarefa.setLocalTarefa("Por aí");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Comprar presente de natal");
        tarefa.setIdTarefa(13);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Comprar para amigo secreto e para o próprio natal");
        tarefa.setLocalTarefa("Por aí");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Pagar contas");
        tarefa.setIdTarefa(14);
        tarefa.setCategoria("Pagamentos");
        tarefa.setComentários("Contas de água e luz");
        tarefa.setLocalTarefa("Por aí");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Comprar presente de dia das mães");
        tarefa.setIdTarefa(15);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Comprar aquele presente esperto que a mamãe queria tanto");
        tarefa.setLocalTarefa("Por aí");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Comprar presente de dia dos namorados");
        tarefa.setIdTarefa(16);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Namorada tá cobrando...");
        tarefa.setLocalTarefa("Por aí");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Levar pai no hospital");
        tarefa.setIdTarefa(17);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Pai tá com saúde ruim depois do cigarro");
        tarefa.setLocalTarefa("Hospital");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Churrasco do trabalho");
        tarefa.setIdTarefa(18);
        tarefa.setCategoria("Festas");
        tarefa.setComentários("Churrasco!!!");
        tarefa.setLocalTarefa("Chácara");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Churrasco da classe");
        tarefa.setIdTarefa(19);
        tarefa.setCategoria("Festas");
        tarefa.setComentários("Churrasco!!!");
        tarefa.setLocalTarefa("Chácara");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Assistir o Brasiliense no campeonato estadual");
        tarefa.setIdTarefa(20);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Campeonato Candango, o melhor do Brasil!!!");
        tarefa.setLocalTarefa("Boca do Jacaré");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Negócios da empresa");
        tarefa.setIdTarefa(21);
        tarefa.setCategoria("Trabalho");
        tarefa.setComentários("Viagem pra Goiânia");
        tarefa.setLocalTarefa("Goiânia");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Outra festa");
        tarefa.setIdTarefa(22);
        tarefa.setCategoria("Festas");
        tarefa.setComentários("Tá cheio de festa por aí");
        tarefa.setLocalTarefa("Boate");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Aniversário do Jaimão");
        tarefa.setIdTarefa(23);
        tarefa.setCategoria("Amigos");
        tarefa.setComentários("Melhor amigo do mundo");
        tarefa.setLocalTarefa("Por aí");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Campeonato do trampo");
        tarefa.setIdTarefa(24);
        tarefa.setCategoria("Esportes");
        tarefa.setComentários("Vamo pra ganhar!");
        tarefa.setLocalTarefa("Campo de futebol do trampo");
        setBase3Values(tarefa);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Tirar carta de Van");
        tarefa.setIdTarefa(25);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Ver se consigo uma grana por fora");
        tarefa.setLocalTarefa("Auto-escola");
        setBase3Values(tarefa);
        base.add(tarefa);

        return base;
    }

    public static List<Tarefa> base4(Pesos pesos){
        List<Tarefa> base = new ArrayList();
        Tarefa tarefa = new Tarefa();

        tarefa.setNomeTarefa("Levar o cachorro no veterinário");
        tarefa.setIdTarefa(1);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Cachorro perneta");
        tarefa.setLocalTarefa("Por aí");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Estudar para a prova");
        tarefa.setIdTarefa(2);
        tarefa.setCategoria("Estudos");
        tarefa.setComentários("Prova chata, tem que estudar");
        tarefa.setLocalTarefa("Sala de aula");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Fazer trabalho escolar");
        tarefa.setIdTarefa(3);
        tarefa.setCategoria("Estudos");
        tarefa.setComentários("Trabalho trabalhoso");
        tarefa.setLocalTarefa("Casa");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Ir no supermercado");
        tarefa.setIdTarefa(4);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Comprar pão, ovos, salsicha, catchup e maionese para o cachorro-quente");
        tarefa.setLocalTarefa("Supermercado");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Festa!!!");
        tarefa.setIdTarefa(5);
        tarefa.setCategoria("Festas");
        tarefa.setComentários("Festa legal");
        tarefa.setLocalTarefa("Boate");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Maratona do ano");
        tarefa.setIdTarefa(6);
        tarefa.setCategoria("Esportes");
        tarefa.setComentários("Treinar");
        tarefa.setLocalTarefa("Por aí");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Futebol com os amigos");
        tarefa.setIdTarefa(7);
        tarefa.setCategoria("Esportes");
        tarefa.setComentários("Futebol é bom");
        tarefa.setLocalTarefa("Campo de futebol");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Cerveja com os amigos");
        tarefa.setIdTarefa(8);
        tarefa.setCategoria("Amigos");
        tarefa.setComentários("Uma cervejinha de vez em quando...");
        tarefa.setLocalTarefa("Bar");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Pagar dívida");
        tarefa.setIdTarefa(9);
        tarefa.setCategoria("Pagamentos");
        tarefa.setComentários("10 reáu!");
        tarefa.setLocalTarefa("Por aí");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Trocar pneu do carro");
        tarefa.setIdTarefa(10);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Tá murcho");
        tarefa.setLocalTarefa("Por aí");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Andar de bicicleta");
        tarefa.setIdTarefa(11);
        tarefa.setCategoria("Esportes");
        tarefa.setComentários("Dar uma corrida no camelo");
        tarefa.setLocalTarefa("Por aí");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Sair com a namorada");
        tarefa.setIdTarefa(12);
        tarefa.setCategoria("Namoro");
        tarefa.setComentários("Um namoro de vez em quando");
        tarefa.setLocalTarefa("Por aí");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Comprar presente de natal");
        tarefa.setIdTarefa(13);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Comprar para amigo secreto e para o próprio natal");
        tarefa.setLocalTarefa("Por aí");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Pagar contas");
        tarefa.setIdTarefa(14);
        tarefa.setCategoria("Pagamentos");
        tarefa.setComentários("Contas de água e luz");
        tarefa.setLocalTarefa("Por aí");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Comprar presente de dia das mães");
        tarefa.setIdTarefa(15);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Comprar aquele presente esperto que a mamãe queria tanto");
        tarefa.setLocalTarefa("Por aí");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Comprar presente de dia dos namorados");
        tarefa.setIdTarefa(16);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Namorada tá cobrando...");
        tarefa.setLocalTarefa("Por aí");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Levar pai no hospital");
        tarefa.setIdTarefa(17);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Pai tá com saúde ruim depois do cigarro");
        tarefa.setLocalTarefa("Hospital");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Churrasco do trabalho");
        tarefa.setIdTarefa(18);
        tarefa.setCategoria("Festas");
        tarefa.setComentários("Churrasco!!!");
        tarefa.setLocalTarefa("Chácara");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Churrasco da classe");
        tarefa.setIdTarefa(19);
        tarefa.setCategoria("Festas");
        tarefa.setComentários("Churrasco!!!");
        tarefa.setLocalTarefa("Chácara");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Assistir o Brasiliense no campeonato estadual");
        tarefa.setIdTarefa(20);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Campeonato Candango, o melhor do Brasil!!!");
        tarefa.setLocalTarefa("Boca do Jacaré");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Negócios da empresa");
        tarefa.setIdTarefa(21);
        tarefa.setCategoria("Trabalho");
        tarefa.setComentários("Viagem pra Goiânia");
        tarefa.setLocalTarefa("Goiânia");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Outra festa");
        tarefa.setIdTarefa(22);
        tarefa.setCategoria("Festas");
        tarefa.setComentários("Tá cheio de festa por aí");
        tarefa.setLocalTarefa("Boate");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Aniversário do Jaimão");
        tarefa.setIdTarefa(23);
        tarefa.setCategoria("Amigos");
        tarefa.setComentários("Melhor amigo do mundo");
        tarefa.setLocalTarefa("Por aí");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Campeonato do trampo");
        tarefa.setIdTarefa(24);
        tarefa.setCategoria("Esportes");
        tarefa.setComentários("Vamo pra ganhar!");
        tarefa.setLocalTarefa("Campo de futebol do trampo");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        tarefa = new Tarefa();
        tarefa.setNomeTarefa("Tirar carta de Van");
        tarefa.setIdTarefa(25);
        tarefa.setCategoria("Afazeres");
        tarefa.setComentários("Ver se consigo uma grana por fora");
        tarefa.setLocalTarefa("Auto-escola");
        setBase4Values(tarefa,base,pesos);
        base.add(tarefa);

        return base;
    }

    public static Vector<String> vectorBase1(){
        Vector<String> vt = new Vector<String>();
        vt.add("Levar o cachorro no veterinário");
        vt.add("Estudar para a prova");
        vt.add("Fazer trabalho escolar");
        vt.add("Ir no supermercado");
        vt.add("Festa!!!");
        vt.add("Maratona do ano");
        vt.add("Futebol com os amigos");
        vt.add("Cerveja com os amigos");
        vt.add("Pagar dívida");
        vt.add("Trocar pneu do carro");
        vt.add("Andar de bicicleta");
        vt.add("Sair com a namorada");
        vt.add("Comprar presente de natal");
        vt.add("Pagar contas");
        vt.add("Comprar presente de dia das mães");
        vt.add("Comprar presente de dia dos namorados");
        vt.add("Levar pai no hospital");
        vt.add("Churrasco do trabalho");
        vt.add("Churrasco da classe");
        vt.add("Assistir o Brasiliense no campeonato estadual");
        vt.add("Negócios da empresa");
        vt.add("Outra festa");
        vt.add("Aniversário do Jaimão");
        vt.add("Campeonato do trampo");
        vt.add("Tirar carta de Van");
        return vt;
    }

    public static Vector<String> vectorBase2() {
        Vector<String> vt = new Vector<String>();
        vt.add("Levar o cachorro no veterinário");
        vt.add("Estudar para a prova");
        vt.add("Fazer trabalho escolar");
        vt.add("Ir no supermercado");
        vt.add("Festa!!!");
        vt.add("Maratona do ano");
        vt.add("Futebol com os amigos");
        vt.add("Cerveja com os amigos");
        vt.add("Pagar dívida");
        vt.add("Trocar pneu do carro");
        vt.add("Andar de bicicleta");
        vt.add("Sair com a namorada");
        vt.add("Comprar presente de natal");
        vt.add("Pagar contas");
        vt.add("Comprar presente de dia das mães");
        vt.add("Comprar presente de dia dos namorados");
        vt.add("Levar pai no hospital");
        vt.add("Churrasco do trabalho");
        vt.add("Churrasco da classe");
        vt.add("Assistir o Brasiliense no campeonato estadual");
        vt.add("Negócios da empresa");
        vt.add("Outra festa");
        vt.add("Aniversário do Jaimão");
        vt.add("Campeonato do trampo");
        vt.add("Tirar carta de Van");
        return vt;
    }

    public static Vector<String> vectorBase3() {
        Vector<String> vt = new Vector<String>();
        vt.add("Levar o cachorro no veterinário");
        vt.add("Estudar para a prova");
        vt.add("Fazer trabalho escolar");
        vt.add("Ir no supermercado");
        vt.add("Festa!!!");
        vt.add("Maratona do ano");
        vt.add("Futebol com os amigos");
        vt.add("Cerveja com os amigos");
        vt.add("Pagar dívida");
        vt.add("Trocar pneu do carro");
        vt.add("Andar de bicicleta");
        vt.add("Sair com a namorada");
        vt.add("Comprar presente de natal");
        vt.add("Pagar contas");
        vt.add("Comprar presente de dia das mães");
        vt.add("Comprar presente de dia dos namorados");
        vt.add("Levar pai no hospital");
        vt.add("Churrasco do trabalho");
        vt.add("Churrasco da classe");
        vt.add("Assistir o Brasiliense no campeonato estadual");
        vt.add("Negócios da empresa");
        vt.add("Outra festa");
        vt.add("Aniversário do Jaimão");
        vt.add("Campeonato do trampo");
        vt.add("Tirar carta de Van");
        return vt;
    }

    public static Vector<String> vectorBase4() {
        Vector<String> vt = new Vector<String>();
        vt.add("Levar o cachorro no veterinário");
        vt.add("Estudar para a prova");
        vt.add("Fazer trabalho escolar");
        vt.add("Ir no supermercado");
        vt.add("Festa!!!");
        vt.add("Maratona do ano");
        vt.add("Futebol com os amigos");
        vt.add("Cerveja com os amigos");
        vt.add("Pagar dívida");
        vt.add("Trocar pneu do carro");
        vt.add("Andar de bicicleta");
        vt.add("Sair com a namorada");
        vt.add("Comprar presente de natal");
        vt.add("Pagar contas");
        vt.add("Comprar presente de dia das mães");
        vt.add("Comprar presente de dia dos namorados");
        vt.add("Levar pai no hospital");
        vt.add("Churrasco do trabalho");
        vt.add("Churrasco da classe");
        vt.add("Assistir o Brasiliense no campeonato estadual");
        vt.add("Negócios da empresa");
        vt.add("Outra festa");
        vt.add("Aniversário do Jaimão");
        vt.add("Campeonato do trampo");
        vt.add("Tirar carta de Van");
        return vt;
    }


    private static void setRandomValues(Tarefa tarefa) {
        tarefa.setPrioridade((int)(Math.random()*10) + 1);
        tarefa.setTotalHoras(Math.random()*101);
        tarefa.setHorasTrabalhadas((1 - Math.random()) * tarefa.getTotalHoras());
        tarefa.setPorcentagem((int)(Math.random()*100));
        tarefa.setDataInicio(new Date((int)(Math.random()*10) + 2005,(int)(Math.random()*12),(int)(Math.random()*31) + 1));
        Date dataFinal = new Date((int)(Math.random()*10) + 2005,(int)(Math.random()*12),(int)(Math.random()*31) + 1);
        while(dataFinal.compareTo(tarefa.getDataInicio()) < 0){
            dataFinal = new Date((int)(Math.random()*10) + 2005,(int)(Math.random()*12),(int)(Math.random()*31) + 1);
        }
        tarefa.setDataFinal(dataFinal);
    }

    private static void setBase2Values(Tarefa tarefa) {
        tarefa.setPrioridade((int)(Math.random()*10) + 1);
        tarefa.setTotalHoras(100/tarefa.getPrioridade());
        tarefa.setHorasTrabalhadas((1 - (double)tarefa.getPrioridade()/10) * tarefa.getTotalHoras());
        tarefa.setPorcentagem(10*tarefa.getPrioridade());
        tarefa.setDataInicio(new Date((int)(Math.random()*(11 - tarefa.getPrioridade())) + 2012,(int)(Math.random()*12),(int)(Math.random()*31) + 1));
        Date dataFinal = new Date((int)(Math.random()*(11 - tarefa.getPrioridade())) + 2012,(int)(Math.random()*12),(int)(Math.random()*31) + 1);
        while(dataFinal.compareTo(tarefa.getDataInicio()) < 0){
            dataFinal = new Date((int)(Math.random()*(11 - tarefa.getPrioridade())) + 2012,(int)(Math.random()*12),(int)(Math.random()*31) + 1);
        }
        tarefa.setDataFinal(dataFinal);
    }

    private static void setBase3Values(Tarefa tarefa) {
        tarefa.setPrioridade((int)(Math.random()*10) + 1);
        tarefa.setTotalHoras(10*tarefa.getPrioridade());
        tarefa.setHorasTrabalhadas(((double)tarefa.getPrioridade()/10) * tarefa.getTotalHoras());
        tarefa.setPorcentagem(10*(11 - tarefa.getPrioridade()));
        tarefa.setDataInicio(new Date((int)(Math.random()*tarefa.getPrioridade()) + 2012,(int)(Math.random()*12),(int)(Math.random()*31) + 1));
        Date dataFinal = new Date((int)(Math.random()*tarefa.getPrioridade()) + 2012,(int)(Math.random()*12),(int)(Math.random()*31) + 1);
        while(dataFinal.compareTo(tarefa.getDataInicio()) < 0){
            dataFinal = new Date((int)(Math.random()*tarefa.getPrioridade()) + 2012,(int)(Math.random()*12),(int)(Math.random()*31) + 1);
        }
        tarefa.setDataFinal(dataFinal);
    }

    private static void setBase4Values(Tarefa tarefa, List<Tarefa> base, Pesos pesos) {
        if(base.size() <= 0){
            setRandomValues(tarefa);
        }else{
            Tarefa tbase = base.get(0);
            ScoreTarefa stbase = new ScoreTarefa(tbase.getIdTarefa(),tbase.getPrioridade(), new Date(), tbase.getDataInicio(), tbase.getDataFinal(), tbase.getPorcentagem(), tbase.getTotalHoras(), tbase.getHorasTrabalhadas());
            double fitnessbase = funcoesRestricoes.getScoreTotal(stbase.getScorePrioridade(), stbase.getScoreTempoRestante(), stbase.getScoreTempoEsperado(), stbase.getScorePorcentagemRestante(), stbase.getScoreTotalHoras(), stbase.getScoreHorasTrabalhadas(), pesos.getPesoPrioridade(), pesos.getPesoTempoRestante(), pesos.getPesoTempoEsperado(), pesos.getPesoPorcentagemRestante(), pesos.getPesoTotalHoras(), pesos.getPesoHorasTrabalhadas());
            double multPesos = 10 * pesos.getPesoPrioridade() + 10 * pesos.getPesoTempoRestante() + 10 * pesos.getPesoTempoEsperado() + 10 * pesos.getPesoPorcentagemRestante() + 10 * pesos.getPesoTotalHoras() + 10 * pesos.getPesoHorasTrabalhadas();
            double fitness = 0;
            do{
                setRandomValues(tarefa);
                ScoreTarefa st = new ScoreTarefa(tarefa.getIdTarefa(),tarefa.getPrioridade(), new Date(), tarefa.getDataInicio(), tarefa.getDataFinal(), tarefa.getPorcentagem(), tarefa.getTotalHoras(), tarefa.getHorasTrabalhadas());
                fitness = funcoesRestricoes.getScoreTotal(st.getScorePrioridade(), st.getScoreTempoRestante(), st.getScoreTempoEsperado(), st.getScorePorcentagemRestante(), st.getScoreTotalHoras(), st.getScoreHorasTrabalhadas(), pesos.getPesoPrioridade(), pesos.getPesoTempoRestante(), pesos.getPesoTempoEsperado(), pesos.getPesoPorcentagemRestante(), pesos.getPesoTotalHoras(), pesos.getPesoHorasTrabalhadas());
            }while(Math.sqrt((fitnessbase - fitness)*(fitnessbase - fitness)) >= multPesos);
        }
    }
}
