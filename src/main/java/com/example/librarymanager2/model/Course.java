package com.example.librarymanager2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Course")
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @SequenceGenerator(
            name = "sequence_course",
            allocationSize = 1
    )
    @GeneratedValue(

            strategy = GenerationType.SEQUENCE,
            generator = "sequence_course"
    )
    Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    String name;

    @Column(

            name = "department",
            nullable = false,
            columnDefinition = "TEXT"
    )
    String department;

    @JsonManagedReference
    @OneToMany(mappedBy = "course",
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Enrolment> enrolmentList = new ArrayList<>();

    public void addEnrolment(Enrolment e){

        this.enrolmentList.add(e);
        e.setCourse(this);
    }

    public Course(String name, String department) {
        this.name = name;
        this.department = department;
    }
}
