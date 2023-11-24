package com.example.mscourse.api;

import com.example.mscourse.bl.CourseBl;
import com.example.mscourse.dto.ResponseDto;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseStudentApi {

    @Autowired
    private CourseBl courseBl;

    @PostMapping("/{courseId}/students/{keycloakId}")
    public ResponseEntity<ResponseDto<String>> addStudentToCourse(
            @PathVariable Long courseId,
            @PathVariable String keycloakId
    ) {
        courseBl.addCourseStudent(keycloakId,courseId);

        return ResponseEntity.ok(new ResponseDto<>("0000",
                "Student added to course successfully",
                null));

    }
}
