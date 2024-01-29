package com.thechessnuts.gamesessionservice.repositories;

import com.thechessnuts.gamesessionservice.models.GameEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;


public interface GameRepository extends MongoRepository<GameEntity, String> {
    Optional<GameEntity> findByGameId(String gameId);
}