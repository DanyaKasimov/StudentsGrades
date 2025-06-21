package app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import java.time.LocalDate;

data class StudentDTO (
    @field:NotBlank(message = "Поле [name] обязательно")
    @field:Length(min = 1, max = 255, message = "Имя должно иметь длину от 1 до 255 символов")
    val name: String = "",

    @field:NotBlank(message = "Поле [surname] обязательно")
    @field:Length(min = 1, max = 255, message = "Фамилия должна иметь длину от 1 до 255 символов")
    val surname: String = "",

    @field:Length(min = 1, max = 255, message = "Отчество должно иметь длину от 1 до 255 символов")
    val middle: String? = null,

    @field:Email(message = "Невалидный email")
    @field:Length(min = 3, max = 255, message = "Email должен иметь длину от 3 до 255 символов")
    @field:NotBlank(message = "Поле [surname] обязательно")
    val email: String = "",

    @field:NotEmpty(message = "Поле [birthDate] обязательно")
    val birthDate: LocalDate = LocalDate.now(),

    @field:NotBlank(message = "Поле [group] обязательно")
    @field:Length(min = 6, max = 6, message = "Длина названия группы должна быть 6 символов")
    val group: String = ""
) {

    override fun toString(): String {
        return """
        Студент:
          Имя: $name
          Фамилия: $surname
          Отчество: ${middle ?: "-"}
          Email: $email
          Дата рождения: $birthDate
          Группа: $group
    """.trimIndent()
    }
}
