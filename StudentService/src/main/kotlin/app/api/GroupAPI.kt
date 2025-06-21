package app.api

import app.dto.GroupListDTO
import app.entity.Group
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.web.bind.annotation.*

@RequestMapping("/groups")
@Schema(name = "Управление группами", description = "API для управления группами")
interface GroupAPI {

    @GetMapping("/{name}")
    fun getGroupByName(@PathVariable("name")  name: String): Group

    @PostMapping("/{name}")
    fun createGroup(@PathVariable("name") name: String): Group

    @DeleteMapping("/{name}")
    fun deleteGroupByName(@PathVariable("name") name: String)

    @PutMapping("/{name}")
    fun updateGroupByName(@PathVariable("name") name: String): Group

    @GetMapping("/list/{prefix}")
    fun getGroupsByPrefix(@PathVariable("prefix") prefix: String): GroupListDTO

}