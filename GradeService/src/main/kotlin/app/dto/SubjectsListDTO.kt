package app.dto

import app.entity.Subject

data class SubjectsListDTO(val size: Int, val subjects: List<Subject>) {
}