package org.harsh.rbac.controller

import org.harsh.rbac.dto.NotesDto
import org.harsh.rbac.mapper.toNoteDto
import org.harsh.rbac.service.NotesService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/notes")
class NotesController constructor(
    private val notesService: NotesService
) {

    fun getNotes(): ResponseEntity<List<NotesDto>> = ResponseEntity.ok(notesService.getNotes().map { it.toNoteDto() })

    fun postNotes(
        @RequestBody note: NotesDto
    ): ResponseEntity<NotesDto> {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            notesService.postNote(note)
        )
    }

    fun deleteNote(
        @RequestBody note: NotesDto
    ): ResponseEntity<Unit> {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
            notesService.deleteNotes(note.id)
        )
    }

    fun updateNote(
        @RequestBody note: NotesDto
    ): ResponseEntity<NotesDto> {
        return ResponseEntity.status(HttpStatus.OK).body(
            notesService.editNote(note.id, note)
        )
    }

}