package app.dto

import app.entity.Grade
import app.entity.Subject

data class GradeListDTO(val size: Int, val grades: List<Grade>) {
}