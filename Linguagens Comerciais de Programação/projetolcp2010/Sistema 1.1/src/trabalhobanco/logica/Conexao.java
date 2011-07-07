/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhobanco.logica;


import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 * classe que faz a conexao com o banco de dados
 * @author Administrador
 */
public class Conexao {
   private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static Connection connection;
    private static ResultSet resultSet;
    private static PreparedStatement stmt;
    private static String urll;
    private static String namee;
    private static String pass;

    /**
     * @return the JDBC_DRIVER
     */
    public static String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }

    /**
     * @return the connection
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * @return the resultSet
     */
    public static ResultSet getResultSet() {
        return resultSet;
    }

    /**
     * @return the stmt
     */
    public static PreparedStatement getStmt() {
        return stmt;
    }

    /**
     * @return the urll
     */
    public static String getUrll() {
        return urll;
    }

    /**
     * @return the namee
     */
    public static String getNamee() {
        return namee;
    }

    /**
     * @return the pass
     */
    public static String getPass() {
        return pass;
    }

    /**
     * construtor
     */
    public Conexao(){urll = "jdbc:mysql://localhost:3306/mydb2";
    namee = "root";
    pass = "1234";
   }

    // metodo que faz a conexao com o banco de dados mysql(always),recebe:url,user,password do banco
    // retorna "true" se sucesso
    /**
     *
     * @param url url
     * @param name nome
     * @param password senha
     * @return verdadeiro se conectou falso senao
     */
    public boolean conectar(String url, String name, String password) {
        urll = url;
        namee = name;
        pass = password;

        try {
            connection = DriverManager.getConnection(url, name, password);
            return true;
        } // end try
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar" + sqlException);
            return false;
        } // end catch
    }

    //metodo que desconecta do banco de dados mysql que foi anteriormente aberto
    // "true" se sucesso
    /**
     *
     * @return
     */
    public boolean disconect() {
        try {
            getConnection().close();
            return true;
        } // end try
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas durante o processo de desconectar!" + e);
            return false;
        } // end catch
    }
}
