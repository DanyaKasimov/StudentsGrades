package app.entity

import jakarta.persistence.*

@Entity
open class Grade(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "student_id", nullable = false)
    var studentId: Long = 0,

    @Column(nullable = false)
    var mark: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false)
    var subject: Subject = Subject(),
) {
}