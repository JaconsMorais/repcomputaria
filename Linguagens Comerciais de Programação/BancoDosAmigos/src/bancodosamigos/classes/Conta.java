/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bancodosamigos.classes;

import bancodosamigos.util.BancoLMFAO;

/**
 *
 * @author aluno
 */
public class Conta {
    private int nConta;
    private int nAgencia;
    private double saldo;

    public int getnAgencia() {
        return nAgencia;
    }

    public void setnAgencia(int nAgencia) {
        this.nAgencia = nAgencia;
    }

    public int getnConta() {
        return nConta;
    }

    public void setnConta(int nConta) {
        this.nConta = nConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void exibeSaldo(){
        System.out.println("O seu saldo e de R$ " + this.saldo);
    }

    public void sacar(double grana){
        this.saldo -= grana;
    }

    public void depositar(double grana){
        this.saldo += grana;
    }

    public static Conta criaConta(){

    	Conta c = new Conta();
    	
    	int conta = (int)(Math.random() * 9999999) + 1;
    	int agencia = (int)(Math.random() * 9999) + 1;
    	
    	while(!BancoLMFAO.getBancoContaCliente(agencia, conta).isEmpty()){
        	conta = (int)(Math.random() * 9999999) + 1;
        	agencia = (int)(Math.random() * 9999) + 1;
    	}
    	
    	c.setSaldo(0);
    	c.setnConta(conta);
    	c.setnAgencia(agencia);
    	
    	return c;
    }

}
