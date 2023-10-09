package com.example.mscourse.api;

import com.example.mscourse.dto.CourseDto;
import com.example.mscourse.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import com.example.mscourse.bl.CourseBl;

@RestController
@RequestMapping("/api/v1")
public class CourseApi {
    @Autowired
    private CourseBl courseBl;

    @PostMapping("/course")
    public ResponseDto<String> createCourse(@RequestBody CourseDto courseDto) {


        ResponseDto<String> response = new ResponseDto<>();
        try {
            courseBl.saveCourse(courseDto);
            response.setCode("0000");
            response.setResponse("Course created successfully");
            return response;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }

    }


    @GetMapping("/course")
    public ResponseDto<Page<CourseDto>> getAllCourses(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        ResponseDto<Page<CourseDto>> response = new ResponseDto<>();
        Pageable pageable = PageRequest.of(page, size);
        try {
            Page<CourseDto> CouseDtoPage = courseBl.findAllCourses(pageable);
            response.setCode("0000");
            response.setResponse(CouseDtoPage);
            return response;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }

    }

    @GetMapping("/course/{id}")
    public ResponseDto<CourseDto> getCourseById(@PathVariable Long id) {
        ResponseDto<CourseDto> response = new ResponseDto<>();
        try {
            CourseDto courseDto = courseBl.findById(id);
            response.setCode("0000");
            response.setResponse(courseDto);
            return response;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }

    }

    //Register course for user
    @PostMapping("/course/{id}/register")
    public ResponseDto<String> registerCourse(@PathVariable Long id) {
        ResponseDto<String> response = new ResponseDto<>();
        try{
            //courseBl.registerCourse(id);
            response.setCode("0000");
            response.setResponse("Course registered successfully");
            return response;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }

    }


}
