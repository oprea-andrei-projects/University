package com.example.librarymanager2;

import com.example.librarymanager2.model.Book;
import com.example.librarymanager2.model.Course;
import com.example.librarymanager2.model.Enrolment;
import com.example.librarymanager2.model.Student;
import com.example.librarymanager2.repo.CourseRepo;
import com.example.librarymanager2.repo.StudentRepo;
import com.example.librarymanager2.service.StudentService;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class LibraryManager2Application {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManager2Application.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(StudentService studentService){

        return args -> {

            studentService.getAllEnrolments(7L).stream().forEach(System.out::println);

        };
    }
}
