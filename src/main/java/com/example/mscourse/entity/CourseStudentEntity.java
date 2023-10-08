package com.example.mscourse.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "COURSE_STUDENT")
public class CourseStudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_USER_ID")
    private Long courseUserId;

    @Column(name = "STATUS", nullable = false)
    private boolean status;

    @Column(name = "COURSE_ID", nullable = false)
    private Long courseId;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    public CourseStudentEntity() {}

    public CourseStudentEntity(boolean status, Long courseId, Long userId) {
        this.status = status;
        this.courseId = courseId;
        this.userId = userId;
    }

    // Getters and Setters

    public Long getCourseUserId() {
        return courseUserId;
    }

    public void setCourseUserId(Long courseUserId) {
        this.courseUserId = courseUserId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CourseStudent{" +
                "courseUserId=" + courseUserId +
                ", status=" + status +
                ", courseId=" + courseId +
                ", userId=" + userId +
                '}';
    }
}
