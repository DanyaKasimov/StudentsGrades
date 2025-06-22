package app.service.notification

import app.config.AppConfig
import app.dto.EmailDTO
import app.service.NotificationService
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class NotificationKAFKAService(private val kafkaTemplateString: KafkaTemplate<String, String>,
                               private val objectMapper: ObjectMapper,
                               private val appConfig: AppConfig) : NotificationService {

    private val log = LoggerFactory.getLogger(NotificationKAFKAService::class.java)

    override fun sendEmail(address: String, content: String) {
        log.info("Отправка запроса по KAFKA")

        val emailDTO = EmailDTO(address, content)
        val emailBody = objectMapper.writeValueAsString(emailDTO)

        kafkaTemplateString.send(appConfig.kafka.topics.email, emailBody)
    }
}