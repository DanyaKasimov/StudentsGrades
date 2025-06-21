package app.dto

import app.entity.Student

data class GroupStudentDTO(val size: Int, val students: List<Student>) {
}