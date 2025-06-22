package app.dto

import java.time.LocalDate

data class StudentResponseDTO(val id: Long,
                              var name: String,
                              var surname: String,
                              var middle: String? = null,
                              var email: String,
                              var birthDate: LocalDate,
                              var group: GroupResponseDTO
){}