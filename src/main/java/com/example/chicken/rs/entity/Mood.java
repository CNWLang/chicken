package com.example.chicken.rs.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Mood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    String mood;

}
