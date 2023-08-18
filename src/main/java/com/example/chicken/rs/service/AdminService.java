package com.example.chicken.rs.service;

import com.example.chicken.rs.entity.User;
import com.example.chicken.rs.mapper.AdminMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    private static final Logger logger = LogManager.getLogger(AdminService.class);

    public List<User> findStudentList(){
        try {
            List<User> result = adminMapper.findStudentList();
            //System.out.println("findStudentList"+result);
            return result;
        }catch (Exception exception){
            logger.error(exception);
            return null;
        }
    }

    public  boolean offOnline(String email){
        try {
            int affectedRows = adminMapper.offEmail(email);
            return affectedRows>0;
        }catch (Exception ex){
            logger.error(ex);
            return false;
        }
    }

    public boolean deleteUserByEmail(String email) {
        try {
            int affectedRows = adminMapper.deleteUserByEmail(email);
            boolean Result=(affectedRows>0);
            logger.info("deleteUserByEmail:   " + email +"   "+Result);
            return Result;
        } catch (Exception e) {
            logger.error(e);
            return false;
        }
    }

    public List<User> getUserByEmail(String email) {
        try {
            return adminMapper.getUserByEmail(email);
        }catch (Exception e){
            logger.error(e);
            return null;
        }
    }
}
