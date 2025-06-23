package app.logger

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class ControllerLoggingAspect {

    private val logger = LoggerFactory.getLogger(ControllerLoggingAspect::class.java)

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    fun restController() {}

    @Before("restController()")
    fun logBefore(joinPoint: JoinPoint) {
        val signature = joinPoint.signature as MethodSignature
        val methodName = signature.method.name
        val className = joinPoint.target.javaClass.simpleName
        val args = joinPoint.args

        logger.info("Запрос в контроллер: {}.{}()", className, methodName)
        logger.info("Аргументы: {}", args.contentToString())
    }
}