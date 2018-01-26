package com.ems.service;

/**
 * Created by Ashish on 26-01-2018.
 */
public interface EntityDefService {
    //Create DbEntity Definition
    int addNewEntityDef(String entityDefName);
    int addAttributeToEntityDef(String entityDefName,String attributeDefName, String attributeType, String renderingEngineDetails);
    int addSubEntityToEntityDef(String entityDefName, String subEntityDefName, String subEntityType);
    //Read DbEntity Definition
    String getEntityDef(String entityDefName);
    String getAttributeOfEntityDef(String entityDefName,String attributeDefName);
    String getSubEntityOfEntityDef(String entityDefName, String subEntityDefName);
}
