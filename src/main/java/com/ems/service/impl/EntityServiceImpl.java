package com.ems.service.impl;

import com.ems.model.EmsAttributeType;
import com.ems.model.EmsEntityType;
import com.ems.repository.EmsEntityRepository;
import com.ems.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class EntityServiceImpl implements EntityService {
    @Autowired
    EmsEntityRepository repository;

    private Boolean isEmptyArguments(String... args) {
        for (String arg : args){
            if (StringUtils.isEmpty(arg)) return true;
        }
        return false;
    }

    @Override
    public EmsEntityType addNewEntityType(String entityTypeName) {
        if (isEmptyArguments(entityTypeName)) return null;
        return repository.addNewEntityType(entityTypeName);
    }

    @Override
    public EmsAttributeType addAttributeOfEntityType(String entityTypeName, String attributeName, String attributeType, String renderingEngineDetails) {
        if (isEmptyArguments(entityTypeName, attributeName)) return null;
        return repository.addAttributeOfEntityType(entityTypeName, attributeName, attributeType, renderingEngineDetails);
    }

    @Override
    public EmsEntityType addSubEntityOfEntityType(String entityTypeName, String subEntityName, String subEntityType) {
        if (isEmptyArguments(entityTypeName, subEntityName, subEntityType)) return null;
        return repository.addSubEntityOfEntityType(entityTypeName, subEntityName, subEntityType);
    }

    @Override
    public EmsEntityType getEntityType(String entityTypeName) {
        if (isEmptyArguments(entityTypeName)) return null;
        return repository.getEntityType(entityTypeName);
    }

    @Override
    public EmsAttributeType getAttributeOfEntityType(String entityTypeName, String attributeTypeName) {
        if (isEmptyArguments(entityTypeName)) return null;
        return repository.getAttributeOfEntityType(entityTypeName, attributeTypeName);
    }

    @Override
    public EmsEntityType getSubEntityOfEntityType(String entityTypeName, String subEntityTypeName) {
        if (isEmptyArguments(entityTypeName)) return null;
        return repository.getSubEntityOfEntityType(entityTypeName, subEntityTypeName);
    }

    @Override
    public Long addEntity(String entityTypeName) {
        if (isEmptyArguments(entityTypeName)) return null;
        return repository.addEntity(entityTypeName);
    }

    @Override
    public Long addEntity(String entityTypeName, String entityName) {
        if (isEmptyArguments(entityTypeName, entityName)) return null;
        return repository.addEntity(entityTypeName, entityName);
    }

    @Override
    public String addAttributeOfEntity(String entityName, String attributeName, String value) {
        if (isEmptyArguments(entityName, attributeName)) return null;
        return repository.addAttributeOfEntity(entityName, attributeName, value);
    }

    @Override
    public Long addSubEntityOfEntity(String entityName, String subEntityName, Long emsSubEntityRef) {
        if (isEmptyArguments(entityName, subEntityName)) return null;
        return repository.addSubEntityOfEntity(entityName, subEntityName, emsSubEntityRef);
    }

    @Override
    public String addAttributeOfEntity(Long entityId, String attributeName, String value) {
        if (isEmptyArguments(attributeName, attributeName)) return null;
        return repository.addAttributeOfEntity(entityId, attributeName, value);
    }

    @Override
    public Long addSubEntityOfEntity(Long entityId, String subEntityName, Long emsSubEntityRef) {
        if (isEmptyArguments(subEntityName)) return null;
        return null;
    }

    @Override
    public Boolean hasEntity(Long EntityId) {
        return false;
    }

    @Override
    public Boolean hasEntity(String entityName) {
        if (isEmptyArguments(entityName)) return null;
        return repository.hasEntity(entityName);
    }

    @Override
    public Boolean hasAttributeOfEntity(String entityName, String attributeName) {
        if (isEmptyArguments(entityName)) return null;
        return false;
    }

    @Override
    public Boolean hasSubEntityOfEntity(String entityName, String subEntityName) {
        if (isEmptyArguments(entityName)) return null;
        return false;
    }

    @Override
    public Boolean hasAttributeOfEntity(Long entityId, String attributeName) {
        if (isEmptyArguments(attributeName)) return null;
        return false;
    }

    @Override
    public Boolean hasSubEntityOfEntity(Long entityId, String subEntityName) {
        if (isEmptyArguments(subEntityName)) return null;
        return false;
    }

    @Override
    public Long getEntity(String entityName) {
        if (isEmptyArguments(entityName)) return null;
        return repository.getEntity(entityName);
    }

    @Override
    public String getAttributeOfEntity(String entityName, String attributeName) {
        if (isEmptyArguments(entityName, attributeName)) return null;
        return repository.getAttributeOfEntity(entityName, attributeName);
    }

    @Override
    public Long getSubEntityOfEntity(String entityName, String subEntityName) {
        if (isEmptyArguments(entityName, subEntityName)) return null;
        return repository.getSubEntityOfEntity(entityName, subEntityName);
    }

    @Override
    public String getAttributeOfEntity(Long entityId, String attributeName) {
        if (isEmptyArguments(attributeName, attributeName)) return null;
        return repository.getAttributeOfEntity(entityId, attributeName);
    }

    @Override
    public Long getSubEntityOfEntity(Long entityId, String subEntityName) {
        if (isEmptyArguments(subEntityName, subEntityName)) return null;
        return repository.getSubEntityOfEntity(entityId, subEntityName);
    }

    @Override
    public String updateAttributeOfEntity(String entityName, String attributeName, String value) {
        if (isEmptyArguments(attributeName, attributeName)) return null;
        return repository.updateAttributeOfEntity(entityName, attributeName, value);
    }

    @Override
    public String updateAttributeOfEntity(Long entityId, String attributeName, String value) {
        if (isEmptyArguments(attributeName)) return null;
        return repository.updateAttributeOfEntity(entityId, attributeName, value);
    }

    @Override
    public Long updateSubEntityOfEntity(String entityName, String subEntityName, Long emsSubEntityRef) {
        if (isEmptyArguments(entityName, subEntityName)) return null;
        return repository.updateSubEntityOfEntity(entityName, subEntityName, emsSubEntityRef);
    }

    @Override
    public Long updateSubEntityOfEntity(Long entityId, String subEntityName, Long emsSubEntityRef) {
        if (isEmptyArguments(subEntityName)) return null;
        return repository.updateSubEntityOfEntity(entityId, subEntityName, emsSubEntityRef);
    }

    @Override
    public Boolean deleteEntity(String entityName) {
        if (isEmptyArguments(entityName)) return false;
        return repository.deleteEntity(entityName);
    }

    @Override
    public Boolean deleteEntity(Long entityId) {
        return repository.deleteEntity(entityId);
    }

    @Override
    public Boolean deleteAttributeFromEntity(String entityName, String attributeName) {
        if (isEmptyArguments(entityName, attributeName)) return false;
        return repository.deleteAttributeFromEntity(entityName, attributeName);
    }

    @Override
    public EmsEntityType addNewEntityType(EmsEntityType emsEntityType) {
        return repository.addNewEntityType(emsEntityType);
    }

    @Override
    public Boolean deleteSubEntityFromEntity(String entityName, String subEntityName) {
        if (isEmptyArguments(entityName, subEntityName)) return false;
        return repository.deleteSubEntityFromEntity(entityName, subEntityName);
    }

    @Override
    public Boolean deleteAttributeFromEntity(Long entityId, String attributeName) {
        if (isEmptyArguments(attributeName)) return false;
        return repository.deleteAttributeFromEntity(entityId, attributeName);
    }

    @Override
    public Boolean deleteSubEntityFromEntity(Long entityId, String subEntityName) {
        if (isEmptyArguments(subEntityName)) return false;
        return repository.deleteSubEntityFromEntity(entityId, subEntityName);
    }

    @Override
    public Boolean hasEntityType(String entityTypeName) {
        if (isEmptyArguments(entityTypeName)) return false;
        return repository.hasEntityType(entityTypeName);
    }

    @Override
    public Boolean hasAttributeOfEntityType(String entityTypeName, String attributeName) {
        if (isEmptyArguments(entityTypeName, attributeName)) return false;
        return repository.hasAttributeOfEntityType(entityTypeName, attributeName);
    }

    @Override
    public Boolean hasSubEntityOfEntityType(String entityTypeName, String subEntityName) {
        if (isEmptyArguments(entityTypeName, subEntityName)) return false;
        return repository.hasSubEntityOfEntityType(entityTypeName, subEntityName);
    }
}