package com.learn.spring.demo.Service;

import com.learn.spring.demo.response.UserDetails;

import java.io.IOException;
import java.util.List;

public interface IUserDetailService {
    List<UserDetails> users() throws IOException;

    String activateOrDeactivateUser(int id, boolean isActive) throws IOException;
}
