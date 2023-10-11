package com.example.mscourse.dto;

public class SubCategoryDto {

    private Long idSubCategory;
    private String subCategoryName;
    private Long idCategory;

    public SubCategoryDto() {}

    public SubCategoryDto(String subCategoryName, Long idCategory,Long idSubCategory) {
        this.subCategoryName = subCategoryName;
        this.idCategory = idCategory;
        this.idSubCategory = idSubCategory;
    }

    //getters

    public Long getIdSubCategory() {
        return idSubCategory;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public Long getIdCategory() {
        return idCategory;
    }





    //setters

    public void setIdSubCategory(Long idSubCategory) {
        this.idSubCategory = idSubCategory;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }




}

