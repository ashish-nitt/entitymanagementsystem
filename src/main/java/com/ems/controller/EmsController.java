package com.ems.controller;

import com.ems.model.EmsAttributeType;
import com.ems.model.EmsEntityType;
import com.ems.service.EntityService;
import org.springframework.asm.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
    public ResponseEntity<Map<String, EmsAttributeType>> addAttributeOfEntityType(
            @PathVariable("entitytype") String entityType,
            @RequestBody Map<String, EmsAttributeType> attributes) {
        System.out.println("EmsController.addAttributeOfEntityType");
        System.out.println("attributes = [" + attributes + "]");
        try {
            EmsEntityType emsEntityType = entityService.getEntityType(entityType);
            if (emsEntityType != null) {
                attributes.forEach((attr, attrType) -> {
                    entityService.addAttributeOfEntityType(entityType,
                            attr,
                            attrType.getAttributeTypeName(),
                            attrType.getRenderingDetails());
                });
                return new ResponseEntity<>(emsEntityType.getAttributes(), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
        }
        return new ResponseEntity<>(attributes, HttpStatus.BAD_REQUEST);
    }

/*    @RequestMapping(value = "/entitytypes/{entitytype}", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> addSubEntityOfEntityType(
            @PathVariable("entitytype") String entityType,
            @RequestBody Map<String, String> subEntities) {
        System.out.println("EmsController.addSubEntityOfEntityType");
        System.out.println("SubEntitys = [" + subEntities + "]");
        try {
            EmsEntityType emsEntityType = entityService.getEntityType(entityType);
            if (emsEntityType != null) {
                subEntities.forEach((subEntity, subEntityType) -> {
                    entityService.addSubEntityOfEntityType(entityType,
                            subEntity,
                            subEntityType);
                });
                return new ResponseEntity<>(emsEntityType.getSubEntities(), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
        }
        return new ResponseEntity<>(subEntities, HttpStatus.BAD_REQUEST);
    }*/

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
                return new ResponseEntity<EmsEntityType>(emsEntityType, HttpStatus.OK);
        } catch (Exception e) {
        }
        return new ResponseEntity<EmsEntityType>(new EmsEntityType(entityType), HttpStatus.NOT_FOUND);
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
            EmsAttributeType emsAttributeType = entityService.getAttributeOfEntityType(entityType, attributeOrSubEntityName);
            if (emsAttributeType != null)
                return new ResponseEntity<EmsAttributeType>(emsAttributeType, HttpStatus.OK);
            else {
                EmsEntityType emsEntityType = entityService.getSubEntityOfEntityType(entityType, attributeOrSubEntityName);
                if (emsEntityType != null)
                    return new ResponseEntity<EmsEntityType>(emsEntityType, HttpStatus.OK);
            }
        } catch (Exception e) {
        }
        return new ResponseEntity<String>(attributeOrSubEntityName, HttpStatus.NOT_FOUND);
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
