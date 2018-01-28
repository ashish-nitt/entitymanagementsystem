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

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String hello() {
        return "This service helps entity management in server using REST calls";
    }

    //Create DbEntity Definition
    @RequestMapping(value = "/entitytypes/{entityType}", method = RequestMethod.POST)
    public EmsEntityType addNewEntityType(@PathVariable("entityType") String entityType,
                                   HttpServletResponse response){
        System.out.println("EmsController.addNewEntityType");
        System.out.println("entityType = [" + entityType + "]");
        EmsEntityType emsEntityType = entityService.addNewEntityType(entityType);
        if (emsEntityType != null)
            response.setStatus(HttpServletResponse.SC_CREATED);
        else
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return emsEntityType;
    }

    @RequestMapping(value = "/attrtypes/{entityType}/{attributeName}", method = RequestMethod.POST)
    public EmsAttributeType addAttributeOfEntityType(
            @PathVariable("entityType") String entityType,
            @PathVariable("attributeName") String attributeName,
            @RequestBody String requestBody,
            HttpServletResponse response) {
        System.out.println("EmsController.addAttributeOfEntityType");
        System.out.println("entityType = [" + entityType + "], attributeName = [" + attributeName + "], requestBody = [" + requestBody + "], response = [" + response + "]");
        String attributeType = "";
        String renderingEngineDetails = "";
        EmsAttributeType AtrributeType = entityService.addAttributeOfEntityType(entityType, attributeName, attributeType, renderingEngineDetails);
        if (AtrributeType != null)
            response.setStatus(HttpServletResponse.SC_CREATED);
        else
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return AtrributeType;
    }

    @RequestMapping(value = "/entitytypes/{entityType}/{subEntityName}", method = RequestMethod.POST)
    EmsEntityType addSubEntityOfEntityType(
            @PathVariable("entityType") String entityType,
            @PathVariable("subEntityName") String subEntityName,
            @RequestBody String requestBody,
            HttpServletResponse response){
        System.out.println("EmsController.addSubEntityOfEntityType");
        System.out.println("entityType = [" + entityType + "], subEntityName = [" + subEntityName + "], requestBody = [" + requestBody + "], response = [" + response + "]");
        String subEntityType = "";
        String renderingEngineDetails = "";
        EmsEntityType emsEntityType = entityService.addSubEntityOfEntityType(entityType, subEntityName, subEntityType);
        if (emsEntityType != null)
            response.setStatus(HttpServletResponse.SC_CREATED);
        else
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return emsEntityType;
    }
    //Read DbEntity Definition
    @RequestMapping(value = "/check/entitytype/{entityType}", method = RequestMethod.GET)
    public Boolean hasEntityType(
            @PathVariable("entityType") String entityType,
            HttpServletResponse response){
        System.out.println("EmsController.hasEntityType");
        System.out.println("entityTypeName = [" + entityType + "]");
        if (entityService.hasEntityType(entityType)) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return false;
        }
    }
    @RequestMapping(value = "/check/attrtypes/{entityType}/{attributeName}", method = RequestMethod.GET)
    public Boolean hasAttributeOfEntityType(
            @PathVariable("entityType") String entityType,
            @PathVariable("attributeName") String attributeName,
            HttpServletResponse response) {
        System.out.println("EmsController.instance initializer");
        System.out.println("entityTypeName = [" + entityType + "], attributeName = [" + attributeName + "]");
        if (entityService.hasAttributeOfEntityType(entityType, attributeName)) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return false;
        }
    }

    @RequestMapping(value = "/check/subentitytypes/{entityTypeName}/{subEntityName}", method = RequestMethod.GET)
    public Boolean hasSubEntityOfEntityType(
            @PathVariable("entityType") String entityType,
            @PathVariable("subEntityName") String subEntityName,
            HttpServletResponse response) {
        System.out.println("EmsController.hasSubEntityOfEntityType");
        System.out.println("entityType = [" + entityType + "], subEntityType = [" + subEntityName + "], response = [" + response + "]");
        if (entityService.hasAttributeOfEntityType(entityType, subEntityName)) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return false;
        }
    }
    @RequestMapping(value = "/entitytypes/{entityType}", method = RequestMethod.GET)
    public EmsEntityType getEntityType(
            @PathVariable("entityType") String entityType,
            HttpServletResponse response){
        System.out.println("EmsController.getEntityType");
        System.out.println("entityTypeName = [" + entityType + "]");
        EmsEntityType emsEntityType = entityService.getEntityType(entityType);
        if (emsEntityType != null)
            response.setStatus(HttpServletResponse.SC_OK);
        else
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return emsEntityType;
    }
    @RequestMapping(value = "/attrtypes/{entityType}/{attributeName}", method = RequestMethod.GET)
    public EmsAttributeType getAttributeOfEntityType(
            @PathVariable("entityType") String entityType,
            @PathVariable("attributeName") String attributeName,
            HttpServletResponse response) {
        System.out.println("EmsController.getAttributeOfEntityType");
        System.out.println("entityType = [" + entityType + "], attributeName = [" + attributeName + "]");
        EmsAttributeType emsAttributeType = entityService.getAttributeOfEntityType(entityType, attributeName);
        if (emsAttributeType != null)
            response.setStatus(HttpServletResponse.SC_OK);
        else
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return emsAttributeType;
    }
    @RequestMapping(value = "/subentitytypes/{entityType}/{subEntityName}", method = RequestMethod.GET)
    public EmsEntityType getSubEntityOfEntityType(
            @PathVariable("entityType") String entityType,
            @PathVariable("subEntityName") String subEntityName,
            HttpServletResponse response) {
        System.out.println("EmsController.getSubEntityOfEntityType");
        System.out.println("entityType = [" + entityType + "], subEntityName = [" + subEntityName + "]");
        EmsEntityType emsEntityType = entityService.getSubEntityOfEntityType(entityType, subEntityName);
        if (emsEntityType != null)
            response.setStatus(HttpServletResponse.SC_OK);
        else
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return emsEntityType;
    }
    //EmsEntity Create
    Long addEntity(@PathVariable("entityType") String entityTypeName){return null;}
    Long addEntity(@PathVariable("entityType") String entityTypeName, String entityName){return null;}
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
