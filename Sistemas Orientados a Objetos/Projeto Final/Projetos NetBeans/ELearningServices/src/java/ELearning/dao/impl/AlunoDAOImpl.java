/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.dao.impl;

import ELearning.connection.FabricaConexao;
import ELearning.dao.interfaces.AlunoDAO;
import ELearning.model.Aluno;
import ELearning.model.Matricula;
import ELearning.model.Nota;
import ELearning.model.special.StudentEnrollmentModel;
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
public class AlunoDAOImpl implements AlunoDAO {

    @Override
    public boolean cadastrar(Aluno newStudent) {
        boolean saved = false;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long idUsuario = -1;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(InsertQueryBuilder.INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
                pstm.setString(1, newStudent.getLogin());
                pstm.setString(2, newStudent.getSenha());
                pstm.setInt(3, 3);
                pstm.executeUpdate();
                res = pstm.getGeneratedKeys();
                if (res.next()){
                    idUsuario = res.getLong(1);
                }
                System.out.println("ID: " + idUsuario);                
                
                pstm = con.prepareStatement(InsertQueryBuilder.INSERT_PERSON);
                pstm.setLong(1, idUsuario);
                pstm.setString(2, newStudent.getEndereco());
                pstm.setString(3, newStudent.getTelefone());
                pstm.executeUpdate();

                pstm = con.prepareStatement(InsertQueryBuilder.INSERT_STUDENT);
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
    public List<Aluno> procurar(Aluno student) {
        List<Aluno> listaAlunos = new ArrayList<Aluno>();
        PreparedStatement pstm = null;
        ResultSet res1 = null, res2 = null, res3 = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_STUDENT);
                pstm.setLong(1, student.getIdUsuario());
                res1 = pstm.executeQuery();
                
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_ENROLLMENT_BY_STUDENT);
                pstm.setLong(1, student.getIdUsuario());
                res2 = pstm.executeQuery();
                
                while(res1.next()){
                    Aluno a = new Aluno();
                    
                    a.setIdUsuario(res1.getLong("idAluno"));
                    a.setLogin(res1.getString("login"));
                    a.setSenha(res1.getString("senha"));
                    a.setEndereco(res1.getString("endereco"));
                    a.setTelefone(res1.getString("telefone"));

                    List<Matricula> matriculas = new ArrayList<Matricula>();
                    while(res2.next()){
                        Matricula m = new Matricula();
                            
                        m.setIdMatricula(res2.getLong("idMatricula"));
                        m.setIdDisciplina(res2.getLong("Matricula.idDisciplina"));
                        m.setIdAluno(res2.getLong("idAluno"));
                        m.setNotaFinal(res2.getFloat("notaFinal"));
                        
                        pstm = con.prepareStatement(SelectQueryBuilder.SELECT_GRADE_BY_ENROLLMENT);
                        pstm.setLong(1, res2.getLong("idMatricula"));
                        res3 = pstm.executeQuery();

                        List<Nota> notas = new ArrayList<Nota>();
                        while(res3.next()){
                            Nota n = new Nota();
                            n.setIdNota(res3.getLong("idNota"));
                            n.setIdMatricula(res3.getLong("Nota.idMatricula"));
                            n.setIdCriterion(res3.getLong("idCriterioAvaliacao"));
                            n.setNotaCriterio(res3.getFloat("notaCriterio"));
                               
                            notas.add(n);
                        }
                        m.setNotas(notas);

                        matriculas.add(m);
                    }
                    a.setMatriculas(matriculas);
                    
                    listaAlunos.add(a);
                }
                
                con.commit();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Problemas ao procurar: " + ex.getMessage());
            }
        }
        
        return listaAlunos;
    }

    @Override
    public Aluno editar(Aluno oldStudent, Aluno newStudent) {
        boolean saved = false;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long idUsuario = -1;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(UpdateQueryBuilder.UPDATE_USER);
                pstm.setString(1, newStudent.getLogin());
                pstm.setString(2, newStudent.getSenha());
                pstm.setLong(3, oldStudent.getIdUsuario());
                pstm.executeUpdate();               
                
                pstm = con.prepareStatement(UpdateQueryBuilder.UPDATE_PERSON);
                pstm.setString(1, newStudent.getEndereco());
                pstm.setString(2, newStudent.getTelefone());
                pstm.setLong(3, oldStudent.getIdUsuario());
                pstm.executeUpdate();
                
                con.commit();
                con.close();
                saved = true;
            } catch (SQLException ex) {
                System.out.println("Problemas ao editar: " + ex.getMessage());
            }
        }
        if(saved)
            return newStudent;
        else
            return null;
    }

    @Override
    public boolean deletar(Aluno student) {
        try{
            student = (Aluno)procurar(student).get(0);
        }catch(Exception e){
            return false;
        }
        boolean saved = false;
        PreparedStatement pstm = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                for(Matricula m : student.getMatriculas()){
                    for(Nota n : m.getNotas()){
                        pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_GRADE);
                        pstm.setLong(1, n.getIdNota());
                        pstm.executeUpdate();
                    }
                    pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_ENROLLMENT);
                    pstm.setLong(1, m.getIdMatricula());
                    pstm.executeUpdate();
                }
                
                pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_STUDENT);
                pstm.setLong(1, student.getIdUsuario());
                pstm.executeUpdate();              
                
                pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_PERSON);
                pstm.setLong(1, student.getIdUsuario());
                pstm.executeUpdate();

                pstm = con.prepareStatement(DeleteQueryBuilder.DELETE_USER);
                pstm.setLong(1, student.getIdUsuario());
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

    @Override
    public List<StudentEnrollmentModel> procurarMatriculasNaoFeitas(Aluno student) {
        List<StudentEnrollmentModel> listaMatriculas = new ArrayList<StudentEnrollmentModel>();
        PreparedStatement pstm = null;
        ResultSet res1 = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_NOT_MADE_ENROLLMENTS_FROM_STUDENT);
                pstm.setLong(1, student.getIdUsuario());
                res1 = pstm.executeQuery();
                
                while(res1.next()){
                    StudentEnrollmentModel model = new StudentEnrollmentModel();
                    
                    model.setIdDisciplina(res1.getLong("Disciplina.idDisciplina"));
                    model.setLogin(res1.getString("login"));
                    model.setNomeDisciplina(res1.getString("nomeDisciplina"));
                    model.setDataInicio(res1.getDate("dataInicio"));
                    model.setDataFim(res1.getDate("dataFim"));
                    
                    listaMatriculas.add(model);
                }
                
                con.commit();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Problemas ao procurar: " + ex.getMessage());
            }
        }
        
        return listaMatriculas;
    }
    
}
