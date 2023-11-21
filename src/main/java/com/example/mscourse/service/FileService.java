package com.example.mscourse.service;

import com.example.mscourse.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Service
@FeignClient(name = "ms-files", configuration = FeignConfig.class)
public interface FileService {

    @PostMapping("/api/v1/files")
    ResponseEntity<String> uploadFile(
            @RequestParam MultipartFile file, @RequestParam String bucketName,
            @RequestParam Long classId);

    @PostMapping(value = "/api/v1/files/logo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<String> uploadLogo(
            @RequestParam MultipartFile file, @RequestParam String bucketName,
            @RequestParam String courseName);

    @GetMapping("/api/v1/files/url/logo")
    ResponseEntity<String> getUrlLogo(
//            @RequestHeader("Authorization") String token,
            @RequestParam String courseName);


}
