package com.example.chicken.rs.controller;

import com.example.chicken.rs.entity.User;
import com.example.chicken.rs.service.UserService;
import com.example.chicken.rs.util.LoginResponse;
import com.example.chicken.rs.util.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //登陆
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody User user) {
        //System.out.println(user);
        User loggedInUser = userService.login(user.getUsername(), user.getPassword());
        if (loggedInUser != null) {
            return ResponseEntity.ok(new LoginResponse(true,loggedInUser.isStudent()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(false,false));
    }

    //注册
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody User user) {
        if (userService.register(user)){
            return ResponseEntity.ok(new RegisterResponse(true));
        }else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new RegisterResponse(false));
        }
    }

    //检验用户是否已经被注册
    @GetMapping("/examine")
    public boolean isExist(@RequestParam String username){
        User user = userService.selectUserByUsername(username);
        if(user!=null){
            return true;
        }
        return false;
    }

    //反转在线状态
    @GetMapping("/re-online")
    public boolean reverseOnline(@RequestBody User user){
        if(userService.reverseOnline(user.getEmail())){
            return true;
        }
        return false;
    }
}
