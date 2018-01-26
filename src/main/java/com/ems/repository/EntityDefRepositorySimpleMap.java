package com.ems.repository;

import com.ems.model.map.AttributeDef;
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
        if (null == entityDefMap.get(entityDefName)) {
            EntityDef ed = new EntityDef(entityDefName);
            entityDefMap.putIfAbsent(entityDefName, ed);
            if ((entityDefMap.get(entityDefName) == ed)) return 0;
        }
        return -1;
    }

    
    public int addAttributeToEntityDef(String entityDefName, String attributeDefName, String attributeType, String renderingEngineDetails) {
        EntityDef ed = entityDefMap.get(entityDefName);
        if (ed != null) {
            if (null == ed.getAttributes().get(attributeDefName)) {
                AttributeDef attributeDef = new AttributeDef(attributeDefName, attributeType, renderingEngineDetails);
                ed.getAttributes().putIfAbsent(attributeDefName, attributeDef);
                if ((ed.getAttributes().get(attributeDefName)) == attributeDef) return 0;
            }
        }
        return -1;
    }

    
    public int addSubEntityToEntityDef(String entityDefName, String subEntityDefName, String subEntityType) {
        EntityDef ed = entityDefMap.get(entityDefName);
        if (ed != null) {
            if (null == ed.getSubEntities().get(subEntityDefName)) {
                ed.getSubEntities().putIfAbsent(subEntityDefName, subEntityType);
                if ((ed.getSubEntities().get(subEntityDefName)) == subEntityType) return 0;
            }
        }
        return -1;
    }

    
    public String getAttributeOfEntityDef(String entityDefName, String attributeDefName) {
        EntityDef ed = entityDefMap.get(entityDefName);
        if (ed != null) {
            AttributeDef attributeDef = ed.getAttributes().get(attributeDefName);
            if (attributeDef != null) {
                return attributeDef.getAttributeName();
            }
        }
        return null;
    }

    
    public String getSubEntityOfEntityDef(String entityDefName, String subEntityDefName) {
        EntityDef ed = entityDefMap.get(entityDefName);
        if (ed != null) {
            return ed.getSubEntities().get(subEntityDefName);
        }
        return null;
    }

    
    public String getEntityDef(String entityDefName) {
        EntityDef ed = entityDefMap.get(entityDefName);
        return ((ed != null) ? ed.getEntityName() : null);
    }
}
