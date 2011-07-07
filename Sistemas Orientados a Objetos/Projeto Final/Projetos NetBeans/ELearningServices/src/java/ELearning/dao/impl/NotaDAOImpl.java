/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.dao.impl;

import ELearning.connection.FabricaConexao;
import ELearning.dao.interfaces.NotaDAO;
import ELearning.model.Nota;
import ELearning.query.builder.lang.DeleteQueryBuilder;
import ELearning.query.builder.lang.InsertQueryBuilder;
import ELearning.query.builder.lang.SelectQueryBuilder;
import ELearning.query.builder.lang.UpdateQueryBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acessa SP
 */
public class NotaDAOImpl implements NotaDAO {

    @Override
    public boolean cadastrar(Nota newGrade) {
        boolean saved = false;
        PreparedStatement pstm = null;
        ResultSet res = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(InsertQueryBuilder.INSERT_GRADE);
                pstm.setLong(1, newGrade.getIdMatricula());
                pstm.setLong(2, newGrade.getIdCriterion());
                pstm.setFloat(3, newGrade.getNotaCriterio());
                pstm.executeUpdate();

                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_CRITERION);
                pstm.setLong(1, newGrade.getIdCriterion());
                res = pstm.executeQuery();
                
                Float c = null;
                if(res.next()){
                    c = ((float)res.getInt("peso"))*((float)0.01);
                }
                
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_ENROLLMENT);
                pstm.setLong(1, newGrade.getIdMatricula());
                res = pstm.executeQuery();
                
                Float f = null;
                if(res.next()){
                    f = res.getFloat("notaFinal") +  c*newGrade.getNotaCriterio();
                }
                
                pstm = con.prepareStatement(UpdateQueryBuilder.UPDATE_ENROLLMENT);
                pstm.setFloat(1, f);
                pstm.setLong(2, newGrade.getIdMatricula());
                pstm.executeUpdate();
                
                con.commit();
                con.close();
                saved = true;
            } catch (SQLException ex) {
                System.out.println("Problemas ao inserir: " + ex.getMessage());
            }
        }
        
        return saved;
    }

    @Override
    public List<Nota> procurar(Nota grade) {
        List<Nota> listaNotas = new ArrayList<Nota>();
        PreparedStatement pstm = null;
        ResultSet res = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_GRADE);
                pstm.setLong(1, grade.getIdNota());
                res = pstm.executeQuery();
                
                while(res.next()){
                    Nota n = new Nota();
                    
                    n.setIdNota(res.getLong("idNota"));
                    n.setIdMatricula(res.getLong("idMatricula"));
                    n.setIdCriterion(res.getLong("idCriterioAvaliacao"));
                    n.setNotaCriterio(res.getFloat("notaCriterio"));
                    
                    listaNotas.add(n);
                }
                
                con.commit();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Problemas ao procurar: " + ex.getMessage());
            }
        }
        
        return listaNotas;
    }

    @Override
    public Nota editar(Nota oldGrade, Nota newGrade) {
        boolean saved = false;
        PreparedStatement pstm = null;
        ResultSet res = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(UpdateQueryBuilder.UPDATE_GRADE);
                pstm.setFloat(1, newGrade.getNotaCriterio());
                pstm.setLong(2, newGrade.getIdNota());
                pstm.executeUpdate();

                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_CRITERION);
                pstm.setLong(1, oldGrade.getIdCriterion());
                res = pstm.executeQuery();
                
                Float c = null;
                while(res.next()){
                    c = ((float)res.getInt("peso"))*((float)0.01);
                }
                
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_ENROLLMENT);
                pstm.setLong(1, oldGrade.getIdMatricula());
                res = pstm.executeQuery();
                
                Float f = null;
                while(res.next()){
                    f = res.getFloat("notaFinal") - c*oldGrade.getNotaCriterio() + c*newGrade.getNotaCriterio();
                }
                
                pstm = con.prepareStatement(UpdateQueryBuilder.UPDATE_ENROLLMENT);
                pstm.setFloat(1, f);
                pstm.setLong(2, oldGrade.getIdMatricula());
                pstm.executeUpdate();
                
                con.commit();
                con.close();
                saved = true;
            } catch (SQLException ex) {
                System.out.println("Problemas ao editar: " + ex.getMessage());
            }
        }
        
        return newGrade;
    }

    @Override
    public boolean deletar(Nota grade) {
        try{
            grade = (Nota)procurar(grade).get(0);
        }catch(Exception e){
            return false;
        }
        boolean saved = false;
        PreparedStatement pstm = null;
        ResultSet res = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_CRITERION);
                pstm.setLong(1, grade.getIdCriterion());
                res = pstm.executeQuery();
                
                Float c = null;
                if(res.next()){
                    c = ((float)res.getInt("peso"))*((float)0.01);
                }
                
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_ENROLLMENT_BY_CRITERION);
                pstm.setLong(1, grade.getIdCriterion());
                res = pstm.executeQuery();
                
                Float f = null;
                while(res.next()){
                    f = res.getFloat("notaFinal") - c*grade.getNotaCriterio();
                    
                    pstm = con.prepareStatement(UpdateQueryBuilder.UPDATE_ENROLLMENT);
                    pstm.setFloat(1, f);
                    pstm.setLong(2, res.getLong("idMatricula"));
                    pstm.executeUpdate();
                }
                
                pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_GRADE);
                pstm.setLong(1, grade.getIdNota());
                pstm.executeUpdate();                
                
                con.commit();
                con.close();
                saved = true;
            } catch (SQLException ex) {
                System.out.println("Problemas ao deletar: " + ex.getMessage());
            }
        }

        return saved;
    }
    
}
