package com.learn.spring.demo.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.spring.demo.response.UserDetails;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class UserDetailUtil {


    private UserDetailUtil() {

    }

    public static File getJsonFile() throws IOException {
        ClassPathResource resource = new ClassPathResource("UserDetails.json");
        return resource.getFile();
    }

    public static List<UserDetails> getUserDetails(ObjectMapper objectMapper) throws IOException {
        List<UserDetails> userDetailsList = objectMapper.readValue(UserDetailUtil.getJsonFile(), new TypeReference<List<UserDetails>>() {
        });
        return userDetailsList;
    }

}
