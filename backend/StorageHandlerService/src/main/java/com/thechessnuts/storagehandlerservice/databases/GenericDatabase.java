package com.thechessnuts.storagehandlerservice.databases;

import com.thechessnuts.storagehandlerservice.models.BaseEntity;

public abstract class GenericDatabase {
    public abstract IDatabase<BaseEntity> initDatabase();
}
