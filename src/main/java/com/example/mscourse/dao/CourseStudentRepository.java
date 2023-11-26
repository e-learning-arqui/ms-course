package com.example.mscourse.dao;

import com.example.mscourse.entity.CourseEntity;
import com.example.mscourse.entity.CourseStudentEntity;
import com.example.mscourse.entity.LanguageEntity;
import com.example.mscourse.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseStudentRepository extends JpaRepository<CourseStudentEntity, Long> {
    @Query(value = "SELECT c FROM CourseStudentEntity c WHERE c.userId.userId = :userId AND c.courseId.courseId = :courseId")
    CourseStudentEntity findByUserIdAndCourseId(@Param("userId") Long userId, @Param("courseId") Long courseId);

//    @Query(value = "SELECT c.courseId.courseId FROM CourseStudentEntity c WHERE c.userId.keycloakId = :userId")
//    List<Long> courseIdsByUserKcId(String userId);

    @Query(value = "SELECT c.courseId.courseId FROM CourseStudentEntity c WHERE c.userId.keycloakId = :userId")
    Page<Long> courseIdsByUserKcId(String userId, Pageable pageable);
 }
