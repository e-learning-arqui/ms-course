package com.example.mscourse.dao;

import com.example.mscourse.entity.CourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    @Query(value = "SELECT * FROM course WHERE status = true", nativeQuery = true)
    Page <CourseEntity> findAllCourses(Pageable pageable);
}

