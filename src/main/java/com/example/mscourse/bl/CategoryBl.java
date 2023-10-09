package com.example.mscourse.bl;

import com.example.mscourse.dao.CategoryRepository;
import com.example.mscourse.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryBl {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryEntity getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }


}
