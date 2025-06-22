# StudentsGrades

## Описание

Pet-проект на kotlin

## Stack

* Kotlin
* Spring (Data JPA, Cloud)
* Postgres
* Kafka
* Hibernate

## Особенности

Реализован выбор транспорта (HTTP, KAFKA) между StudentService, GradeService и NotificationService через конфигурационной файл при помощи свойства:

```yaml
transport: 
    type: HTTP
```
или

```yaml
transport:
    type: KAFKA
```
В случае отказа HTTP или Kafka при отправке уведомлений происходит fallback на альтернативный транспорт

Взаимодействие по HTTP происходит через OpenFeign
