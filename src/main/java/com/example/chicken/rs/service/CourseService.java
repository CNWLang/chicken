package com.example.chicken.rs.service;


import com.example.chicken.rs.entity.Course;
import com.example.chicken.rs.entity.UserCourse;
import com.example.chicken.rs.mapper.CourseMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseMapper CourseMapper;
    @Autowired
    private UserCourseService userCourseService;
    private static final Logger logger = LogManager.getLogger(CourseService.class);

    public List<Course> findCourseList() {
        try {
            List<Course> result = CourseMapper.findCourseList();
            return result;
        }catch (Exception exception){
            logger.error(exception);
            return null;
        }
    }

    public boolean enrollUserCourse(UserCourse userCourse) {
        try {
            int affectedRows = userCourseService.insert(userCourse);
            return affectedRows>0;
        } catch (Exception e) {
            logger.error(e);
            return false;
        }
    }

    public List<Course> getCoursesForStudent(String email) {
         try {
             List<Course> courses=userCourseService.getCoursesForStudent(email);
            if (courses!=null){
                return courses;
            }else {
                return null;
            }
         }catch (Exception exception){
             logger.error(exception);
             return null;
         }
    }

}
