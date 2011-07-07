/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.services;

import ELearning.dao.impl.ReportDAOImpl;
import ELearning.dao.interfaces.ReportDAO;
import ELearning.model.Aluno;
import ELearning.model.Professor;
import ELearning.model.report.DisciplineGradeReport;
import ELearning.model.report.EnrollmentCountReport;
import ELearning.model.report.EnrollmentCriteriaReport;
import ELearning.model.report.StudentDisciplineGradeReport;
import ELearning.model.report.StudentListReport;
import ELearning.model.special.StudentEnrollmentModel;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Acessa SP
 */
@WebService(serviceName = "ReportService")
public class ReportService {
    ReportDAO dao = new ReportDAOImpl();
    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "getAllProfessors")
    public List<Professor> getAllProfessors() {
        //TODO write your implementation code here:
        return dao.getAllProfessors();
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "getAllStudents")
    public List<Aluno> getAllStudents() {
        //TODO write your implementation code here:
        return dao.getAllStudents();
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "getDisciplineGrade")
    public List<DisciplineGradeReport> getDisciplineGrade(@WebParam(name = "professor")
    Professor professor) {
        //TODO write your implementation code here:
        return dao.getDisciplineGrade(professor);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "getStudentDisciplineGrade")
    public List<StudentDisciplineGradeReport> getStudentDisciplineGrade(@WebParam(name = "student")
    Aluno student) {
        //TODO write your implementation code here:
        return dao.getStudentDisciplineGrade(student);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "getStudentList")
    public List<StudentListReport> getStudentList(@WebParam(name = "professor")
    Professor professor) {
        //TODO write your implementation code here:
        return dao.getStudentList(professor);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "getEnrollmentCount")
    public List<EnrollmentCountReport> getEnrollmentCount(@WebParam(name = "professor")
    Professor professor) {
        //TODO write your implementation code here:
        return dao.getEnrollmentCount(professor);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "getEnrollmentCriteria")
    public List<EnrollmentCriteriaReport> getEnrollmentCriteria(@WebParam(name = "professor")
    Professor professor) {
        //TODO write your implementation code here:
        return dao.getEnrollmentCriteria(professor);
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "getAllDisciplines")
    public List<StudentEnrollmentModel> getAllDisciplines() {
        //TODO write your implementation code here:
        return dao.getAllDisciplines();
    }

}
