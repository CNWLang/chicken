package com.example.chicken.rs.mapper;

import com.example.chicken.rs.entity.UserCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCourseMapper {
    List<Integer> findCoursesIdByUserId(int userId);
    int insert(UserCourse userCourse);
}
