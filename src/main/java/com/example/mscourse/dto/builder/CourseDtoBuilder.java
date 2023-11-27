package com.example.mscourse.dto.builder;

import java.math.BigDecimal;

public class CourseDtoBuilder {
    private Long id;
    private String title;
    private String description;
    private BigDecimal amount;
    private int version;
    private int duration;
    private Long languageId;
    private Long levelId;
    private String subCategoryName;
    private String professorKeycloakId;
    private String logoUrl;

    private Double progressPercent;

    private CourseDtoBuilder(Builder builder){
        this.title = builder.title;
        this.description = builder.description;
        this.amount = builder.amount;
        this.version = builder.version;
        this.duration = builder.duration;
        this.languageId = builder.languageId;
        this.levelId = builder.levelId;
        this.subCategoryName = builder.subCategoryName;
        this.professorKeycloakId = builder.professorKeycloakId;
        this.logoUrl = builder.logoUrl;
        this.progressPercent = builder.progressPercent;
        this.id = builder.id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getProfessorKeycloakId() {
        return professorKeycloakId;
    }

    public void setProfessorKeycloakId(String professorKeycloakId) {
        this.professorKeycloakId = professorKeycloakId;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public static class Builder{
        private Long id;
        private String title;
        private String description;
        private BigDecimal amount;
        private int version;
        private int duration;
        private Long languageId;
        private Long levelId;
        private String subCategoryName;
        private String professorKeycloakId;
        private String logoUrl;
        private Double progressPercent;

        public Builder(){}

        public Builder withTitle(String title){
            this.title = title;
            return this;
        }

        public Builder withDescription(String description){
            this.description = description;
            return this;
        }

        public Builder withAmount(BigDecimal amount){
            this.amount = amount;
            return this;
        }

        public Builder withVersion(int version){
            this.version = version;
            return this;
        }

        public Builder withDuration(int duration){
            this.duration = duration;
            return this;
        }

        public Builder withLanguageId(Long languageId){
            this.languageId = languageId;
            return this;
        }

        public Builder withLevelId(Long levelId){
            this.levelId = levelId;
            return this;
        }

        public Builder withSubCategoryName(String subCategoryName){
            this.subCategoryName = subCategoryName;
            return this;
        }

        public Builder withProfessorKeycloakId(String professorKeycloakId){
            this.professorKeycloakId = professorKeycloakId;
            return this;
        }

        public Builder withLogoUrl(String logoUrl){
            this.logoUrl = logoUrl;
            return this;
        }

        public Builder withProgressPercent(Double progressPercent){
            this.progressPercent = progressPercent;
            return this;
        }

        public Builder withId(Long id){
            this.id = id;
            return this;
        }

        public CourseDtoBuilder build(){
            return new CourseDtoBuilder(this);
        }
    }
}

