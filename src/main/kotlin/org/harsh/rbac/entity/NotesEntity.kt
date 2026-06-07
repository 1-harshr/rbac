package org.harsh.rbac.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity(name = "Notes")
class NotesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    @ManyToOne(fetch = FetchType.LAZY)
    var owner: UsersEntity? = null
    @Column(nullable = false)
    var title: String = ""
    @Column(nullable = false)
    var content: String = ""
    @Column(nullable = false)
    var date: LocalDateTime = LocalDateTime.now()
}