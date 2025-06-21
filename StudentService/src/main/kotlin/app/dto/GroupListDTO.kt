package app.dto

import app.entity.Group

data class GroupListDTO(val size: Int, val groups: List<Group>) {
}