package com.example.mscourse.bl;

import com.example.mscourse.dao.CategoryRepository;
import com.example.mscourse.dto.CategoryDto;
import com.example.mscourse.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryBl {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryEntity getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public List<CategoryDto> getAllCategories() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (CategoryEntity categoryEntity : categoryEntityList) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategoryId(categoryEntity.getCategoryId());
            categoryDto.setCategoryName(categoryEntity.getCategoryName());
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }

    // obtener las subcategorias por id




}
