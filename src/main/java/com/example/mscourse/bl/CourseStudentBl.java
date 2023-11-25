package com.example.mscourse.bl;

import com.example.mscourse.dao.CourseStudentRepository;
import com.example.mscourse.entity.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CourseStudentBl {

    @Autowired
    private CourseStudentRepository courseStudentRepository;

    @Autowired
    private CourseBl courseBl;

    Logger log = Logger.getLogger(CourseStudentBl.class.getName());
    public List<CourseEntity> courseIdsTakenByStudent(Long userId) {
        List<CourseEntity> courseIds = courseStudentRepository.courseIdsByUserId(userId);
        for (CourseEntity courseId : courseIds) {
            log.info("Course id: " + courseId.getCourseId());
            log.info("Course id: " + courseId.getTitle());
        }
        return courseIds;
    }


}
