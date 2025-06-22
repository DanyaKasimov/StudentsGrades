package app.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "groups")
data class Group(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var name: String = "",

    @UpdateTimestamp
    @Column(nullable = false, name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @CreationTimestamp
    @Column(nullable = false, name = "created_at", updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    var students: MutableList<Student> = mutableListOf()
) {
}