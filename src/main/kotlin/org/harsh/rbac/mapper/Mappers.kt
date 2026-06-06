package org.harsh.rbac.mapper

import org.harsh.rbac.dto.NotesDto
import org.harsh.rbac.dto.UserDto
import org.harsh.rbac.entity.NotesEntity
import org.harsh.rbac.entity.UsersEntity
import java.time.ZoneOffset


fun NotesDto.toNoteEntity(owner: UsersEntity) : NotesEntity {
    val notesEntity = NotesEntity()
    notesEntity.id = this.id
    notesEntity.title = this.title
    notesEntity.content = this.content
    notesEntity.owner = owner
    return notesEntity

}

fun NotesEntity.toNoteDto() = NotesDto(
    id = this.id,
    title = this.title,
    content = this.content,
    createdAt = this.date.toEpochSecond(ZoneOffset.UTC)
)


fun UsersEntity.toDto() = UserDto(
    id = this.id,
    name = this.name,
    role = this.userType
)

fun UserDto.toEntity() : UsersEntity {
    val entity =  UsersEntity()
    entity.id = this.id
    entity.name = this.name
    entity.userType = this.role
    return entity
}