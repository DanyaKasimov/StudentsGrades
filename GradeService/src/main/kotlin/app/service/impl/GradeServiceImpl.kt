package app.service.impl

import app.clients.StudentClient
import app.constants.Message
import app.dto.GradeListDTO
import app.dto.StudentDTO
import app.entity.Grade
import app.entity.Subject
import app.exceptions.NotFoundDataException
import app.repository.GradeRepository
import app.service.GradeService
import app.service.NotificationService
import app.service.SubjectService
import org.springframework.stereotype.Service

@Service
class GradeServiceImpl(private val subjectService: SubjectService,
                       private val studentClient: StudentClient,
                       private val notificationService: NotificationService,
                       private val gradeRepository: GradeRepository) : GradeService {

    override fun addGrade(studentId: Long, mark: String, subjectName: String): Grade {
        val subject: Subject = subjectService.getSubjectByName(subjectName)
        val grade = Grade(null, studentId, mark, subject)

        val student: StudentDTO = studentClient.getStudentById(studentId)
        notificationService.sendEmail(student.email,
            Message.addMark(student.name, student.surname, mark, subjectName))

        return gradeRepository.save(grade)
    }

    override fun getGrades(studentId: Long): GradeListDTO {
        val grades: List<Grade> = gradeRepository.findAllByStudentId(studentId)
        return GradeListDTO(grades.size, grades)
    }

    override fun findById(id: Long): Grade = gradeRepository.findById(id).orElseThrow {
        throw NotFoundDataException("Grade не найден")
    }

    override fun getGradesBySubject(studentId: Long, subjectName: String): GradeListDTO {
        val subject = subjectService.getSubjectByName(subjectName)
        val grades = gradeRepository.findAllByStudentIdAndSubject(studentId, subject)
        return GradeListDTO(grades.size, grades)
    }

    override fun updateGrade(id: Long, mark: String): Grade {
        val grade: Grade = findById(id)

        val student: StudentDTO = studentClient.getStudentById(grade.studentId)
        notificationService.sendEmail(student.email,
            Message.updateMark(student.name, student.surname, grade.mark, grade.subject.name, mark))

        grade.mark = mark
        return gradeRepository.save(grade)
    }

    override fun deleteGrade(id: Long) {
        val grade: Grade = findById(id)

        val student: StudentDTO = studentClient.getStudentById(grade.studentId)
        notificationService.sendEmail(student.email,
            Message.deleteMark(student.name, student.surname))

        gradeRepository.delete(grade)
    }
}