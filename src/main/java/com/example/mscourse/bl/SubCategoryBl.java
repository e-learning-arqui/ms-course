package com.example.mscourse.bl;

import com.example.mscourse.dto.SubCategoryDto;
import com.example.mscourse.entity.CategoryEntity;
import com.example.mscourse.entity.SubCategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mscourse.dao.SubCategoryRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class SubCategoryBl {
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    public List<SubCategoryDto> findAllSubCategoriesByCategoryId(Long idCategory){
        List<SubCategoryDto> subCategoryDtoList = new ArrayList<>();
        List<SubCategoryEntity> subCategoryEntityList = this.subCategoryRepository.findAllSubCategoriesByCategoryId(idCategory);
        for (SubCategoryEntity subCategoryEntity : subCategoryEntityList) {
            CategoryEntity categoryEntity = subCategoryEntity.getCategoryId();
            SubCategoryDto subCategoryDto = new SubCategoryDto();
            subCategoryDto.setIdSubCategory(subCategoryEntity.getSubCategoryId());
            subCategoryDto.setSubCategoryName(subCategoryEntity.getSubCategoryName());
            subCategoryDto.setIdCategory(categoryEntity.getCategoryId());
            subCategoryDtoList.add(subCategoryDto);
        }
        return subCategoryDtoList;
    }

    public String findSubCategoryNameById(Long idSubCategory){
        SubCategoryEntity subCategoryEntity = this.subCategoryRepository.findById(idSubCategory).orElse(null);
        assert subCategoryEntity != null;
        return subCategoryEntity.getSubCategoryName();
    }


}
