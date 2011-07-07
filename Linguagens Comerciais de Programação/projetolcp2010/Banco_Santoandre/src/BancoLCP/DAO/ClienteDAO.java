/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoLCP.DAO;

import BancoLCP.Conta.Cliente;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author aluno
 */
public class ClienteDAO extends Conexao {

    public ClienteDAO() throws SQLException {
        super(1,2);
    }

    public ResultSet ValidaLogin(long id, String pass, String tipo) throws SQLException {

        String sql = "SELECT * FROM " + tipo
                + " WHERE ID = '" + id + "' AND senha = '" + pass + "'";

        Statement stmt = this.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        return rs;

        //if (rs.next()) {
            /*Usuario usuario = new Usuario(rs.getString("tudo"));
             */
        //    return true;
        //} else {
        //    return false;
        //}

    }

    public void depositar(Cliente cliente, double valor) throws SQLException {
        double saldo = cliente.getSaldo() + valor;

        Statement stmt = this.getConnection().createStatement();

        String sql = "UPDATE Cliente"
                + " SET saldo=" + saldo
                + " WHERE ID=" + cliente.getId();
        String sql2 = "INSERT INTO Transação (conta, data, tipo, valor) "
                + " VALUES (" + cliente.getId() + ", '" + new SimpleDateFormat("dd/MM/yyyy").format(new Date().getDate()) + "', 'Depósito', '" + valor + "')";

        try {
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            System.out.println("Depósito realizado com sucesso!");
            cliente.setSaldo(saldo);
        } catch (SQLException e) {
            System.out.println("ERRO!");
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }
    }

    public void sacar(Cliente cliente, double valor) throws SQLException {
        double saldo = cliente.getSaldo() - valor;

        Statement stmt = this.getConnection().createStatement();

        String sql = "UPDATE Cliente"
                + " SET saldo=" + saldo
                + " WHERE ID=" + cliente.getId();
        String sql2 = "INSERT INTO Transação (conta, data, tipo, valor) "
                + " VALUES (" + cliente.getId() + ", '" + new SimpleDateFormat("dd/MM/yyyy").format(new Date().getDate()) + "', 'Saque', '" + valor + "')";

        try {
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            System.out.println("Saque realizado com sucesso!");
            cliente.setSaldo(saldo);
        } catch (SQLException e) {
            System.out.println("ERRO!");
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }

    }

    public ResultSet selectTransacao(long id) throws SQLException {

        String sql = "SELECT * FROM Transação"
                + " WHERE conta=" + id
                + " ORDER BY data";
        Statement stmt = this.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        return rs;

        /*while (rs.next()) {
            String data = rs.getString("data");
            String tipo = rs.getString("tipo");
            String valor = rs.getString("valor");
        }*/
    }
}
