package app.service.impl

import app.dto.GroupListDTO
import app.dto.GroupStudentDTO
import app.entity.Group
import app.entity.Student
import app.exceptions.InvalidDataException
import app.exceptions.NotFoundDataException
import app.repository.GroupRepository
import app.service.GroupService
import org.springframework.stereotype.Service

@Service
class GroupServiceImpl(private val groupRepository: GroupRepository) : GroupService {

    override fun findByName(name: String): Group = groupRepository.findByName(name)
        ?: throw NotFoundDataException("Группа c названием = $name не найдена.");

    override fun findById(id: Long): Group = groupRepository.findById(id)
        .orElseThrow { NotFoundDataException("Группа c id = $id не найдена.") }

    override fun createGroup(name: String): Group {
        if (groupRepository.existsGroupByName(name)) {
            throw InvalidDataException("Группа с названием = $name уже существует.")
        }

        val group = Group(name = name)
        return groupRepository.save(group)
    }

    override fun updateGroup(name: String): Group {
        val group = findByName(name)
        group.name = name
        return groupRepository.save(group)
    }

    override fun deleteGroup(name: String) {
        val group = findByName(name)
        groupRepository.delete(group)
    }

    override fun getAllStudents(name: String): GroupStudentDTO {
        val group: Group = findByName(name)
        val students: List<Student> = group.students
        return GroupStudentDTO(students.size, students);
    }

    override fun findAllGroupsByPrefix(prefix: String): GroupListDTO {
        val groups: List<Group> = groupRepository.findAllByNameStartingWith(prefix)
        return GroupListDTO(groups.size, groups)
    }
}