package app.service.impl

import app.constants.Message
import app.dto.StudentDTO
import app.dto.StudentResponseDTO
import app.entity.Group
import app.entity.Student
import app.exceptions.NotFoundDataException
import app.mapper.toDTO
import app.mapper.toEntity
import app.mapper.updateFromDTO
import app.repository.StudentRepository
import app.service.GroupService
import app.service.NotificationService
import app.service.StudentService
import org.apache.catalina.mapper.Mapper
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl(private val studentRepository: StudentRepository,
                         private val groupService: GroupService,
                         private val notificationService: NotificationService) : StudentService {

    override fun addStudent(studentDTO: StudentDTO): StudentResponseDTO {
        require(!studentRepository.existsByEmail(studentDTO.email)) {
            "Email уже зарегистрирован"
        }

        val group: Group = groupService.findByName(studentDTO.group)
        val student: Student = studentDTO.toEntity(group)

        notificationService.sendEmail(
            studentDTO.email,
            Message.createStudent(studentDTO.name, studentDTO.surname, group.name))

        return studentRepository.save(student).toDTO()
    }

    override fun getStudentById(id: Long): StudentResponseDTO {
        return findEntityById(id).toDTO()
    }

    override fun updateStudent(id: Long, studentDTO: StudentDTO): StudentResponseDTO {
        val student: Student = findEntityById(id)
        val group: Group = groupService.findByName(studentDTO.group)
        val updatedStudent: Student = student.updateFromDTO(studentDTO, group)

        notificationService.sendEmail(
            studentDTO.email,
            Message.updateStudent(studentDTO))

        return studentRepository.save(updatedStudent).toDTO()
    }

    override fun deleteStudent(id: Long) {
        val student: Student = findEntityById(id)

        notificationService.sendEmail(
            student.email,
            Message.deleteStudent(student.name, student.surname))

        studentRepository.delete(student)
    }

    private fun findEntityById(id: Long): Student = studentRepository.findById(id)
        .orElseThrow { NotFoundDataException("Студент не найден.") }
}