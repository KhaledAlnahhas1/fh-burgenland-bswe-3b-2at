package io.muehlbachler.fhburgenland.swm.examination.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.model.Person;
import io.muehlbachler.fhburgenland.swm.examination.repository.PersonRepository;
import io.muehlbachler.fhburgenland.swm.examination.service.NoteService;
import io.muehlbachler.fhburgenland.swm.examination.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private NoteService noteService;

    /**
     * Retrieves all persons.
     *
     * @return List of all persons.
     */
    public List<Person> getAll() {
        return Lists.newArrayList(personRepository.findAll());
    }

    /**
     * Retrieves a person by their unique ID.
     *
     * @param id The ID of the person to retrieve.
     * @return Optional containing the retrieved person, or empty if not found.
     */
    public Optional<Person> get(String id) {
        return personRepository.findById(id);
    }

    /**
     * Creates a new person.
     *
     * @param person The person object to create.
     * @return The created person.
     */
    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    /**
     * Searches for persons by first and/or last names.
     *
     * @param firstName The first name to search for.
     * @param lastName  The last name to search for.
     * @return List of persons matching the specified first and/or last names.
     */
    @Override
    public List<Person> findByName(String firstName, String lastName) {
        if (firstName.isEmpty() && !lastName.isEmpty()) {
            return personRepository.findByFirstName(lastName);
        } else if (lastName.isEmpty() && !firstName.isEmpty()) {
            return personRepository.findByLastName(firstName);
        }
        return Lists.newArrayList();
    }

    /**
     * Creates a new note for a specific person.
     *
     * @param personId The ID of the person to associate the note with.
     * @param note     The note object to create.
     * @return Optional containing the created note, or empty if the person is not found.
     */
    @Override
    public Optional<Note> createNote(String personId, Note note) {
        return get(personId).map((Person person) -> {
            note.setPerson(person);
            return noteService.create(note);
        });
    }
}
