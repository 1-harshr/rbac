package org.harsh.rbac.advice

import org.harsh.rbac.dto.ErrorDto
import org.harsh.rbac.exception.NoteNotFound
import org.harsh.rbac.exception.UserAlreadyExists
import org.harsh.rbac.exception.UserNotFound
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalExceptionAdvice {

    @ExceptionHandler(UserNotFound::class)
    fun handleUserNotFound(exception: UserNotFound) : ResponseEntity<ErrorDto> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ErrorDto(
                errorCode = HttpStatus.NOT_FOUND.value(),
                errorMessage = "User ${exception.id} not found"
            )
        )
    }

    @ExceptionHandler(UserAlreadyExists::class)
    fun handleUserAlreadyExists(exception: UserAlreadyExists) : ResponseEntity<ErrorDto> {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
            ErrorDto(
                errorCode = HttpStatus.CONFLICT.value(),
                errorMessage = "Cannot create user ${exception.name}. User already exists"
            )
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationErrors(exception: MethodArgumentNotValidException): ResponseEntity<ErrorDto> {
        val errors = exception.bindingResult.fieldErrors.joinToString(", ") {
            "${it.field}: ${it.defaultMessage}"
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ErrorDto(
                errorCode = HttpStatus.BAD_REQUEST.value(),
                errorMessage = errors
            )
        )
    }

    @ExceptionHandler(NoteNotFound::class)
    fun handleNoteNotFound(exception: NoteNotFound) : ResponseEntity<ErrorDto> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ErrorDto(
                errorCode = HttpStatus.NOT_FOUND.value(),
                errorMessage = "Note for this id not found for this user"
            )
        )
    }
}