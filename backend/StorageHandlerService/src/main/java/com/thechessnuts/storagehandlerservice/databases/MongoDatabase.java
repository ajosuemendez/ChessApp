package com.thechessnuts.storagehandlerservice.databases;

// Entities
import com.thechessnuts.storagehandlerservice.models.BaseEntity;

// MongoAPIs
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

// Components
import org.springframework.stereotype.Component;

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

    @Override
    public T updateEntity(String id, T updatedEntity) {
        updatedEntity.setId(id);
        mongoTemplate.save(updatedEntity);

        Query query = new Query(Criteria.where("id").is(id));

        return (T) mongoTemplate.findOne(query, updatedEntity.getClass());
    }

    @Override
    public boolean deleteEntityById(String id, T entity) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(mongoTemplate.findOne(query, entity.getClass()));
        if (mongoTemplate.findById(id, entity.getClass()) != null) {
            return false;
        }
        return true;
    }
}
