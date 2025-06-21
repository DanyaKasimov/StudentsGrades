package app.constants

import app.dto.StudentDTO

object Message {

    fun createStudent(name: String, surname: String, group: String) =
        "Здравствуйте $surname $name! Вы были добавлены в группу $group"

    fun updateStudent(dto: StudentDTO) =
        "Здравствуйте ${dto.surname} ${dto.name}! Ваши обновленные данные: $dto"

    fun deleteStudent(name: String, surname: String) =
        "Здравствуйте $surname $name! Ваш аккаунт был удален!"
}