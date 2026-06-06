package org.harsh.rbac.controller

import jakarta.validation.Valid
import org.harsh.rbac.dto.UserDto
import org.harsh.rbac.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping("/{userId}")
    fun getUser(
        @PathVariable userId: Long,
    ): ResponseEntity<UserDto> {
        val user: UserDto = userService.getUserById(userId)
        return ResponseEntity(user, HttpStatus.OK)

    }

    @PostMapping("/create")
    fun createUser(
        @Valid @RequestBody userDto: UserDto
    ): ResponseEntity<UserDto> {
        val user : UserDto = userService.createUser(userDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(user)
    }
}