package app.controller

import app.api.GradeAPI
import app.dto.GradeListDTO
import app.entity.Grade
import app.service.GradeService
import org.springframework.web.bind.annotation.RestController

@RestController
open class GradeController(private val gradeService: GradeService) : GradeAPI {

    override fun addGrade(studentId: Long,
                          mark: String,
                          subject: String): Grade = gradeService.addGrade(studentId, mark, subject)

    override fun getGrades(studentId: Long): GradeListDTO = gradeService.getGrades(studentId)

    override fun getGradesBySubject(studentId: Long,
                                    subject: String): GradeListDTO = gradeService.getGradesBySubject(studentId, subject)

    override fun updateGrade(id: Long,
                             mark: String): Grade = gradeService.updateGrade(id, mark)

    override fun deleteGrade(id: Long) = gradeService.deleteGrade(id)

    override fun findById(id: Long): Grade = gradeService.findById(id)
}