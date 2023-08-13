package com.example.chicken.rs.service;

import com.example.chicken.rs.entity.User;

import com.example.chicken.rs.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public boolean register(User user) {
        try {
            int affectedRows = userMapper.insertUser(user);
            return affectedRows>0;
        }catch (Exception ex){
            return false;
        }
    }

    public User selectUserByUsername(String username){
        User u = userMapper.findByUsername(username);
        if(u!= null){
            return u;
        }
        return null;
    }

    public  boolean reverseOnline(String email){
        try {
            int affectedRows = userMapper.reverseEmail(email);
            return affectedRows>0;
        }catch (Exception ex){
            return false;
        }
    }

}
