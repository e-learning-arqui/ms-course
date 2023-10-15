package com.example.mscourse.api;

import com.example.mscourse.bl.CategoryBl;
import com.example.mscourse.bl.SubCategoryBl;
import com.example.mscourse.dto.CategoryDto;
import com.example.mscourse.dto.ResponseDto;
import com.example.mscourse.dto.SubCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin(origins = "*")
public class CategoryApi {

    @Autowired
    private CategoryBl categoryBl;
    @Autowired
    private SubCategoryBl subCategoryBl;

    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable Long id) {
        return categoryBl.getCategoryById(id).toString();
    }

    @GetMapping("/all")
    public ResponseDto<List<CategoryDto>> getAllCategories() {
        ResponseDto<List<CategoryDto>> response = new ResponseDto<>();
        try {
            response.setCode("0000");
            response.setResponse(categoryBl.getAllCategories());
            return response;
        } catch (Exception ex) {
            response.setCode("9999");
            response.setErrorMessage(ex.getMessage());
            return response;
        }
    }

    // obtener las subcategorias por id
    @GetMapping("/{id}/subcategory")
    public ResponseDto<List<SubCategoryDto>> getSubcategories(@PathVariable Long id) {
        ResponseDto<List<SubCategoryDto>> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(subCategoryBl.findAllSubCategoriesByCategoryId(id));
        response.setErrorMessage(null);
        return response;

    }
}
