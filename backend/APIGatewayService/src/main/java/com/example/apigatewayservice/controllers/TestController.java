package com.example.apigatewayservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import com.example.apigatewayservice.models.BaseEntity;
import com.example.apigatewayservice.models.GameEntity;
import com.example.apigatewayservice.models.SquareForSending;


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

    @RequestMapping("/gameId={gameId}")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000")
    public List<SquareForSending> getGameSession(@PathVariable String gameId) {
        String url = "http://game-session-service/gameId=" + gameId;
        List<SquareForSending> res = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<SquareForSending>>() {}).getBody();
        return res;
    }

    @RequestMapping("/creategame")
    @CrossOrigin(origins = "http://localhost:3000")
    public String CreateGame() {
        String res = restTemplate.getForObject("http://game-initialisation-service/creategame", String.class);
        return res;
    }

}
