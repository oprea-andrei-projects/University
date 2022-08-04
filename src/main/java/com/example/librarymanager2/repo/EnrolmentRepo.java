package com.example.librarymanager2.repo;

import com.example.librarymanager2.model.Enrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnrolmentRepo extends JpaRepository<Enrolment, Long> {


}
