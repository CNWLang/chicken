package com.example.chicken.rs.mapper;

import com.example.chicken.rs.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUsername(String username);
    User findByUserEmail(String email);
    int insertUser(User user);
    int onEmail(String email);

}
