package io.muehlbachler.fhburgenland.swm.examination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.model.Person;
import io.muehlbachler.fhburgenland.swm.examination.service.PersonService;

@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    private PersonService personService;

    /**
     * Retrieves a list of all persons.
     *
     * @return List of all persons.
     */
    @GetMapping("/")
    public List<Person> list() {
        return personService.getAll();
    }

    /**
     * Gets a specific person by their unique ID.
     *
     * @param id The ID of the person to retrieve.
     * @return ResponseEntity containing the retrieved person, or null if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Person> get(@PathVariable String id) {
        return ResponseEntity.of(personService.get(id));
    }

    /**
     * Creates a new person.
     *
     * @param person The person object to create.
     * @return The created person.
     */
    @PostMapping("/")
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    /**
     * Searches for persons based on first and last names.
     *
     * @param firstName The first name to search for.
     * @param lastName  The last name to search for.
     * @return List of persons matching the provided first and last names.
     */
    @GetMapping("/query")
    public List<Person> query(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return personService.findByName(firstName, lastName);
    }

    /**
     * Creates a new note for a specific person.
     *
     * @param id   The ID of the person to associate the note with.
     * @param note The note object to create.
     * @return ResponseEntity containing the created note, or null if the person is not found.
     */
    @PostMapping("/{id}/note")
    public ResponseEntity<Note> createNote(@PathVariable String id, @RequestBody Note note) {
        return ResponseEntity.of(personService.createNote(id, note));
    }
}
