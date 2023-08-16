package com.example.chicken.rs.mapper;

import com.example.chicken.rs.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> findCourseList();
    List<Course> findCoursesByIds(@Param("course_id") List<Integer> courseIds);
    int insertCourse(Course course);
}
