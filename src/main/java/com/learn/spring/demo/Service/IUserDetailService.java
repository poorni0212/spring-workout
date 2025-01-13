package com.learn.spring.demo.Service;

import com.learn.spring.demo.response.UserDetails;

import java.io.IOException;

public interface IUserDetailService {
    UserDetails users() throws IOException;
}
