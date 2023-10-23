package com.example.mscourse.dto;

import java.math.BigDecimal;

public class CourseDto {
    private String title;
    private String description;
    private int version;
    private int duration;
    private Long languageId;
    private Long levelId;
    private Long subCategoryId;
    private String professorKeycloakId;

    private String logoUrl;

    // Constructor vacío
    public CourseDto() {
    }

    // Constructor con valores
    public CourseDto(String title, String description,  int version, int duration, Long languageId, Long levelId,
                     Long subCategoryId, String professorKeycloakIdId, String logoUrl) {
        this.title = title;
        this.description = description;
        this.version = version;
        this.duration = duration;
        this.languageId = languageId;
        this.levelId = levelId;
        this.subCategoryId = subCategoryId;
        this.professorKeycloakId = professorKeycloakIdId;
        this.logoUrl = logoUrl;
    }

    // Getters

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public int getVersion() {
        return version;
    }

    public int getDuration() {
        return duration;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public Long getLevelId() {
        return levelId;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public String getProfessorKeycloakId() {
        return professorKeycloakId;
    }
    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setVersion(int version) {
        this.version = version;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public void setProfessorKeycloakId(String professorKeycloakId) {
        this.professorKeycloakId = professorKeycloakId;
    }
    // Método toString
    @Override
    public String toString() {
        return "CourseDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", version=" + version +
                ", duration=" + duration +
                ", languageId=" + languageId +
                ", levelId=" + levelId +
                ", subCategoryId=" + subCategoryId +
                ", professorId=" + professorKeycloakId +
                '}';
    }
}