package io.muehlbachler.fhburgenland.swm.examination.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

/**
 * Represents a note associated with a person.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private String id;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;
    private String content;

    /**
     * Creates a new note with the provided details.
     * this constructor is used for tests.
     *
     * @param id      The unique identifier for the note.
     * @param content The content of the note.
     */
    public Note(String id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Note [belongsTo=" + this.person + ", text=" + this.content + "]";
    }
}
