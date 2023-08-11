package com.example.chicken.rs.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    int id;
    private String actionTime;
    private int actions;
    private String addressCity;
    private String addressProvince;
    private String email;
    private boolean isStudent;
    private boolean online;
    private String password;
    private String regTime;
    private String trueName;
    private String username;

}
