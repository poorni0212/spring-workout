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
    public ArrayList<UserDetails> users() {
        ArrayList<UserDetails>  userDetailsList = new ArrayList<UserDetails>();
        try {
            userDetailsList = userDetailsService.users();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userDetailsList;
    }

    @GetMapping("/users/{id}/{isActive}")
    public String updateUserDetails(@PathVariable("id") int id,@PathVariable("isActive") boolean isActive) {
        try {
            String response = userDetailsService.activateOrDeactivateUser(id,isActive);
            return response;
        } catch (Exception e) {
            return e.toString();
        }
    }

}
