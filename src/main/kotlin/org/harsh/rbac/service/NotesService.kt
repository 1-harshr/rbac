package org.harsh.rbac.service

import jakarta.transaction.Transactional
import org.harsh.rbac.dto.NotesDto
import org.harsh.rbac.exception.NoteNotFound
import org.harsh.rbac.exception.UserNotFound
import org.harsh.rbac.mapper.toNoteDto
import org.harsh.rbac.mapper.toNoteEntity
import org.harsh.rbac.repo.NotesRepository
import org.harsh.rbac.repo.UserRepo
import org.springframework.stereotype.Service

@Service
class NotesService(
    private val notesRepository: NotesRepository,
    private val userRepo: UserRepo
) {

    fun getNotes(userId: Long): List<NotesDto> {
        val userNotes = notesRepository.findByOwnerId(userId)
        return userNotes.map { it.toNoteDto() }
    }

    fun postNote(userId: Long, note: NotesDto) : NotesDto {
        val user = userRepo.findById(userId).orElseThrow{ UserNotFound(userId) }
        val entity = note.toNoteEntity(user)
        return notesRepository.save(entity).toNoteDto()
    }

    fun deleteNotes(userId: Long, id: Long) = notesRepository.deleteById(id)


    @Transactional
    fun editNote(userId: Long, notesId : Long, note: NotesDto) : NotesDto {
        userRepo.findById(userId).orElseThrow{ UserNotFound(userId) }

        val userNoteEntity = notesRepository.findById(notesId).orElseThrow{ NoteNotFound() }
        userNoteEntity.title = note.title
        userNoteEntity.content = note.content

        return userNoteEntity.toNoteDto()
    }
}