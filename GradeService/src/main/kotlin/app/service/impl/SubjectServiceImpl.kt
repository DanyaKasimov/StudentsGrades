package app.service.impl

import app.dto.SubjectsListDTO
import app.entity.Subject
import app.repository.SubjectRepository
import app.service.SubjectService
import org.springframework.stereotype.Service

@Service
class SubjectServiceImpl(private val subjectRepository: SubjectRepository) : SubjectService {

    override fun addSubject(name: String): Subject {
        require(subjectRepository.existByName(name)) {
            "Такой предмет уже существует"
        }

        val subject = Subject(name = name)
        return subjectRepository.save(subject)
    }

    override fun getSubjectByName(name: String): Subject = subjectRepository.findByName(name) ?:
        throw RuntimeException("Предмет [$name] не найден")

    override fun getSubjectById(id: Long): Subject = subjectRepository.findById(id).orElseThrow {
        throw RuntimeException("Предмет c id = $id не найден") }

    override fun deleteSubject(name: String) {
        val subject = getSubjectByName(name)
        subjectRepository.delete(subject)
    }

    override fun updateSubject(id: Long, name: String) {
        val subject = getSubjectById(id)
        subject.name = name
        subjectRepository.save(subject)
    }

    override fun getAllSubjects(): SubjectsListDTO {
        val subjects: List<Subject> = subjectRepository.findAll()
        return SubjectsListDTO(subjects.size, subjects);
    }
}