package com.thechessnuts.gameinitialisationservice.controllers;

import com.thechessnuts.gameinitialisationservice.models.Game;
import com.thechessnuts.gameinitialisationservice.models.SquareForSending;
import com.thechessnuts.gameinitialisationservice.repositories.GameRepository;
import com.thechessnuts.gameinitialisationservice.utils.ChessboardUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;
import java.util.Stack;


@RestController
@RequestMapping("/")
public class CreateGameController{

    @Autowired
    private GameRepository gameRepository;
    
    @RequestMapping("/creategame")
    public Game CreateGame() {

        // Generate a unique game ID
        String gameId = UUID.randomUUID().toString();

        // Generate random password
        String password = RandomStringUtils.randomAlphanumeric(8);

        // Generate the Default State
        List<SquareForSending> defaultBoardState = ChessboardUtils.getDefaultChessboardState();

        
        Game game = new Game();
        game.setGameId(gameId);
        game.setPassword(password);
        game.setBoardState(defaultBoardState);
        game.setHistory(new Stack<>());
        game.setUndos(new Stack<>());

        // Save the game details to MongoDB
        return gameRepository.save(game);

    }
}
