/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BancoLCP.Conta;

public class Cliente extends Usuario{

    private double saldo;
    private String tipo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public void setTipo() {
        this.tipo = "Cliente";
    }
}
