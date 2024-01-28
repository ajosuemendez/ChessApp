package com.thechessnuts.gamehistoryservice.controllers;

import com.thechessnuts.gamehistoryservice.models.Game;
import com.thechessnuts.gamehistoryservice.models.SquareForSending;
import com.thechessnuts.gamehistoryservice.repositories.GameRepository;
import com.thechessnuts.gamehistoryservice.services.GameHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
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
    private GameHistoryService gameHistoryService;

    @RequestMapping("/{gameId}/add/{move}")
    public Game addMove(@PathVariable("gameId") String gameId, @PathVariable("move") String move) {
        return gameHistoryService.addMove(gameId, move);
    }

    @RequestMapping("/{gameId}/undo")
    public Game undoMove(@PathVariable("gameId") String gameId) {
        return gameHistoryService.undoMove(gameId);
    }

    @RequestMapping("/{gameId}/redo")
    public Game redoMove(@PathVariable("gameId") String gameId) {
        return gameHistoryService.redoMove(gameId);
    }
}
