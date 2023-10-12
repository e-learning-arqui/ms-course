package com.example.mscourse.api;

import com.example.mscourse.bl.SectionBl;
import com.example.mscourse.dto.CourseDto;
import com.example.mscourse.dto.ResponseDto;
import com.example.mscourse.dto.SectionDto;
import com.example.mscourse.service.FileService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;
import com.example.mscourse.bl.CourseBl;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.rmi.ServerException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/v1")
public class CourseApi {
    @Autowired
    private CourseBl courseBl;

    @Autowired
    private SectionBl sectionBl;

    @Autowired
    private FileService fileService;

    @PostMapping("/courses")
    public ResponseDto<String> createCourse(@RequestBody CourseDto courseDto) {

        System.out.println("courseDto: " + courseDto.toString());
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


    @GetMapping("/courses")
    public ResponseDto<Page<CourseDto>> getAllCourses(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer languageId,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Integer levelId
    ) {
        ResponseDto<Page<CourseDto>> response = new ResponseDto<>();
        Pageable pageable = PageRequest.of(page, size);
        try {
            Page<CourseDto> CouseDtoPage = courseBl.findAllCourses(pageable, title, languageId, categoryId, levelId);
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

    @GetMapping("/courses/{id}")
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
    @PostMapping("/courses/{id}/register")
    public ResponseDto<String> registerCourse(@PathVariable Long id) {
        ResponseDto<String> response = new ResponseDto<>();
        try {
            //courseBl.registerCourse(id);
            response.setCode("0000");
            response.setResponse("Course registered successfully");
            return response;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }

    }

    @GetMapping("/courses/professor/{professorId}")
    public ResponseEntity<Page<CourseDto>> getCoursesByProfessorId(
            @PathVariable String professorId,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("title").ascending());
        Page<CourseDto> courseDtoPage = courseBl.coursesByProfessorId(professorId, pageable);
        return ResponseEntity.ok(courseDtoPage);
    }


    //Create a section for a course
    @PostMapping("/courses/{id}/sections")
    public ResponseEntity<ResponseDto<String>> createSection(@PathVariable Long id, @RequestBody SectionDto sectionDto) {
        ResponseDto<String> response = new ResponseDto<>();
        try {
            sectionBl.saveSection(sectionDto);
            response.setCode("0000");
            response.setResponse("Section created successfully");
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("courses/classes/{id}/files")
    public ResponseEntity<String> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("bucketName") String bucketName,
            @RequestParam("classId") Long classId

    ) throws ServerException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException {
        fileService.uploadFile(file, bucketName, classId);

        return ResponseEntity.ok("File uploaded successfully");
    }
}




