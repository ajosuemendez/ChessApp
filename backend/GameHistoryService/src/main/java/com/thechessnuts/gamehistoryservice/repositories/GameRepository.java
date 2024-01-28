package com.thechessnuts.gamehistoryservice.repositories;

import com.thechessnuts.gamehistoryservice.models.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GameRepository extends MongoRepository<Game, String> {
    Optional<Game> findByGameId(String gameId);
}