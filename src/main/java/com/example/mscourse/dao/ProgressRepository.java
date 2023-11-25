package com.example.mscourse.dao;

import com.example.mscourse.entity.ProgressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressRepository extends JpaRepository<ProgressEntity, Long> {
}
