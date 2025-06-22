package app.service.notification

import app.clients.NotificationClient
import app.dto.EmailDTO
import app.service.NotificationService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class NotificationHTTPService(private val notificationClient: NotificationClient) : NotificationService {

    private val log = LoggerFactory.getLogger(NotificationHTTPService::class.java)

    override fun sendEmail(address: String, content: String) {
        log.info("Отправка запроса по HTTP")

        val emailDTO = EmailDTO(address, content)

        notificationClient.sendEmail(emailDTO)
    }
}