package app.service

import app.dto.GroupListDTO
import app.dto.GroupStudentDTO
import app.entity.Group

interface GroupService {

    fun findByName(name: String): Group

    fun findById(id: Long): Group

    fun createGroup(name: String): Group

    fun updateGroup(name: String): Group

    fun deleteGroup(name: String)

    fun getAllStudents(name: String): GroupStudentDTO

    fun findAllGroupsByPrefix(prefix: String): GroupListDTO
}