package com.learn.spring.demo.controller;

import com.learn.spring.demo.Service.IUserDetailService;
import com.learn.spring.demo.response.GreetingsResponse;
import com.learn.spring.demo.response.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DemoController {
    @Autowired
    private UserDetails userDetails;

    @Autowired
    private IUserDetailService userDetailsService;

    @GetMapping("/demo/greetings")
    public GreetingsResponse greetings(){
        return new GreetingsResponse( "Welcome to learn Spring Boot Rest Api");
    }

    @GetMapping("/users")
    public UserDetails users() {
        try {
            userDetails = userDetailsService.users();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userDetails;
    }


}
