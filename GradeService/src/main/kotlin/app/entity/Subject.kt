package app.entity

import jakarta.persistence.*

@Entity
data class Subject (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, unique = true)
    var name: String = ""
)