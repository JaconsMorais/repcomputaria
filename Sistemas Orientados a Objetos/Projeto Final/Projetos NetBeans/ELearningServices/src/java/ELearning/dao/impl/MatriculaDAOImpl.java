/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.dao.impl;

import ELearning.connection.FabricaConexao;
import ELearning.dao.interfaces.MatriculaDAO;
import ELearning.model.Matricula;
import ELearning.model.Nota;
import ELearning.query.builder.lang.InsertQueryBuilder;
import ELearning.query.builder.lang.SelectQueryBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acessa SP
 */
public class MatriculaDAOImpl implements MatriculaDAO {

    @Override
    public boolean cadastrar(Matricula newEnrollment) {
        boolean saved = false;
        PreparedStatement pstm = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(InsertQueryBuilder.INSERT_ENROLLMENT);
                pstm.setLong(1, newEnrollment.getIdDisciplina());
                pstm.setLong(2, newEnrollment.getIdAluno());
                pstm.executeUpdate();
                
                con.commit();
                saved = true;
            } catch (SQLException ex) {
                System.out.println("Problemas ao inserir: " + ex.getMessage());
            }
        }
        
        return saved;
    }

    @Override
    public List<Matricula> procurar(Matricula enrollment) {
        List<Matricula> listaMatriculas = new ArrayList<Matricula>();
        PreparedStatement pstm = null;
        ResultSet res1 = null, res2 = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_ENROLLMENT);
                pstm.setLong(1, enrollment.getIdMatricula());
                res1 = pstm.executeQuery();
                
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_GRADE_BY_ENROLLMENT);
                pstm.setLong(1, enrollment.getIdMatricula());
                res2 = pstm.executeQuery();
                
                while(res1.next()){
                    Matricula m = new Matricula();
                    
                    m.setIdMatricula(res1.getLong("idCriterioAvaliacao"));
                    m.setIdDisciplina(res1.getLong("idDisciplina"));
                    List<Nota> notas = new ArrayList<Nota>();
                    while(res2.next()){
                        Nota n = new Nota();
                        
                        n.setIdNota(res2.getLong("idNota"));
                        n.setIdMatricula(res2.getLong("idMatricula"));
                        n.setIdCriterion(res2.getLong("idCriterioAvaliacao"));
                        n.setNotaCriterio(res2.getFloat("notaCriterio"));
                    
                        notas.add(n);
                    }
                    m.setNotas(notas);
                    m.setNotaFinal(res1.getFloat("notaFinal"));
                    
                    listaMatriculas.add(m);
                }
                
                con.commit();
            } catch (SQLException ex) {
                System.out.println("Problemas ao inserir: " + ex.getMessage());
            }
        }
        
        return listaMatriculas;
    }

    @Override
    public Matricula editar(Matricula oldEnrollment, Matricula newEnrollment) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deletar(Matricula enrollment) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
