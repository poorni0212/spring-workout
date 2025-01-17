package com.learn.spring.demo.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.spring.demo.Service.UserDetailServiceImpl;
import com.learn.spring.demo.response.UserDetails;
import com.learn.spring.demo.util.UserDetailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class WriteFileOnGracefulShutdown implements ApplicationListener<ContextClosedEvent> {

    @Autowired
    public UserDetailServiceImpl userDetailServiceImpl;
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("Graceful termination");
        try (FileWriter file = new FileWriter(UserDetailUtil.getJsonFile())) {
            ObjectMapper mapper = new ObjectMapper();
            List<UserDetails> userDetailList = new ArrayList<>(userDetailServiceImpl.getUserDetailMap().values());
            mapper.writeValue(file,userDetailList );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
