package com.example.chicken.rs.mapper;

import com.example.chicken.rs.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    List<User> findStudentList();
    int offEmail(String email);
    int deleteUserByEmail(String email);
    List<User> getUserByEmail(String email);
}
