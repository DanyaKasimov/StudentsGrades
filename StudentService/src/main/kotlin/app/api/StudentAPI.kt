package app.api

import app.dto.ApiErrorResponse
import app.dto.StudentDTO
import app.dto.StudentResponseDTO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.parameters.RequestBody as SwaggerRequestBody
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "Students", description = "API для управления студентами")
@RequestMapping("/students")
interface StudentAPI {

    @Operation(
        summary = "Получить студента по ID",
        description = "Возвращает данные студента по идентификатору"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Студент найден",
                content = [Content(schema = Schema(implementation = StudentResponseDTO::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Студент не найден",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @GetMapping("/{id}")
    fun getStudentById(@Parameter(description = "ID студента", example = "101")
                       @PathVariable("id") id: Long): StudentResponseDTO

    @Operation(
        summary = "Удалить студента по ID",
        description = "Удаляет студента по его идентификатору"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Студент успешно удален"
            ),
            ApiResponse(
                responseCode = "404",
                description = "Студент не найден",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @DeleteMapping("/{id}")
    fun deleteStudentById(@Parameter(description = "ID студента", example = "101")
                          @PathVariable("id") id: Long)

    @Operation(
        summary = "Добавить студента",
        description = "Добавляет нового студента"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Студент успешно добавлен",
                content = [Content(schema = Schema(implementation = StudentResponseDTO::class))]
            ),
            ApiResponse(
                responseCode = "400",
                description = "Ошибка валидации данных",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @PostMapping
    fun addStudent(
        @SwaggerRequestBody(
            description = "Данные нового студента",
            required = true,
            content = [Content(schema = Schema(implementation = StudentDTO::class))]
        )
        @RequestBody studentDTO: StudentDTO
    ): StudentResponseDTO


    @Operation(
        summary = "Обновить студента по ID",
        description = "Обновляет данные студента по идентификатору"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Данные студента обновлены",
                content = [Content(schema = Schema(implementation = StudentResponseDTO::class))]
            ),
            ApiResponse(
                responseCode = "400",
                description = "Ошибка валидации данных",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Студент не найден",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @PutMapping("/{id}")
    fun updateStudent(@Parameter(description = "ID студента", example = "101")
                      @PathVariable("id") id: Long,
                      @SwaggerRequestBody(
                            description = "Новые данные студента",
                            required = true,
                            content = [Content(schema = Schema(implementation = StudentDTO::class))]
                        )
                      @RequestBody studentDTO: StudentDTO): StudentResponseDTO
}