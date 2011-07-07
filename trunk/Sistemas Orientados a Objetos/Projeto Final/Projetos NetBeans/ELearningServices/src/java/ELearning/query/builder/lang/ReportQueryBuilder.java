/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.query.builder.lang;

/**
 *
 * @author Acessa SP
 */
public class ReportQueryBuilder {
    public static final String REPORT_ALL_STUDENTS = "SELECT login, endereco, telefone FROM Usuario, Pessoa, Aluno WHERE Usuario.idUsuario = Pessoa.idPessoa AND Pessoa.idPessoa = Aluno.idAluno ORDER BY login";
    public static final String REPORT_ALL_PROFESSORS = "SELECT login, endereco, telefone FROM Usuario, Pessoa, Professor WHERE Usuario.idUsuario = Pessoa.idPessoa AND Pessoa.idPessoa = Professor.idProfessor ORDER BY login";
    public static final String REPORT_ALL_DISCIPLINES = "SELECT nomeDisciplina, login, dataInicio, dataFim FROM Usuario, Disciplina WHERE Disciplina.idProfessor = Usuario.idUsuario ORDER BY nomeDisciplina";
    public static final String REPORT_ALL_DISCIPLINES_AND_CRITERIA_FROM_PROFESSOR = "SELECT nomeDisciplina, nome, peso FROM Disciplina, CriterioAvaliacao WHERE Disciplina.idDisciplina = CriterioAvaliacao.idDisciplina AND idProfessor = ? ORDER BY nomeDisciplina, idCriterioAvaliacao";
    public static final String REPORT_ALL_ENROLLMENTS_FROM_PROFESSOR = "SELECT login, nomeDisciplina FROM Aluno, Usuario, Disciplina, Matricula WHERE Aluno.idAluno = Matricula.idAluno AND Usuario.idUsuario = Aluno.idAluno AND Disciplina.idDisciplina = Matricula.idDisciplina AND idProfessor = ? ORDER BY nomeDisciplina";
    public static final String REPORT_ENROLLMENTS_COUNT = "SELECT nomeDisciplina, COUNT(*) FROM Aluno, Disciplina, Matricula WHERE Aluno.idAluno = Matricula.idAluno AND Disciplina.idDisciplina = Matricula.idDisciplina AND idProfessor = ? GROUP BY nomeDisciplina";
    public static final String REPORT_FINAL_GRADE_FROM_PROFESSOR = "SELECT login, nomeDisciplina, notaFinal FROM Matricula, Disciplina, Usuario WHERE Matricula.idAluno = Usuario.idUsuario AND Matricula.idDisciplina = Disciplina.idDisciplina AND idProfessor = ? ORDER BY login";
    public static final String REPORT_FINAL_GRADE_FROM_STUDENT = "SELECT nomeDisciplina, notaFinal FROM Matricula, Disciplina, Usuario WHERE Matricula.idAluno = Usuario.idUsuario AND Matricula.idDisciplina = Disciplina.idDisciplina AND Matricula.idAluno = ? ORDER BY login";
}
