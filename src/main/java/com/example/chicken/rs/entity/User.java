package com.example.chicken.rs.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String actionTime;
    private int actions;
    private String addressCity;
    private String addressProvince;
    private String email;
    private boolean student;
    private boolean online;
    private String password;
    private String regTime;
    private String trueName;
    private String username;

}
