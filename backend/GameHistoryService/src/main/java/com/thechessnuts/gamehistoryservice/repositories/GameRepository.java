package com.thechessnuts.gamehistoryservice.repositories;

import com.thechessnuts.gamehistoryservice.models.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game, String> {
}