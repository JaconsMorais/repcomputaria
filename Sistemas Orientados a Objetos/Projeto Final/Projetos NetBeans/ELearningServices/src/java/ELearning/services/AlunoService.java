/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.services;

import ELearning.dao.impl.AlunoDAOImpl;
import ELearning.dao.interfaces.AlunoDAO;
import ELearning.model.Aluno;
import ELearning.model.special.StudentEnrollmentModel;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Acessa SP
 */
@WebService(serviceName = "AlunoService")
public class AlunoService {
    AlunoDAO dao = new AlunoDAOImpl();
    
    @WebMethod(operationName = "cadastrarAluno")
    public boolean cadastrarAluno(@WebParam(name = "newStudent")
    Aluno newStudent) {
        //TODO write your implementation code here:
        //cadastra o aluno
        return dao.cadastrar(newStudent);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "procurarAluno")
    public List<Aluno> procurarAluno(@WebParam(name = "student")
    Aluno student) {
        //TODO write your implementation code here:
        return dao.procurar(student);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "editarAluno")
    public Aluno editarAluno(@WebParam(name = "oldStudent")
    Aluno oldStudent, @WebParam(name = "newStudent")
    Aluno newStudent) {
        //TODO write your implementation code here:
        return dao.editar(oldStudent,newStudent);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "deletarAluno")
    public boolean deletarAluno(@WebParam(name = "student")
    Aluno student) {
        //TODO write your implementation code here:
        return dao.deletar(student);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "procurarMatriculasNaoFeitas")
    public List<StudentEnrollmentModel> procurarMatriculasNaoFeitas(@WebParam(name = "student")
    Aluno student) {
        //TODO write your implementation code here:
        return dao.procurarMatriculasNaoFeitas(student);
    }
}
