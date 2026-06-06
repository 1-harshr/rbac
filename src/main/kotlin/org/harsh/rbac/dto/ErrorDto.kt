package org.harsh.rbac.dto

import org.jetbrains.annotations.NotNull

data class ErrorDto(
    @NotNull
    val errorCode: Int,
    val errorMessage: String
)
