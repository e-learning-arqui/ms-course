package com.example.mscourse.api;

import com.example.mscourse.bl.ClassBl;
import com.example.mscourse.dto.ClassDto;
import com.example.mscourse.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/courses")
public class ClassApi {

    @Autowired
    private ClassBl classBl;


    Logger log = Logger.getLogger(ClassApi.class.getName());

    @PostMapping("/sections/{id}/classes")
    public ResponseEntity<ResponseDto<Long>> createClass(@PathVariable Long id, @RequestBody ClassDto classDto) {
        ResponseDto<Long> response = new ResponseDto<>();
        log.info("Starting to create a class from section: " + id);
        try {
            Long classId = classBl.saveClass(classDto);
            response.setCode("0000");
            response.setResponse(classId);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

    }

    @GetMapping("{courseId}/classes/all")
    public ResponseEntity<ResponseDto<List<ClassDto>>> getClassesByCourseId
            (@PathVariable Long courseId) {
        ResponseDto<List<ClassDto>> response = new ResponseDto<>();
        try {
            List<ClassDto> classes = classBl.classesByCourseId(courseId);
            response.setCode("0000");
            response.setResponse(classes);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

    }

    @GetMapping("/classes/{classId}")
    public ResponseEntity<ResponseDto<ClassDto>> getClassById(@PathVariable Long classId) {
        ResponseDto<ClassDto> response = new ResponseDto<>();
        try {
            ClassDto classDto = classBl.getClassById(classId);
            response.setCode("0000");
            response.setResponse(classDto);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

    }

    @GetMapping("sections/{sectionId}/classes")
    public ResponseEntity<ResponseDto<List<ClassDto>>> findClassesBySectionId(@PathVariable Long sectionId) {
        ResponseDto<List<ClassDto>> response = new ResponseDto<>();
        try {
            List<ClassDto> classDtoList = classBl.findClassesBySectionId(sectionId);
            response.setCode("0000");
            response.setResponse(classDtoList);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

    }

}
