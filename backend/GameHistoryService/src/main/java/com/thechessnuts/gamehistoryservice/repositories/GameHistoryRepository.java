package com.thechessnuts.gamehistoryservice.repositories;

import com.thechessnuts.gamehistoryservice.models.History;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameHistoryRepository extends MongoRepository<History, String> {
}