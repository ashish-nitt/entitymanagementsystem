package com.ems.service;

/**
 * Created by Ashish on 26-01-2018.
 */
public interface EntityService {
    //DbEntity Create
    int addEntity(String entityDefName, String entityName);
    int addAttributeToEntity(String entityName, String attributeDefName, String value);
    int addSubEntityToEntity(String entityName, String subEntityDefName, String value);
    //DbEntity Read
    String getEntity(String entityName);
    String getAttributeOfEntity(String entityName, String attributeDefName);
    String getSubEntityOfEntity(String entityName, String subEntityDefName);
    //DbEntity Update
    int updateAttributeToEntity(String entityName, String attributeDefName, String value);
    int updateSubEntityToEntity(String entityName, String subEntityDefName, String value);
    //DbEntity Delete
    int deleteEntity(String entityName);
    int deleteAttributeFromEntity(String entityName, String attributeDefName);
    int deleteSubEntityFromEntity(String entityName, String subEntityDefName);
}
