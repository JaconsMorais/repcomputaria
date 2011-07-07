/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhobanco.logica.exceptions;

import java.sql.SQLException;

/**
 *classe de tratar as exceptions 
 * @author Administrador
 */
public class TratarExceptions {
    /**metodo que trata qualquer exception
     *
     * @param e
     */
    public TratarExceptions(Exception e){
if(e instanceof SQLException) {
 SQLException exception =  new SQLException();
 exception.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "erro1:" + exception.getMessage());
}
if(e instanceof ClassNotFoundException) {
     ClassNotFoundException exception =  new ClassNotFoundException();
      exception.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "erro2:" + exception.getMessage());
    }
if(e instanceof Exception) {
            e.printStackTrace();
            }
}
}