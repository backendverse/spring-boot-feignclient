package com.feign.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringBootFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFeignClientApplication.class, args);
    }

    void sendHeaders() {
//        1. Send Multiple Static Headers Per API
//        2. Send Single Dynamic Header Per API
//        3. Send Multiple Dynamic Headers Per API
//        4. Send Multiple Dynamic Headers For Every API
    }

}
