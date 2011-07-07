/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.dao.impl;

import ELearning.connection.FabricaConexao;
import ELearning.dao.interfaces.UsuarioDAO;
import ELearning.model.Usuario;
import ELearning.query.builder.lang.SelectQueryBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acessa SP
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public Usuario validaLogin(Usuario loginUser) {
        Usuario user = null;
        Connection con = FabricaConexao.getConexao();
        PreparedStatement psmt;
        ResultSet rs;
        
        if(con != null){
            try {
                psmt = con.prepareStatement(SelectQueryBuilder.SELECT_LOGIN);
                psmt.setString(1, loginUser.getLogin());
                psmt.setString(2, loginUser.getSenha());
                
                rs = psmt.executeQuery();
                while(rs.next()){
                    user = new Usuario();
                    user.setIdUsuario(rs.getLong("idUsuario"));
                    user.setLogin(rs.getString("login"));
                    user.setSenha(rs.getString("senha"));
                    user.setTipoUsuario(rs.getInt("tipoUsuario"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        
        return user;
    }

    @Override
    public boolean cadastrar(Usuario newUser) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Usuario editar(Usuario oldPessoa, Usuario newPessoa) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deletar(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Usuario> procurar(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
