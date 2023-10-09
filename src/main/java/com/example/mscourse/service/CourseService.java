package com.example.mscourse.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ms-user")
public interface CourseService {
    @GetMapping("/user")
    public String getUser();
}
