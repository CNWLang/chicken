package com.example.chicken.rs.service;

import com.example.chicken.rs.entity.User;
import com.example.chicken.rs.mapper.UserMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    private static final Logger logger = LogManager.getLogger(UserService.class);

    public User login(String username, String password) {
        try {
            User user = userMapper.findByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                userMapper.onEmail(user.getEmail());
                return user;
            }else {
                return null;
            }
        }catch (Exception ex){
            logger.error(ex);
            return null;
        }
    }

    public boolean register(User user) {
        try {
            int affectedRows = userMapper.insertUser(user);
            return affectedRows>0;
        }catch (Exception ex){
            logger.error(ex);
            return false;
        }
    }

    public boolean state(String email){
        try {
            User user = userMapper.findByUserEmail(email);
            if (user!=null){
                return user.isOnline();
            }else{
                return false;
            }
        }catch (Exception ex){
            logger.error(ex);
            return false;
        }
    }

    public User examine(String username){
        try {
            User user = userMapper.findByUsername(username);
            return user;
        }catch (Exception ex){
            logger.error(ex);
            return null;
        }

    }


}
