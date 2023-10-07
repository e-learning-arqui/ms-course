package com.example.mscourse.entity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "COURSE")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID")
    private Long courseId;

    @Column(name = "TITLE", nullable = false, length = 200)
    private String title;

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Column(name = "STATUS", nullable = false)
    private boolean status;

    @Column(name = "DESCRIPTION", nullable = false, length = 1000)
    private String description;

    @Column(name = "LAST_UPDATE", nullable = false)
    private Date lastUpdate;

    @Column(name = "AMOUNT", nullable = false, precision = 8, scale = 2)
    private BigDecimal amount;

    @Column(name = "VERSION", nullable = false)
    private int version;

    @Column(name = "DURATION", nullable = false)
    private int duration;

    @Column(name = "LANGUAGE_ID", nullable = false)
    private int languageId;

    @Column(name = "LEVEL_ID", nullable = false)
    private int levelId;

    @Column(name = "SUB_CATEGORY_ID", nullable = false)
    private int subCategoryId;

    public CourseEntity() {}

    public CourseEntity(String title, Date startDate, boolean status, String description, Date lastUpdate, BigDecimal amount, int version, int duration, int languageId, int levelId, int subCategoryId) {
        this.title = title;
        this.startDate = startDate;
        this.status = status;
        this.description = description;
        this.lastUpdate = lastUpdate;
        this.amount = amount;
        this.version = version;
        this.duration = duration;
        this.languageId = languageId;
        this.levelId = levelId;
        this.subCategoryId = subCategoryId;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", amount=" + amount +
                ", version=" + version +
                ", duration=" + duration +
                ", languageId=" + languageId +
                ", levelId=" + levelId +
                ", subCategoryId=" + subCategoryId +
                '}';
    }
}




