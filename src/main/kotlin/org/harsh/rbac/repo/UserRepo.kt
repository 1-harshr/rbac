package org.harsh.rbac.repo

import org.apache.catalina.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepo: JpaRepository<User, Long>