package app.clients

import app.dto.StudentDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Component
@FeignClient("student-service", url = "\${app.student-service.url}/students")
interface StudentClient {

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable("id") id: Long): StudentDTO
}