package app

import app.config.AppConfig
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableConfigurationProperties(AppConfig::class)
@EnableFeignClients
open class GradeApplication

fun main(args: Array<String>) {
    SpringApplication.run(GradeApplication::class.java, *args)
}

