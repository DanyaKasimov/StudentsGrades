package app.controller;

import app.api.StudentAPI
import app.dto.StudentDTO
import app.entity.Student
import app.service.StudentService
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentController(private val studentService: StudentService) : StudentAPI {

    override fun getStudentById(id: Long): Student = studentService.getStudentById(id)

    override fun deleteStudentById(id: Long) = studentService.deleteStudent(id)

    override fun addStudent(studentDTO: StudentDTO): Student = studentService.addStudent(studentDTO)

    override fun updateStudent(id: Long, studentDTO: StudentDTO): Student = studentService.updateStudent(id, studentDTO)
}
