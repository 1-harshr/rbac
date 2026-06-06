package org.harsh.rbac.controller

import org.harsh.rbac.dto.NotesDto
import org.harsh.rbac.service.NotesService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/notes")
class NotesController(
    private val notesService: NotesService
) {

    @GetMapping
    fun getNotes(
        @RequestHeader("userId") userId: Long,
    ): ResponseEntity<List<NotesDto>> {
        return ResponseEntity.ok(notesService.getNotes(userId))
    }

    @PostMapping
    fun postNotes(
        @RequestHeader("userId") userId: Long,
        @RequestBody note: NotesDto
    ): ResponseEntity<NotesDto> {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            notesService.postNote(userId, note)
        )
    }

    @DeleteMapping
    fun deleteNote(
        @RequestHeader("userId") userId: Long,
        @RequestBody note: NotesDto
    ): ResponseEntity<Unit> {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
            notesService.deleteNotes(userId, note.id)
        )
    }

    @PutMapping
    fun updateNote(
        @RequestHeader("userId") userId: Long,
        @RequestBody note: NotesDto
    ): ResponseEntity<NotesDto> {
        return ResponseEntity.status(HttpStatus.OK).body(
            notesService.editNote(notesId = note.id, userId = userId, note = note)
        )
    }

}