package com.Bankgos.bank.controller;


import com.Bankgos.bank.model.User;
import com.Bankgos.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody Map<String,String> credentials)
    {
        try
        {
            String username = credentials.get("username");
            String password = credentials.get("password");
            User user = userService.login(username,password);
            return ResponseEntity.ok(user);
        }
        catch (Exception e){
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }




    }

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody User user)
    {
        try
        {
           User newUser=userService.register(user);
            return ResponseEntity.ok(newUser);
        }
        catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }




    }

    @GetMapping("/{userId}/balance")

        public ResponseEntity<?> getBalance (@PathVariable Long userId)
        {
            try
            {
                double balance =userService.getBalance(userId);

                return ResponseEntity.ok(Collections.singletonMap("balance",balance));
            }
            catch (Exception e){
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
        }



}