package app.api

import app.dto.ApiErrorResponse
import app.dto.GradeListDTO
import app.entity.Grade
import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid

@Tag(name = "Grades", description = "Управление оценками студентов")
@RequestMapping("/grades")
interface GradeAPI {

    @Operation(
        summary = "Добавить оценку студенту",
        description = "Добавляет новую оценку для студента по предмету"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Оценка успешно добавлена",
                content = [Content(schema = Schema(implementation = Grade::class))]
            ),
            ApiResponse(
                responseCode = "400",
                description = "Ошибка в запросе",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Студент или предмет не найден",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @PostMapping("/add/{studentId}/{subject}/{mark}")
    fun addGrade(@Parameter(description = "ID студента", example = "123")
                 @PathVariable @Valid studentId: Long,
                 @Parameter(description = "Оценка", example = "5")
                 @PathVariable @Valid mark: String,
                 @Parameter(description = "Название предмета", example = "Информатика")
                 @PathVariable @Valid subject: String): Grade


    @Operation(
        summary = "Получить список оценок студента",
        description = "Возвращает все оценки студента"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Список оценок студента",
                content = [Content(schema = Schema(implementation = GradeListDTO::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Студент не найден",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @GetMapping("/list/{studentId}")
    fun getGrades(@Parameter(description = "ID студента", example = "123")
                  @PathVariable @Valid studentId: Long): GradeListDTO

    @Operation(
        summary = "Получить оценки по предмету",
        description = "Возвращает оценки студента по указанному предмету"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Список оценок по предмету",
                content = [Content(schema = Schema(implementation = GradeListDTO::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Студент или предмет не найден",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @GetMapping("/list/{studentId}/{subject}")
    fun getGradesBySubject(@Parameter(description = "ID студента", example = "123")
                           @PathVariable @Valid studentId: Long,
                           @Parameter(description = "Название предмета", example = "Mathematics")
                           @PathVariable @Valid subject: String): GradeListDTO

    @Operation(
        summary = "Обновить оценку",
        description = "Обновляет оценку по идентификатору"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Оценка успешно обновлена",
                content = [Content(schema = Schema(implementation = Grade::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Оценка не найдена",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @PutMapping("/update/{id}/{mark}")
    fun updateGrade(@Parameter(description = "ID оценки", example = "555")
                    @PathVariable @Valid id: Long,
                    @Parameter(description = "Новая оценка", example = "B")
                    @PathVariable @Valid mark: String): Grade

    @Operation(
        summary = "Удалить оценку",
        description = "Удаляет оценку по идентификатору"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Оценка успешно удалена"
            ),
            ApiResponse(
                responseCode = "404",
                description = "Оценка не найдена",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @DeleteMapping("/{id}")
    fun deleteGrade(@Parameter(description = "ID оценки", example = "555")
                    @PathVariable @Valid id: Long
    )

    @Operation(
        summary = "Получить оценку по ID",
        description = "Возвращает оценку по её идентификатору"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Оценка найдена",
                content = [Content(schema = Schema(implementation = Grade::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Оценка не найдена",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @GetMapping("/{id}")
    fun findById(@Parameter(description = "ID оценки", example = "555") @PathVariable @Valid id: Long): Grade
}