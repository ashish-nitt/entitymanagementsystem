package com.ems.service.impl;

import com.ems.service.EntityDefService;
import org.springframework.stereotype.Service;

/**
 * Created by Ashish on 26-01-2018.
 */
@Service
public class EntityDefServiceImpl implements EntityDefService {
    @Override
    public int addNewEntityDef(String entityDefName) {
        return 0;
    }

    @Override
    public int addAttributeToEntityDef(String entityDefName, String attributeDefName, String attributeType, String renderingEngineDetails) {
        return 0;
    }

    @Override
    public int addSubEntityToEntityDef(String entityDefName, String subEntityDefName, String subEntityType) {
        return 0;
    }

    @Override
    public String getAttributeOfEntityDef(String entityDefName, String attributeDefName) {
        return null;
    }

    @Override
    public String getSubEntityOfEntityDef(String entityDefName, String subEntityDefName) {
        return null;
    }

    @Override
    public String getEntityDef(String entityDefName) {
        return null;
    }
}
