package org.harsh.rbac.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.jetbrains.annotations.NotNull


@Entity
@Table(name = "users")
class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0L

    @Column(unique = true,nullable = false)
    var name: String? = null

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var userType: UserType? = UserType.USER

}

enum class UserType {
    USER, ADMIN
}