package com.example.apigatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayService {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayService.class, args);
    }

    // @Bean
    // @LoadBalanced
    // public RestTemplate restTemplate() {
    //     return new RestTemplate();
    // }
}
