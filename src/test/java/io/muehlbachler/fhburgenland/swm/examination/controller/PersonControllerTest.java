package io.muehlbachler.fhburgenland.swm.examination.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.muehlbachler.fhburgenland.swm.examination.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootTest
public class PersonControllerTest {
    @Autowired
    private PersonController personController;

    @Test
    void testGetById() {
        ResponseEntity<Person> person = personController.get("81150016-8501-4b97-9168-01113e21d8a5");

        assertEquals(HttpStatus.OK, person.getStatusCode(), "person should be found");
        assertEquals("John", Objects.requireNonNull(person.getBody()).getFirstName(), "firstName should be John");
    }


    @Test
    void testGetByWrongId() {
        ResponseEntity<Person> person = personController.get("FakeID");

        assertEquals(HttpStatus.NOT_FOUND, person.getStatusCode(), "no person should be found");
    }

    @Test
    void testListAllPersons() {
        // Act
        List<Person> persons = personController.list();

        // Assert
        assertNotNull(persons);
    }

    @Test
    void testCreatePerson() {
        // Arrange
        Person newPerson = new Person();
        newPerson.setFirstName("Sarah");
        newPerson.setLastName("Schmidt");
        newPerson.setNotes(new ArrayList<Note>());


        // Act
        Person createdPerson = personController.create(newPerson);

        // Assert
        assertNotNull(createdPerson);
        assertEquals(newPerson.getId(), createdPerson.getId());
        assertEquals(newPerson.getFirstName(), createdPerson.getFirstName());
        assertEquals(newPerson.getLastName(), createdPerson.getLastName());
    }



    @Test
    void testQueryPersonsByName() {
        // Arrange
        String firstName = "Jane";
        String lastName = "Doe";

        // Act
        List<Person> persons = personController.query(firstName, lastName);

        // Assert
        assertNotNull(persons);
        assertEquals(1, persons.size());
        assertEquals("d891323f-a3ad-4a95-b340-2e1c8aa8d1bd", persons.getFirst().getId());
    }
}
