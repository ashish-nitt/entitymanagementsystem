package com.ems.repository;

import com.ems.model.EmsAttributeType;
import com.ems.model.EmsEntityType;

/**
 * Created by Ashish on 28-01-2018.
 */
public interface EmsEntityRepository extends EmsEntityTypeRepository {
    //EmsEntity Create
    Long addEntity(String entityTypeName);
    Long addEntity(String entityTypeName, String entityName);
    String addAttributeOfEntity(String entityName, String attributeName, String value);
    Long addSubEntityOfEntity(String entityName, String subEntityName, Long emsSubEntityRef);
    String addAttributeOfEntity(Long entityId, String attributeName, String value);
    Long addSubEntityOfEntity(Long entityId, String subEntityName, Long emsSubEntityRef);
    //EmsEntity Read
    Boolean hasEntity(String entityName);
    Boolean hasEntity(Long EntityId);
    Boolean hasAttributeOfEntity(String entityName, String attributeName);
    Boolean hasSubEntityOfEntity(String entityName, String subEntityName);
    Boolean hasAttributeOfEntity(Long entityId, String attributeName);
    Boolean hasSubEntityOfEntity(Long entityId, String subEntityName);
    Long getEntity(String entityName);
    String getAttributeOfEntity(String entityName, String attributeName);
    Long getSubEntityOfEntity(String entityName, String subEntityName);
    String getAttributeOfEntity(Long entityId, String attributeName);
    Long getSubEntityOfEntity(Long entityId, String subEntityName);
    //EmsEntity Update
    String updateAttributeOfEntity(String entityName, String attributeName, String value);
    String updateAttributeOfEntity(Long entityId, String attributeName, String value);
    Long updateSubEntityOfEntity(String entityName, String subEntityName, Long emsSubEntityRef);
    Long updateSubEntityOfEntity(Long entityId, String subEntityName, Long emsSubEntityRef);
    //EmsEntity Delete
    Boolean deleteEntity(String entityName);
    Boolean deleteEntity(Long entityId);
    Boolean deleteAttributeFromEntity(String entityName, String attributeTypeName);
    Boolean deleteSubEntityFromEntity(String entityName, String subEntityTypeName);
    Boolean deleteAttributeFromEntity(Long entityId, String attributeTypeName);
    Boolean deleteSubEntityFromEntity(Long entityId, String subEntityTypeName);
}
