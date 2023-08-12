package com.example.chicken.rs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.chicken.rs.entity.Course;

import java.util.List;
import java.util.Map;

@Mapper

public interface CourseMapper {
    List<Course> findCourseList();

    List<Course> findCourseListByState(int courseState);

    Course getCourseById(Long courseId);

    void updateCourseStateAndStartDate(Map<String, Object> params);
}
