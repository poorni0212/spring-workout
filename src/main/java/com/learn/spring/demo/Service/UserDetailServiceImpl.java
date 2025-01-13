package com.learn.spring.demo.Service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.spring.demo.response.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class UserDetailServiceImpl implements IUserDetailService {
    @Autowired
    private UserDetails userDetails;

    @Override
    public UserDetails users() throws IOException {
       ObjectMapper objectMapper = new ObjectMapper();
       ClassPathResource resource = new ClassPathResource("UserDetails.json");
       File inputFile = resource.getFile();
       JsonNode rootNode = objectMapper.readTree(inputFile);
       userDetails.setId(rootNode.path("id").asInt());
       userDetails.setUserName(rootNode.path("name").asText());
       userDetails.setUserAddress(rootNode.path("address").asText());
       userDetails.setActive(rootNode.path("active").asBoolean());
       return userDetails;
    }
}
