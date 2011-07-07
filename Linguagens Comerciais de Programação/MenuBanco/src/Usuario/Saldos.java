/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Usuario;

import Conta.Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author Thales
 */
public class Saldos {
    public Saldos(/*Cliente c*/){
        JOptionPane.showMessageDialog(null, "O seu saldo é de R$ "/*+c.getSaldo()*/, "Saldo", 1);
    }
}
