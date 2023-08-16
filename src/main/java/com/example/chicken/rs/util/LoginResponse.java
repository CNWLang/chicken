package com.example.chicken.rs.util;

import lombok.Data;

@Data
public class LoginResponse {
    private boolean success;
    private boolean student;
    private String email;
    private int id;

    public LoginResponse(boolean success, boolean student, String email,int id) {
        this.success = success;
        this.student = student;
        this.email = email;
        this.id=id;
    }
}
