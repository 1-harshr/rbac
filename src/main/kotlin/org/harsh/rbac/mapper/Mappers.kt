package org.harsh.rbac.mapper

import org.harsh.rbac.dto.NotesDto
import org.harsh.rbac.dto.UserDto
import org.harsh.rbac.entity.NotesEntity
import org.harsh.rbac.entity.UsersEntity
import java.util.UUID


fun NotesDto.toNoteEntity() = NotesEntity(

)

fun NotesEntity.toNoteDto() = NotesDto(

)


fun UsersEntity.toDto() = UserDto(
    id = this.id,
    name = this.name,
)

fun UserDto.toEntity() : UsersEntity {
    val entity =  UsersEntity()
    entity.id = this.id
    entity.name = this.name
    return entity
}