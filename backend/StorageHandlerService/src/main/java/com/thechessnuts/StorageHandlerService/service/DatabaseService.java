package com.thechessnuts.StorageHandlerService.service;

import com.thechessnuts.StorageHandlerService.databases.IDatabase;
import com.thechessnuts.StorageHandlerService.models.BaseEntity;
import com.thechessnuts.StorageHandlerService.models.GameEntity;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    private final IDatabase<BaseEntity> database;

    public DatabaseService(IDatabase<BaseEntity> database) {
        this.database = database;
    }

    public BaseEntity saveGame(GameEntity entity) {
        return this.database.saveEntity(entity);
    }

    public BaseEntity findGameById(String id) {
        return this.database.findEntityById(id, new GameEntity());
    }

    public BaseEntity updateGame(String id, GameEntity updatedEntity) {
        return this.database.updateEntity(id, updatedEntity);
    }

    public boolean deleteGame(String id) {
        return database.deleteEntityById(id, new GameEntity());
    }
}
