package com.example.mscourse.api;

import com.example.mscourse.bl.ClassBl;
import com.example.mscourse.dto.ClassDto;
import com.example.mscourse.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/courses")
public class ClassApi {

    @Autowired
    private ClassBl classBl;


    Logger log = Logger.getLogger(ClassApi.class.getName());

    @PostMapping("/sections/{id}/classes")
    public ResponseEntity<ResponseDto<String>> createClass(@PathVariable Long id, @RequestBody ClassDto classDto) {
        ResponseDto<String> response = new ResponseDto<>();
        log.info("Starting to create a class from section: " + id);
        try {
            classBl.saveClass(classDto, id);
            response.setCode("0000");
            response.setResponse("Class created successfully");
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

    }

    @GetMapping("{courseId}/classes/all")
    public ResponseEntity<ResponseDto<Page<ClassDto>>> getClassesByCourseId
            (@PathVariable Long courseId,
             @RequestParam Integer page,
             @RequestParam Integer size) {
        ResponseDto<Page<ClassDto>> response = new ResponseDto<>();
        try {
            Page<ClassDto> classes = classBl.getClassesByCourseId(courseId, page, size);
            response.setCode("0000");
            response.setResponse(classes);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

    }

}
