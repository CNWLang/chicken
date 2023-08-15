package com.example.chicken.rs.entity;

import lombok.Data;

@Data
public class UserCourse {
    private int userId;
    private int courseId;
    private String dateEnrolled;
    private String grade;
}

