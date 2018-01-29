package com.ems.controller;

import com.ems.model.EmsEntityType;
import com.ems.model.EmsEntityTypeFieldRef;
import com.ems.model.EmsFieldType;
import com.ems.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
    @RequestMapping(value = "/entitytypes",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<EmsEntityType> addNewEntityType(@RequestBody EmsEntityType entityType) {
        System.out.println("EmsController.addNewEntityType");
        System.out.println("entityType = [" + entityType + "]");
        try {
            EmsEntityType emsEntityType = entityService.addNewEntityType(entityType);
            if (emsEntityType != null) {
                return new ResponseEntity<>(emsEntityType, HttpStatus.CREATED);
            }
        } catch (Exception e) {
        }
        return new ResponseEntity<>(entityType, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/entitytypes/{entitytype}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<Map<String,EmsEntityTypeFieldRef>> addAttributesOfEntityType(
            @PathVariable("entitytype") String entityType,
            @RequestBody Map<String, EmsFieldType> attributesOrSubEntities) {
        System.out.println("EmsController.addAttributeOfEntityType");
        System.out.println("attributesOrSubEntities = [" + attributesOrSubEntities + "]");
        Map<String, EmsEntityTypeFieldRef> resultRefsMap = new HashMap<>();
        try {
            EmsEntityType emsEntityType = entityService.getEntityType(entityType);
            if (emsEntityType != null) {
                int count = 0;
                for(Map.Entry<String, EmsFieldType> fieldDetails : attributesOrSubEntities.entrySet()) {
                    if (! fieldDetails.getValue().getSubEntity()) {
                        EmsFieldType emsFieldType = entityService.addAttributeOfEntityType(entityType,
                                fieldDetails.getKey(),
                                fieldDetails.getValue().getFieldTypeName(),
                                fieldDetails.getValue().getRenderingDetailsIfAttribute());
                        if (emsFieldType != null) {
                            resultRefsMap.put(fieldDetails.getKey(), new EmsEntityTypeFieldRef(entityType, fieldDetails.getKey()));
                            count++;
                        } else
                            resultRefsMap.put(fieldDetails.getKey(), new EmsEntityTypeFieldRef("", ""));
                    } else {
                        EmsEntityType emsFieldType = entityService.addSubEntityOfEntityType(entityType,
                                fieldDetails.getKey(),
                                fieldDetails.getValue().getFieldTypeName());
                        if (emsFieldType != null) {
                            resultRefsMap.put(fieldDetails.getKey(), new EmsEntityTypeFieldRef(entityType, fieldDetails.getKey()));
                            count++;
                        } else
                            resultRefsMap.put(fieldDetails.getKey(), new EmsEntityTypeFieldRef("", ""));
                    }
                }
                if (count == 0)
                    return new ResponseEntity<>(resultRefsMap, HttpStatus.BAD_REQUEST);
                else if (count < attributesOrSubEntities.size())
                    return new ResponseEntity<>(resultRefsMap, HttpStatus.PARTIAL_CONTENT);
                else
                    return new ResponseEntity<>(resultRefsMap, HttpStatus.CREATED);
            }
        } catch (Exception e) {
        }
        return new ResponseEntity<>(resultRefsMap, HttpStatus.BAD_REQUEST);
    }

    //Read DbEntity Definition
    @RequestMapping(value = "/entitytypes/{entitytype}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public ResponseEntity<EmsEntityType> getEntityType(
            @PathVariable("entitytype") String entityType) {
        System.out.println("EmsController.getEntityType");
        System.out.println("entityTypeName = [" + entityType + "]");
        try {
            EmsEntityType emsEntityType = entityService.getEntityType(entityType);
            if (emsEntityType != null)
                return new ResponseEntity<>(emsEntityType, HttpStatus.OK);
        } catch (Exception e) {
        }
        return new ResponseEntity<>(new EmsEntityType(entityType), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/entitytypes/{entitytype}/{attributeorsubentityname}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public ResponseEntity<?> getAttributeOfEntityType(
            @PathVariable("entitytype") String entityType,
            @PathVariable("attributeorsubentityname") String attributeOrSubEntityName) {
        System.out.println("EmsController.getAttributeOfEntityType");
        System.out.println("entityType = [" + entityType + "], attributeOrSubEntityName = [" + attributeOrSubEntityName + "]");
        try {
            EmsFieldType emsFieldType = entityService.getAttributeOfEntityType(entityType, attributeOrSubEntityName);
            if (emsFieldType != null)
                return new ResponseEntity<>(Collections.singletonMap(
                        attributeOrSubEntityName, emsFieldType), HttpStatus.OK);
            else {
                EmsEntityType emsEntityType = entityService.getSubEntityOfEntityType(entityType, attributeOrSubEntityName);
                if (emsEntityType != null)
                    return new ResponseEntity<>(Collections.singletonMap(
                            attributeOrSubEntityName, emsEntityType), HttpStatus.OK);
            }
        } catch (Exception e) {
        }
        return new ResponseEntity<>(attributeOrSubEntityName, HttpStatus.NOT_FOUND);
    }

    //EmsEntity Create
    Long addEntity(String entityTypeName) {
        return null;
    }

    Long addEntity(String entityTypeName, String entityName) {
        return null;
    }

    String addAttributeOfEntity(String entityName, String attributeName, String value) {
        return null;
    }

    Long addSubEntityOfEntity(String entityName, String subEntityName, Long emsSubEntityRef) {
        return null;
    }

    String addAttributeOfEntity(Long entityId, String attributeName, String value) {
        return null;
    }

    Long addSubEntityOfEntity(Long entityId, String subEntityName, Long emsSubEntityRef) {
        return null;
    }

    //EmsEntity Read
    Boolean hasEntity(String entityName) {
        return null;
    }

    Boolean hasEntity(Long EntityId) {
        return null;
    }

    Boolean hasAttributeOfEntity(String entityName, String attributeName) {
        return null;
    }

    Boolean hasSubEntityOfEntity(String entityName, String subEntityName) {
        return null;
    }

    Boolean hasAttributeOfEntity(Long entityId, String attributeName) {
        return null;
    }

    Boolean hasSubEntityOfEntity(Long entityId, String subEntityName) {
        return null;
    }

    Long getEntity(String entityName) {
        return null;
    }

    String getAttributeOfEntity(String entityName, String attributeName) {
        return null;
    }

    Long getSubEntityOfEntity(String entityName, String subEntityName) {
        return null;
    }

    String getAttributeOfEntity(Long entityId, String attributeName) {
        return null;
    }

    Long getSubEntityOfEntity(Long entityId, String subEntityName) {
        return null;
    }

    //EmsEntity Update
    String updateAttributeOfEntity(String entityName, String attributeName, String value) {
        return null;
    }

    String updateAttributeOfEntity(Long entityId, String attributeName, String value) {
        return null;
    }

    Long updateSubEntityOfEntity(String entityName, String subEntityName, Long emsSubEntityRef) {
        return null;
    }

    Long updateSubEntityOfEntity(Long entityId, String subEntityName, Long emsSubEntityRef) {
        return null;
    }

    //EmsEntity Delete
    Boolean deleteEntity(String entityName) {
        return null;
    }

    Boolean deleteEntity(Long entityId) {
        return null;
    }

    Boolean deleteAttributeFromEntity(String entityName, String attributeTypeName) {
        return null;
    }

    Boolean deleteSubEntityFromEntity(String entityName, String subEntityTypeName) {
        return null;
    }

    Boolean deleteAttributeFromEntity(Long entityId, String attributeTypeName) {
        return null;
    }

    Boolean deleteSubEntityFromEntity(Long entityId, String subEntityTypeName) {
        return null;
    }
}
