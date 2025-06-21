package app.service

import app.dto.StudentDTO
import app.entity.Student

interface StudentService {

    fun addStudent(studentDTO: StudentDTO): Student

    fun getStudentById(id: Long): Student

    fun updateStudent(id: Long, studentDTO: StudentDTO): Student

    fun deleteStudent(id: Long)
}