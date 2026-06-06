package org.harsh.rbac.repo

import org.harsh.rbac.entity.NotesEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface NotesRepository : JpaRepository<NotesEntity, Long>{
    fun findByOwnerId(ownerId: Long): List<NotesEntity>
}