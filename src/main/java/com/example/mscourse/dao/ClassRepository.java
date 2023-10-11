package com.example.mscourse.dao;

import com.example.mscourse.entity.ClassEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {

    @Query("SELECT c FROM ClassEntity c WHERE c.sectionId.courseId.courseId = :courseId")
    Page<ClassEntity> getClassesByCourseId(@Param("courseId") Long courseId, Pageable pageable);
}
