package com.thechessnuts.StorageHandlerService.databases;

import com.thechessnuts.StorageHandlerService.models.BaseEntity;

public abstract class GenericDatabase {
    public abstract IDatabase<BaseEntity> initDatabase();
}
