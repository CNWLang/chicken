package com.example.chicken.rs.service;


import com.example.chicken.rs.entity.User;
import com.example.chicken.rs.entity.Course;

import com.example.chicken.rs.mapper.CourseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


import java.util.List;

@Service
public class CourseService {

    private final CourseMapper CourseMapper;

    @Autowired
    public CourseService(CourseMapper CourseMapper) {
        this.CourseMapper = CourseMapper;
    }

    public List<Course> findCourseList() {
        List<Course> result = CourseMapper.findCourseList();
        return result;
    }

    public List<Course> findCourseListByState(int CourseState) {
        return CourseMapper.findCourseListByState(CourseState);
    }

    public Course getCourseDetailsById(Long CourseId) {
        return CourseMapper.getCourseById(CourseId);
    }

    public void updateCourseStateAndStartDate(Long CourseId, int newState) {
        Map<String, Object> params = new HashMap<>();
        params.put("CourseId", CourseId);
        params.put("newState", newState);
        CourseMapper.updateCourseStateAndStartDate(params);
    }
}
