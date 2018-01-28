package com.ems.model;

import java.util.HashMap;

/**
 * Created by Ashish on 26-01-2018.
 */
public class EmsEntity {
    private final String entityType;
    private final Long entityId;
    private final String entityName;
    private final MyHashTable<String, String> attributes;
    private final MyHashTable<String, Long> subEntities;

    public EmsEntity(String entityType, Long entityId, String entityName) {
        this.entityType = entityType;
        this.entityId = entityId;
        this.entityName = entityName;
        this.attributes = new MyHashTable<>();
        this.subEntities = new MyHashTable<>();
    }

    public EmsEntity(String entityType, Long entityId) {
        this.entityType = entityType;
        this.entityId = entityId;
        this.entityName = "";
        this.attributes = new MyHashTable<>();
        this.subEntities = new MyHashTable<>();
    }

    public String getEntityName() {
        return entityName;
    }

    public String getEntityType() {
        return entityType;
    }

    public Long getEntityId() {
        return entityId;
    }

    public MyHashTable<String, String> getAttributes() {
        return attributes;
    }

    public MyHashTable<String, Long> getSubEntities() {
        return subEntities;
    }
}
