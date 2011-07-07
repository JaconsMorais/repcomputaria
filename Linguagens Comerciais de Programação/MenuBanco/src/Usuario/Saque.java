/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Usuario;

import Conta.Cliente;
import DAO.ClienteDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Thales
 */
public class Saque {
    public Saque(/*ClienteDAO c, Cliente cli*/) throws SQLException{
           double a = Double.parseDouble(JOptionPane
                    .showInputDialog("Digite o Valor a Ser "
                    + "Sacado: (Em R$)"));
           //c.sacar(cli, a);
    }
}
