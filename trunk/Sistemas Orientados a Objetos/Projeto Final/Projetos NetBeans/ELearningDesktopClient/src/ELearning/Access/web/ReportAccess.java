/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ELearning.Access.web;

import ELearning.services.client.relatorios.Aluno;
import ELearning.services.client.relatorios.DisciplineGradeReport;
import ELearning.services.client.relatorios.EnrollmentCountReport;
import ELearning.services.client.relatorios.EnrollmentCriteriaReport;
import ELearning.services.client.relatorios.Professor;
import ELearning.services.client.relatorios.ReportService;
import ELearning.services.client.relatorios.ReportService_Service;
import ELearning.services.client.relatorios.StudentDisciplineGradeReport;
import ELearning.services.client.relatorios.StudentEnrollmentModel;
import ELearning.services.client.relatorios.StudentListReport;
import java.util.List;

/**
 *
 * @author Acessa SP
 */
public class ReportAccess {

    public static List<Aluno> getAllStudents(){
        ReportService_Service service = new ReportService_Service();
        ReportService port = service.getReportServicePort();

        return port.getAllStudents();
    }
    
    public static List<Professor> getAllProfessors(){
        ReportService_Service service = new ReportService_Service();
        ReportService port = service.getReportServicePort();

        return port.getAllProfessors();
    }
    
    public static List<StudentEnrollmentModel> getAllDisciplines(){
        ReportService_Service service = new ReportService_Service();
        ReportService port = service.getReportServicePort();

        return port.getAllDisciplines();
    }

    public static List<DisciplineGradeReport> getDisciplineGrade(Professor professor){
        ReportService_Service service = new ReportService_Service();
        ReportService port = service.getReportServicePort();

        return port.getDisciplineGrade(professor);
    }

    public static List<EnrollmentCountReport> getEnrollmentCount(Professor professor){
        ReportService_Service service = new ReportService_Service();
        ReportService port = service.getReportServicePort();

        return port.getEnrollmentCount(professor);
    }

    public static List<StudentListReport> getStudentList(Professor professor){
        ReportService_Service service = new ReportService_Service();
        ReportService port = service.getReportServicePort();

        return port.getStudentList(professor);
    }

    public static List<EnrollmentCriteriaReport> getEnrollmentCriteria(Professor professor){
        ReportService_Service service = new ReportService_Service();
        ReportService port = service.getReportServicePort();

        return port.getEnrollmentCriteria(professor);
    }

    public static List<StudentDisciplineGradeReport> getStudentDisciplineGrade(Aluno student){
        ReportService_Service service = new ReportService_Service();
        ReportService port = service.getReportServicePort();

        return port.getStudentDisciplineGrade(student);
    }

}
