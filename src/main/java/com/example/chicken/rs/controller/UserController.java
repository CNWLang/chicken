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
        User loggedInUser = userService.login(user.getUsername(), user.getPassword());
        if (loggedInUser != null) {
            return ResponseEntity.ok(new LoginResponse(true,loggedInUser.isStudent(),loggedInUser.getEmail(),loggedInUser.getId()));
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(false,false,null,0));
        }
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

    //用户状态
    @PostMapping("/state")
    public boolean state(@RequestBody User user) {
        if (userService.state(user.getEmail())){
            return true;
        }else {
            return false;
        }
    }

    //检验用户名是否已经被注册
    @GetMapping("/examine")
    public boolean examine(@RequestParam String username){
        User user = userService.examine(username);
        if(user!=null){
            return true;
        }else {
            return false;
        }
    }

    @PostMapping("/moodType")
    public boolean updateMoodType(@RequestBody user_mood u){
        try {
            boolean result = userService.updateWordsMood(u.getUser_email(),u.getWords(),u.getMoodType());
            if(result){
                return true;
            }
            else{
                return false;
            }
        }catch (Exception e){
            return false;
        }

    }

}
