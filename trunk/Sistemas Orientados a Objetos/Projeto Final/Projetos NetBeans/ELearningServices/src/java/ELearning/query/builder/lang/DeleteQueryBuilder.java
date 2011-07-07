/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.query.builder.lang;

/**
 *
 * @author Acessa SP
 */
public class DeleteQueryBuilder {
    public static final String DELETE_USER = "DELETE FROM Usuario WHERE idUsuario = ?";
    public static final String DELETE_PERSON = "DELETE FROM Pessoa WHERE idPessoa = ?";
    public static final String DELETE_STUDENT = "DELETE FROM Aluno WHERE idAluno = ?";
    public static final String DELETE_PROFESSOR = "DELETE FROM Professor WHERE idProfessor = ?";
    public static final String DELETE_ENROLLMENT = "DELETE FROM Matricula WHERE idMatricula = ?";
    public static final String DELETE_DISCIPLINE = "DELETE FROM Disciplina WHERE idDisciplina = ?";
    public static final String DELETE_GRADE = "DELETE FROM Nota  WHERE idNota = ?";
    public static final String DELETE_CRITERION = "DELETE FROM CriterioAvaliacao WHERE idCriterioAvaliacao = ?";
    public static final String DELETE_FROM = "DELETE FROM ";
}
