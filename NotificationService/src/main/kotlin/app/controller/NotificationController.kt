package app.controller

import app.api.NotificationAPI
import app.dto.EmailDTO
import app.service.NotificationService
import org.springframework.web.bind.annotation.RestController

@RestController
class NotificationController(private val notificationService: NotificationService) : NotificationAPI {

    override fun sendEmail(emailDTO: EmailDTO) = notificationService.sendEmail(emailDTO)

}