package com.example.librarymanager2.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Enrolment")
@Table(name = "enrolment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enrolment {

   @Id
   @SequenceGenerator(
           name= "sequence_generator",
           allocationSize = 1
   )
   @GeneratedValue(

           strategy = GenerationType.SEQUENCE,
           generator = "sequence_generator"
   )
   Long id;


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
    Student student;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "course_id_fk"
            )
    )
    Course course;

    public Enrolment(LocalDate created_at) {
        this.created_at = created_at;
    }



    @Override
    public String toString() {
        return "Enrolment{" +
                "id=" + id +
                ", created_at=" + created_at +

                '}';
    }
}
