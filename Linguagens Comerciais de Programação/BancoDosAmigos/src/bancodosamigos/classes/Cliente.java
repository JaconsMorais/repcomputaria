/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bancodosamigos.classes;

/**
 *
 * @author aluno
 */
public class Cliente {
    private int nConta;
    private String nome;
    private long CPF;

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public int getnConta() {
        return nConta;
    }

    public void setnConta(int nConta) {
        this.nConta = nConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
