/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.dao.impl;

import ELearning.connection.FabricaConexao;
import ELearning.dao.interfaces.ProfessorDAO;
import ELearning.model.CriterioAvaliacao;
import ELearning.model.Disciplina;
import ELearning.model.Matricula;
import ELearning.model.Nota;
import ELearning.model.Professor;
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
public class ProfessorDAOImpl implements ProfessorDAO {

    @Override
    public boolean cadastrar(Professor newProfessor) {
        boolean saved = false;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long idUsuario = -1;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(InsertQueryBuilder.INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
                pstm.setString(1, newProfessor.getLogin());
                pstm.setString(2, newProfessor.getSenha());
                pstm.setInt(3, 2);
                pstm.executeUpdate();
                res = pstm.getGeneratedKeys();
                if (res.next()){
                    idUsuario = res.getLong(1);
                }
                System.out.println("ID: " + idUsuario);                
                
                pstm = con.prepareStatement(InsertQueryBuilder.INSERT_PERSON);
                pstm.setLong(1, idUsuario);
                pstm.setString(2, newProfessor.getEndereco());
                pstm.setString(3, newProfessor.getTelefone());
                pstm.executeUpdate();

                pstm = con.prepareStatement(InsertQueryBuilder.INSERT_PROFESSOR);
                pstm.setLong(1, idUsuario);
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
    public List<Professor> procurar(Professor professor) {
        List<Professor> listaProfessores = new ArrayList<Professor>();
        PreparedStatement pstm = null;
        ResultSet res1 = null, res2 = null, res3 = null, res4 = null, res5 = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_PROFESSOR);
                pstm.setLong(1, professor.getIdUsuario());
                res1 = pstm.executeQuery();
                
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_DISCIPLINE_BY_PROFESSOR);
                pstm.setLong(1, professor.getIdUsuario());
                res2 = pstm.executeQuery();
                
                if(res1.next()){
                    Professor p = new Professor();
                    
                    p.setIdUsuario(res1.getLong("idProfessor"));
                    p.setLogin(res1.getString("login"));
                    p.setSenha(res1.getString("senha"));
                    p.setEndereco(res1.getString("endereco"));
                    p.setTelefone(res1.getString("telefone"));
                    
                    List<Disciplina> disciplinas = new ArrayList<Disciplina>();
                    
                    while(res2.next()){
                        Disciplina d = new Disciplina();
                        
                        d.setIdDisciplina(res2.getLong("idDisciplina"));
                        d.setIdProfessor(res2.getLong("Disciplina.idProfessor"));
                        d.setNomeDisciplina(res2.getString("nomeDisciplina"));
                        d.setNumNotas(res2.getInt("numNotas"));
                        d.setDataInicio(res2.getDate("dataInicio"));
                        d.setDataFim(res2.getDate("dataFim"));

                        pstm = con.prepareStatement(SelectQueryBuilder.SELECT_CRITERION_BY_DISCIPLINE);
                        pstm.setLong(1, res2.getLong("Disciplina.idDisciplina"));
                        res3 = pstm.executeQuery();

                        List<CriterioAvaliacao> criteria = new ArrayList<CriterioAvaliacao>();
                        while(res3.next()){
                            CriterioAvaliacao criterion = new CriterioAvaliacao();
                            
                            criterion.setIdCriterioAvaliacao(res3.getLong("idCriterioAvaliacao"));
                            criterion.setIdDisciplina(res3.getLong("CriterioAvaliacao.idDisciplina"));
                            criterion.setNome(res3.getString("nome"));
                            criterion.setPeso(res3.getInt("peso"));
                            
                            criteria.add(criterion);
                        }
                        d.setCriteria(criteria);

                        pstm = con.prepareStatement(SelectQueryBuilder.SELECT_ENROLLMENT_BY_DISCIPLINE);
                        pstm.setLong(1, res2.getLong("Disciplina.idDisciplina"));
                        res4 = pstm.executeQuery();

                        List<Matricula> matriculas = new ArrayList<Matricula>();
                        while(res4.next()){
                            Matricula m = new Matricula();
                            
                            m.setIdMatricula(res4.getLong("idMatricula"));
                            m.setIdDisciplina(res4.getLong("Matricula.idDisciplina"));
                            m.setIdAluno(res4.getLong("idAluno"));
                            m.setNotaFinal(res4.getFloat("notaFinal"));

                            pstm = con.prepareStatement(SelectQueryBuilder.SELECT_GRADE_BY_ENROLLMENT);
                            pstm.setLong(1, res4.getLong("Matricula.idMatricula"));
                            res5 = pstm.executeQuery();

                            List<Nota> notas = new ArrayList<Nota>();
                            while(res5.next()){
                                Nota n = new Nota();
                                n.setIdNota(res5.getLong("idNota"));
                                n.setIdMatricula(res5.getLong("idMatricula"));
                                n.setIdCriterion(res5.getLong("idCriterioAvaliacao"));
                                n.setNotaCriterio(res5.getFloat("notaCriterio"));
                                
                                notas.add(n);
                            }
                            m.setNotas(notas);

                            matriculas.add(m);
                        }
                        d.setMatriculas(matriculas);

                        disciplinas.add(d);
                    }
                    
                    p.setDisciplinas(disciplinas);
                    
                    listaProfessores.add(p);
                }
                
                con.commit();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Problemas ao procurar: " + ex.getMessage());
            }
        }
        
        return listaProfessores;
    }

    @Override
    public Professor editar(Professor oldProfessor, Professor newProfessor) {
        boolean saved = false;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long idUsuario = -1;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(UpdateQueryBuilder.UPDATE_USER);
                pstm.setString(1, newProfessor.getLogin());
                pstm.setString(2, newProfessor.getSenha());
                pstm.setLong(3, oldProfessor.getIdUsuario());
                pstm.executeUpdate();               
                
                pstm = con.prepareStatement(UpdateQueryBuilder.UPDATE_PERSON);
                pstm.setString(1, newProfessor.getEndereco());
                pstm.setString(2, newProfessor.getTelefone());
                pstm.setLong(3, oldProfessor.getIdUsuario());
                pstm.executeUpdate();
                
                con.commit();
                con.close();
                saved = true;
            } catch (SQLException ex) {
                System.out.println("Problemas ao editar: " + ex.getMessage());
            }
        }
            
        return newProfessor;
    }

    @Override
    public boolean deletar(Professor professor) {
        try{
            professor = (Professor)procurar(professor).get(0);
        }catch(Exception e){
            return false;
        }
        boolean saved = false;
        PreparedStatement pstm = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                for(Disciplina d : professor.getDisciplinas()){
                    for(Matricula m : d.getMatriculas()){
                        for(Nota n : m.getNotas()){
                            pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_GRADE);
                            pstm.setLong(1, n.getIdNota());
                            pstm.executeUpdate();
                        }
                        pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_ENROLLMENT);
                        pstm.setLong(1, m.getIdMatricula());
                        pstm.executeUpdate();
                    }
                    for(CriterioAvaliacao c : d.getCriteria()){
                        pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_CRITERION);
                        pstm.setLong(1, c.getIdCriterioAvaliacao());
                        pstm.executeUpdate();                            
                    }
                    pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_DISCIPLINE);
                    pstm.setLong(1, d.getIdDisciplina());
                    pstm.executeUpdate();
                }
                pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_PROFESSOR);
                pstm.setLong(1, professor.getIdUsuario());
                pstm.executeUpdate();              
                
                pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_PERSON);
                pstm.setLong(1, professor.getIdUsuario());
                pstm.executeUpdate();

                pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_USER);
                pstm.setLong(1, professor.getIdUsuario());
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
