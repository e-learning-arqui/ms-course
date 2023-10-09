package com.example.mscourse.api;

import com.example.mscourse.bl.CategoryBl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryApi {

    @Autowired
    private CategoryBl categoryBl;

    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable Long id) {
        return categoryBl.getCategoryById(id).toString();
    }
}
