/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhobanco.logica.funcionario;
import trabalhobanco.logica.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *classe da consulta de funcionarios
 * @author Administrador
 */
public class ConsultaFuncionarioLogica {

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
public ConsultaFuncionarioLogica(){}

/**
 *
 * @param cpf                           entrada do  cpf do funcionario
 * @return                verdadeiro se a busca teve sucesso falso caso contrario
 * @throws java.sql.SQLException
 * @throws java.lang.ClassNotFoundException
 * @throws java.lang.InstantiationException
 * @throws java.lang.IllegalAccessException
 */
public boolean consultaFuncionarioCPF(String cpf)throws SQLException,ClassNotFoundException, InstantiationException, IllegalAccessException{

            Class.forName(Conexao.getJDBC_DRIVER()).newInstance();
            stmt = Conexao.getConnection().prepareStatement("select * from dadospessoais,funcionario where dadospessoais.`CPF`=funcionario.`CPF`  and funcionario.`CPF` like '" + cpf +"%'");
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
 * @param nome                     entrada como nome do funcionario
 * @return                       verdadeiro se a busca teve sucesso falso caso contrario
 * @throws java.sql.SQLException
 * @throws java.lang.ClassNotFoundException
 */
public boolean consultaFuncionarioNome(String nome)throws SQLException,ClassNotFoundException{

            Class.forName(Conexao.getJDBC_DRIVER());
            stmt = Conexao.getConnection().prepareStatement(" select * from dadospessoais,funcionario where dadospessoais.`CPF`=funcionario.`CPF`  and dadospessoais.`Nome` like '"+nome+"%'");

            resultSet = stmt.executeQuery();
            resultSet.next();
            if (resultSet.getString("nome").contains(nome)) {
                resultSet.beforeFirst();
                return true;
            } // end if

            return false;
        } 
 

 // 
 /**metodo para realizar a Exclusao dos dados do Cliente no banco de dados cujo CPF eh informado
  *
  * @param cpf
  * @return
  * @throws java.lang.ClassNotFoundException
  * @throws java.sql.SQLException
  * @throws java.lang.ClassNotFoundException
  */
 public boolean ExcluirFuncionario(String cpf) throws ClassNotFoundException,SQLException,ClassNotFoundException{
            Class.forName(Conexao.getJDBC_DRIVER());
            statement = Conexao.getConnection().createStatement();
                       statement.execute("DELETE FROM funcionario WHERE CPF = '"+ cpf +"'");
            statement.execute("DELETE FROM DadosPessoais WHERE CPF = '"+ cpf +"'");
            statement.execute("DELETE FROM DadosFuncionario WHERE CPF = '"+ cpf +"'");
            statement.close();
            return true;
    }
      
}
