/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BancoLCP.Conta;

/**
 *
 * @author user
 */
public class Funcionario extends Usuario{

    private String tipo;

    public String getTipo() {
        return tipo;
    }

    @Override
    public void setTipo() {
        this.tipo = "Cliente";
    }

}
