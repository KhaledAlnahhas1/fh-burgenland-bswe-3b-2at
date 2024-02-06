package io.muehlbachler.fhburgenland.swm.examination.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;

/**
 * Manages notes in the database.
 */
public interface NoteRepository extends CrudRepository<Note, String> {

    /**
     * Finds notes that include a specific content.
     *
     * @param content The text to look for within notes.
     * @return List of notes matching the specified content.
     */
    List<Note> findByContentContaining(String content);
}
