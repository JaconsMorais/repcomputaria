/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bancodosamigos.classes;

/**
 *
 * @author aluno
 */
public class Banco {

    public int getnAgencia() {
        return nAgencia;
    }

    public void setnAgencia(int nAgencia) {
        this.nAgencia = nAgencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    private String nome;
    private int nAgencia;
}
