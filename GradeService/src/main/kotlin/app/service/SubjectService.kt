package app.service

import app.dto.SubjectsListDTO
import app.entity.Subject

interface SubjectService {

    fun addSubject(name: String): Subject

    fun getSubjectByName(name: String): Subject

    fun getSubjectById(id: Long): Subject

    fun deleteSubject(name: String)

    fun updateSubject(id: Long, name: String)

    fun getAllSubjects(): SubjectsListDTO
}