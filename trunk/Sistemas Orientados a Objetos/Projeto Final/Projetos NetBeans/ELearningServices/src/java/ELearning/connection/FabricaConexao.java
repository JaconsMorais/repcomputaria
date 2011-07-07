/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class FabricaConexao implements Conexao {

    private FabricaConexao() {
    }

    public static Connection getConexao() {
        Connection con = null;

        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.out.println("Problemas ao carregar o Driver!");
            System.out.println("ERRO: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Problemas ao autenticar!");
            System.out.println("ERRO: " + ex.getMessage());
        }

        return con;
    }

    public static void fechar(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Problemas ao fechar: " + ex.getMessage());
        }
    }

    public static void fechar(Connection con, PreparedStatement pstm) {
        try {
            con.close();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Problemas ao fechar: " + ex.getMessage());
        }
    }

    public static void fechar(PreparedStatement pstm) {
        try {
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Problemas ao fechar: " + ex.getMessage());
        }
    }
}
