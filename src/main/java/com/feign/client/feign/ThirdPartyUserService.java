package com.feign.client.feign;

import com.feign.client.models.CreateUserRequest;
import com.feign.client.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(url = "${user.service.url}", path = "/users", value = "third-party-user-service")
public interface ThirdPartyUserService {

    @GetMapping("/{id}")
//    User getUserById(@PathVariable("id") String id, @RequestHeader("api-key") String header);
    User getUserById(@PathVariable("id") String id);

        @PostMapping
//    @RequestMapping(method = RequestMethod.POST, headers = {"api-key=abc"})
    User createUser(@RequestBody CreateUserRequest request);

    @DeleteMapping("/{id}")
//    String deleteUserById(@PathVariable String id, @RequestHeader Map<String, String> headers);
    String deleteUserById(@PathVariable String id);
}
