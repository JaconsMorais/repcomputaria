/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhobanco.logica.funcionario;

import trabalhobanco.logica.*;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *Classe que cadastra o funcionario
 * @author Administrador
 */
public class CadastroFuncionario {

    /**
     *
     */
    public Statement statement;
   /**
    *
    */
   public CadastroFuncionario(){}
    // metodo para realizar a insersao dos dados do funcionario no banco de dados********************
   /**
    *
    * @param CPF
    * @param Nome
    * @param Telefone
    * @param Rua
    * @param Bairro
    * @param Cidade
    * @param Estado
    * @param CEP
    * @param DataAdmissao
    * @param cargo
    * @param salario
    * @return
    */
   public boolean cadastroFuncionario(String CPF, String Nome, String Telefone, String Rua, String Bairro, String Cidade,
            String Estado, String CEP, String DataAdmissao, String cargo, String salario) {
        try {
            Class.forName(Conexao.getJDBC_DRIVER());

            statement = Conexao.getConnection().createStatement(); // Utiliza a conexao criada em Conexao
            statement.execute(
                    "INSERT INTO DadosPessoais(CPF,nome,telefone,rua,bairro,cidade,Estado,cep)VALUE(" +
                    "'" + CPF + "','" + Nome + "','" + Telefone + "','" + Rua + "','" + Bairro + "','" +
                    Cidade + "','" + Estado + "','" + CEP + "')");
            statement.execute(
                    "INSERT INTO funcionario(CPF,DataAdmicao,cargo,salario,DadosPessoais_CPF)VALUE(" +
                    "'" + CPF + "','" + DataAdmissao + "','" + cargo + "','" + salario + "','" + CPF + "')");

            statement.close();
            return true;

        } catch (SQLException e) {

            javax.swing.JOptionPane.showMessageDialog(null, "erro1:" + e.getMessage());
            e.printStackTrace();

            return false;

        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "erro2:" + classNotFound.getMessage());

            return false;
        } // end catch
        catch (Exception exception) {
            javax.swing.JOptionPane.showMessageDialog(null, "erro3:" + exception.getMessage());
            exception.printStackTrace();
            System.exit(1);
            return false;
        } finally {
            try {
                statement.close();
            } // end try
            catch (Exception e) {
                e.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(null, "erro ao fechar statement!!" + e);
            } // end catch
        }
    }
}
