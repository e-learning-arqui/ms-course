package com.example.mscourse.dto;

public class CourseAndProgressDto {
    private Long id;
    private String title;
    private String description;
    private int version;
    private int duration;
    private Long languageId;
    private Long levelId;
    private String subCategoryName;
    private String professorKeycloakId;
    private String logoUrl;

    private Double progressPercent;

    // Constructor vacío
    public CourseAndProgressDto() {
    }

    // Constructor con valores

    public CourseAndProgressDto(String title, String description, int version,
                                int duration, Long languageId, Long levelId,
                                String subCategoryName, String professorKeycloakId, String logoUrl,
                                Double progressPercent) {
        this.title = title;
        this.description = description;
        this.version = version;
        this.duration = duration;
        this.languageId = languageId;
        this.levelId = levelId;
        this.subCategoryName = subCategoryName;
        this.professorKeycloakId = professorKeycloakId;
        this.logoUrl = logoUrl;
        this.progressPercent = progressPercent;
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


    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getProgressPercent() {
        return progressPercent;
    }

    public void setProgressPercent(Double progressPercent) {
        this.progressPercent = progressPercent;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
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
                ", subCategoryId=" + subCategoryName +
                ", professorId=" + professorKeycloakId +
                '}';
    }

}
