package com.ems.service.impl;

import com.ems.service.EntityService;
import org.springframework.stereotype.Service;

/**
 * Created by Ashish on 26-01-2018.
 */
@Service
public class EntityServiceImpl implements EntityService {
    @Override
    public int addEntity(String entityDefName, String entityName) {
        return 0;
    }

    @Override
    public int addAttributeToEntity(String entityName, String attributeDefName, String value) {
        return 0;
    }

    @Override
    public int addSubEntityToEntity(String entityName, String subEntityDefName, String value) {
        return 0;
    }

    @Override
    public String getEntity(String entityName) {
        return null;
    }

    @Override
    public String getAttributeOfEntity(String entityName, String attributeDefName) {
        return null;
    }

    @Override
    public String getSubEntityOfEntity(String entityName, String subEntityDefName) {
        return null;
    }

    @Override
    public int updateAttributeToEntity(String entityName, String attributeDefName, String value) {
        return 0;
    }

    @Override
    public int updateSubEntityToEntity(String entityName, String subEntityDefName, String value) {
        return 0;
    }

    @Override
    public int deleteEntity(String entityName) {
        return 0;
    }

    @Override
    public int deleteAttributeFromEntity(String entityName, String attributeDefName) {
        return 0;
    }

    @Override
    public int deleteSubEntityFromEntity(String entityName, String subEntityDefName) {
        return 0;
    }
}
