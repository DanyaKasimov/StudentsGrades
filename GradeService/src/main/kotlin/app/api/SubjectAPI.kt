package app.api

import app.dto.ApiErrorResponse
import app.dto.SubjectsListDTO
import app.entity.Subject
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@Tag(name = "Subjects", description = "Управление предметами")
@RequestMapping("/subjects")
interface SubjectAPI {

    @Operation(
        summary = "Добавить предмет",
        description = "Добавляет новый предмет по имени"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Предмет успешно добавлен",
                content = [Content(schema = Schema(implementation = Subject::class))]
            ),
            ApiResponse(
                responseCode = "400",
                description = "Некорректный запрос",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            ),
            ApiResponse(
                responseCode = "409",
                description = "Такой предмет уже существует",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @PostMapping("/add/{name}")
    fun addSubject(@Parameter(description = "Название предмета", example = "Mathematics")
                   @PathVariable @Valid name: String): Subject

    @Operation(
        summary = "Получить предмет по имени",
        description = "Возвращает предмет по его имени"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Предмет найден",
                content = [Content(schema = Schema(implementation = Subject::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Предмет не найден",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @GetMapping("/name/{name}")
    fun getSubjectByName(@Parameter(description = "Название предмета", example = "Mathematics")
                         @PathVariable @Valid name: String): Subject

    @Operation(
        summary = "Получить предмет по ID",
        description = "Возвращает предмет по его идентификатору"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Предмет найден",
                content = [Content(schema = Schema(implementation = Subject::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Предмет не найден",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @GetMapping("/id/{id}")
    fun getSubjectById(@Parameter(description = "ID предмета", example = "1")
                       @PathVariable @Valid id: Long): Subject

    @Operation(
        summary = "Удалить предмет",
        description = "Удаляет предмет по имени"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Предмет успешно удален"
            ),
            ApiResponse(
                responseCode = "404",
                description = "Предмет не найден",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @DeleteMapping("/{name}")
    fun deleteSubject(@Parameter(description = "Название предмета", example = "Mathematics")
                      @PathVariable @Valid name: String)

    @Operation(
        summary = "Обновить предмет",
        description = "Обновляет имя предмета по его идентификатору"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Имя предмета успешно обновлено"
            ),
            ApiResponse(
                responseCode = "404",
                description = "Предмет не найден",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @PutMapping("/{id}/{name}")
    fun updateSubject(@Parameter(description = "ID предмета", example = "1")
                      @PathVariable @Valid id: Long,
                      @Parameter(description = "Новое имя предмета", example = "Physics")
                      @PathVariable @Valid name: String
    )

    @Operation(
        summary = "Получить все предметы",
        description = "Возвращает список всех предметов"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Список всех предметов",
                content = [Content(schema = Schema(implementation = SubjectsListDTO::class))]
            )
        ]
    )
    @GetMapping("/list")
    fun getAllSubjects(): SubjectsListDTO
}