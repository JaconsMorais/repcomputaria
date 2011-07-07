/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.dao.impl;

import ELearning.connection.FabricaConexao;
import ELearning.dao.interfaces.ReportDAO;
import ELearning.model.Aluno;
import ELearning.model.Disciplina;
import ELearning.model.Professor;
import ELearning.model.report.DisciplineGradeReport;
import ELearning.model.report.EnrollmentCountReport;
import ELearning.model.report.EnrollmentCriteriaReport;
import ELearning.model.report.StudentDisciplineGradeReport;
import ELearning.model.report.StudentListReport;
import ELearning.model.special.StudentEnrollmentModel;
import ELearning.query.builder.lang.ReportQueryBuilder;
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
public class ReportDAOImpl implements ReportDAO{

    @Override
    public List<Professor> getAllProfessors() {
        List<Professor> listaProfessores = new ArrayList<Professor>();
        PreparedStatement pstm = null;
        ResultSet res1 = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_ALL_PROFESSORS);
                res1 = pstm.executeQuery();

                while(res1.next()){
                    Professor model = new Professor();

                    model.setLogin(res1.getString("login"));
                    model.setEndereco(res1.getString("endereco"));
                    model.setTelefone(res1.getString("telefone"));

                    listaProfessores.add(model);
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
    public List<Aluno> getAllStudents() {
        List<Aluno> listaAlunos = new ArrayList<Aluno>();
        PreparedStatement pstm = null;
        ResultSet res1 = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(SelectQueryBuilder.SELECT_ALL_STUDENTS);
                res1 = pstm.executeQuery();

                while(res1.next()){
                    Aluno model = new Aluno();

                    model.setLogin(res1.getString("login"));
                    model.setEndereco(res1.getString("endereco"));
                    model.setTelefone(res1.getString("telefone"));

                    listaAlunos.add(model);
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
    public List<DisciplineGradeReport> getDisciplineGrade(Professor professor) {
        List<DisciplineGradeReport> listaNotaDisciplinas = new ArrayList<DisciplineGradeReport>();
        PreparedStatement pstm = null;
        ResultSet res1 = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(ReportQueryBuilder.REPORT_FINAL_GRADE_FROM_PROFESSOR);
                pstm.setLong(1, professor.getIdUsuario());
                res1 = pstm.executeQuery();

                while(res1.next()){
                    DisciplineGradeReport model = new DisciplineGradeReport();

                    model.setLogin(res1.getString("login"));
                    model.setNomeDisciplina(res1.getString("nomeDisciplina"));
                    model.setNotaFinal(res1.getFloat("notaFinal"));

                    listaNotaDisciplinas.add(model);
                }

                con.commit();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Problemas ao procurar: " + ex.getMessage());
            }
        }

        return listaNotaDisciplinas;
    }

    @Override
    public List<StudentDisciplineGradeReport> getStudentDisciplineGrade(Aluno student) {
        List<StudentDisciplineGradeReport> listaNotaDisciplinasAluno = new ArrayList<StudentDisciplineGradeReport>();
        PreparedStatement pstm = null;
        ResultSet res1 = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(ReportQueryBuilder.REPORT_FINAL_GRADE_FROM_STUDENT);
                pstm.setLong(1, student.getIdUsuario());
                res1 = pstm.executeQuery();

                while(res1.next()){
                    StudentDisciplineGradeReport model = new StudentDisciplineGradeReport();

                    model.setNomeDisciplina(res1.getString("nomeDisciplina"));
                    model.setNotaFinal(res1.getFloat("notaFinal"));

                    listaNotaDisciplinasAluno.add(model);
                }

                con.commit();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Problemas ao procurar: " + ex.getMessage());
            }
        }

        return listaNotaDisciplinasAluno;
    }

    @Override
    public List<StudentListReport> getStudentList(Professor professor) {
        List<StudentListReport> listaCountMatriculas = new ArrayList<StudentListReport>();
        PreparedStatement pstm = null;
        ResultSet res1 = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(ReportQueryBuilder.REPORT_ALL_ENROLLMENTS_FROM_PROFESSOR);
                pstm.setLong(1, professor.getIdUsuario());
                res1 = pstm.executeQuery();

                while(res1.next()){
                    StudentListReport model = new StudentListReport();

                    model.setLogin(res1.getString("login"));
                    model.setNomeDisciplina(res1.getString("nomeDisciplina"));

                    listaCountMatriculas.add(model);
                }

                con.commit();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Problemas ao procurar: " + ex.getMessage());
            }
        }

        return listaCountMatriculas;
    }

    @Override
    public List<EnrollmentCriteriaReport> getEnrollmentCriteria(Professor professor) {
        List<EnrollmentCriteriaReport> listaCriteriosMatriculas = new ArrayList<EnrollmentCriteriaReport>();
        PreparedStatement pstm = null;
        ResultSet res1 = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(ReportQueryBuilder.REPORT_ALL_DISCIPLINES_AND_CRITERIA_FROM_PROFESSOR);
                pstm.setLong(1, professor.getIdUsuario());
                res1 = pstm.executeQuery();

                while(res1.next()){
                    EnrollmentCriteriaReport model = new EnrollmentCriteriaReport();

                    model.setNomeDisciplina(res1.getString("nomeDisciplina"));
                    model.setNome(res1.getString("nome"));
                    model.setPeso(res1.getInt("peso"));

                    listaCriteriosMatriculas.add(model);
                }

                con.commit();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Problemas ao procurar: " + ex.getMessage());
            }
        }

        return listaCriteriosMatriculas;
    }

    @Override
    public List<EnrollmentCountReport> getEnrollmentCount(Professor professor) {
        List<EnrollmentCountReport> listaCountMatriculas = new ArrayList<EnrollmentCountReport>();
        PreparedStatement pstm = null;
        ResultSet res1 = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(ReportQueryBuilder.REPORT_ENROLLMENTS_COUNT);
                pstm.setLong(1, professor.getIdUsuario());
                res1 = pstm.executeQuery();

                while(res1.next()){
                    EnrollmentCountReport model = new EnrollmentCountReport();

                    model.setNomeDisciplina(res1.getString("nomeDisciplina"));
                    model.setCountDisciplina(res1.getInt(2));

                    listaCountMatriculas.add(model);
                }

                con.commit();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Problemas ao procurar: " + ex.getMessage());
            }
        }

        return listaCountMatriculas;
    }

    public List<StudentEnrollmentModel> getAllDisciplines() {
        List<StudentEnrollmentModel> listaMatriculas = new ArrayList<StudentEnrollmentModel>();
        PreparedStatement pstm = null;
        ResultSet res1 = null;

        Connection con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                pstm = con.prepareStatement(ReportQueryBuilder.REPORT_ALL_DISCIPLINES);
                res1 = pstm.executeQuery();
                
                while(res1.next()){
                    StudentEnrollmentModel model = new StudentEnrollmentModel();

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
