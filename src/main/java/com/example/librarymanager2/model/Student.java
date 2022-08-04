package com.example.librarymanager2.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Student")
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @SequenceGenerator(

            name = "student_sequence",
            allocationSize = 1

    )
    @GeneratedValue(

            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    Long id;

    @Column(

        name ="first_name",
        nullable = false,
        columnDefinition = "TEXT"


    )
    String first_name;

    @Column(

            name ="last_name",
            nullable = false,
            columnDefinition = "TEXT"


    )
    String last_name;

    @Column(

            name ="email",
            nullable = false,
            columnDefinition = "TEXT"


    )
    String email;

    @Column(

            name ="password",
            nullable = false,
            columnDefinition = "TEXT"


    )
    String password;


    @Column(

            name ="age",
            nullable = false,
            columnDefinition = "INTEGER"


    )
    int age ;


    @JsonManagedReference
    @OneToMany(

            mappedBy ="student",
            cascade ={CascadeType.ALL},
            fetch =FetchType.LAZY,
            orphanRemoval = true

    )

    @JsonIgnore
    List<Book> bookList = new ArrayList<>();

    public void addBook(Book b){

        this.bookList.add(b);
        b.setStudent(this);

    }


    @JsonManagedReference
    @OneToMany(mappedBy = "student",
            cascade ={CascadeType.ALL},
            fetch =FetchType.EAGER,
            orphanRemoval = true)

    @JsonIgnore
    private List<Enrolment> enrolments = new ArrayList<>();

    public void addEnrolment(Enrolment e){

        this.enrolments.add(e);
        e.setStudent(this);
    }



    public Student(String first_name, String last_name, String email, String password, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o){

        Student s = (Student) o;

        return this.id == s.getId();
    }
}
