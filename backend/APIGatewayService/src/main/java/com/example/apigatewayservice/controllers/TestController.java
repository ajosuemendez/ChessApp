package com.example.apigatewayservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.example.apigatewayservice.models.BaseEntity;
import com.example.apigatewayservice.models.GameEntity;

@RestController
public class TestController {

    private final RestTemplate restTemplate;

    @Autowired
    public TestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        String res = restTemplate.getForObject("http://storage-service/games/test", String.class);
        return "API Gateway Response: " + res;
    }

    @RequestMapping("/games/{gameId}")
    @ResponseBody
    public BaseEntity obj(@PathVariable String gameId) {
        BaseEntity res = restTemplate.getForObject("http://storage-service/games/" + gameId, GameEntity.class);
        return res;
    }
}
