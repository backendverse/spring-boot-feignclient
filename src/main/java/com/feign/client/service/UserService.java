package com.feign.client.service;

import com.feign.client.feign.ThirdPartyUserService;
import com.feign.client.models.CreateUserRequest;
import com.feign.client.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final ThirdPartyUserService userService;

    public User getUserById(String id) {
        return userService.getUserById(id);
    }

    public User createUser(CreateUserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    public String deleteUserById(String id) {
        return userService.deleteUserById(id);
    }

}
