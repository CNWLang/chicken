package com.example.chicken.rs.entity;

import lombok.Data;

@Data
public class RegisterResponse {
    private boolean success;

    public RegisterResponse(boolean success) {
        this.success = success;
    }
}
