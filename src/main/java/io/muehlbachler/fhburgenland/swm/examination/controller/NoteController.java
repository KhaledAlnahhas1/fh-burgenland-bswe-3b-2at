package io.muehlbachler.fhburgenland.swm.examination.controller;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A REST controller for handling note-related operations.
 */
@RestController
@RequestMapping("note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    /**
     * Gets a specific note by its unique ID.
     *
     * @param id The ID of the note to retrieve.
     * @return ResponseEntity containing the retrieved note, or null if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> get(@PathVariable String id) {
        return ResponseEntity.of(noteService.get(id));
    }

    /**
     * Searches for notes based on a provided content query.
     *
     * @param query The content to search for within notes.
     * @return List of notes matching the provided query.
     */
    @GetMapping("/query")
    public List<Note> query(@RequestParam("query") String query) {
        return noteService.queryByContent(query);
    }
}
