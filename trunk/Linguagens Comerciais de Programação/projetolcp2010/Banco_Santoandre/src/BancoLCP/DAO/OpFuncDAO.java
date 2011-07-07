/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoLCP.DAO;

import BancoLCP.Conta.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OpFuncDAO extends Conexao {

    public OpFuncDAO() throws SQLException {
        super(0,1);
    }

    public ResultSet select(String tipo, String name, String endereco, double CPF) throws SQLException {

        String sql = "SELECT * FROM " + tipo
                + " WHERE nome = '" + name + "' OR endereco = '" + endereco + "' OR CPF = " + CPF
                + " ORDER BY ID";
        Statement stmt = this.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        return rs;

        /*while (rs.next()) {
            String nome = rs.getString("nome");
            String end = rs.getString("endereco");
            String cpf = rs.getString("CPF");
            String id = rs.getString("ID");
            String saldo = "R$ "+rs.getString("saldo");
        }*/
    }

    /*public ArrayList selecionaTodos() throws SQLException{
    String sql = "SELECT nome, email, telefone FROM cliente ORDER BY nome";
    Statement stmt = this.getConnection().createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    ArrayList clientes = new ArrayList();

    while(rs.next()){
    Cliente client = new Cliente(rs.getString("nome"),rs.getString("email"),rs.getString("telefone"));
    clientes.add(client);
    }
    return clientes;
    }*/
    public void update(Usuario usuario, String tipo) throws SQLException {

        Statement stmt = this.getConnection().createStatement();

        long id = usuario.getId();
        String nome = usuario.getName();//request.getParameter("nome");
        String end = usuario.getEnd();//request.getParameter("endereco");
        double CPF = usuario.getCpf();//request.getParameter("cpf");
        String senha = usuario.getPassword();//request.getParameter("senha");
        //request.getParameter("tipo");

        String sql = "UPDATE " + tipo
                + " SET nome='" + nome + "', endereco='" + end + "'" + ", CPF=" + CPF + ", senha = '" + senha + "'"
                + " WHERE ID=" + id;

        try {
            stmt.executeUpdate(sql);
            System.out.println("editou !");
        } catch (SQLException e) {
            System.out.println("ERRO!");
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }


    }

    public void insert(Usuario usuario, String tipo) throws SQLException {

        Statement stmt = this.getConnection().createStatement();

        long id = usuario.getId();
        String nome = usuario.getName();//request.getParameter("nome");
        String end = usuario.getEnd();//request.getParameter("endereco");
        double CPF = usuario.getCpf();//request.getParameter("cpf");
        String senha = usuario.getPassword();//request.getParameter("senha");
        //request.getParameter("tipo");

        String sql = null;

        if (tipo.equals("Cliente")) {
            sql = "INSERT INTO Cliente (nome, endereco, CPF, senha, saldo) "
                    + " VALUES ('" + nome + "', '" + end + "', " + CPF + ", '" + senha + "', 0)";
        } else {
            sql = "INSERT INTO Funcionário (nome, endereco, CPF, senha) "
                    + " VALUES ('" + nome + "', '" + end + "', " + CPF + ", '" + senha + "')";
        }

        try {
            stmt.executeUpdate(sql);
            System.out.println("inseriu !");
        } catch (SQLException e) {
            System.out.println("ERRO!");
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }


    }

    public void delete(long id, String tipo) throws SQLException {

        Statement stmt = this.getConnection().createStatement();

        //request.getParameter("id");
        //request.getParameter("tipo");

        String sql = "DELETE * FROM " + tipo + " WHERE ID=" + id;

        try {
            stmt.executeUpdate(sql);
            System.out.println("excluiu !");
        } catch (SQLException e) {
            System.out.println("ERRO!");
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }


    }
}
