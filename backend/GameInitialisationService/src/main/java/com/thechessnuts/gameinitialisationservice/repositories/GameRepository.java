package com.thechessnuts.gameinitialisationservice.repositories;

import com.thechessnuts.gameinitialisationservice.models.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game, String> {
}