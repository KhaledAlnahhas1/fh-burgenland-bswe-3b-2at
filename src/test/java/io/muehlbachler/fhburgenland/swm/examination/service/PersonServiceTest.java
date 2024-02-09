package io.muehlbachler.fhburgenland.swm.examination.service;

import static org.junit.jupiter.api.Assertions.*;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

/**
 * Unit tests for the {@link PersonService} interface.
 */
@SpringBootTest
class PersonServiceTest {

    @Autowired
    PersonService personService;

    /**
     * Tests the retrieval of a list of all persons.
     */
    @Test
    void testGetAllPersons() {
        // Arrange

        // Act
        List<Person> result = personService.getAll();

        // Assert
        assertNotNull(result);
        // Add more assertions based on the expected behavior
    }

    /**
     * Tests the retrieval of a specific person by their unique ID.
     */
    @Test
    void testGetPersonById() {
        // Arrange
        String personId = "81150016-8501-4b97-9168-01113e21d8a5";
        String firstName = "John";
        String lastName = "Doe";

        // Act
        Optional<Person> result = personService.get(personId);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(firstName, result.get().getFirstName());
        assertEquals(lastName, result.get().getLastName());
    }

    /**
     * Tests the creation of a new person.
     */
    @Test
    void testCreatePerson() {
        // Arrange
        Person newPerson = new Person("testId","Max","Muster");
        // Act
        Person result = personService.create(newPerson);

        // Assert
        assertNotNull(result);
        assertEquals(newPerson.getId(), result.getId());
        assertEquals(newPerson.getFirstName(), result.getFirstName());
        assertEquals(newPerson.getLastName(), result.getLastName());
    }

    /**
     * Tests the searching for persons based on their first and/or last names.
     */
    @Test
    void testFindPersonsByName() {
        // Arrange
        String firstName = "John";
        String lastName = "Doe";

        // Act
        List<Person> personList = personService.findByName(firstName, lastName);

        // Assert
        assertFalse(personList.isEmpty());
        assertEquals(1, personList.size());

    }

    /**
     * Tests the creation of a new note for a specific person.
     */
    @Test
    void testCreateNoteForPerson() {
        // Arrange
        String personId = "d891323f-a3ad-4a95-b340-2e1c8aa8d1bd";
        Note newNote = new Note("1", "Note 2");

        // Act
        Optional<Note> result = personService.createNote(personId, newNote);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(newNote.getId(), result.get().getId());
        assertEquals(newNote.getContent(), result.get().getContent());
    }
}
