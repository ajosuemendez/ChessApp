package com.thechessnuts.gamehistoryservice.controllers;

import com.thechessnuts.gamehistoryservice.models.Game;
import com.thechessnuts.gamehistoryservice.models.SquareForSending;
import com.thechessnuts.gamehistoryservice.repositories.GameRepository;
import com.thechessnuts.gamehistoryservice.repositories.GameHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/")
public class HistoryController{

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameHistoryRepository gameHistoryRepository;
    
    @RequestMapping("/{gameId}/undo")
    public String Undo(@PathVariable("gameId") String gameId) {
        
        return "Looking for id: " + gameId +" in the database and making an undo";
        // return gameRepository.save(game);
    }
}
