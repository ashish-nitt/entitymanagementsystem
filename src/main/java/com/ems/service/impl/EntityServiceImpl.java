package com.ems.service.impl;

import com.ems.model.map.EntityDef;
import com.ems.repository.EntityDefRepositorySimpleMap;
import com.ems.repository.EntityRepositorySimpleMap;
import com.ems.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by Ashish on 26-01-2018.
 */
@Service
public class EntityServiceImpl implements EntityService {
    @Autowired
    EntityRepositorySimpleMap entityRepositorySimpleMap;

    @Autowired
    EntityDefRepositorySimpleMap entityDefRepositorySimpleMap;

    @Override
    public int addEntity(String entityDefName, String entityName) {
        if (!StringUtils.isEmpty(entityName)) {
            return entityRepositorySimpleMap.addEntity(entityDefName, entityName);
        } else {
            return -1;
        }
    }

    @Override
    public int addAttributeToEntity(String entityName, String attributeDefName, String value) {
        if (! StringUtils.isEmpty(attributeDefName))
            return entityRepositorySimpleMap.addAttributeToEntity(entityName, attributeDefName, value);
        else
            return -1;
    }

    @Override
    public int addSubEntityToEntity(String entityName, String subEntityDefName, String value) {
        if (! StringUtils.isEmpty(subEntityDefName)) {
            return entityRepositorySimpleMap.addSubEntityToEntity(entityName, subEntityDefName, value);
        } else
            return -1;
    }

    @Override
    public String getEntity(String entityName) {
        if (!StringUtils.isEmpty(entityName))
            return entityRepositorySimpleMap.getEntity(entityName);
        else
            return null;
    }

    @Override
    public String getAttributeOfEntity(String entityName, String attributeDefName) {
        if (!StringUtils.isEmpty(entityName))
            return entityRepositorySimpleMap.getAttributeOfEntity(entityName, attributeDefName);
        else
            return null;
    }

    @Override
    public String getSubEntityOfEntity(String entityName, String subEntityDefName) {
        if (! StringUtils.isEmpty(subEntityDefName))
            return entityRepositorySimpleMap.getSubEntityOfEntity(entityName, subEntityDefName);
        else
            return null;
    }

    @Override
    public int updateAttributeToEntity(String entityName, String attributeDefName, String value) {
        if (! StringUtils.isEmpty(attributeDefName))
            return entityRepositorySimpleMap.updateAttributeToEntity(entityName, attributeDefName, value);
        else
            return -1;
    }

    @Override
    public int updateSubEntityToEntity(String entityName, String subEntityDefName, String value) {
        if (! StringUtils.isEmpty(subEntityDefName))
            return entityRepositorySimpleMap.updateSubEntityToEntity(entityName, subEntityDefName, value);
        else
            return -1;
    }

    @Override
    public int deleteEntity(String entityName) {
        if (! StringUtils.isEmpty(entityName))
            return entityRepositorySimpleMap.deleteEntity(entityName);
        else
            return -1;
    }

    @Override
    public int deleteAttributeFromEntity(String entityName, String attributeDefName) {
        if (! StringUtils.isEmpty(attributeDefName))
            return entityRepositorySimpleMap.deleteAttributeFromEntity(entityName, attributeDefName);
        else
            return -1;
    }

    @Override
    public int deleteSubEntityFromEntity(String entityName, String subEntityDefName) {
        if (! StringUtils.isEmpty(subEntityDefName))
            return entityRepositorySimpleMap.deleteSubEntityFromEntity(entityName, subEntityDefName);
        else
            return -1;
    }
}
