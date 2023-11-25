package com.example.mscourse.api;

import com.example.mscourse.bl.CourseBl;
import com.example.mscourse.bl.CourseStudentBl;
import com.example.mscourse.dto.CourseDto;
import com.example.mscourse.dto.ResponseDto;
import com.example.mscourse.entity.CourseEntity;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseStudentApi {

    @Autowired
    private CourseBl courseBl;
    @Autowired
    private CourseStudentBl courseStudentBl;

    @PostMapping("/students/{keycloakId}")
    public ResponseEntity<ResponseDto<String>> addStudentToCourse(
            @RequestParam("courseName") String courseTitle,
            @PathVariable String keycloakId
    ) {
        courseBl.addCourseStudent(keycloakId,courseTitle);

        return ResponseEntity.ok(new ResponseDto<>("0000",
                "Student added to course successfully",
                null));

    }

    @GetMapping("/students/{id}")
    public ResponseEntity<ResponseDto<List<CourseDto>>> coursesTakenByStudent(
            @PathVariable Long id
    ) {
       List<CourseEntity> courseIds = courseStudentBl.courseIdsTakenByStudent(id);
         List<CourseDto> courseDtos = new ArrayList<>();
        for (CourseEntity courseId : courseIds) {
            CourseDto courseDto = new CourseDto();
            courseDto.setId(courseId.getCourseId());
            courseDto.setTitle(courseId.getTitle());
            courseDtos.add(courseDto);
    }

        return ResponseEntity.ok(new ResponseDto<>("0000",
                courseDtos,
        "Courses taken by student"));

    }

}
