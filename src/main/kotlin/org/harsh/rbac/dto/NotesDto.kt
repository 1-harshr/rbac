package org.harsh.rbac.dto

import jakarta.validation.constraints.NotBlank

data class NotesDto(
    val id: Long = 0L,
    @field:NotBlank val title: String = "",
    @field:NotBlank val content: String = "",
    val createdAt: Long = System.currentTimeMillis(),
)
