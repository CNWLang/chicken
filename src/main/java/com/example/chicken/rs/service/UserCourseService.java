package com.example.chicken.rs.service;

import com.example.chicken.rs.entity.Course;
import com.example.chicken.rs.entity.UserCourse;
import com.example.chicken.rs.mapper.CourseMapper;
import com.example.chicken.rs.mapper.UserCourseMapper;
import com.example.chicken.rs.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCourseService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserCourseMapper userCourseMapper;

    //注解为整体SQL事务
    @Transactional
    public List<Course> getCoursesForStudent(String userEmail) {
        //通过邮箱查询该用户id
        int userId = userMapper.findByUserEmail(userEmail).getId();
        //通过用户id查询该用户所有的课程id
        List<Integer> courseIds = userCourseMapper.findCoursesIdByUserId(userId);
        //通过所有的课程id查询课程详情
        List<Course> courses = courseMapper.findCoursesByIds(courseIds);
        return courses;
    }

    public int insert(UserCourse userCourse) {
        return userCourseMapper.insert(userCourse);
    }

}
