package com.example.librarymanager2.service;


import com.example.librarymanager2.exceptions.AlreadyExistsException;
import com.example.librarymanager2.exceptions.NoSuchElementExists;
import com.example.librarymanager2.exceptions.NoSuchIDException;
import com.example.librarymanager2.model.Book;
import com.example.librarymanager2.model.Enrolment;
import com.example.librarymanager2.model.Student;
import com.example.librarymanager2.repo.BookRepo;
import com.example.librarymanager2.repo.EnrolmentRepo;
import com.example.librarymanager2.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    StudentRepo studentRepo;
    BookRepo bookRepo;
    EnrolmentRepo enrolmentRepo;

    public StudentService(StudentRepo studentRepo, BookRepo bookRepo, EnrolmentRepo enrolmentRepo)
    {

        this.studentRepo = studentRepo;
        this.bookRepo = bookRepo;
        this.enrolmentRepo = enrolmentRepo;
    }

    public List<Student> getAllStudents(){

        if(this.studentRepo.findAll().size()==0){

            throw new NoSuchElementExists("No students yet registered !!!");
        }

        return this.studentRepo.findAll();
    }

    public void addStudent(Student s){

        if(Collections.frequency(studentRepo.findAll(),s)!=0){

            throw new AlreadyExistsException("Student already exists !!!");
        }

        this.studentRepo.save(s);

    }

    public Student getStudentByID(Long id)throws NoSuchIDException{

        Optional<Student> s = this.studentRepo.findById(id);

        if(s.isEmpty()){

            throw new NoSuchIDException("Student ID not found !!!");
        }

        return s.get();
    }

    public void deleteStudent(Long id){

        Student s = this.getStudentByID(id);

        this.studentRepo.delete(s);
    }

    public void updateStudent(Student s){


        Optional<Student> os = this.studentRepo.findById(s.getId());

        if(os.isEmpty()){

            throw new NoSuchIDException("ID incorrect !!!");
        }

        os.get().setFirst_name(s.getFirst_name());
        os.get().setLast_name(s.getLast_name());
        os.get().setEmail(s.getEmail());
        os.get().setPassword(s.getPassword());
        os.get().setAge(s.getAge());
        os.get().setBookList(s.getBookList());
        os.get().setEnrolments(s.getEnrolments());

        this.studentRepo.save(os.get());

    }

    public List<Book> getAllBooks(Long id){

        List<Book> allBooks = this.studentRepo.findById(id).get().getBookList();

        if(allBooks.isEmpty()){

            throw new NoSuchElementExists("Nu extista carti ale acestui student !!!");

        }

        return allBooks;

    }

    public void addBookToStudent(Long id,Book b){

        Optional<Student> studentOptional = this.studentRepo.findById(id);

        if(studentOptional.isEmpty()){

            throw new NoSuchIDException("No student found !!!");

        }

        if(Collections.frequency(studentOptional.get().getBookList(), b)!=0){

            throw new AlreadyExistsException("Book already exists !!!");
        }

        studentOptional.get().addBook(b);
        this.bookRepo.save(b);

    }

    public void deleteBookFromStudent(Long sid, Long bid){

        Optional<Student> studentOptional = this.studentRepo.findById(sid);
        Optional<Book> optionalBook = this.bookRepo.findById(bid);
        Book b= optionalBook.get();

        if(studentOptional.isEmpty()){

            throw new NoSuchIDException("No student found !!!");

        }

        if(Collections.frequency(studentOptional.get().getBookList(), b)==0){

            throw new NoSuchElementExists("This book does not exist");
        }

        studentOptional.get().getBookList().remove(b);
        this.studentRepo.save(studentOptional.get());
    }

    public Book getBookById(Long sid, Long bid){

        List<Book> books = this.studentRepo.findById(sid).get().getBookList();
        if(books.isEmpty()){
            throw new NoSuchElementExists("No books found on this student !!!");
        }
        Book b = books.stream().filter(e->e.getId().equals(bid)).collect(Collectors.toList()).get(0);
        if(Optional.of(b).isEmpty()){

            throw new NoSuchIDException("This student doesn't have this book !!!");
        }
        return b;
    }

    public Book updateStudentBook(Long id, Book b){

        Book b1 = this.getBookById(id,b.getId());

        b1.setBook_name(b.getBook_name());
        b1.setCreated_at(b.getCreated_at());

        this.bookRepo.save(b1);

        return b1;

    }

    //-----Enrolment-----//

    public List<Enrolment> getAllEnrolments(Long id){

        Optional<Student> os = this.studentRepo.findById(id);

        if(os.isEmpty()){

            throw new NoSuchIDException("ID was not found");
        }

        return os.get().getEnrolments();


    }

    public Enrolment getEnrolmentById(Long sid, Long eid){

        return null;
    }



}
