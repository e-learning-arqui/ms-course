package com.example.mscourse.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "LANGUAGE")
public class LanguageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LANGUAGE_ID")
    private Long languageId;

    @Column(name = "NAME", nullable = false, length = 200)
    private String name;

    public LanguageEntity() {}

    public LanguageEntity(String name) {
        this.name = name;
    }

    // Getters and Setters

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Language{" +
                "languageId=" + languageId +
                ", name='" + name + '\'' +
                '}';
    }
}
