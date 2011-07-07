
package trabalhobanco.logica.cliente;

import trabalhobanco.logica.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *classe que cadastra o cliente
 * @author Administrador
 */
public class CadastroCliente {
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
    public CadastroCliente(){}

    /**metodo para realizar a insersao dos dados do Cliente no banco de dados********************
     *
     * @param CPF
     * @param Nome
     * @param Telefone
     * @param Rua
     * @param Bairro
     * @param Cidade
     * @param Estado
     * @param CEP
     * @param CPF_c
     * @param Nome_c
     * @param EstCivil
     * @param Filhos
     * @param Empresa
     * @param Rua_f
     * @param Bairro_f
     * @param CEP_f
     * @param Telefone_f
     * @param Cargo
     * @param Tempo
     * @param casa
     * @param carro
     * @param Banco
     * @param clienteDesde
     * @return
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public boolean cadastroCliente(String CPF, String Nome, String Telefone, String Rua, String Bairro,
            String Cidade, String Estado, String CEP, String CPF_c, String Nome_c,
            String EstCivil, String Filhos, String Empresa, String Rua_f, String Bairro_f,
            String CEP_f, String Telefone_f, String Cargo, String Tempo,
            String casa, String carro, String Banco, String clienteDesde) throws SQLException,ClassNotFoundException{

            Class.forName(Conexao.getJDBC_DRIVER());
            statement = Conexao.getConnection().createStatement();

            statement.execute(
                    "INSERT IGNORE INTO DadosPessoais(CPF,nome,telefone,rua,bairro,cidade,Estado,cep)VALUE(" +
                    "'" + CPF + "','" + Nome + "','" + Telefone +
                    "','" + Rua + "','" + Bairro + "','" + Cidade + "','" + Estado + "','" + CEP + "')");

            statement.execute(
                    "INSERT IGNORE INTO DadosFuncionario(CPF,Empresa,rua,bairro,CEP,telefone,cargo,tempo)" +
                    "VALUE(" + "'" + CPF + "','" + Empresa + "','" + Rua_f + "','" + Bairro_f + "','" + CEP_f + 
                    "','" + Telefone_f + "','" + Cargo + "','" + Tempo + "')");
            statement.execute(
                    "INSERT IGNORE INTO Bens(CPF,CASA,CARRO,BANCO,ClienteDesde)" +
                    "VALUE(" +
                    "'" + CPF + "','" + casa + "','" + carro + "','" + Banco + "','" + clienteDesde + "')");
            statement.execute(
                    "INSERT IGNORE INTO DadosConjugais(CPF,CPF_C,Nome_C,EstCivil,Filhos)" +
                    "VALUE(" + "'" + CPF + "','" + CPF_c + "','" + Nome_c + "','" + EstCivil + "','" + Filhos + "')");
            statement.execute(
                    "INSERT IGNORE INTO Cliente(CPF,DadosFuncionario_CPF,DadosConjugais_CPF,DadosPessoais_CPF,Bens_CPF)" +
                    "VALUE(" +
                    "'" + CPF + "','" + CPF + "','" + CPF + "','" + CPF + "','" + CPF + "')");

            statement.close();
            return true;
    }
       
}
