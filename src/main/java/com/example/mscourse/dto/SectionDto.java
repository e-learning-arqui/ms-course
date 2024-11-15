package com.example.mscourse.dto;

public class SectionDto {
    private Long id;
    private Long courseId;
    private String title;
    private String description;
    private Boolean status;

    public SectionDto() {
    }

    public SectionDto(Long sectionId, Long courseId, String title, String description, Boolean status) {
        this.id = sectionId;
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setSectionId(Long sectionId) {
        this.id = sectionId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
