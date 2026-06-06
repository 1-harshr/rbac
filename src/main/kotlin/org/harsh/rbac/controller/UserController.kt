package org.harsh.rbac.controller

import org.harsh.rbac.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/users")
class UserController(
    userService: UserService
) {

    @GetMapping("/{userId}")
    fun getUser(
        @RequestParam(required =true) userId: String?,
    ){

    }
}