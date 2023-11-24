package com.example.mscourse.dto;

public class StudentDto {

    private Long studentId;
    private String username;

    private String email;

    private boolean status;

    private String keycloakId;

    public StudentDto() {
    }

    public StudentDto(Long studentId, String username, String email, boolean status, String keycloakId) {
        this.studentId = studentId;
        this.username = username;
        this.email = email;
        this.status = status;
        this.keycloakId = keycloakId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getKeycloakId() {
        return keycloakId;
    }

    public void setKeycloakId(String keycloakId) {
        this.keycloakId = keycloakId;
    }
}
