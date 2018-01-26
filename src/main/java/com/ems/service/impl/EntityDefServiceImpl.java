package com.ems.service.impl;

import com.ems.repository.EntityDefRepositorySimpleMap;
import com.ems.service.EntityDefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ashish on 26-01-2018.
 */
@Service
public class EntityDefServiceImpl implements EntityDefService {
    @Autowired
    EntityDefRepositorySimpleMap entityDefRepositorySimpleMap;

    @Override
    public int addNewEntityDef(String entityDefName) {
        return entityDefRepositorySimpleMap.addNewEntityDef(entityDefName);
    }

    @Override
    public int addAttributeToEntityDef(String entityDefName, String attributeDefName, String attributeType, String renderingEngineDetails) {
        return entityDefRepositorySimpleMap.addAttributeToEntityDef(entityDefName, attributeDefName, attributeType, renderingEngineDetails);
    }

    @Override
    public int addSubEntityToEntityDef(String entityDefName, String subEntityDefName, String subEntityType) {
        return entityDefRepositorySimpleMap.addSubEntityToEntityDef(entityDefName, subEntityDefName, subEntityType);
    }

    @Override
    public String getAttributeOfEntityDef(String entityDefName, String attributeDefName) {
        return entityDefRepositorySimpleMap.getAttributeOfEntityDef(entityDefName, attributeDefName);
    }

    @Override
    public String getSubEntityOfEntityDef(String entityDefName, String subEntityDefName) {
        return entityDefRepositorySimpleMap.getSubEntityOfEntityDef(entityDefName, subEntityDefName);
    }

    @Override
    public String getEntityDef(String entityDefName) {
        return entityDefRepositorySimpleMap.getEntityDef(entityDefName);
    }
}
