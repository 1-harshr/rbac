package org.harsh.rbac.dto

import org.harsh.rbac.entity.UserType

data class UserDto(
    val id: Long? = null,

    val name: String? = null,

    val role: UserType? = null,
)