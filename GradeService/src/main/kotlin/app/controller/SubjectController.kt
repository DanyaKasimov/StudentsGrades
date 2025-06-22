package app.controller

import app.api.SubjectAPI
import app.dto.SubjectsListDTO
import app.entity.Subject
import app.service.SubjectService
import org.springframework.web.bind.annotation.RestController

@RestController
class SubjectController(private val subjectService: SubjectService) : SubjectAPI {

    override fun addSubject(name: String): Subject = subjectService.addSubject(name)

    override fun getSubjectByName(name: String): Subject = subjectService.getSubjectByName(name)

    override fun getSubjectById(id: Long): Subject = subjectService.getSubjectById(id)

    override fun deleteSubject(name: String) = subjectService.deleteSubject(name)

    override fun updateSubject(id: Long, name: String) = subjectService.updateSubject(id, name)

    override fun getAllSubjects(): SubjectsListDTO = subjectService.getAllSubjects()

}