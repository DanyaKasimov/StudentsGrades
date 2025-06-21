package app.service

import app.dto.GradeListDTO
import app.entity.Grade


interface GradeService {

    fun addGrade(studentId: Long, mark: String, subjectName: String): Grade

    fun getGrades(studentId: Long): GradeListDTO

    fun getGradesBySubject(studentId: Long, subjectName: String): GradeListDTO

    fun updateGrade(id: Long, mark: String): Grade

    fun deleteGrade(id: Long)

    fun findById(id: Long): Grade
}