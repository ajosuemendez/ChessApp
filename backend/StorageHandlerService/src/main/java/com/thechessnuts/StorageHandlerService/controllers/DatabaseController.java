package com.thechessnuts.StorageHandlerService.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.thechessnuts.StorageHandlerService.service.DatabaseService;

import org.springframework.beans.factory.annotation.Autowired;

import com.thechessnuts.StorageHandlerService.databases.GenericDatabase;
import com.thechessnuts.StorageHandlerService.databases.MongoDatabaseCreator;
import com.thechessnuts.StorageHandlerService.models.BaseEntity;
import com.thechessnuts.StorageHandlerService.models.GameEntity;



@RestController
@RequestMapping("/database")
public class DatabaseController {

    private final DatabaseService databaseService;

    public DatabaseController() {
        GenericDatabase mongoDB = new MongoDatabaseCreator();
        this.databaseService = new DatabaseService(mongoDB.initDatabase());
    }

    @GetMapping("/games/{gameId}")
    public BaseEntity getGame(@PathVariable String gameId) {
        return databaseService.findGameById(gameId);
    }

    @GetMapping("/save/{gameId}")
    public BaseEntity saveGame(@PathVariable String gameId) {
        GameEntity game = new GameEntity();
        game.setId(gameId);
        game.setGameName("Name 20");
        return databaseService.saveGame(game);
    }
}
