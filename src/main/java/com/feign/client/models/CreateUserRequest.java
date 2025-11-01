package com.feign.client.models;

import lombok.Data;

@Data
public class CreateUserRequest {

    private String name;
    private String email;
}
