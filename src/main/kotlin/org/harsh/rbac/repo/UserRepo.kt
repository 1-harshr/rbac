package org.harsh.rbac.repo

import org.harsh.rbac.entity.UsersEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepo: JpaRepository<UsersEntity, Long>