/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.dao.interfaces;

import ELearning.model.Aluno;
import ELearning.model.Disciplina;
import ELearning.model.Professor;
import ELearning.model.report.DisciplineGradeReport;
import ELearning.model.report.EnrollmentCountReport;
import ELearning.model.report.EnrollmentCriteriaReport;
import ELearning.model.report.StudentDisciplineGradeReport;
import ELearning.model.report.StudentListReport;
import ELearning.model.special.StudentEnrollmentModel;
import java.util.List;

/**
 *
 * @author Acessa SP
 */
public interface ReportDAO {

    public List<Professor> getAllProfessors();

    public List<Aluno> getAllStudents();

    public List<DisciplineGradeReport> getDisciplineGrade(Professor professor);

    public List<StudentDisciplineGradeReport> getStudentDisciplineGrade(Aluno student);

    public List<StudentListReport> getStudentList(Professor professor);

    public List<EnrollmentCriteriaReport> getEnrollmentCriteria(Professor professor);

    public List<EnrollmentCountReport> getEnrollmentCount(Professor professor);

    public List<StudentEnrollmentModel> getAllDisciplines();
    
}
