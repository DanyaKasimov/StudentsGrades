package app.repository

import app.entity.Subject
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SubjectRepository : JpaRepository<Subject, Long> {

    fun existByName(name: String): Boolean

    fun findByName(email: String): Subject?
}