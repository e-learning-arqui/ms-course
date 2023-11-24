package com.example.mscourse.entity;

import jakarta.persistence.*;

@Entity(name = "progress")
public class ProgressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long progressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_course_id", nullable = false, referencedColumnName = "course_id")
    private CourseEntity courseId;

    @Column(name = "progress_percent")
    private Double progressPercent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id", nullable = false, referencedColumnName = "user_id")
    private Student actorId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", nullable = false, referencedColumnName = "class_id")
    private ClassEntity classId;
}
