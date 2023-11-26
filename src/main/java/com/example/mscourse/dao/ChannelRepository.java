package com.example.mscourse.dao;

import com.example.mscourse.entity.ChannelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChannelRepository extends JpaRepository<ChannelEntity,Long> {

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM ChannelEntity c WHERE c.courseId.courseId = :courseId")
    boolean isChannelCreated(Long courseId);
    //obtener el canal por id de curso

    @Query("SELECT c FROM ChannelEntity c WHERE c.courseId.courseId = :courseId")
    ChannelEntity getChannelByCourseId(Long courseId);
}
