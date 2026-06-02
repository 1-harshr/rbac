package org.harsh.rbac.dto

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime


@Entity(name = "Notes")
class NotesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var title: String = ""
    var content: String = ""
    var date: LocalDateTime = LocalDateTime.now()
}