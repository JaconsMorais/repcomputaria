/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.query.builder.lang;

/**
 *
 * @author Acessa SP
 */
public class InsertQueryBuilder {
    public static final String INSERT_USER = "INSERT INTO Usuario (login,senha,tipoUsuario) VALUES (?,?,?)";
    public static final String INSERT_PERSON = "INSERT INTO Pessoa (idPessoa,endereco,telefone) VALUES (?,?,?)";
    public static final String INSERT_STUDENT = "INSERT INTO Aluno (idAluno) VALUES (?)";
    public static final String INSERT_PROFESSOR = "INSERT INTO Professor (idProfessor) VALUES (?)";
    public static final String INSERT_ENROLLMENT = "INSERT INTO Matricula (idDisciplina,idAluno) VALUES (?,?)";
    public static final String INSERT_DISCIPLINE = "INSERT INTO Disciplina (idProfessor,nomeDisciplina,numNotas,dataInicio,dataFim) VALUES (?,?,?,?,?)";
    public static final String INSERT_GRADE = "INSERT INTO Nota (idMatricula,idCriterioAvaliacao,notaCriterio) VALUES (?,?,?)";
    public static final String INSERT_CRITERION = "INSERT INTO CriterioAvaliacao (idDisciplina,nome,peso) VALUES (?,?,?)";
    public static final String INSERT = "INSERT INTO ";
    public static final String VALUES = " VALUES ";
}
