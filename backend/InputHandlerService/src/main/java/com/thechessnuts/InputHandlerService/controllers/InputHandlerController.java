package com.thechessnuts.InputHandlerService.controllers;

import com.thechessnuts.InputHandlerService.models.Square;
import com.thechessnuts.InputHandlerService.models.SquareForSending;
import com.thechessnuts.InputHandlerService.models.CenterPosition;
import com.thechessnuts.InputHandlerService.models.Game;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


@RestController
@RequestMapping("/")
public class InputHandlerController{
    Game game;

    @RequestMapping("/gameId={gameId}")
    @CrossOrigin(origins = "http://localhost:3000")
     public List<SquareForSending> getNewGame(@PathVariable("gameId") String gameId) {
        game = new Game();
        game.gameID = gameId;

        return game.getBoardState();
     }



    // public List<SquareForSending> getGameState(@PathVariable("gameId") String gameId) {

    //     List<SquareForSending> squareList = new ArrayList<SquareForSending>();
    //     squareList.addAll(squareList);
        
        
    //     return squareList;
    // }
}


