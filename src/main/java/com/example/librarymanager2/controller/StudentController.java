package com.example.librarymanager2.controller;


import com.example.librarymanager2.model.Book;
import com.example.librarymanager2.model.Student;
import com.example.librarymanager2.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService){

        this.studentService = studentService;
    }

    //------Student------//

    @GetMapping("/getStudentByID/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){

        Student s = this.studentService.getStudentByID(id);

        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Student> updatedTheStudent(@RequestBody Student student){

        this.studentService.updateStudent(student);

        return new ResponseEntity<>(student, HttpStatus.CREATED);

    }

    @PostMapping("/addAStudent")
    public ResponseEntity<Student> addAStudent(@RequestBody Student student){

        this.studentService.addStudent(student);

        return new ResponseEntity<>(student,HttpStatus.CREATED);

    }

    @DeleteMapping("/deleteAStudent")
    public ResponseEntity<Long> deleteStudent(@RequestParam Long id){

        this.studentService.deleteStudent(id);

        return new ResponseEntity<>(id, HttpStatus.OK);

    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllTheStudents(){

        List<Student> students = this.studentService.getAllStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    //------Book-------//

    @GetMapping("/getAllStudentBooks/{id}")
    public ResponseEntity<List<Book>> getStudentBooks(@PathVariable Long id){

        List<Book> books = this.studentService.getAllBooks(id);

        return new ResponseEntity<>(books, HttpStatus.OK);

    }

    @PostMapping("/addBook/{id}")
    public ResponseEntity<Book>addABook(@PathVariable Long id, @RequestBody Book book){

        this.studentService.addBookToStudent(id,book);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<Long> deleteBookFromStudent(@RequestParam Long sid, @RequestParam Long bid){

        this.studentService.deleteBookFromStudent(sid,bid);

        return new ResponseEntity<>(bid,HttpStatus.OK);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateTheBook(@RequestParam Long id, @RequestBody Book book){

        this.studentService.updateStudentBook(id, book);

        return new ResponseEntity<>(book, HttpStatus.OK);


    }




}

