package org.harsh.rbac.service

import org.harsh.rbac.dto.NotesDto
import org.harsh.rbac.dto.NotesEntity
import org.harsh.rbac.mapper.toNoteDto
import org.harsh.rbac.mapper.toNoteEntity
import org.harsh.rbac.repo.NotesRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class NotesService(private val notesRepository: NotesRepository) {

    fun getNotes(): List<NotesEntity> = notesRepository.findAll()

    fun postNote(note: NotesDto) : NotesDto {
        val entity = note.toNoteEntity()
        return notesRepository.save(entity).toNoteDto()
    }

    fun deleteNotes(id: Long) = notesRepository.deleteById(id)

    fun editNote(id : Long, note: NotesDto) : NotesDto {
        val entity = note.toNoteEntity()
        return notesRepository.save(entity).toNoteDto()
    }


}