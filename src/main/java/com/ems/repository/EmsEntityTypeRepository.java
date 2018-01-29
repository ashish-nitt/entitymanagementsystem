package com.ems.repository;

import com.ems.model.EmsAttributeType;
import com.ems.model.EmsEntityType;

/**
 * Created by Ashish on 28-01-2018.
 */
public interface EmsEntityTypeRepository {
    //Create DbEntity Definition
    EmsEntityType addNewEntityType(String entityTypeName);
    EmsEntityType addNewEntityType(EmsEntityType emsEntityType);
    EmsAttributeType addAttributeOfEntityType(String entityTypeName, String attributeTypeName, String attributeType, String renderingEngineDetails);
    EmsEntityType addSubEntityOfEntityType(String entityTypeName, String subEntityName, String subEntityType);
    //Read DbEntity Definition
    Boolean hasEntityType(String entityTypeName);
    Boolean hasAttributeOfEntityType(String entityTypeName, String attributeTypeName);
    Boolean hasSubEntityOfEntityType(String subEntityName, String subEntityType);
    EmsEntityType getEntityType(String entityTypeName);
    EmsAttributeType getAttributeOfEntityType(String entityTypeName, String attributeTypeName);
    EmsEntityType getSubEntityOfEntityType(String subEntityName, String subEntityType);
}
