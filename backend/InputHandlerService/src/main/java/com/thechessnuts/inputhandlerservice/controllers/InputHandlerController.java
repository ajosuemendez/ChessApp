package com.thechessnuts.inputhandlerservice.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@RestController
@RequestMapping("/")
public class InputHandlerController{
    

    @RequestMapping("/gameId={gameId}")
    @CrossOrigin(origins = "http://localhost:3000")
    
    public void getNewGame(@PathVariable("gameId") String gameId) {
    
    }
}
