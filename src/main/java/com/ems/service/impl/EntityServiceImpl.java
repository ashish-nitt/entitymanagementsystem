package com.ems.service.impl;

import com.ems.repository.EntityRepositorySimpleMap;
import com.ems.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ashish on 26-01-2018.
 */
@Service
public class EntityServiceImpl implements EntityService {
    @Autowired
    EntityRepositorySimpleMap entityRepositorySimpleMap;

    @Override
    public int addEntity(String entityDefName, String entityName) {
        return entityRepositorySimpleMap.addEntity(entityDefName, entityName);
    }

    @Override
    public int addAttributeToEntity(String entityName, String attributeDefName, String value) {
        return entityRepositorySimpleMap.addAttributeToEntity(entityName, attributeDefName, value);
    }

    @Override
    public int addSubEntityToEntity(String entityName, String subEntityDefName, String value) {
        return entityRepositorySimpleMap.addSubEntityToEntity(entityName, subEntityDefName, value);
    }

    @Override
    public String getEntity(String entityName) {
        return entityRepositorySimpleMap.getEntity(entityName);
    }

    @Override
    public String getAttributeOfEntity(String entityName, String attributeDefName) {
        return entityRepositorySimpleMap.getAttributeOfEntity(entityName, attributeDefName);
    }

    @Override
    public String getSubEntityOfEntity(String entityName, String subEntityDefName) {
        return entityRepositorySimpleMap.getSubEntityOfEntity(entityName, subEntityDefName);
    }

    @Override
    public int updateAttributeToEntity(String entityName, String attributeDefName, String value) {
        return entityRepositorySimpleMap.updateAttributeToEntity(entityName, attributeDefName, value);
    }

    @Override
    public int updateSubEntityToEntity(String entityName, String subEntityDefName, String value) {
        return entityRepositorySimpleMap.updateSubEntityToEntity(entityName, subEntityDefName, value);
    }

    @Override
    public int deleteEntity(String entityName) {
        return entityRepositorySimpleMap.deleteEntity(entityName);
    }

    @Override
    public int deleteAttributeFromEntity(String entityName, String attributeDefName) {
        return entityRepositorySimpleMap.deleteAttributeFromEntity(entityName, attributeDefName);
    }

    @Override
    public int deleteSubEntityFromEntity(String entityName, String subEntityDefName) {
        return entityRepositorySimpleMap.deleteSubEntityFromEntity(entityName, subEntityDefName);
    }
}
