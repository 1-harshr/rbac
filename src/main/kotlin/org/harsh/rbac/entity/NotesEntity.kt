package org.harsh.rbac.entity

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
    var ownerId: String? = null
    var title: String = ""
    var content: String = ""
    var date: LocalDateTime = LocalDateTime.now()
}