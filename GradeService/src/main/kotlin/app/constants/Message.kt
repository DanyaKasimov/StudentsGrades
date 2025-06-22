package app.constants


object Message {

    fun addMark(name: String, surname: String, mark: String, subject: String) =
        "Здравствуйте $surname $name! Вам поставили оценку $mark по предмету $subject"

    fun updateMark(name: String, surname: String, mark: String, subject: String, newMark: String) =
        "Здравствуйте $surname $name! Вам обновили оценку $mark по предмету $subject на $newMark"

    fun deleteMark(name: String, surname: String) =
        "Здравствуйте $surname $name! Вашу оценку убрали!"
}