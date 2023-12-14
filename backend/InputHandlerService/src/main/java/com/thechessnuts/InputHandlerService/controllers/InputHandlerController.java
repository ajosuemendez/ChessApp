package com.thechessnuts.InputHandlerService.controllers;

import com.thechessnuts.InputHandlerService.models.Square;
import com.thechessnuts.InputHandlerService.models.SquareForSending;
import com.thechessnuts.InputHandlerService.models.CenterPosition;
import com.thechessnuts.InputHandlerService.models.Game;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@RestController
@RequestMapping("/")
public class InputHandlerController{
    Game game = new Game();
    int i = -1;
    String[] movesTests = {"h11", "h9", "b2", "b3", "c7", "c8", "b7", "b6", "h9", "h4"};

    @RequestMapping("/gameId={gameId}")
    @CrossOrigin(origins = "http://localhost:3000")
     public List<SquareForSending> getNewGame(@PathVariable("gameId") String gameId) {
        System.out.println("Received request");
         System.out.println(i);
        if(i==-1){
            game.gameID = "#24567d";
            game.newGame();
            i++;
        }
        else{
            if((i)<movesTests.length){
                game.handleEvent(movesTests[i]);
                i++;
            }
        }

        return game.getBoardState();
     }



    // public List<SquareForSending> getGameState(@PathVariable("gameId") String gameId) {

    //     List<SquareForSending> squareList = new ArrayList<SquareForSending>();
    //     squareList.addAll(squareList);
        
        
    //     return squareList;
    // }
}


