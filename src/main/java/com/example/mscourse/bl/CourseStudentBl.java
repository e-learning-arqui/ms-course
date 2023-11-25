package com.example.mscourse.bl;

import com.example.mscourse.dao.CourseRepository;
import com.example.mscourse.dao.CourseStudentRepository;
import com.example.mscourse.dao.StudentRepository;
import com.example.mscourse.dto.CourseDto;
import com.example.mscourse.entity.CourseEntity;
import com.example.mscourse.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CourseStudentBl {

    @Autowired
    private CourseStudentRepository courseStudentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseBl courseBl;



    Logger log = Logger.getLogger(CourseStudentBl.class.getName());
    public List<CourseDto> courseIdsTakenByStudent(String keycloakId) {
        log.info("Getting courses taken by student: " + keycloakId);
        List<CourseDto> takenCourses = new ArrayList<>();
        List<Long> courseIds = courseStudentRepository.courseIdsByUserKcId(keycloakId);
        for (Long courseId : courseIds) {
            CourseEntity courseEntity = courseRepository.findByCourseId(courseId);
            CourseDto courseDto = new CourseDto();
            //courseDto.set(courseEntity);
            courseDto.setTitle(courseEntity.getTitle());
            courseDto.setDescription(courseEntity.getDescription());
            courseDto.setLanguageId(courseEntity.getLanguageId().getLanguageId());
            courseDto.setLevelId(courseEntity.getLevelId().getLevelId());
            courseDto.setProfessorKeycloakId(courseEntity.getProfessorId().getKeycloakId());
            String logoUrl = courseBl.url(courseEntity.getTitle());
            courseDto.setLogoUrl(logoUrl);
            takenCourses.add(courseDto);
        }

        return takenCourses;
    }


}
