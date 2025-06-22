package app.clients

import app.dto.EmailDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Component
@FeignClient("notification-service", url = "\${app.notification-service.url}/notification")
interface NotificationClient {

    @PostMapping("/email")
    fun sendEmail(@RequestBody emailDTO: EmailDTO)
}