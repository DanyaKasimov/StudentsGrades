package app.service

import app.dto.StudentDTO
import app.dto.StudentResponseDTO
import app.entity.Student

interface StudentService {

    fun addStudent(studentDTO: StudentDTO): StudentResponseDTO

    fun getStudentById(id: Long): StudentResponseDTO

    fun updateStudent(id: Long, studentDTO: StudentDTO): StudentResponseDTO

    fun deleteStudent(id: Long)
}