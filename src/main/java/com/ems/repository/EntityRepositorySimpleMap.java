package com.ems.repository;

import com.ems.model.map.Entity;
import org.eclipse.jetty.util.ConcurrentHashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Ashish on 27-01-2018.
 */
@Repository
public class EntityRepositorySimpleMap {
    @Autowired
    EntityDefRepositorySimpleMap entityDefRepositorySimpleMap;

    private final ConcurrentHashMap<String, Entity> entityMap;

    public EntityRepositorySimpleMap() {
        entityMap = new ConcurrentHashMap<>();
    }

    public int addEntity(String entityDefName, String entityName) {
        if (null == entityMap.get(entityName)) {
            Entity entity = new Entity(entityDefName, entityName);
            entityMap.putIfAbsent(entityName, entity);
            if (entity == entityMap.get(entityName)) return 0;
        }
        return -1;
    }

    
    public int addAttributeToEntity(String entityName, String attributeDefName, String value) {
        Entity entity = entityMap.get(entityName);
        if (entity != null) {
            if (null == entity.getAttributes().get(attributeDefName)) {
                entity.getAttributes().putIfAbsent(attributeDefName, value);
                if (entity.getAttributes().get(attributeDefName) == value) return 0;
            }
        }
        return -1;
    }

    
    public int addSubEntityToEntity(String entityName, String subEntityDefName, String subEntityName) {
        Entity entity = entityMap.get(entityName);
        if (entity != null) {
            if (null == entity.getSubEntities().get(subEntityDefName)) {
                entity.getSubEntities().putIfAbsent(subEntityDefName, subEntityName);
                if (entity.getSubEntities().get(subEntityDefName) == subEntityName) return 0;
            }
        }
        return -1;
    }

    
    public String getEntity(String entityName) {
        Entity entity = entityMap.get(entityName);
        if (entity != null) {
            return entity.getEntityName();
        }
        return null;
    }

    
    public String getAttributeOfEntity(String entityName, String attributeDefName) {
        Entity entity = entityMap.get(entityName);
        if (entity != null) {
            return entity.getAttributes().get(attributeDefName);
        }
        return null;
    }

    
    public String getSubEntityOfEntity(String entityName, String subEntityDefName) {
        Entity entity = entityMap.get(entityName);
        if (entity != null) {
            return entity.getSubEntities().get(subEntityDefName);
        }
        return null;
    }

    
    public int updateAttributeToEntity(String entityName, String attributeDefName, String value) {
        return 0;
    }

    
    public int updateSubEntityToEntity(String entityName, String subEntityDefName, String value) {
        return 0;
    }

    
    public int deleteEntity(String entityName) {
        return 0;
    }

    
    public int deleteAttributeFromEntity(String entityName, String attributeDefName) {
        return 0;
    }

    
    public int deleteSubEntityFromEntity(String entityName, String subEntityDefName) {
        return 0;
    }
}
