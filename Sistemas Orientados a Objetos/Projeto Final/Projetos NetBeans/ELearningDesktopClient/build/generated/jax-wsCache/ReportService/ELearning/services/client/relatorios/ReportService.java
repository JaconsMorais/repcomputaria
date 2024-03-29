
package ELearning.services.client.relatorios;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-hudson-752-
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ReportService", targetNamespace = "http://services.ELearning/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ReportService {


    /**
     * 
     * @return
     *     returns java.util.List<ELearning.services.client.relatorios.Professor>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllProfessors", targetNamespace = "http://services.ELearning/", className = "ELearning.services.client.relatorios.GetAllProfessors")
    @ResponseWrapper(localName = "getAllProfessorsResponse", targetNamespace = "http://services.ELearning/", className = "ELearning.services.client.relatorios.GetAllProfessorsResponse")
    @Action(input = "http://services.ELearning/ReportService/getAllProfessorsRequest", output = "http://services.ELearning/ReportService/getAllProfessorsResponse")
    public List<Professor> getAllProfessors();

    /**
     * 
     * @return
     *     returns java.util.List<ELearning.services.client.relatorios.Aluno>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllStudents", targetNamespace = "http://services.ELearning/", className = "ELearning.services.client.relatorios.GetAllStudents")
    @ResponseWrapper(localName = "getAllStudentsResponse", targetNamespace = "http://services.ELearning/", className = "ELearning.services.client.relatorios.GetAllStudentsResponse")
    @Action(input = "http://services.ELearning/ReportService/getAllStudentsRequest", output = "http://services.ELearning/ReportService/getAllStudentsResponse")
    public List<Aluno> getAllStudents();

    /**
     * 
     * @param professor
     * @return
     *     returns java.util.List<ELearning.services.client.relatorios.DisciplineGradeReport>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDisciplineGrade", targetNamespace = "http://services.ELearning/", className = "ELearning.services.client.relatorios.GetDisciplineGrade")
    @ResponseWrapper(localName = "getDisciplineGradeResponse", targetNamespace = "http://services.ELearning/", className = "ELearning.services.client.relatorios.GetDisciplineGradeResponse")
    @Action(input = "http://services.ELearning/ReportService/getDisciplineGradeRequest", output = "http://services.ELearning/ReportService/getDisciplineGradeResponse")
    public List<DisciplineGradeReport> getDisciplineGrade(
        @WebParam(name = "professor", targetNamespace = "")
        Professor professor);

    /**
     * 
     * @param student
     * @return
     *     returns java.util.List<ELearning.services.client.relatorios.StudentDisciplineGradeReport>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStudentDisciplineGrade", targetNamespace = "http://services.ELearning/", className = "ELearning.services.client.relatorios.GetStudentDisciplineGrade")
    @ResponseWrapper(localName = "getStudentDisciplineGradeResponse", targetNamespace = "http://services.ELearning/", className = "ELearning.services.client.relatorios.GetStudentDisciplineGradeResponse")
    @Action(input = "http://services.ELearning/ReportService/getStudentDisciplineGradeRequest", output = "http://services.ELearning/ReportService/getStudentDisciplineGradeResponse")
    public List<StudentDisciplineGradeReport> getStudentDisciplineGrade(
        @WebParam(name = "student", targetNamespace = "")
        Aluno student);

    /**
     * 
     * @param professor
     * @return
     *     returns java.util.List<ELearning.services.client.relatorios.StudentListReport>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStudentList", targetNamespace = "http://services.ELearning/", className = "ELearning.services.client.relatorios.GetStudentList")
    @ResponseWrapper(localName = "getStudentListResponse", targetNamespace = "http://services.ELearning/", className = "ELearning.services.client.relatorios.GetStudentListResponse")
    @Action(input = "http://services.ELearning/ReportService/getStudentListRequest", output = "http://services.ELearning/ReportService/getStudentListResponse")
    public List<StudentListReport> getStudentList(
        @WebParam(name = "professor", targetNamespace = "")
        Professor professor);

    /**
     * 
     * @param professor
     * @return
     *     returns java.util.List<ELearning.services.client.relatorios.EnrollmentCountReport>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getEnrollmentCount", targetNamespace = "http://services.ELearning/", className = "ELearning.services.client.relatorios.GetEnrollmentCount")
    @ResponseWrapper(localName = "getEnrollmentCountResponse", targetNamespace = "http://services.ELearning/", className = "ELearning.services.client.relatorios.GetEnrollmentCountResponse")
    @Action(input = "http://services.ELearning/ReportService/getEnrollmentCountRequest", output = "http://services.ELearning/ReportService/getEnrollmentCountResponse")
    public List<EnrollmentCountReport> getEnrollmentCount(
        @WebParam(name = "professor", targetNamespace = "")
        Professor professor);

    /**
     * 
     * @param professor
     * @return
     *     returns java.util.List<ELearning.services.client.relatorios.EnrollmentCriteriaReport>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getEnrollmentCriteria", targetNamespace = "http://services.ELearning/", className = "ELearning.services.client.relatorios.GetEnrollmentCriteria")
    @ResponseWrapper(localName = "getEnrollmentCriteriaResponse", targetNamespace = "http://services.ELearning/", className = "ELearning.services.client.relatorios.GetEnrollmentCriteriaResponse")
    @Action(input = "http://services.ELearning/ReportService/getEnrollmentCriteriaRequest", output = "http://services.ELearning/ReportService/getEnrollmentCriteriaResponse")
    public List<EnrollmentCriteriaReport> getEnrollmentCriteria(
        @WebParam(name = "professor", targetNamespace = "")
        Professor professor);

    /**
     * 
     * @return
     *     returns java.util.List<ELearning.services.client.relatorios.StudentEnrollmentModel>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllDisciplines", targetNamespace = "http://services.ELearning/", className = "ELearning.services.client.relatorios.GetAllDisciplines")
    @ResponseWrapper(localName = "getAllDisciplinesResponse", targetNamespace = "http://services.ELearning/", className = "ELearning.services.client.relatorios.GetAllDisciplinesResponse")
    @Action(input = "http://services.ELearning/ReportService/getAllDisciplinesRequest", output = "http://services.ELearning/ReportService/getAllDisciplinesResponse")
    public List<StudentEnrollmentModel> getAllDisciplines();

}
