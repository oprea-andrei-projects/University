package com.example.librarymanager2.controller;

import com.example.librarymanager2.model.Student;
import com.example.librarymanager2.repo.CourseRepo;
import com.example.librarymanager2.repo.StudentRepo;
import com.example.librarymanager2.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Mock
    private StudentRepo mockStudentRepo;

    @Mock
    private CourseRepo mockCourseRepo;

    @Mock
    private StudentService mockStudentService;


    private MockMvc mockMvc;

    @Test
    void test_getAllStudents() throws Exception {

        List<Student> students = new ArrayList<>();
        Student student =
                new Student("Andrei","Oprea","mail@mail.com", "pass",41);
        student.setId(1L);
        students.add(student);

        when(mockStudentService.getAllStudents()).thenReturn(students);
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getAllStudents")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(students)));

    }

    @Test
    void test_getStudentById(){

//        Student student =
//                new Student("Andrei","Oprea","mail@mail.com", "pass",41);
//        student.setId(1L);
//
//        when(mockStudentService.getStudentByID(1L)).thenReturn(student);
//        mockMvc.perform((MockMvcRequestBuilders.get("/api/v1/getStudentByID/1L")
//                .accept(MediaType.APPLICATION_JSON)))



    }

}