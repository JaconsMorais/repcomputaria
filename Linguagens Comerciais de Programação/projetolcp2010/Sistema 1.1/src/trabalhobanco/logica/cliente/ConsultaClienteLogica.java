/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhobanco.logica.cliente;

import trabalhobanco.logica.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *classe que faz a consulta de clientes
 * @author Administrador
 */
public class ConsultaClienteLogica {

    /**
     *
     */
    public static ResultSet resultSet;
/**
 *
 */
public Statement statement;
/**
 *
 */
public static PreparedStatement stmt;
/**
 *
 */
public ConsultaClienteLogica(){}

/**
 *consulta de clientes por cpf
 * @param cpf
 * @return
 * @throws java.lang.ClassNotFoundException
 * @throws java.lang.InstantiationException
 * @throws java.lang.IllegalAccessException
 * @throws java.sql.SQLException
 */
public boolean consultaClienteCPF(String cpf)throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{

            Class.forName(Conexao.getJDBC_DRIVER()).newInstance();

            stmt = Conexao.getConnection().prepareStatement("select * from dadospessoais,cliente where dadospessoais.`CPF`=cliente.`CPF`  and cliente.`CPF` like '" + cpf + "%'");

            resultSet = stmt.executeQuery();
            resultSet.next();

            if (resultSet.getString("CPF").contains(cpf)) {
                resultSet.beforeFirst();
                return true;
            } // end if
            return false;
    }
// 
/**metodo para realizar a consulta dos dados do Cliente no banco de dados cujo parte ou todo o Nome eh informado
 *
 * @param nome
 *
 * @throws java.sql.SQLException
 * @throws java.lang.ClassNotFoundException
 */
public boolean consultaClienteNome(String nome)throws SQLException,ClassNotFoundException{

            Class.forName(Conexao.getJDBC_DRIVER());
            stmt = Conexao.getConnection().prepareStatement(" select * from dadospessoais,cliente where dadospessoais.`CPF`=cliente.`CPF`  and dadospessoais.`Nome` like '"+nome+"%'");
            resultSet = stmt.executeQuery();
            resultSet.next();
            if (resultSet.getString("nome").contains(nome)) {
                resultSet.beforeFirst();
                return true;
            } // end if
            return false;
        } 



 /**metodo para realizar a Exclusao dos dados do Cliente no banco de dados cujo CPF eh informado
  *
  * @param cpf
  * @return
  * @throws java.lang.ClassNotFoundException
  * @throws java.sql.SQLException
  * @throws java.lang.ClassNotFoundException
  */
 public boolean ExcluirCliente(String cpf) throws ClassNotFoundException,SQLException,ClassNotFoundException{
            Class.forName(Conexao.getJDBC_DRIVER());
            statement = Conexao.getConnection().createStatement();
            statement.execute("DELETE FROM cliente WHERE CPF = '"+ cpf +"'");
            statement.execute("DELETE FROM DadosPessoais WHERE CPF = '"+ cpf +"'");
            statement.execute("DELETE FROM DadosFuncionario WHERE CPF = '"+ cpf +"'");
            statement.execute("DELETE FROM Bens WHERE CPF = '"+ cpf +"'");
            statement.execute("DELETE FROM DadosConjugais WHERE CPF = '"+ cpf +"'");
            statement.close();
            return true;
    }

}
