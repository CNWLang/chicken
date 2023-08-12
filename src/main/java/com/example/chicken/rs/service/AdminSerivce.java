package com.example.chicken.rs.service;

import com.example.chicken.rs.entity.User;
import com.example.chicken.rs.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminSerivce {
    @Autowired
    private AdminMapper adminMapper;

    public List<User> findCustomerList(){
        List<User> result = adminMapper.findStudentList();
        return result;
    }
}
