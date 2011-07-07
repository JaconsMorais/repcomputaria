/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.query.builder.lang;

/**
 *
 * @author Acessa SP
 */
public class ColumnQueryBuilder {
    //Geral
    public static final String ALL = "*";
    
    //Chaves primárias
    public static final String ID_USER = "idUsuario";
    public static final String ID_PERSON = "idPessoa";
    public static final String ID_STUDENT = "idAluno";
    public static final String ID_PROFESSOR = "idProfessor";
    public static final String ID_ENROLLMENT = "idMatricula";
    public static final String ID_DISCIPLINE = "idDisciplina";
    public static final String ID_CRITERION = "idCriterioAvaliacao";
    public static final String ID_GRADE = "idNota";
    
    //Tabela Usuario
    public static final String LOGIN = "login";
    public static final String PASSWORD = "senha";
    public static final String USER_TYPE = "tipoUsuario";
    
    //Tabela Pessoa
    public static final String ADDRESS = "endereco";
    public static final String TELEPHONE= "telefone";
    
    //Tabela Matricula
    public static final String FINAL_GRADE = "notaFinal";
    
    //Tabela Disciplina
    public static final String NAME_DISCIPLINE = "nomeDisciplina";
    public static final String NUMBER_GRADES = "numNotas";
    public static final String INITIAL_DATE = "dataInicio";
    public static final String FINAL_DATE = "dataFim";
    
    //Tabela CriterioAvaliacao
    public static final String NAME_CRITERION = "nome";
    public static final String WEIGHT_CRITERION = "peso";
    
    //Tabela Nota
    public static final String GRADE_CRITERION = "notaCriterio";
}
