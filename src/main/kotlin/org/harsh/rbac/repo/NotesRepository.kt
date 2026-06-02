package org.harsh.rbac.repo

import org.harsh.rbac.dto.NotesEntity
import org.springframework.data.jpa.repository.JpaRepository


interface NotesRepository : JpaRepository<NotesEntity, Long>