package com.example.mscourse.dao;

import com.example.mscourse.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT s FROM Student s WHERE s.keycloakId = :keycloakId")
    Student findByKeycloakId (String keycloakId);
}
