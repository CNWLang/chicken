package com.example.chicken.rs.controller;

import com.example.chicken.rs.entity.LoginResponse;
import com.example.chicken.rs.entity.RegisterResponse;
import com.example.chicken.rs.entity.User;
import com.example.chicken.rs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody User user) {
        //System.out.println(user);
        User loggedInUser = userService.login(user.getUsername(), user.getPassword());
        if (loggedInUser != null) {
            return ResponseEntity.ok(new LoginResponse(true,loggedInUser.isStudent()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(false,false));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody User user) {
        if (userService.register(user)){
            return ResponseEntity.ok(new RegisterResponse(true));
        }else {
            //System.out.println("1111111111111111111111111111111111111");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new RegisterResponse(false));
        }

    }
}
