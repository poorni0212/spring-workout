package com.learn.spring.demo.controller;

import com.learn.spring.demo.Service.IUserDetailService;
import com.learn.spring.demo.response.GreetingsResponse;
import com.learn.spring.demo.response.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class DemoController {
    @Autowired
    private IUserDetailService userDetailsService;

    @GetMapping("/demo/greetings")
    public GreetingsResponse greetings(){
        return new GreetingsResponse( "Welcome to learn Spring Boot Rest Api");
    }

    @GetMapping("/users")
    public ArrayList<UserDetails> users() throws IOException {
        return userDetailsService.users();
    }

    @PostMapping("/users/{id}/{isActive}")
    public String updateUserDetails(@PathVariable("id") int id,@PathVariable("isActive") boolean isActive) throws IOException {
        return userDetailsService.activateOrDeactivateUser(id,isActive);
    }

}
