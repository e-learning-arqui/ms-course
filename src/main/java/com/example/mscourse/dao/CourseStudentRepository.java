package com.example.mscourse.dao;

import com.example.mscourse.entity.CourseStudentEntity;
import com.example.mscourse.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseStudentRepository extends JpaRepository<CourseStudentEntity, Long> { }
