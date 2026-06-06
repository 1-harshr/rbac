package org.harsh.rbac.controller

import org.harsh.rbac.dto.UserDto
import org.harsh.rbac.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping("/{userId}")
    fun getUser(
        @PathVariable userId: Long,
    ): ResponseEntity<UserDto> {
        val user: UserDto? = userService.getUserById(userId)

        return if (user != null) {
            ResponseEntity(user, HttpStatus.OK)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/create")
    fun createUser(
        @RequestBody userDto: UserDto
    ): ResponseEntity<UserDto> {
        val user : UserDto = userService.createUser(userDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(user)
    }
}