package app.service.impl

import app.dto.GradeListDTO
import app.entity.Grade
import app.entity.Subject
import app.repository.GradeRepository
import app.service.GradeService
import app.service.SubjectService
import org.springframework.stereotype.Service

@Service
class GradeServiceImpl(private val subjectService: SubjectService,
                       private val gradeRepository: GradeRepository) : GradeService {

    override fun addGrade(studentId: Long, mark: String, subjectName: String): Grade {
        val subject: Subject = subjectService.getSubjectByName(subjectName)
        val grade = Grade(null, studentId, mark, subject)
        return gradeRepository.save(grade)
    }

    override fun getGrades(studentId: Long): GradeListDTO {
        val grades: List<Grade> = gradeRepository.findAllByStudentId(studentId)
        return GradeListDTO(grades.size, grades)
    }

    override fun findById(id: Long): Grade = gradeRepository.findById(id).orElseThrow {
        throw RuntimeException("Grade not found")
    }

    override fun getGradesBySubject(studentId: Long, subjectName: String): GradeListDTO {
        val subject = subjectService.getSubjectByName(subjectName)
        val grades = gradeRepository.findAllByStudentIdAndSubject(studentId, subject)
        return GradeListDTO(grades.size, grades)
    }

    override fun updateGrade(id: Long, mark: String): Grade {
        val grade: Grade = findById(id)
        grade.mark = mark
        return gradeRepository.save(grade)
    }

    override fun deleteGrade(id: Long) {
        val grade: Grade = findById(id)
        gradeRepository.delete(grade)
    }
}