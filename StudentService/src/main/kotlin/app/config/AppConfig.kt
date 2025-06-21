package app.config

import app.constants.TransportEnum
import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated

@Validated
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
data class AppConfig(
    @Valid val kafka: KafkaProperties,
    @Valid val transport: TransportProperties,
    @Valid val notificationService: NotificationServiceProperties,
) {

    data class KafkaProperties(@NotEmpty val bootstrapServers: String,
                               @Valid val topics: Topics
    ) {}

    data class Topics(@NotEmpty val email: String)

    data class TransportProperties(@NotEmpty val type: TransportEnum)

    data class NotificationServiceProperties(@NotEmpty val url: String)
}