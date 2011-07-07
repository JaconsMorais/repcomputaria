/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ELearning.connection;

/**
 *
 * @author aluno
 */
public interface Conexao {

    final String DATABASE = "elearning";

    final String DRIVER = "org.gjt.mm.mysql.Driver";    

    final String PASSWORD = "root";

    final String USER = "root";

    final String URL = "jdbc:mysql://localhost:3306/" + DATABASE;

}
