/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.query.builder;

import ELearning.query.builder.lang.DeleteQueryBuilder;
import ELearning.query.builder.lang.InsertQueryBuilder;
import ELearning.model.*;
import ELearning.query.builder.lang.ColumnQueryBuilder;
import ELearning.query.builder.lang.CriteriaQueryBuilder;
import ELearning.query.builder.lang.StatementQueryBuilder;
import ELearning.query.builder.lang.TableQueryBuilder;
import ELearning.query.builder.lang.UpdateQueryBuilder;

/**
 *
 * @author Acessa SP
 */
public class QueryBuilder {
    public static String buildInsert(String table){
        StringBuilder statement = new StringBuilder();
        
        if(table.toUpperCase().equals("USUARIO")){
            statement.append(InsertQueryBuilder.INSERT_USER);
        }else if(table.toUpperCase().equals("PESSOA")){
            statement.append(InsertQueryBuilder.INSERT_PERSON);
        }else if(table.toUpperCase().equals("ALUNO")){
            statement.append(InsertQueryBuilder.INSERT_STUDENT);
        }else if(table.toUpperCase().equals("PROFESSOR")){
            statement.append(InsertQueryBuilder.INSERT_PROFESSOR);
        }else if(table.toUpperCase().equals("MATRICULA")){
            statement.append(InsertQueryBuilder.INSERT_ENROLLMENT);
        }else if(table.toUpperCase().equals("CRITERIOAVALIACAO")){
            statement.append(InsertQueryBuilder.INSERT_CRITERION);
        }else if(table.toUpperCase().equals("DISCIPLINA")){
            statement.append(InsertQueryBuilder.INSERT_DISCIPLINE);
        }else if(table.toUpperCase().equals("NOTA")){
            statement.append(InsertQueryBuilder.INSERT_GRADE);
        }
        
        return statement.toString();
    }

    public static String buildUpdate(Object oldRow, Object newRow){
        StringBuilder statement = new StringBuilder();
        boolean twoOrMoreParameters = false;
        
        if(oldRow.getClass().equals(newRow.getClass()) && oldRow != null && newRow != null){
            if(oldRow instanceof Aluno){
                //Não existe elemento da tabela Aluno a ser atualizado no banco
            }else if(oldRow instanceof CriterioAvaliacao){
                CriterioAvaliacao oldCriterion = (CriterioAvaliacao) oldRow;
                CriterioAvaliacao newCriterion = (CriterioAvaliacao) newRow;
                
                statement.append(UpdateQueryBuilder.UPDATE);
                statement.append(TableQueryBuilder.CRITERION);
                statement.append(UpdateQueryBuilder.SET);
                
                if(!(oldCriterion.getNome().equals(newCriterion.getNome()))){
                    statement.append(ColumnQueryBuilder.NAME_CRITERION);
                    statement.append(CriteriaQueryBuilder.EQUAL);
                    statement.append(newCriterion.getNome());
                    twoOrMoreParameters = true;
                }
                if(!(oldCriterion.getPeso() == newCriterion.getPeso())){
                     if(twoOrMoreParameters) statement.append(StatementQueryBuilder.COMMA);
                     statement.append(ColumnQueryBuilder.WEIGHT_CRITERION);
                     statement.append(CriteriaQueryBuilder.EQUAL);
                     statement.append(newCriterion.getPeso());
                     twoOrMoreParameters = true;
                }
                
                statement.append(CriteriaQueryBuilder.WHERE);
                statement.append(ColumnQueryBuilder.ID_CRITERION);
                statement.append(CriteriaQueryBuilder.EQUAL);
                statement.append(oldCriterion.getIdCriterioAvaliacao());
            }else if(oldRow instanceof Disciplina){
                Disciplina oldDiscipline = (Disciplina) oldRow;
                Disciplina newDiscipline = (Disciplina) newRow;
                
                statement.append(UpdateQueryBuilder.UPDATE);
                statement.append(TableQueryBuilder.DISCIPLINE);
                statement.append(UpdateQueryBuilder.SET);
                
                
                
                statement.append(CriteriaQueryBuilder.WHERE);
                statement.append(ColumnQueryBuilder.ID_DISCIPLINE);
                statement.append(CriteriaQueryBuilder.EQUAL);
                statement.append(oldDiscipline.getIdDisciplina());
            }else if(oldRow instanceof Matricula){
                Matricula oldEnrollment = (Matricula) oldRow;
                Matricula newEnrollment = (Matricula) newRow;

                statement.append(UpdateQueryBuilder.UPDATE);
                statement.append(TableQueryBuilder.ENROLLMENT);
                statement.append(UpdateQueryBuilder.SET);
                
                if(!(oldEnrollment.getNotaFinal() == newEnrollment.getNotaFinal())){
                    statement.append(ColumnQueryBuilder.FINAL_GRADE);
                    statement.append(CriteriaQueryBuilder.EQUAL);
                    statement.append(newEnrollment.getNotaFinal());                      
                }
                        
                statement.append(CriteriaQueryBuilder.WHERE);
                statement.append(ColumnQueryBuilder.ID_ENROLLMENT);
                statement.append(CriteriaQueryBuilder.EQUAL);
                statement.append(oldEnrollment.getIdMatricula());
            }else if(oldRow instanceof Nota){
                Nota oldGrade = (Nota) oldRow;
                Nota newGrade = (Nota) newRow;
                
                statement.append(UpdateQueryBuilder.UPDATE);
                statement.append(TableQueryBuilder.GRADE);
                statement.append(UpdateQueryBuilder.SET);
                
                if(!(oldGrade.getNotaCriterio() == newGrade.getNotaCriterio())){
                    statement.append(ColumnQueryBuilder.GRADE_CRITERION);
                    statement.append(CriteriaQueryBuilder.EQUAL);
                    statement.append(newGrade.getNotaCriterio());                    
                }
                
                statement.append(CriteriaQueryBuilder.WHERE);
                statement.append(ColumnQueryBuilder.ID_GRADE);
                statement.append(CriteriaQueryBuilder.EQUAL);
                statement.append(oldGrade.getIdNota());
            }else if(oldRow instanceof Professor){
                //Não existe elemento da tabela Professor a ser atualizado no banco
            }else if(oldRow instanceof Pessoa){
                Pessoa oldPessoa = (Pessoa) oldRow;
                Pessoa newPessoa = (Pessoa) newRow;
                
                statement.append(UpdateQueryBuilder.UPDATE);
                statement.append(TableQueryBuilder.PERSON);
                statement.append(UpdateQueryBuilder.SET);
                
                if(!oldPessoa.getEndereco().equals(newPessoa.getEndereco())){
                     statement.append(ColumnQueryBuilder.ADDRESS);
                     statement.append(CriteriaQueryBuilder.EQUAL);
                     statement.append(newPessoa.getEndereco());
                     twoOrMoreParameters = true;   
                }
                if(!oldPessoa.getTelefone().equals(newPessoa.getTelefone())){
                     if(twoOrMoreParameters) statement.append(StatementQueryBuilder.COMMA);
                     statement.append(ColumnQueryBuilder.TELEPHONE);
                     statement.append(CriteriaQueryBuilder.EQUAL);
                     statement.append(newPessoa.getTelefone());
                     twoOrMoreParameters = true;
                }
                
                statement.append(CriteriaQueryBuilder.WHERE);
                statement.append(ColumnQueryBuilder.ID_PERSON);
                statement.append(CriteriaQueryBuilder.EQUAL);
                statement.append(oldPessoa.getIdUsuario());
            }else if(oldRow instanceof Usuario){
                Usuario oldUser = (Usuario) oldRow;
                Usuario newUser = (Usuario) newRow;
                
                statement.append(UpdateQueryBuilder.UPDATE);
                statement.append(TableQueryBuilder.USER);
                statement.append(UpdateQueryBuilder.SET);
                
                if(!oldUser.getSenha().equals(newUser.getSenha())){
                     statement.append(ColumnQueryBuilder.PASSWORD);
                     statement.append(CriteriaQueryBuilder.EQUAL);
                     statement.append(newUser.getSenha());
                     twoOrMoreParameters = true;   
                }
                
                statement.append(CriteriaQueryBuilder.WHERE);
                statement.append(ColumnQueryBuilder.ID_USER);
                statement.append(CriteriaQueryBuilder.EQUAL);
                statement.append(oldUser.getIdUsuario());
            }
        }
        
        return statement.toString();        
    }

