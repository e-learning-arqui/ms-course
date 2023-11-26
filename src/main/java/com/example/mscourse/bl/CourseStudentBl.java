package com.example.mscourse.bl;

import com.example.mscourse.dao.CourseRepository;
import com.example.mscourse.dao.CourseStudentRepository;
import com.example.mscourse.dao.StudentRepository;
import com.example.mscourse.dto.CourseAndProgressDto;
import com.example.mscourse.dto.CourseDto;
import com.example.mscourse.dto.builder.CourseDtoBuilder;
import com.example.mscourse.entity.CourseEntity;
import com.example.mscourse.entity.Student;
import com.example.mscourse.service.ProgressService;
import com.example.mscourse.specifications.CourseSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@Service
public class CourseStudentBl {

    @Autowired
    private CourseStudentRepository courseStudentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ProgressService progressService;
    @Autowired
    private CourseBl courseBl;



    Logger log = Logger.getLogger(CourseStudentBl.class.getName());
    public Page<CourseAndProgressDto> courseIdsTakenByStudent(Pageable pageable,
                                                   String keycloakId,
                                                   Integer languageId,
                                                   Integer levelId,
                                                   Integer categoryId,
                                                   String title) {
        Specification<CourseEntity> spec = Specification.where(null);
        if (title != null) {
            spec = spec.and(CourseSpecification.titleContains(title));
        }

        if (languageId != null) {
            spec = spec.and(CourseSpecification.hasLanguage(languageId));
        }
        if (categoryId != null) {
            spec = spec.and(CourseSpecification.hasCategory(categoryId));
        }
        if (levelId != null) {
            spec = spec.and(CourseSpecification.hasLevel(levelId));
        }
        log.info("Getting courses taken by student: " + keycloakId);

        Page<Long> courseIds = courseStudentRepository.courseIdsByUserKcId(keycloakId, pageable);
        List<CourseAndProgressDto> takenCourses = new ArrayList<>();

        for (Long courseId : courseIds) {
            Double progress = Objects.requireNonNull(progressService.getProgressByCourseIdAndKcId(courseId, keycloakId).
                    getBody()).getResponse().getProgressPercent();
            CourseEntity courseEntity = courseRepository.findByCourseId(courseId);
            CourseAndProgressDto courseDto = new CourseAndProgressDto();
            courseDto.setId(courseEntity.getCourseId());
            courseDto.setDescription(courseEntity.getDescription());
            courseDto.setLanguageId(courseEntity.getLanguageId().getId());
            courseDto.setLevelId(courseEntity.getLevelId().getId());
            courseDto.setSubCategoryName(courseEntity.getSubCategoryId().getSubCategoryName());
            courseDto.setTitle(courseEntity.getTitle());
            courseDto.setDuration(courseEntity.getDuration());
            courseDto.setLogoUrl(courseBl.url(courseEntity.getTitle()));
            courseDto.setProgressPercent(progress);


            takenCourses.add(courseDto);

        }

        return new PageImpl<>(takenCourses, pageable, courseIds.getTotalElements());
    }



}
