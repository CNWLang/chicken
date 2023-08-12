package com.example.chicken.rs.controller;

import com.example.chicken.rs.entity.User;
import com.example.chicken.rs.service.AdminSerivce;
import com.example.chicken.rs.util.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminSerivce adminSerivce;

    @GetMapping("/findStudentList")
    public Result findStudentList()
    {

        List<User> StudentList = adminSerivce.findCustomerList();
        //分页对象
        PageInfo pageInfo = new PageInfo(StudentList);
        return Result.success(pageInfo, "成功查询");
    }

}
