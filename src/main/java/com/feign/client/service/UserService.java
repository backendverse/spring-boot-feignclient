package com.feign.client.service;

import com.feign.client.feign.ThirdPartyUserService;
import com.feign.client.models.CreateUserRequest;
import com.feign.client.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final ThirdPartyUserService userService;

    public User getUserById(String id) {
//        return userService.getUserById(id, "12345");
        return userService.getUserById(id);
    }

    public User createUser(CreateUserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    public String deleteUserById(String id) {
        Map<String, String> abc = Map.of("api-key", "123",
                "abc", "7890");

//        return userService.deleteUserById(id, abc);
        return userService.deleteUserById(id);
    }

}
