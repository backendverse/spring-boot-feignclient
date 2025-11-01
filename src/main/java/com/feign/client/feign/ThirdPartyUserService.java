package com.feign.client.feign;

import com.feign.client.models.CreateUserRequest;
import com.feign.client.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(url = "${user.service.url}", path = "/users", value = "third-party-user-service")
public interface ThirdPartyUserService {

    @GetMapping("/{id}")
    User getUserById(@PathVariable("id") String id);

    @PostMapping
    User createUser(@RequestBody CreateUserRequest request);

    @DeleteMapping("/{id}")
    String deleteUserById(@PathVariable String id);
}
