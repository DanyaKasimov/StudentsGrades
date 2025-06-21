package app.controller

import app.api.GroupAPI
import app.dto.GroupListDTO
import app.entity.Group
import app.service.GroupService
import org.springframework.web.bind.annotation.RestController

@RestController
class GroupController(private val groupService: GroupService) : GroupAPI {

    override fun getGroupByName(name: String): Group = groupService.findByName(name)

    override fun createGroup(name: String): Group = groupService.createGroup(name)

    override fun deleteGroupByName(name: String) = groupService.deleteGroup(name)

    override fun updateGroupByName(name: String): Group = groupService.updateGroup(name)

    override fun getGroupsByPrefix(prefix: String): GroupListDTO = groupService.findAllGroupsByPrefix(prefix);
}