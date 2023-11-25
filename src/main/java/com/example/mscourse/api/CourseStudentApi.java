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

    @GetMapping("/students/{keycloakId}")
    public ResponseEntity<ResponseDto<List<CourseDto>>> coursesTakenByStudent(
            @PathVariable String keycloakId
    ) {
       List<CourseDto> coursesTakenByStudent = courseStudentBl.courseIdsTakenByStudent(keycloakId);



        return ResponseEntity.ok(new ResponseDto<>("0000",
                coursesTakenByStudent,
        null));

    }

}
