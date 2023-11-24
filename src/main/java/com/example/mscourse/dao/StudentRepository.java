package com.example.mscourse.dao;

import com.example.mscourse.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByKeycloakId (String keycloakId);
}
