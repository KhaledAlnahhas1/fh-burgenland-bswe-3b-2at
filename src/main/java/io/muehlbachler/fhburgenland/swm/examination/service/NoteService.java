package io.muehlbachler.fhburgenland.swm.examination.service;

import java.util.List;
import java.util.Optional;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;

/**
 * Service interface for managing notes, providing methods to retrieve, create,
 * and query notes based on content.
 */
public interface NoteService {

    /**
     * Gets a specific note by its unique ID.
     *
     * @param id The ID of the note you want to retrieve.
     * @return The note if found, or an empty result if not.
     */
    Optional<Note> get(String id);

    /**
     * Creates a new note.
     *
     * @param note The note you want to create.
     * @return The newly created note.
     */
    Note create(Note note);

    /**
     * Searches for notes based on their content.
     *
     * @param query The content you're looking for within notes.
     * @return A list of notes matching the specified content.
     */
    List<Note> queryByContent(String query);
}
