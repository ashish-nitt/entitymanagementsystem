package com.ems.repository;

import com.ems.model.map.Entity;
import org.eclipse.jetty.util.ConcurrentHashSet;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Ashish on 27-01-2018.
 */
@Repository
public class EntityRepositorySimpleMap {
    private final ConcurrentHashMap<String, Entity> entityMap;

    public EntityRepositorySimpleMap() {
        entityMap = new ConcurrentHashMap<>();
    }

    public int addEntity(String entityDefName, String entityName) {
        return 0;
    }

    
    public int addAttributeToEntity(String entityName, String attributeDefName, String value) {
        return 0;
    }

    
    public int addSubEntityToEntity(String entityName, String subEntityDefName, String value) {
        return 0;
    }

    
    public String getEntity(String entityName) {
        return null;
    }

    
    public String getAttributeOfEntity(String entityName, String attributeDefName) {
        return null;
    }

    
    public String getSubEntityOfEntity(String entityName, String subEntityDefName) {
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
