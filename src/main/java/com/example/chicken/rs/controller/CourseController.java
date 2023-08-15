package com.example.chicken.rs.controller;


import com.example.chicken.rs.entity.Course;
import com.example.chicken.rs.entity.User;
import com.example.chicken.rs.entity.UserCourse;
import com.example.chicken.rs.service.CourseService;
import com.example.chicken.rs.service.UserCourseService;
import com.example.chicken.rs.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Course")
public class CourseController {
    @Autowired
    CourseService CourseService;

    @Autowired
    UserCourseService userCourseService;

    //查询课程列表
    @GetMapping("/findCourseList")
    public ResponseEntity<Result> CourseList() {
        List<Course> CourseList = CourseService.findCourseList();
        if (CourseList != null) {
            return ResponseEntity.ok(Result.success(CourseList, "成功查询"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.error("服务器内部错误"));
        }
    }

    //学生选课
    @PostMapping("/enroll")
    public boolean enrollUserInCourse(@RequestBody UserCourse userCourse) {
        if (CourseService.enrollUserCourse(userCourse)){
            return true;
        }else {
            return false;
        }

    }

    //查询特定学生已选课程
    @GetMapping("/enrolledCourses")
    public ResponseEntity<Result> getCoursesForStudent(@RequestBody User user) {
        List<Course> CourseList = CourseService.getCoursesForStudent(user.getEmail());
        if (CourseList != null) {
            return ResponseEntity.ok(Result.success(CourseList, "成功查询"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.error("服务器内部错误"));
        }
    }
}