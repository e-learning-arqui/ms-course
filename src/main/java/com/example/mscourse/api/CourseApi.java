package com.example.mscourse.api;

import com.example.mscourse.dto.CourseDto;
import com.example.mscourse.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.mscourse.bl.CourseBl;

@RestController
@RequestMapping("/api/v1")
public class CourseApi {
    @Autowired
    private CourseBl courseBl;
    @PostMapping("/course")
    public ResponseDto<String> createCourse(@RequestBody CourseDto courseDto) {
        ResponseDto<String> response = new ResponseDto<>();
        try{
            courseBl.saveCourse(courseDto);
            response.setCode("0000");
            response.setResponse("Course created successfully");
            return response;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }

    }

}
