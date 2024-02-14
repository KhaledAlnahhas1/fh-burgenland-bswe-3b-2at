package io.muehlbachler.fhburgenland.swm.examination.service;

import java.util.List;
import java.util.Optional;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.model.Person;

/**
 * Service interface for managing persons and associated notes.
 */
public interface PersonService {

    /**
     * Retrieves a list of all persons.
     *
     * @return A list containing all persons.
     */
    public List<Person> getAll();

    /**
     * Retrieves a specific person by their unique ID.
     *
     * @param id The ID of the person to retrieve.
     * @return The person if found, or an empty result if not.
     */
    public Optional<Person> get(String id);

    /**
     * Creates a new person.
     *
     * @param person The person to create.
     * @return The newly created person.
     */
    public Person create(Person person);


    /**
     * if any name (first or last) is empty, we only search for the other one.
     *
     * @param firstName The first name to search for.
     * @param lastName  The last name to search for.
     * @return A list of persons matching the specified first and/or last names.
     */
    public List<Person> findByName(String firstName, String lastName);

    /**
     * Creates a new note for a specific person.
     *
     * @param personId The ID of the person to associate the note with.
     * @param note     The note to create.
     * @return The newly created note if the person is found, or an empty result otherwise.
     */
    public Optional<Note> createNote(String personId, Note note);
}
