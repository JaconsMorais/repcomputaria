/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bancodosamigos.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import bancodosamigos.classes.Conta;

/**
 *
 * @author aluno
 */
public class Menus {
    public static void mainMenu(){
        System.out.println("Bem vindo ao B.O.A.A - Banco Oficial dos Amigos da Amizade");
        System.out.println();
        System.out.println("1 - Novo Cliente (Criar conta)");
        System.out.println("2 - Cliente Ja Cadastrado");
        System.out.println("3 - Sair");
        System.out.print("Opcao: ");
    }

    public static ArrayList<String> menuNovoCliente(BufferedReader buffer) throws IOException{
        ArrayList<String> s = new ArrayList<String>();
        
    	System.out.println("Cadastro de B.O.A.A - Banco Oficial dos Amigos da Amizade");
        System.out.println();
        System.out.print("Nome: ");
        s.add(buffer.readLine());
        System.out.print("CPF: ");
        s.add(buffer.readLine());
        
        return s;
    }

    public static int[] menuClienteJaExistente(BufferedReader buffer) throws IOException{
    	int s[] = new int[2];
    	
    	System.out.print("Agencia: ");
    	s[0] = Integer.parseInt(buffer.readLine());
        System.out.print("Conta: ");
        s[1] = Integer.parseInt(buffer.readLine());
        
        return s;
    }

    public static void menuSaque(){
        System.out.print("Digite a quantia para sacar: ");
    }

    public static void menuDeposito(){
        System.out.print("Digite a quantia para depositar: ");
    }

    public static void menuSaldo(){
        new Conta().exibeSaldo();
    }

    public static void menuVoltar(){
        System.out.print("Deseja voltar para o menu anterior?(s/n) ");
    }

    public static void menuOperacoes(String nomeCli){
        System.out.println(nomeCli.toUpperCase() + ", " + Mensagens.sucessoLogin);
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3 - Exibir Saldo");
        System.out.println("4 - LogOut");
        System.out.print("Opcao: ");
    }
}
