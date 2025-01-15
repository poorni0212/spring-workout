package com.learn.spring.demo.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.learn.spring.demo.response.UserDetails;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class UserDetailServiceImpl implements IUserDetailService {

    @Override
    public ArrayList<UserDetails> users() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("UserDetails.json");
        ArrayList<UserDetails> userDetailsList = objectMapper.readValue(resource.getFile(), new TypeReference<ArrayList<UserDetails>>() {
        });
        return userDetailsList;
    }

    @Override
    public String activateOrDeactivateUser(int id, boolean isActive) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("UserDetails.json");
        ArrayList<UserDetails> userDetailsList = objectMapper.readValue(resource.getFile(), new TypeReference<ArrayList<UserDetails>>() {
        });

        ArrayNode arrayObject = objectMapper.createArrayNode();

        userDetailsList.forEach((userDetailsObj) -> {
            try {
                if (userDetailsObj.getId() == id) {
                    setJsonNodes(objectMapper, resource, arrayObject, userDetailsObj, isActive);
                } else {
                    setJsonNodes(objectMapper, resource, arrayObject, userDetailsObj, userDetailsObj.isActive());
                }
            } catch (IOException e) {
                throw new RuntimeException("Error while updating user details");
            }

        });


        return "User Activated/Deactivated Successfully";
    }

    private void setJsonNodes(ObjectMapper objectMapper, ClassPathResource resource, ArrayNode arrayObject, UserDetails userDetailsObj, boolean isActive) throws IOException {
        ObjectNode jsonObject = objectMapper.createObjectNode();
        jsonObject.put("id", userDetailsObj.getId());
        jsonObject.put("userName", userDetailsObj.getName());
        jsonObject.put("address", userDetailsObj.getAddress());
        jsonObject.put("active", isActive);
        arrayObject.add(jsonObject);
        objectMapper.writeValue(resource.getFile(), arrayObject);
    }
}
