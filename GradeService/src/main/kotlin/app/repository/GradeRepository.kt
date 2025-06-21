package app.repository

import app.entity.Grade
import app.entity.Subject
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GradeRepository : JpaRepository<Grade, Long> {

    fun findAllByStudentId(studentId: Long): List<Grade>

    fun findAllByStudentIdAndSubject(studentId: Long, subject: Subject): List<Grade>
}