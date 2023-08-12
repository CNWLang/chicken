package com.example.chicken.rs.util;

import lombok.Data;

@Data
public class LoginResponse {
    private boolean success;
    private boolean student;

    public LoginResponse(boolean success, boolean student) {
        this.success = success;
        this.student = student;
    }
}
