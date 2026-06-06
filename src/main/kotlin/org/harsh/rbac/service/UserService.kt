package org.harsh.rbac.service

import org.harsh.rbac.dto.UserDto
import org.harsh.rbac.mapper.toDto
import org.harsh.rbac.mapper.toEntity
import org.harsh.rbac.repo.UserRepo
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class UserService(
    private val userRepo: UserRepo
) {
    fun getUserById(userId: Long): UserDto? {
        return userRepo.findByIdOrNull(userId)?.toDto()
    }
    fun createUser(userDto: UserDto): UserDto {
        val user = userRepo.save(userDto.toEntity()).toDto()
        return user
    }
}