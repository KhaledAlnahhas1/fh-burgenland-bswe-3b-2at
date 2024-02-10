package io.muehlbachler.fhburgenland.swm.examination.service;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.service.impl.NoteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link NoteService} interface.
 * These tests verify the correct behavior of methods defined in the NoteService interface.
 */
@SpringBootTest
class NoteServiceTest {
    @Autowired
    NoteService noteService;
    /**
     * Verifies the correct retrieval of a specific note by its unique ID.
     */
    @Test
    void testGetNoteById() {
        // Arrange
        String noteId = "c5b38625-7eed-4705-858d-c685f18ed47d";
        String personFirstName = "John";
        // Act
        Optional<Note> result = noteService.get(noteId);

        // Assert
        assertTrue(result.isPresent());

        assertEquals("Note 1", result.get().getContent());
        assertEquals(personFirstName, result.get().getPerson().getFirstName());
    }


    @Test
    void testGetNoteByWrongId() {
        // Arrange
        String noteId = "FakeID";
        // Act
        Optional<Note> result = noteService.get(noteId);

        // Assert
        assertFalse(result.isPresent());

    }


    /**
     * Validates the accurate creation of a new note.
     */
    @Test
    void testCreateNote() {
        // Arrange
        Optional<Note> note1 = noteService.get("c5b38625-7eed-4705-858d-c685f18ed47d");
        assertTrue(note1.isPresent());
        Note newNote = new Note("2",note1.get().getPerson(), "Note 4");

        // Act
        Note result = noteService.create(newNote);

        // Assert
        assertNotNull(result);
        assertEquals(newNote.getId(), result.getId());
        assertEquals(newNote.getContent(), result.getContent());
    }

    /**
     * Ensures the correct search for notes based on their content.
     */
    @Test
    void testQueryNotesByContent() {
        // Arrange
        String noteContent = "Note 1";

        // Act
        List<Note> noteList = noteService.queryByContent(noteContent);

        // Assert
        assertFalse(noteList.isEmpty());
        assertEquals(1, noteList.size());
        assertEquals("c5b38625-7eed-4705-858d-c685f18ed47d", noteList.getFirst().getId());
    }
}