    public static String buildSelect(Object objCriteria) {
        StringBuilder statement = new StringBuilder();

        if (objCriteria instanceof Aluno) {
            
        } else if (objCriteria instanceof CriterioAvaliacao) {
            
        } else if (objCriteria instanceof Disciplina) {
            
        } else if (objCriteria instanceof Matricula) {
            
        } else if (objCriteria instanceof Nota) {
            
        } else if (objCriteria instanceof Professor) {
            
        } else if (objCriteria instanceof Pessoa) {
            
        } else if (objCriteria instanceof Usuario) {
            
        }

        return statement.toString();
    }
    
    public static String buildDelete(String table){
        StringBuilder statement = new StringBuilder();
        
        if(table.toUpperCase().equals("USUARIO")){
            statement.append(DeleteQueryBuilder.DELETE_USER);
        }else if(table.toUpperCase().equals("PESSOA")){
            statement.append(DeleteQueryBuilder.DELETE_PERSON);
        }else if(table.toUpperCase().equals("ALUNO")){
            statement.append(DeleteQueryBuilder.DELETE_STUDENT);
        }else if(table.toUpperCase().equals("PROFESSOR")){
            statement.append(DeleteQueryBuilder.DELETE_PROFESSOR);
        }else if(table.toUpperCase().equals("MATRICULA")){
            statement.append(DeleteQueryBuilder.DELETE_ENROLLMENT);
        }else if(table.toUpperCase().equals("CRITERIOAVALIACAO")){
            statement.append(DeleteQueryBuilder.DELETE_CRITERION);
        }else if(table.toUpperCase().equals("DISCIPLINA")){
            statement.append(DeleteQueryBuilder.DELETE_DISCIPLINE);
        }else if(table.toUpperCase().equals("NOTA")){
            statement.append(DeleteQueryBuilder.DELETE_GRADE);
        }
        
        return statement.toString();
    }
}
