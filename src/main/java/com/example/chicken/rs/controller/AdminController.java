package com.example.chicken.rs.controller;

import com.example.chicken.rs.entity.User;
import com.example.chicken.rs.service.AdminService;
import com.example.chicken.rs.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    //查询学生名单
    @GetMapping("/findStudentList")
    public ResponseEntity<Result> findStudentList() {
        List<User> StudentList = adminService.findStudentList();
        //PageInfo pageInfo = new PageInfo(StudentList);
        if (StudentList != null) {
            return ResponseEntity.ok(Result.success(StudentList, "成功查询"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.error("服务器内部错误"));
        }
    }

    //下线-在线状态
    @PostMapping("/off-online")
    public boolean offOnline(@RequestBody User user) {
        if (adminService.offOnline(user.getEmail())) {
            return true;
        }else {
            return false;
        }
    }

    //通过邮箱删除对应用户
    @DeleteMapping("/deleteByEmail")
    public boolean deleteUser(@RequestBody User user) {
        if (adminService.deleteUserByEmail(user.getEmail())) {
            return true;
        } else {
            return false;
        }
    }

    //通过邮箱查询特定用户
    @GetMapping("/getUserDetails")
    public ResponseEntity<Result> getUserDetails(@RequestBody User user) {
        List<User> userList = adminService.getUserByEmail(user.getEmail());
        if (userList != null) {
            return ResponseEntity.ok(Result.success(userList, "成功查询"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.error("服务器内部错误"));
        }
    }

}
