package org.harsh.rbac.mapper

import org.harsh.rbac.dto.NotesDto
import org.harsh.rbac.dto.NotesEntity


fun NotesDto.toNoteEntity() = NotesEntity(

)

fun NotesEntity.toNoteDto() = NotesDto(

)