package com.example.mscourse.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
@FeignClient(name = "ms-files")
public interface FileService {

    @PostMapping("/api/v1/files")
    ResponseEntity<String> uploadFile(
            @RequestParam MultipartFile file, @RequestParam String bucketName,
            @RequestParam Long classId);
}
