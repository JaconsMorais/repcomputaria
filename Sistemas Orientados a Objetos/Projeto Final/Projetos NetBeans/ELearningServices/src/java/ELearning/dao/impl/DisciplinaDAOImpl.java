/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.dao.impl;

import ELearning.connection.FabricaConexao;
import ELearning.dao.interfaces.DisciplinaDAO;
import ELearning.model.CriterioAvaliacao;
import ELearning.model.Disciplina;
import ELearning.model.Matricula;
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
public class DisciplinaDAOImpl implements DisciplinaDAO {

    @Override
    public boolean cadastrar(Disciplina newDiscipline) {
        boolean saved = false;
        PreparedStatement pstm = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(InsertQueryBuilder.INSERT_DISCIPLINE);
                pstm.setLong(1, newDiscipline.getIdProfessor());
                pstm.setString(2, newDiscipline.getNomeDisciplina());
                pstm.setInt(3, newDiscipline.getNumNotas());
                pstm.setDate(4, null);
                pstm.setDate(5, null);
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
    public List<Disciplina> procurar(Disciplina discipline) {
        List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
        PreparedStatement pstm = null;
        ResultSet res1 = null, res2 = null, res3 = null, res4 = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_DISCIPLINE);
                pstm.setLong(1, discipline.getIdDisciplina());
                res1 = pstm.executeQuery();

                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_CRITERION_BY_DISCIPLINE);
                pstm.setLong(1, discipline.getIdDisciplina());
                res2 = pstm.executeQuery();
                
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_ENROLLMENT_BY_DISCIPLINE);
                pstm.setLong(1, discipline.getIdDisciplina());
                res3 = pstm.executeQuery();

                while(res1.next()){
                    Disciplina d = new Disciplina();
                        
                    d.setIdDisciplina(res1.getLong("idDisciplina"));
                    d.setIdProfessor(res1.getLong("idProfessor"));
                    d.setNomeDisciplina(res1.getString("nomeDisciplina"));
                    d.setNumNotas(res1.getInt("numNotas"));
                    d.setDataInicio(res1.getDate("dataInicio"));
                    d.setDataFim(res1.getDate("dataFim"));
                        
                    List<CriterioAvaliacao> criteria = new ArrayList<CriterioAvaliacao>();
                    while(res2.next()){
                        CriterioAvaliacao criterion = new CriterioAvaliacao();
                           
                        criterion.setIdCriterioAvaliacao(res2.getLong("idCriterioAvaliacao"));
                        criterion.setIdDisciplina(res2.getLong("idDisciplina"));
                        criterion.setNome(res2.getString("nome"));
                        criterion.setPeso(res2.getInt("peso"));
                            
                        criteria.add(criterion);
                    }
                    d.setCriteria(criteria);

                    List<Matricula> matriculas = new ArrayList<Matricula>();
                    while(res3.next()){
                        Matricula m = new Matricula();
                          
                        m.setIdMatricula(res3.getLong("idMatricula"));
                        m.setIdDisciplina(res3.getLong("idDisciplina"));
                        m.setIdAluno(res3.getLong("idAluno"));
                        m.setNotaFinal(res3.getFloat("notaFinal"));

                        pstm = con.prepareStatement(SelectQueryBuilder.SELECT_GRADE_BY_ENROLLMENT);
                        pstm.setLong(1, res3.getLong("idMatricula"));
                        res4 = pstm.executeQuery();
                        List<Nota> notas = new ArrayList<Nota>();
                        while(res4.next()){
                            Nota n = new Nota();
                            n.setIdNota(res4.getLong("idNota"));
                            n.setIdMatricula(res4.getLong("idMatricula"));
                            n.setIdCriterion(res4.getLong("idCriterioAvaliacao"));
                            n.setNotaCriterio(res4.getFloat("notaCriterio"));
                               
                            notas.add(n);
                        }
                        m.setNotas(notas);

                        matriculas.add(m);
                    }
                    d.setMatriculas(matriculas);
                        
                    listaDisciplinas.add(d);
                }
                
                con.commit();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Problemas ao procurar: " + ex.getMessage());
            }
        }
        
        return listaDisciplinas;
    }

    @Override
    public Disciplina editar(Disciplina oldDiscipline, Disciplina newDiscipline) {
        boolean saved = false;
        PreparedStatement pstm = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(UpdateQueryBuilder.UPDATE_DISCIPLINE);
                pstm.setString(1, newDiscipline.getNomeDisciplina());
                pstm.setInt(2, newDiscipline.getNumNotas());
                pstm.setLong(3, newDiscipline.getIdDisciplina());
                pstm.executeUpdate();
                
                con.commit();
                con.close();
                saved = true;
            } catch (SQLException ex) {
                System.out.println("Problemas ao editar: " + ex.getMessage());
            }
        }

        return newDiscipline;
    }

    @Override
    public boolean deletar(Disciplina discipline) {
        try{
            discipline = (Disciplina)procurar(discipline).get(0);
        }catch(Exception e){
            return false;
        }
        boolean saved = false;
        PreparedStatement pstm = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                    for(Matricula m : discipline.getMatriculas()){
                        for(Nota n : m.getNotas()){
                            pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_GRADE);
                            pstm.setLong(1, n.getIdNota());
                            pstm.executeUpdate();
                        }
                        pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_ENROLLMENT);
                        pstm.setLong(1, m.getIdMatricula());
                        pstm.executeUpdate();
                    }
                    for(CriterioAvaliacao c : discipline.getCriteria()){
                        pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_CRITERION);
                        pstm.setLong(1, c.getIdCriterioAvaliacao());
                        pstm.executeUpdate();                            
                    }
                    pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_DISCIPLINE);
                    pstm.setLong(1, discipline.getIdDisciplina());
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
