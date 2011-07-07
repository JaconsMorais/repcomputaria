/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.query.builder.lang;

/**
 *
 * @author Acessa SP
 */
public class UpdateQueryBuilder {
    public static final String UPDATE_USER = "UPDATE Usuario SET login = ?, senha = ? WHERE idUsuario = ?";
    public static final String UPDATE_PERSON = "UPDATE Pessoa SET endereco = ?, telefone = ? WHERE idPessoa = ?";
    public static final String UPDATE_DISCIPLINE = "UPDATE Disciplina SET nomeDisciplina = ?, numNotas = ?, dataInicio = NULL, dataFim = NULL WHERE idDisciplina = ?";
    public static final String UPDATE_ENROLLMENT = "UPDATE Matricula SET notaFinal = ? WHERE idMatricula = ?";
    public static final String UPDATE_GRADE = "UPDATE Nota SET notaCriterio = ? WHERE idNota = ?";
    public static final String UPDATE_CRITERIA = "UPDATE CriterioAvaliacao SET nome = ?, peso = ? WHERE idCriterioAvaliacao = ?";
    public static final String UPDATE = "UPDATE ";
    public static final String SET = " SET ";
}
