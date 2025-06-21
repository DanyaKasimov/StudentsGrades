package app.repository

import app.entity.Group
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GroupRepository : JpaRepository<Group, Long> {

    fun findByName(name: String): Group?

    fun existsGroupByName(name: String): Boolean

    fun findAllByNameStartingWith(prefix: String): List<Group>
}