package com.example.mscourse.dao;

import com.example.mscourse.entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {

    @Query("SELECT p FROM ProfessorEntity p WHERE p.keycloakId = :professorKeycloakId")
    ProfessorEntity getProfessorByProfessorKeycloakId(@Param("professorKeycloakId") String professorKeycloakId);
}
