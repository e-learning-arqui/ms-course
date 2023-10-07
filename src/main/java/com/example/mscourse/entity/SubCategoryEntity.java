package com.example.mscourse.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "SUB_CATEGORY")
public class SubCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUB_CATEGORY_ID")
    private Long subCategoryId;

    @Column(name = "SUB_CATEGORY_NAME", nullable = false, length = 100)
    private String subCategoryName;

    @Column(name = "DESCRIPTION", nullable = false, length = 200)
    private String description;

    @Column(name = "CATEGORY_ID", nullable = false)
    private Long categoryId;

    public SubCategoryEntity() {}

    public SubCategoryEntity(String subCategoryName, String description, Long categoryId) {
        this.subCategoryName = subCategoryName;
        this.description = description;
        this.categoryId = categoryId;
    }

    // Getters and Setters

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "subCategoryId=" + subCategoryId +
                ", subCategoryName='" + subCategoryName + '\'' +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
