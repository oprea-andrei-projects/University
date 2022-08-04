package com.example.librarymanager2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Book")
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @SequenceGenerator(

        name = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(

            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )

    Long id;


    @Column(

            name = "book_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    String book_name;

    @Column(

            name = "created_at",
            nullable = false,
            columnDefinition = "DATE"
    )
    LocalDate created_at;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(
        name = "student_id",
        referencedColumnName = "id",
        foreignKey = @ForeignKey(
            name = "student_id_fk"
        )

    )
    private Student student;

    public Book(String book_name, LocalDate created_at) {
        this.book_name = book_name;
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object o){

        Book b = (Book) o;

        return this.book_name.equals(b.getBook_name());

    }
}
