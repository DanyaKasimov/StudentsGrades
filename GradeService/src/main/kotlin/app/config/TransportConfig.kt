package app.config

import app.constants.TransportEnum
import app.service.notification.NotificationDelegatorService
import app.service.notification.NotificationHTTPService
import app.service.notification.NotificationKAFKAService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
open class TransportConfig(private val appConfig: AppConfig) {

    @Bean
    @Primary
    open fun notificationService(httpService: NotificationHTTPService,
                                 kafkaService: NotificationKAFKAService): NotificationDelegatorService {
        return when (appConfig.transport.type) {
            "HTTP" -> NotificationDelegatorService(httpService, kafkaService)
            "KAFKA" -> NotificationDelegatorService(kafkaService, httpService)
            else -> { throw RuntimeException("") }
        }
    }
}