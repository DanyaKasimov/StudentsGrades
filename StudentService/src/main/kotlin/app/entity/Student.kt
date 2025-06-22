package app.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "students")
data class Student (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, length = 255)
    var name: String = "",

    @Column(nullable = false, length = 255)
    var surname: String = "",

    @Column(nullable = true, length = 255)
    var middle: String? = null,

    @Column(nullable = false, unique = true, length = 255)
    var email: String = "",

    @Column(nullable = false)
    var birthDate: LocalDate? = null,

    @UpdateTimestamp
    @Column(nullable = false, name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @CreationTimestamp
    @Column(nullable = false, name = "created_at", updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    var group: Group = Group()
) {}

