package com.example.chicken.rs.controller;

import com.example.chicken.rs.entity.User;
import com.example.chicken.rs.service.AdminService;
import com.example.chicken.rs.util.LoginResponse;
import com.example.chicken.rs.util.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/findStudentList")
    public ResponseEntity<Result> findStudentList()
    {
        try {
            List<User> StudentList = adminService.findCustomerList();
            //PageInfo pageInfo = new PageInfo(StudentList);
            return ResponseEntity.ok(Result.success(StudentList, "成功查询"));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.error("服务器内部错误"));
        }

    }

}
