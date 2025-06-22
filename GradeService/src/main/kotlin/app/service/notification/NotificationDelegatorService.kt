package app.service.notification

import app.service.NotificationService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class NotificationDelegatorService(private val primary: NotificationService,
                                   private val secondary: NotificationService) : NotificationService {

    private val log = LoggerFactory.getLogger(NotificationDelegatorService::class.java)

    override fun sendEmail(address: String, content: String) {
        try {
            log.info("Отправка уведомления через primary транспорт")
            primary.sendEmail(address, content)
        } catch (e: Exception) {
            log.error(e.message)
            try {
                log.info("Отправить запрос через primary транспорт не удалось, попытка отправить через secondary")
                secondary.sendEmail(address, content)
            } catch (ex: Exception) {
                throw RuntimeException(
                    "Не удалось отправить уведомление ни через один транспорт. Message: ${ex.message}"
                )
            }
        }
    }
}