package io.muehlbachler.fhburgenland.swm.examination.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.muehlbachler.fhburgenland.swm.examination.model.Person;

/**
 * Manages persons in the database.
 */
public interface PersonRepository extends CrudRepository<Person, String> {
    /**
     * Finds persons by their first name.
     *
     * @param firstName The first name to search for.
     * @return List of persons with the specified first name.
     */
    List<Person> findByFirstName(String firstName);

    /**
     * Finds persons by their last name.
     *
     * @param lastName The last name to search for.
     * @return List of persons with the specified last name.
     */
    List<Person> findByLastName(String lastName);

    /**
     * Finds persons by both first and last names.
     *
     * @param firstName The first name to search for.
     * @param lastName The last name to search for.
     * @return List of persons matching both first and last names.
     */
    List<Person> findByFirstNameAndLastName(String firstName, String lastName);
}
