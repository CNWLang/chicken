package com.example.chicken.rs.controller;


import com.example.chicken.rs.entity.Course;
import com.example.chicken.rs.service.CourseService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.chicken.rs.util.Result;

import java.util.List;


@RestController
@RequestMapping("/Course")
public class CourseController {
    @Autowired
    CourseService CourseService;

    @GetMapping("/findCourseList")
    public Result CourseList() {
        List<Course> CourseList = CourseService.findCourseList();
        PageInfo pageInfo = new PageInfo(CourseList);
        return Result.success(pageInfo, "成功查询");
    }

    @GetMapping("/Courses")
    public List<Course> getCourses(@RequestParam int CourseState) {
        return CourseService.findCourseListByState(CourseState);
    }

    @GetMapping("/Course/{CourseId}")
    public Course getCourseDetails(@PathVariable Long CourseId) {
        return CourseService.getCourseDetailsById(CourseId);
    }

    @PostMapping("/updateCourse")
    public void updateCourse(@RequestParam Long CourseId, @RequestParam int newState) {
        CourseService.updateCourseStateAndStartDate(CourseId, newState);
    }

}