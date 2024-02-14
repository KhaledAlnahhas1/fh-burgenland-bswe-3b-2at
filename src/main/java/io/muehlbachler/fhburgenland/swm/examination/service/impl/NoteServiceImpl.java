package io.muehlbachler.fhburgenland.swm.examination.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.repository.NoteRepository;
import io.muehlbachler.fhburgenland.swm.examination.service.NoteService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


/**
 * The NoteService provides methods for retrieving, creating, and querying notes.
 * It is marked as a Spring service using the {@code @Service} annotation.
 */
@NoArgsConstructor
@AllArgsConstructor
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    /**
     * Retrieves a note by its unique ID.
     *
     * @param id The ID of the note to retrieve.
     * @return Optional containing the retrieved note, or empty if not found.
     */
    @Override
    public Optional<Note> get(String id) {
        return noteRepository.findById(id);
    }

    /**
     * Creates a new note.
     *
     * @param note The note object to create.
     * @return The created note.
     */
    @Override
    public Note create(Note note) {
        return noteRepository.save(note);
    }

    /**
     * Queries notes based on content.
     *
     * @param query The content to search for within notes.
     * @return List of notes matching the specified content.
     */
    @Override
    public List<Note> queryByContent(String query) {
        return noteRepository.findByContentContaining(query);
    }
}
