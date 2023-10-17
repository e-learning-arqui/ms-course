package com.example.mscourse.api;

import com.example.mscourse.bl.SectionBl;
import com.example.mscourse.dto.CourseDto;
import com.example.mscourse.dto.ResponseDto;
import com.example.mscourse.dto.SectionDto;
import com.example.mscourse.service.FileService;
import feign.Request;
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
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class CourseApi {
    @Autowired
    private CourseBl courseBl;

    @Autowired
    private SectionBl sectionBl;

    @Autowired
    private FileService fileService;

    @PostMapping("/courses")
    public ResponseDto<Long> createCourse(
            @RequestBody CourseDto courseDto
            ) {

        System.out.println("courseDto: " + courseDto.toString());
        ResponseDto<Long> response = new ResponseDto<>();

        try {

            response.setCode("0000");
            response.setResponse(courseBl.saveCourse(courseDto));
            return response;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }

    }

    @CrossOrigin(origins = "*")
    @PostMapping("/courses/logo")
    public ResponseDto<String> uploadLogo(@RequestParam("file") MultipartFile file,
                                          @RequestParam("bucketName") String bucketName,
                                          @RequestParam("courseName") String courseName) {
        ResponseDto<String> response = new ResponseDto<>();
        System.out.println("courseName: " + courseName);
        try {

            fileService.uploadLogo(file, bucketName, courseName);
            response.setCode("0000");
            response.setResponse("Logo uploaded successfully");

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




