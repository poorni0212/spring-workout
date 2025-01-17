package com.learn.spring.demo.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.spring.demo.response.UserDetails;
import com.learn.spring.demo.util.UserDetailUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author Poornima
 * <p>
 * Description: This class is used to implement the display the user details and activate or deactivate the user.
 */

@Service
public class UserDetailServiceImpl implements IUserDetailService {

    private final ObjectMapper objectMapper;
    private final List<UserDetails> userDetailList;

    private HashMap<Integer, UserDetails> userDetailMap;

    public UserDetailServiceImpl(ObjectMapper objectMapper) throws IOException {
        this.objectMapper = objectMapper;
        userDetailList = UserDetailUtil.getUserDetails(objectMapper);
        userDetailMap = userDetailList.stream().collect(Collectors.toMap(UserDetails::getId, userDetails -> userDetails, (oldValue, newValue) -> newValue, HashMap::new));
    }

    @Override
    public List<UserDetails> users() {
        return userDetailList;
    }

    @Override
    public String activateOrDeactivateUser(int id, boolean isActive) {
        userDetailMap.get(id).setActive(isActive);
        System.out.println("result :" + userDetailMap);
        return "User Activated/Deactivated Successfully";
    }

    public HashMap<Integer, UserDetails> getUserDetailMap() {
        return userDetailMap;
    }


}
