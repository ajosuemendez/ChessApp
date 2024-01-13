package com.thechessnuts.StorageHandlerService.databases;

import com.thechessnuts.StorageHandlerService.config.MongoConfig;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.thechessnuts.StorageHandlerService.models.BaseEntity;


public class MongoDatabaseCreator extends GenericDatabase {

    private final MongoTemplate mongoTemplate;

    public MongoDatabaseCreator () {
        this.mongoTemplate = new MongoConfig().getMongoTemplate();
    }

    @Override
    public IDatabase<BaseEntity> initDatabase() {
        MongoTemplate mongoTemplate = new MongoConfig().getMongoTemplate();
        return new MongoDatabase(this.mongoTemplate);
    }
}
