package com.thechessnuts.gamesessionservice.controllers;

import  com.thechessnuts.gamesessionservice.models.SquareForSending;
import  com.thechessnuts.gamesessionservice.models.Game;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

import com.thechessnuts.gamesessionservice.models.MoveHistory;
import com.thechessnuts.gamesessionservice.models.Chess3Settings;
import com.thechessnuts.gamesessionservice.models.GameEntity;
import com.thechessnuts.gamesessionservice.repositories.GameRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/")
public class GameSessionController{

    @Autowired
    private GameRepository gameRepository;

    private final RestTemplate restTemplate;

    @Autowired
    public GameSessionController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    Game game = new Game();
    int i = -1;
    String[] movesTests = {"h11", "h9", "b2", "b3", "c7", "c8", "b7", "b6", "h12", "h10", "c1", "a3" };

    // @RequestMapping("/gameId={gameId}")
    //  public List<SquareForSending> getNewGame(@PathVariable("gameId") String gameId) {
    //     System.out.println(gameId);
    //     if(i==-1){
    //         //game.getId() = "#24567d";
    //         game.newGame();
    //         i++;
    //     }
    //     else{
    //             game.handleEvent(gameId);
    //             i++;
            
    //     }

    //     return game.getBoardState();
    //  }

     @RequestMapping("/{gameId}/{move}")
     public List<SquareForSending> updateGame(@PathVariable("gameId") String gameId, @PathVariable("move") String move) {
        System.out.println(gameId);
        System.out.println(move);

        GameEntity gameRequested = gameRepository.findByGameId(gameId)
                .orElseThrow(() -> new RuntimeException("Game not found for ID: " + gameId));

        MoveHistory movesHistory = new MoveHistory();
        movesHistory.setHistory(gameRequested.getHistory());
        //game.loadGame(movesHistory, new Chess3Settings());
        boolean reload = game.handleEvent(move, gameId, this.restTemplate);

        if(reload){
        gameRequested = gameRepository.findByGameId(gameId)
                .orElseThrow(() -> new RuntimeException("Game not found for ID: " + gameId));

        movesHistory.setHistory(gameRequested.getHistory());
        game.loadGame(movesHistory, new Chess3Settings());
        }
        // GameEntity gameResponse = new GameEntity();
        // gameResponse.setHistory(gameRequested.getHistory());
        // gameResponse.setBoardState(game.getBoardState());
        // gameResponse.setGameId(gameId);

        //System.out.println(gameResponse.toString());
         
        // return gameResponse;
        return game.getBoardState();
     }



    // public List<SquareForSending> getGameState(@PathVariable("gameId") String gameId) {

    //     List<SquareForSending> squareList = new ArrayList<SquareForSending>();
    //     squareList.addAll(squareList);
        
        
    //     return squareList;
    // }
}



// @RestController
// public class InputHandlerController {

//     @PostMapping("/gameID")
//     public List<SquareForSending> handleChessEvent(@RequestBody ChessEventRequest request) {
//         try {
//             // Call your handleEvent function with the squareClicked data
//             ChessEventResult result = handleEvent(request.getSquareClicked());

//             // Return the result as JSON response
//             return ResponseEntity.ok(result);
//         } catch (Exception e) {
//             // Handle exceptions and return an error response
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//         }
//     }

//     private ChessEventResult handleEvent(String squareClicked) {
//         // Implement your business logic in the handleEvent function
//         // Call your existing handleEvent function or implement the logic directly here
//         // ...

//         // For demonstration purposes, let's create a simple result object
//         ChessEventResult result = new ChessEventResult();
//         result.setMessage("Square Clicked: " + squareClicked);
//         return result;
//     }
