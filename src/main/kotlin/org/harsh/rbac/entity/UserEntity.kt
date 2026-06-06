package org.harsh.rbac.entity

import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
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

    @NotNull
    @Column(unique = true)
    var name: String? = null

    @Embedded
    var userType: UserType = UserType.USER

}

enum class UserType {
    USER, ADMIN
}