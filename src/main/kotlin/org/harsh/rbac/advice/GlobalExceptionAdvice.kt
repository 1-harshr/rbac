package org.harsh.rbac.advice

import org.harsh.rbac.dto.ErrorDto
import org.harsh.rbac.exception.UserAlreadyExists
import org.harsh.rbac.exception.UserNotFound
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalExceptionAdvice {

    @ExceptionHandler(UserNotFound::class)
    fun handleUserNotFound(exception: UserNotFound) : ResponseEntity<ErrorDto> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ErrorDto(
                errorCode = HttpStatus.NOT_FOUND.value(),
                errorMessage = "User not found"
            )
        )
    }

    @ExceptionHandler(UserAlreadyExists::class)
    fun handleUserAlreadyExists(exception: UserAlreadyExists) : ResponseEntity<ErrorDto> {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
            ErrorDto(
                errorCode = HttpStatus.CONFLICT.value(),
                errorMessage = "Cannot create user. User already exists"
            )
        )
    }
}