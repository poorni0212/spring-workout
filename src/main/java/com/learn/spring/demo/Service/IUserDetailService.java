package com.learn.spring.demo.Service;

import com.learn.spring.demo.response.UserDetails;

import java.io.IOException;
import java.util.ArrayList;

public interface IUserDetailService {
    ArrayList<UserDetails> users() throws IOException;
    String activateOrDeactivateUser(int id, boolean isActive) throws IOException;
}
