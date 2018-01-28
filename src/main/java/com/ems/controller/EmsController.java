package com.ems.controller;

import com.ems.model.EmsAttributeType;
import com.ems.model.EmsEntity;
import com.ems.model.EmsEntityType;
import com.ems.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.comparator.BooleanComparator;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ashish on 27-01-2018.
 */
@RestController
@RequestMapping("/ems")
public class EmsController {
    @Autowired
    private EntityService entityService;

    @RequestMapping(value = "/hello/{user}", method = RequestMethod.GET)
    public String hello(@PathVariable("user") String user) {
        return "hello " + user;
    }

    //Create DbEntity Definition
    @RequestMapping(value = "/entityTypes/{entityTypeName}", method = RequestMethod.POST)
    public EmsEntityType addNewEntityType(@PathVariable("entityTypeName") String entityTypeName,
                                   HttpServletResponse response){
        System.out.println("EmsController.addNewEntityType");
        System.out.println("entityTypeName = [" + entityTypeName + "]");
        EmsEntityType emsEntityType = entityService.addNewEntityType(entityTypeName);
        if (emsEntityType != null)
            response.setStatus(HttpServletResponse.SC_CREATED);
        else
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return emsEntityType;
    }
    EmsAttributeType addAttributeOfEntityType(String entityTypeName, String attributeTypeName, String attributeType, String renderingEngineDetails){return null;}
    EmsEntityType addSubEntityOfEntityType(String entityTypeName, String subEntityName, String subEntityType){return null;}
    //Read DbEntity Definition
    @RequestMapping(value = "/entityTypeCheck/{entityTypeName}", method = RequestMethod.GET)
    public Boolean hasEntityType(@PathVariable String entityTypeName,
                          HttpServletResponse response){
        System.out.println("EmsController.hasEntityType");
        System.out.println("entityTypeName = [" + entityTypeName + "]");
        if (entityService.hasEntityType(entityTypeName)) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return false;
        }
    }
    Boolean hasAttributeOfEntityType(String entityTypeName, String attributeTypeName){return null;}
    Boolean hasSubEntityOfEntityType(String subEntityName, String subEntityType){return null;}
    @RequestMapping(value = "/entityTypes/{entityTypeName}", method = RequestMethod.GET)
    public EmsEntityType getEntityType(@PathVariable String entityTypeName,
                                HttpServletResponse response){
        System.out.println("EmsController.getEntityType");
        System.out.println("entityTypeName = [" + entityTypeName + "]");
        EmsEntityType emsEntityType = entityService.getEntityType(entityTypeName);
        if (emsEntityType != null)
            response.setStatus(HttpServletResponse.SC_OK);
        else
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return emsEntityType;
    }
    EmsAttributeType getAttributeOfEntityType(String entityTypeName, String attributeTypeName){return null;}
    EmsEntityType getSubEntityOfEntityType(String subEntityName, String subEntityType){return null;}
    //EmsEntity Create
    Long addEntity(String entityTypeName){
        return null;
    }
    Long addEntity(String entityTypeName, String entityName){return null;}
    String addAttributeOfEntity(String entityName, String attributeName, String value){return null;}
    Long addSubEntityOfEntity(String entityName, String subEntityName, Long emsSubEntityRef){return null;}
    String addAttributeOfEntity(Long entityId, String attributeName, String value){return null;}
    Long addSubEntityOfEntity(Long entityId, String subEntityName, Long emsSubEntityRef){return null;}
    //EmsEntity Read
    Boolean hasEntity(String entityName){return null;}
    Boolean hasEntity(Long EntityId){return null;}
    Boolean hasAttributeOfEntity(String entityName, String attributeName){return null;}
    Boolean hasSubEntityOfEntity(String entityName, String subEntityName){return null;}
    Boolean hasAttributeOfEntity(Long entityId, String attributeName){return null;}
    Boolean hasSubEntityOfEntity(Long entityId, String subEntityName){return null;}
    Long getEntity(String entityName){return null;}
    String getAttributeOfEntity(String entityName, String attributeName){return null;}
    Long getSubEntityOfEntity(String entityName, String subEntityName){return null;}
    String getAttributeOfEntity(Long entityId, String attributeName){return null;}
    Long getSubEntityOfEntity(Long entityId, String subEntityName){return null;}
    //EmsEntity Update
    String updateAttributeOfEntity(String entityName, String attributeName, String value){return null;}
    String updateAttributeOfEntity(Long entityId, String attributeName, String value){return null;}
    Long updateSubEntityOfEntity(String entityName, String subEntityName, Long emsSubEntityRef){return null;}
    Long updateSubEntityOfEntity(Long entityId, String subEntityName, Long emsSubEntityRef){return null;}
    //EmsEntity Delete
    Boolean deleteEntity(String entityName){return null;}
    Boolean deleteEntity(Long entityId){return null;}
    Boolean deleteAttributeFromEntity(String entityName, String attributeTypeName){return null;}
    Boolean deleteSubEntityFromEntity(String entityName, String subEntityTypeName){return null;}
    Boolean deleteAttributeFromEntity(Long entityId, String attributeTypeName){return null;}
    Boolean deleteSubEntityFromEntity(Long entityId, String subEntityTypeName){return null;}
}
