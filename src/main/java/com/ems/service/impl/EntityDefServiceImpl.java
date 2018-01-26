package com.ems.service.impl;

import com.ems.repository.EntityDefRepositorySimpleMap;
import com.ems.service.EntityDefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by Ashish on 26-01-2018.
 */
@Service
public class EntityDefServiceImpl implements EntityDefService {
    @Autowired
    EntityDefRepositorySimpleMap entityDefRepositorySimpleMap;

    @Override
    public int addNewEntityDef(String entityDefName) {
        if (!StringUtils.isEmpty(entityDefName))
            return entityDefRepositorySimpleMap.addNewEntityDef(entityDefName);
        else
            return -1;
    }

    @Override
    public int addAttributeToEntityDef(String entityDefName, String attributeDefName, String attributeType, String renderingEngineDetails) {
        if (! StringUtils.isEmpty(attributeDefName))
            return entityDefRepositorySimpleMap.addAttributeToEntityDef(entityDefName, attributeDefName, attributeType, renderingEngineDetails);
        else
            return -1;
    }

    @Override
    public int addSubEntityToEntityDef(String entityDefName, String subEntityDefName, String subEntityType) {
        if (! StringUtils.isEmpty(subEntityDefName))
            return entityDefRepositorySimpleMap.addSubEntityToEntityDef(entityDefName, subEntityDefName, subEntityType);
        else
            return -1;
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
        if (!StringUtils.isEmpty(entityDefName))
            return entityDefRepositorySimpleMap.getEntityDef(entityDefName);
        else
            return null;
    }
}
