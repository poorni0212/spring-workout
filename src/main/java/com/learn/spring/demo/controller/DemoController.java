package com.learn.spring.demo.controller;

import com.learn.spring.demo.Service.IUserDetailService;
import com.learn.spring.demo.response.GreetingsResponse;
import com.learn.spring.demo.response.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class DemoController {

    private final IUserDetailService userDetailsService;

    public DemoController(IUserDetailService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/demo/greetings")
    public GreetingsResponse greetings(){
        return new GreetingsResponse( "Welcome to learn Spring Boot Rest Api");
    }

    @GetMapping("/users")
    public List<UserDetails> users() throws IOException {
        return userDetailsService.users();
    }

    @PutMapping("/users/{id}/{isActive}")
    public String updateUserDetails(@PathVariable("id") int id,@PathVariable("isActive") boolean isActive) throws IOException {
        return userDetailsService.activateOrDeactivateUser(id,isActive);
    }

}
