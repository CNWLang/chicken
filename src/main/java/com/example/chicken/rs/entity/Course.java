package com.example.chicken.rs.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private Long course_id;//课程id
    private String course_no; //课程号
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String start_date; //课程开始日期
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String end_date; //课程结束日期

    private int course_state; //课程状态：0可选择，1已选择，2授课中，3已结课

    private double course_money; //课程花费
    private String course_student_name; //学生姓名
    private String course_student_usertel; //学生电话
    private String course_teacher; //教师

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }


    public Course(Long course_id, String course_no, String start_date, String end_date, int course_state, double course_money, String course_student_name, String course_student_usertel, String course_teacher) {
        this.course_id = course_id;
        this.course_no = course_no;
        this.start_date = start_date;
        this.end_date = end_date;
        this.course_state = course_state;
        this.course_money = course_money;
        this.course_student_name = course_student_name;
        this.course_student_usertel = course_student_usertel;
        this.course_teacher = course_teacher;
    }

    public Course(String course_no, String start_date, String end_date, int course_state, double course_money, String course_student_name, String course_student_usertel, String course_teacher) {
        this.course_no = course_no;
        this.start_date = start_date;
        this.end_date = end_date;
        this.course_state = course_state;
        this.course_money = course_money;
        this.course_student_name = course_student_name;
        this.course_student_usertel = course_student_usertel;
        this.course_teacher = course_teacher;
    }


    public Course() {

    }
}