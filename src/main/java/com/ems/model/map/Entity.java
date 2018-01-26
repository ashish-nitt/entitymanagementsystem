package com.ems.model.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Ashish on 26-01-2018.
 */
public class Entity {
    private final String entityType;
    private final String entityName;
    private final ConcurrentHashMap<String, String> attributes;
    private final ConcurrentHashMap<String, String> subEntities;

    public Entity(String entityType, String entityName) {
        this.entityType = entityType;
        this.entityName = entityName;
        this.attributes = new ConcurrentHashMap<>();
        this.subEntities = new ConcurrentHashMap<>();
    }

    public String getEntityType() {
        return entityType;
    }

    public String getEntityName() {
        return entityName;
    }

    public ConcurrentHashMap<String, String> getAttributes() {
        return attributes;
    }

    public ConcurrentHashMap<String, String> getSubEntities() {
        return subEntities;
    }
}
