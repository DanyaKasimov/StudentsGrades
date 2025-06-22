package app.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Ответ ошибки API")
data class ApiErrorResponse(

    @Schema(description = "Описание ошибки")
    val description: String? = null,

    @Schema(description = "HTTP статус ошибки", example = "Not found")
    val code: String? = null,

    @Schema(description = "Название исключения", example = "NotFoundDataException")
    val exceptionName: String? = null,

    @Schema(description = "Сообщение об ошибке")
    val exceptionMessage: String? = null
)