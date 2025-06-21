package app.api


import app.dto.StudentDTO
import app.entity.Student
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.web.bind.annotation.*

@RequestMapping("/students")
@Schema(name = "Управление студентами", description = "API для управления студентами")
interface StudentAPI {

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable("id") id: Long): Student

    @DeleteMapping("/{id}")
    fun deleteStudentById(@PathVariable("id") id: Long)

    @PostMapping
    fun addStudent(studentDTO: StudentDTO): Student

    @PutMapping("/{id}")
    fun updateStudent(@PathVariable("id") id: Long, studentDTO: StudentDTO): Student
}