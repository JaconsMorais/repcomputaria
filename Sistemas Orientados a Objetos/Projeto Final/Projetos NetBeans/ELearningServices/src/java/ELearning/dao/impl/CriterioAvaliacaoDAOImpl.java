/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.dao.impl;

import ELearning.connection.FabricaConexao;
import ELearning.dao.interfaces.CriterioAvaliacaoDAO;
import ELearning.model.CriterioAvaliacao;
import ELearning.model.Nota;
import ELearning.query.builder.lang.DeleteQueryBuilder;
import ELearning.query.builder.lang.InsertQueryBuilder;
import ELearning.query.builder.lang.SelectQueryBuilder;
import ELearning.query.builder.lang.UpdateQueryBuilder;
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
public class CriterioAvaliacaoDAOImpl implements CriterioAvaliacaoDAO {

    @Override
    public boolean cadastrar(CriterioAvaliacao newCriterion) {
        boolean saved = false;
        PreparedStatement pstm = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(InsertQueryBuilder.INSERT_CRITERION);
                pstm.setLong(1, newCriterion.getIdDisciplina());
                pstm.setString(2, newCriterion.getNome());
                pstm.setInt(3, newCriterion.getPeso());
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
    public List<CriterioAvaliacao> procurar(CriterioAvaliacao criterion) {
        List<CriterioAvaliacao> listaCriterios = new ArrayList<CriterioAvaliacao>();
        PreparedStatement pstm = null;
        ResultSet res = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_CRITERION);
                pstm.setLong(1, criterion.getIdCriterioAvaliacao());
                res = pstm.executeQuery();
                
                while(res.next()){
                    CriterioAvaliacao c = new CriterioAvaliacao();
                    
                    c.setIdCriterioAvaliacao(res.getLong("idCriterioAvaliacao"));
                    c.setIdDisciplina(res.getLong("idDisciplina"));
                    c.setNome(res.getString("nome"));
                    c.setPeso(res.getInt("peso"));
                    
                    listaCriterios.add(c);
                }
                
                con.commit();
            } catch (SQLException ex) {
                System.out.println("Problemas ao inserir: " + ex.getMessage());
            }
        }
        
        return listaCriterios;
    }

    @Override
    public CriterioAvaliacao editar(CriterioAvaliacao oldCriterion, CriterioAvaliacao newCriterion) {
        boolean saved = false;
        PreparedStatement pstm = null;
        ResultSet res = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                //Incompleto, atualizar Nota final da Matricula
                pstm = con.prepareStatement(UpdateQueryBuilder.UPDATE_CRITERIA);
                pstm.setString(1, newCriterion.getNome());
                pstm.setInt(2, newCriterion.getPeso());
                pstm.setLong(3, newCriterion.getIdCriterioAvaliacao());
                pstm.executeUpdate();
                
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_GRADE_BY_CRITERION);
                pstm.setLong(1, oldCriterion.getIdCriterioAvaliacao());
                res = pstm.executeQuery();
                
                Float nota = null;
                if(res.next()){
                    nota = res.getFloat("notaCriterio");
                }
                Float oldC = ((float)oldCriterion.getPeso())*((float)0.01);
                Float newC = newCriterion.getPeso()*((float)0.01);
                Float f = null;
                
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_ENROLLMENT_BY_CRITERION);
                pstm.setLong(1, oldCriterion.getIdCriterioAvaliacao());
                res = pstm.executeQuery();
                
                while(res.next()){
                    f = res.getFloat("notaFinal") - oldC*nota + newC*nota;
                    
                    pstm = con.prepareStatement(UpdateQueryBuilder.UPDATE_ENROLLMENT);
                    pstm.setFloat(1, f);
                    pstm.setLong(2, res.getLong("idMatricula"));
                    pstm.executeUpdate();
                }
                
                con.commit();
                saved = true;
            } catch (SQLException ex) {
                System.out.println("Problemas ao inserir: " + ex.getMessage());
            }
        }

        return newCriterion;
    }

    @Override
    public boolean deletar(CriterioAvaliacao criterion) {
        try{
            criterion = (CriterioAvaliacao)procurar(criterion).get(0);
        }catch(Exception e){
            return false;
        }
        Nota grade = new Nota();
        boolean saved = false;
        PreparedStatement pstm = null;
        ResultSet res = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_GRADE_BY_CRITERION);
                pstm.setLong(1, criterion.getIdCriterioAvaliacao());
                res = pstm.executeQuery();
                
                Float nota = null;
                if(res.next()){
                    nota = res.getFloat("notaCriterio");
                }
                Float c = ((float)criterion.getPeso())*((float)0.01);
                Float f = null;


                pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_GRADE);
                pstm.setLong(1, res.getLong("idNota"));
                pstm.executeUpdate(); 
                
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_ENROLLMENT_BY_CRITERION);
                pstm.setLong(1, criterion.getIdCriterioAvaliacao());
                res = pstm.executeQuery();
                
                while(res.next()){
                    f = res.getFloat("notaFinal") - c*nota;
                    
                    pstm = con.prepareStatement(UpdateQueryBuilder.UPDATE_ENROLLMENT);
                    pstm.setFloat(1, f);
                    pstm.setLong(2, res.getLong("idMatricula"));
                    pstm.executeUpdate();
                }                
                
                pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_CRITERION);
                pstm.setLong(1, criterion.getIdCriterioAvaliacao());
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
    
}
