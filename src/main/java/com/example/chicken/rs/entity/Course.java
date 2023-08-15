package com.example.chicken.rs.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;//课程id
    private String course_no; //课程号
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String start_date; //课程开始日期
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String end_date; //课程结束日期
    private int course_state; //课程状态：0可选择，1已选择，2授课中，3已结课
    private double course_money; //课程花费
    private String course_teacher_phone; //教师电话
    private String course_teacher; //教师

}