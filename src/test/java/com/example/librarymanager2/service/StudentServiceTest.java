package com.example.librarymanager2.service;

import com.example.librarymanager2.model.Book;
import com.example.librarymanager2.model.Student;
import com.example.librarymanager2.repo.BookRepo;
import com.example.librarymanager2.repo.StudentRepo;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@TestPropertySource(
        locations="classpath:application-it.properties"
)
class StudentServiceTest {

    @Mock
    private StudentRepo studentRepo;
    @Mock
    private BookRepo bookRepo;
    @InjectMocks
    private  StudentService studentService;

    @Captor
    private ArgumentCaptor<Student> studentArgumentCaptor;

    public StudentServiceTest() {

        MockitoAnnotations.openMocks(this);

    }


    @Test
    void test_getAllStudents(){

        List<Student> students = new ArrayList<>();
        Faker faker = new Faker();

        for(int i = 0; i<10; i++){
            students.add(new Student(faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(),faker.internet().password(),faker.number().numberBetween(1,65)));
        }

        when(studentRepo.findAll()).thenReturn(students);

        assertEquals(studentService.getAllStudents().size(),10);

    }

    @Test
    void test_getStudentById(){

        List<Student> students = new ArrayList<>();
        Student student =
                new Student("Andrei","Oprea","mail@mail.com", "pass",41);
        student.setId(1L);
        students.add(student);
        when(studentRepo.findById(1L)).thenReturn(Optional.of(student));
//        when(studentService.getStudentByID(1L).getAge()).thenReturn(41);

        assertEquals(studentService.getStudentByID(1L).getAge(),41);

    }

    @Test
    void test_deleteStudent(){

        Student student =
                new Student("Andrei","Oprea","mail@mail.com", "pass",41);
        student.setId(1L);
        when(studentRepo.findById(1L)).thenReturn(Optional.of(student));

        studentService.deleteStudent(1L);

        then(studentRepo).should().delete(studentArgumentCaptor.capture());

        assertEquals(student.getAge(),studentArgumentCaptor.getValue().getAge());


    }

    @Test
    void test_UpdateStudent(){

        Student student =
                new Student("Andrei","Oprea","mail@mail.com", "pass",41);
        student.setId(1L);

        Student student2 =
                new Student("Andrei","Oprea","mail@mail.com", "pass",20);
        student2.setId(1L);

        when(studentRepo.findById(1L)).thenReturn(Optional.of(student));
        studentService.updateStudent(student2);
        assertEquals(student.getAge(),20);

    }

    @Test
    void test_addStudent(){


        Student student =
                new Student("Andrei","Oprea","mail@mail.com", "pass",41);
        student.setId(1L);


        when(studentRepo.findById(1L)).thenReturn(Optional.of(student));

        studentService.addStudent(student);

        then(studentRepo).should().save(studentArgumentCaptor.capture());

        assertEquals(student.getAge(),studentArgumentCaptor.getValue().getAge());


    }

    @Test
    void test_getAllStudentBooks(){

        List<Book> studentBooks = new ArrayList<>();
    }

}