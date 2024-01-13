package com.thechessnuts.StorageHandlerService.databases;

// Entities
import com.thechessnuts.StorageHandlerService.models.BaseEntity;
import com.thechessnuts.StorageHandlerService.models.GameEntity;

// MongoAPIs
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

// Components
import org.springframework.stereotype.Component;

import java.lang.Class;

@Component
public class MongoDatabase<T extends BaseEntity> implements IDatabase<T> {

    private final MongoTemplate mongoTemplate;

    public MongoDatabase(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public T saveEntity(T entity) {
        mongoTemplate.insert(entity);
        return entity;
    }

    @Override
    public T findEntityById(String id, T entity) {
        Query query = new Query(Criteria.where("id").is(id));
        return (T) mongoTemplate.findOne(query, entity.getClass());
    }
}
