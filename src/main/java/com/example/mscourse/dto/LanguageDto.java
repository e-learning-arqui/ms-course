package com.example.mscourse.dto;

public class LanguageDto {

private Long languageId;
    private String languageName;

    public LanguageDto() {}

    public LanguageDto(Long languageId, String languageName) {
        this.languageId = languageId;
        this.languageName = languageName;
    }

    // getters setters y to string
    public Long getLanguageId() {return languageId;}

    public void setLanguageId(Long languageId) {this.languageId = languageId;}

    public String getLanguageName() {return languageName;}

    public void setLanguageName(String languageName) {this.languageName = languageName;}

    @Override
    public String toString() {
        return "Language{" +
                "languageId=" + languageId +
                ", languageName='" + languageName + '\'' +
                '}';
    }
}
