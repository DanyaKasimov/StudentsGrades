package app.dto

import java.time.LocalDate

data class StudentDTO (
    val id: Long,

    val name: String,

    val surname: String,

    val middle: String,

    val email: String,

    val birthDate: LocalDate,

    var group: GroupDTO,
) {}