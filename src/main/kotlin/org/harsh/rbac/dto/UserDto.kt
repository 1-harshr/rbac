package org.harsh.rbac.dto

import jakarta.validation.constraints.NotBlank
import org.harsh.rbac.entity.UserType

data class UserDto(
    val id: Long? = null,

    @field:NotBlank val name: String? = null,

    val role: UserType? = null,
)