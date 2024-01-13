package com.thechessnuts.StorageHandlerService.databases;

import org.springframework.data.mongodb.core.MongoTemplate;
import com.thechessnuts.StorageHandlerService.models.BaseEntity;


public class MongoDatabaseCreator extends GenericDatabase {

    private final MongoTemplate mongoTemplate;

    public MongoDatabaseCreator (MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public IDatabase<BaseEntity> initDatabase() {
        return new MongoDatabase(this.mongoTemplate);
    }
}
