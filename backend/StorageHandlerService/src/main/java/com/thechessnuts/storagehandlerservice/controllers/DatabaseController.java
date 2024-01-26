package com.thechessnuts.storagehandlerservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

// HTTP Responses
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


import com.thechessnuts.storagehandlerservice.service.DatabaseService;
import com.thechessnuts.storagehandlerservice.databases.GenericDatabase;
import com.thechessnuts.storagehandlerservice.databases.MongoDatabaseCreator;
import com.thechessnuts.storagehandlerservice.models.BaseEntity;
import com.thechessnuts.storagehandlerservice.models.GameEntity;

// Config
import com.thechessnuts.storagehandlerservice.config.MongoConfig;


@RestController
@RequestMapping("/database")
public class DatabaseController {

    private final DatabaseService databaseService;

    public DatabaseController() {
        MongoConfig mongoConfig = new MongoConfig();
        GenericDatabase mongoDB = new MongoDatabaseCreator(mongoConfig.getMongoTemplate());
        this.databaseService = new DatabaseService(mongoDB.initDatabase());
    }

    @GetMapping("/games/{gameId}")
    public BaseEntity getGame(@PathVariable String gameId) {
        return databaseService.findGameById(gameId);
    }

    @PostMapping("/games/")
    public BaseEntity saveGame(@RequestBody GameEntity game) {
        return databaseService.saveGame(game);
    }

    @PutMapping("/games/{gameId}")
    public BaseEntity updateGame(@PathVariable String gameId, @RequestBody GameEntity updatedGame) {
        return databaseService.updateGame(gameId, updatedGame);
    }

    @DeleteMapping("/games/{gameId}")
    public ResponseEntity<String> deleteGame(@PathVariable String gameId) {
        boolean wasDeleted = databaseService.deleteGame(gameId);
        return this.SendDeleteHttpResponse(wasDeleted);
    }

    ResponseEntity<String> SendDeleteHttpResponse(boolean isRequestSuccesful) {
        if (isRequestSuccesful) {
            return new ResponseEntity<>("Game deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Game not found", HttpStatus.NOT_FOUND);
        }
    }
}
