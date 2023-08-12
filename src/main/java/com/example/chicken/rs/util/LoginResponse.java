package com.example.chicken.rs.util;

import lombok.Data;

@Data
public class LoginResponse {
    private boolean success;
    private boolean isStudent;

    public LoginResponse(boolean success, boolean isStudent) {
        this.success = success;
        this.isStudent = isStudent;
    }
}