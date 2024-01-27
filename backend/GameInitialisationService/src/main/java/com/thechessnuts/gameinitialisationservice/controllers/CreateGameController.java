package com.thechessnuts.gameinitialisationservice.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@RestController
@RequestMapping("/")
public class CreateGameController{
    
    @RequestMapping("/creategame")
    public String CreateGame() {
        return "Returning the Game ID: 1 and Password: 12";
    }
}
