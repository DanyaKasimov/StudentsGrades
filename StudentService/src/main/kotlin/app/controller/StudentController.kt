package app.controller;

import app.api.StudentAPI
import app.dto.StudentDTO
import app.dto.StudentResponseDTO
import app.entity.Student
import app.service.StudentService
import org.springframework.web.bind.annotation.RestController

@RestController
open class StudentController(private val studentService: StudentService) : StudentAPI {

    override fun getStudentById(id: Long): StudentResponseDTO = studentService.getStudentById(id)

    override fun deleteStudentById(id: Long) = studentService.deleteStudent(id)

    override fun addStudent(studentDTO: StudentDTO): StudentResponseDTO = studentService.addStudent(studentDTO)

    override fun updateStudent(id: Long, studentDTO: StudentDTO): StudentResponseDTO = studentService.updateStudent(id, studentDTO)
}
