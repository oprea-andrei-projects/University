package com.example.librarymanager2.repo;

import com.example.librarymanager2.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
}
