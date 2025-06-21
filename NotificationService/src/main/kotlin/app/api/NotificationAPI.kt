package app.api

import app.dto.EmailDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/notification")
interface NotificationAPI {

    @PostMapping("/email")
    fun sendEmail(emailDTO: EmailDTO)
}