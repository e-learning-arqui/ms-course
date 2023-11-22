package com.example.mscourse.dao;

import com.example.mscourse.entity.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SectionRepository extends JpaRepository<SectionEntity, Long> {
    @Query(value = "SELECT s FROM SectionEntity s WHERE s.courseId.courseId = :courseId")
    List<SectionEntity> findByCourseId(Long courseId);
}
