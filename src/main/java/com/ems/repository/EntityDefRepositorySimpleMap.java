package com.ems.repository;

import com.ems.model.map.EntityDef;
import org.springframework.stereotype.Repository;

import java.util.Hashtable;

/**
 * Created by Ashish on 27-01-2018.
 */
@Repository
public class EntityDefRepositorySimpleMap {
    private final Hashtable<String, EntityDef> entityDefMap;

    public EntityDefRepositorySimpleMap() {
        entityDefMap = new Hashtable<>();
    }

    public int addNewEntityDef(String entityDefName) {
        return 0;
    }

    
    public int addAttributeToEntityDef(String entityDefName, String attributeDefName, String attributeType, String renderingEngineDetails) {
        return 0;
    }

    
    public int addSubEntityToEntityDef(String entityDefName, String subEntityDefName, String subEntityType) {
        return 0;
    }

    
    public String getAttributeOfEntityDef(String entityDefName, String attributeDefName) {
        return null;
    }

    
    public String getSubEntityOfEntityDef(String entityDefName, String subEntityDefName) {
        return null;
    }

    
    public String getEntityDef(String entityDefName) {
        return null;
    }
}
