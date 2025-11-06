package com.feign.client.feign;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Request;
import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class FeignConfig {

    private final ObjectMapper mapper;

    @Bean
    public RequestInterceptor beforeLoggerInterceptor() {
        return template -> {
            Request request = template.request();

            System.out.println("\n====================== Before Logger Interceptor======================");

            log.info("\n Base URL: [{}] | API URL: [{}] | Method: [{}] \n Request Body: [{}] \n Headers: [{}] | QueryParams: [{}]",
                    template.feignTarget().url(), template.url(), template.method(), new String(Objects.requireNonNullElse(request.body(), new byte[0])), template.headers(), template.queries());

            System.out.println("====================== Before Logger Interceptor======================");
        };
    }

    @Bean
    public RequestInterceptor headerInterceptor() {
        return (template) -> {
            template.header("api-key", "12345");
            template.header("custom-feign", "abcd");

            // query param
            template.query("custom-feign-param", "custom value");

//            template.method(Request.HttpMethod.PATCH);
//
//            template.uri("/abcd-modification");

            byte[] bytes = template.body() != null ? template.body() : null;
            if (bytes != null) {
                String body = new String(bytes, StandardCharsets.UTF_8);
                Map map = deSerialize(body, Map.class);
                if (map != null) {
                    map.put("custom-key", "custom-payload value");
                }

                String serialize = serialize(map);
                template.body(serialize.getBytes(), StandardCharsets.UTF_8);

            }
        };
    }

    @Bean
    public RequestInterceptor afterLoggerInterceptor() {
        return template -> {
            Request request = template.request();

            System.out.println("\n====================== After Logger Interceptor======================");

            log.info("\n Base URL: [{}] | API URL: [{}] | Method: [{}] \n Request Body: [{}] \n Headers: [{}] | QueryParams: [{}]",
                    template.feignTarget().url(), template.url(), template.method(), new String(Objects.requireNonNullElse(request.body(), new byte[0])), template.headers(), template.queries());

            System.out.println("====================== After Logger Interceptor======================");
        };
    }

    public String serialize(final Object input) {
        try {
            return mapper.writeValueAsString(input);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    public <T> T deSerialize(final Object input, final Class<T> clazz) {
        try {
            return mapper.readValue(input.toString(), clazz);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}
