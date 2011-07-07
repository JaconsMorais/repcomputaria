/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.query.builder.lang;

/**
 *
 * @author Acessa SP
 */
public class SelectQueryBuilder {
    public static final String SELECT_LOGIN = "SELECT * FROM Usuario WHERE login = ? and senha = ?";
    //Parâmetro: idAluno
    public static final String SELECT_NOT_MADE_ENROLLMENTS_FROM_STUDENT = "SELECT DISTINCT Disciplina.idDisciplina, nomeDisciplina, login, dataInicio, dataFim FROM Matricula, Disciplina, Usuario, Aluno WHERE Disciplina.idProfessor = Usuario.idUsuario AND Disciplina.idDisciplina NOT IN (SELECT idDisciplina FROM Matricula WHERE idAluno = ?) ORDER BY nomeDisciplina";
    public static final String SELECT_ENROLLMENT = "SELECT * FROM Matricula WHERE idMatricula = ?";
    public static final String SELECT_CRITERION = "SELECT * FROM CriterioAvaliacao WHERE idCriterioAvaliacao = ?";
    public static final String SELECT_ENROLLMENT_BY_CRITERION = "SELECT Matricula.idMatricula, Matricula.idDisciplina, idAluno, notaFinal FROM Matricula, Nota, CriterioAvaliacao WHERE Matricula.idMatricula = Nota.idMatricula AND Nota.idCriterioAvaliacao = CriterioAvaliacao.idCriterioAvaliacao AND CriterioAvaliacao.idCriterioAvaliacao = ?";
    public static final String SELECT_STUDENT = "SELECT idAluno, login, senha, endereco, telefone FROM Aluno, Pessoa, Usuario WHERE idUsuario = idPessoa AND idPessoa = idAluno AND idAluno = ?";
    public static final String SELECT_ALL_STUDENTS = "SELECT idAluno, login, senha, endereco, telefone FROM Aluno, Pessoa, Usuario WHERE idUsuario = idPessoa AND idPessoa = idAluno";
    public static final String SELECT_DISCIPLINE = "SELECT * FROM Disciplina WHERE idDisciplina = ?";
    public static final String SELECT_GRADE = "SELECT * FROM Nota WHERE idNota = ?";
    public static final String SELECT_GRADE_BY_CRITERION = "SELECT * FROM Nota WHERE idCriterioAvaliacao = ?";
    public static final String SELECT_GRADE_BY_ENROLLMENT = "SELECT idNota, Nota.idMatricula, idCriterioAvaliacao, notaCriterio FROM Nota, Matricula WHERE Nota.idMatricula = Matricula.idMatricula AND Matricula.idMatricula = ?";
    public static final String SELECT_PROFESSOR = "SELECT idProfessor, login, senha, endereco, telefone FROM Professor, Pessoa, Usuario WHERE Usuario.idUsuario = Pessoa.idPessoa AND Pessoa.idPessoa = Professor.idProfessor AND idProfessor = ?";
    public static final String SELECT_ALL_PROFESSORS = "SELECT idProfessor, login, senha, endereco, telefone FROM Professor, Pessoa, Usuario WHERE Usuario.idUsuario = Pessoa.idPessoa AND Pessoa.idPessoa = Professor.idProfessor";
    public static final String SELECT = "SELECT ";
    public static final String FROM = " FROM ";
    public static final String SELECT_DISCIPLINE_BY_PROFESSOR = "SELECT idDisciplina, Disciplina.idProfessor, nomeDisciplina, numNotas, dataInicio, dataFim FROM Disciplina, Professor WHERE Disciplina.idProfessor = Professor.idProfessor AND Professor.idProfessor = ?";
    public static final String SELECT_CRITERION_BY_DISCIPLINE = "SELECT idCriterioAvaliacao, CriterioAvaliacao.idDisciplina, nome, peso FROM CriterioAvaliacao, Disciplina WHERE Disciplina.idDisciplina = CriterioAvaliacao.idDisciplina AND Disciplina.idDisciplina = ?";
    public static final String SELECT_ENROLLMENT_BY_DISCIPLINE = "SELECT idMatricula, Matricula.idDisciplina, idAluno, notaFinal FROM Matricula, Disciplina WHERE Disciplina.idDisciplina = Matricula.idDisciplina AND Disciplina.idDisciplina = ?";
    public static final String SELECT_ENROLLMENT_BY_STUDENT = "SELECT idMatricula, Matricula.idDisciplina, idAluno, notaFinal FROM Matricula, Disciplina WHERE Matricula.idAluno = ?";
    public static final String SELECT_CRITERION_BY_PROFESSOR = "SELECT idCriterioAvaliacao, CriterioAvaliacao.idDisciplina, nome, peso FROM CriterioAvaliacao, Disciplina WHERE CriterioAvaliacao.idDisciplina = Disciplina.idDisciplina AND idProfessor = ?";
    public static final String SELECT_GRADE_BY_PROFESSOR = "SELECT idNota, Nota.idMatricula, idAluno, notaCriterio FROM Nota, Matricula, Disciplina WHERE Nota.idMatricula = Matricula.idMatricula AND Matricula.idDisciplina = Disciplina.idDisciplina AND idProfessor = ?";
}
