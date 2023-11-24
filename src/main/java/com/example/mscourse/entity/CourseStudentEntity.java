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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false, referencedColumnName = "user_id")
    private Student userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false, referencedColumnName = "course_id")
    private CourseEntity courseId;

    public CourseStudentEntity() {}

    public CourseStudentEntity(boolean status, CourseEntity courseId, Student userId) {
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


    public Student getUserId() {
        return userId;
    }

    public void setUserId(Student userId) {
        this.userId = userId;
    }

    public CourseEntity getCourseId() {
        return courseId;
    }

    public void setCourseId(CourseEntity courseId) {
        this.courseId = courseId;
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
