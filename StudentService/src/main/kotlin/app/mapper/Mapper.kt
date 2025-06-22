package app.mapper


import app.dto.GroupResponseDTO
import app.dto.StudentDTO
import app.dto.StudentResponseDTO
import app.entity.Group
import app.entity.Student

fun StudentDTO.toEntity(group: Group): Student = Student(
    name = this.name,
    surname = this.surname,
    middle = this.middle,
    email = this.email,
    birthDate = this.birthDate,
    group = group
)

fun Student.updateFromDTO(dto: StudentDTO, group: Group): Student {
    return this.copy(
        name = dto.name,
        surname = dto.surname,
        middle = dto.middle,
        email = dto.email,
        birthDate = dto.birthDate,
        group = group
    )
}

fun Student.toDTO(): StudentResponseDTO {
    return StudentResponseDTO(
        id = this.id ?: 0L,
        name = this.name,
        surname = this.surname,
        middle = this.middle,
        email = this.email,
        birthDate = this.birthDate ?: throw IllegalStateException("birthDate is null"),
        group = this.group.toDTO()
    )
}

fun Group.toDTO(): GroupResponseDTO {
    return GroupResponseDTO(
        id = this.id ?: 0L,
        name = this.name
    )
}