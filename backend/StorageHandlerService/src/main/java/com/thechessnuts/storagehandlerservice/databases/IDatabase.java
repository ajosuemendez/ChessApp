package com.thechessnuts.storagehandlerservice.databases;

import com.thechessnuts.storagehandlerservice.models.BaseEntity;

public interface IDatabase<T extends BaseEntity> {
    T saveEntity(T entity);
    T findEntityById(String id, T entity);
    T updateEntity(String id, T updatedEntity);
    boolean deleteEntityById(String id, T updatedEntity);
}
