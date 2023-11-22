package com.example.mscourse.dao;

import com.example.mscourse.entity.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SectionRepository extends JpaRepository<SectionEntity, Long> {

    @Query("SELECT s FROM SectionEntity s WHERE s.courseId.courseId = :id and s.status = true")
    List<SectionEntity> findByCourseId(@Param("id") Long id);


}
