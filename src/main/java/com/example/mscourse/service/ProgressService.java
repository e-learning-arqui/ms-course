package com.example.mscourse.service;

import com.example.mscourse.dto.ProgressDto;
import com.example.mscourse.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "ms-assignment")
public interface ProgressService {

    @GetMapping("/api/v1/progress/{courseId}/student/{kcId}")
    ResponseEntity<ResponseDto<ProgressDto>> getProgressByCourseIdAndKcId
            (@PathVariable Long courseId,
             @PathVariable String kcId);
}


