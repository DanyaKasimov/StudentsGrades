package app.api

import app.dto.ApiErrorResponse
import app.dto.GroupListDTO
import app.entity.Group
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@Tag(name = "Groups", description = "API для управления группами")
@RequestMapping("/groups")
interface GroupAPI {

    @Operation(
        summary = "Получить группу по имени",
        description = "Возвращает группу по её имени"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Группа найдена",
                content = [Content(schema = Schema(implementation = Group::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Группа не найдена",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @GetMapping("/{name}")
    fun getGroupByName(@Parameter(description = "Имя группы", example = "11-205")
                       @PathVariable("name") name: String): Group

    @Operation(
        summary = "Создать группу",
        description = "Создает новую группу по имени"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Группа успешно создана",
                content = [Content(schema = Schema(implementation = Group::class))]
            ),
            ApiResponse(
                responseCode = "409",
                description = "Группа уже существует",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @PostMapping("/{name}")
    fun createGroup(@Parameter(description = "Имя новой группы", example = "11-205")
                    @PathVariable("name") @Valid name: String): Group

    @Operation(
        summary = "Удалить группу по имени",
        description = "Удаляет группу по её имени"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Группа успешно удалена"
            ),
            ApiResponse(
                responseCode = "404",
                description = "Группа не найдена",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @DeleteMapping("/{name}")
    fun deleteGroupByName(@Parameter(description = "Имя группы", example = "11-205")
                          @PathVariable("name") name: String)

    @Operation(
        summary = "Обновить группу по имени",
        description = "Обновляет данные группы по имени"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Группа обновлена",
                content = [Content(schema = Schema(implementation = Group::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Группа не найдена",
                content = [Content(schema = Schema(implementation = ApiErrorResponse::class))]
            )
        ]
    )
    @PutMapping("/{name}")
    fun updateGroupByName(@Parameter(description = "Имя группы", example = "11-205")
                          @PathVariable("name") name: String): Group

    @Operation(
        summary = "Получить список групп по префиксу",
        description = "Возвращает список групп, имена которых начинаются с заданного префикса"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Список групп по префиксу",
                content = [Content(schema = Schema(implementation = GroupListDTO::class))]
            )
        ]
    )
    @GetMapping("/list/{prefix}")
    fun getGroupsByPrefix(@Parameter(description = "Префикс имени группы", example = "11")
                          @PathVariable("prefix") prefix: String): GroupListDTO
}