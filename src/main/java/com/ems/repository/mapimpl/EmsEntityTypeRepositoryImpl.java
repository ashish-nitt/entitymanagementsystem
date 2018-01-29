package com.ems.repository.mapimpl;

import com.ems.model.EmsAttributeType;
import com.ems.model.EmsEntityType;
import com.ems.repository.EmsEntityTypeRepository;
import org.springframework.util.StringUtils;

/**
 * Created by Ashish on 28-01-2018.
 */
public class EmsEntityTypeRepositoryImpl extends EmsEntityRepositorySimpleMapContainer implements EmsEntityTypeRepository {
    @Override
    public EmsEntityType addNewEntityType(String entityTypeName) {
        return entityTypeNameToentityType.addNew(entityTypeName, new EmsEntityType(entityTypeName));
    }

    @Override
    public EmsEntityType addNewEntityType(EmsEntityType emsEntityType) {
        return entityTypeNameToentityType.addNew(emsEntityType.getEntityTypeName(), new EmsEntityType(emsEntityType));
    }

    @Override
    public EmsAttributeType addAttributeOfEntityType(String entityTypeName, String attributeName, String attributeType, String renderingEngineDetails) {
        EmsEntityType emsEntityType = getEntityType(entityTypeName);
        if (emsEntityType != null) {
            EmsAttributeType emsAttributeType = new EmsAttributeType(attributeName, attributeType);
            emsEntityType.getAttributes().putIfAbsent(attributeName, emsAttributeType);
            if (emsEntityType.getAttributeType(attributeName).equals(emsAttributeType)) return emsAttributeType;
        }
        return null;
    }

    @Override
    public EmsEntityType addSubEntityOfEntityType(String entityTypeName, String subEntityName, String subEntityType) {
        EmsEntityType emsEntityType = getEntityType(entityTypeName);
        EmsEntityType emsSubEntityType = getEntityType(subEntityType);
        if (emsEntityType != null && emsSubEntityType != null) {
            if (!emsEntityType.getSubEntities().containsKey(subEntityName)) {
                emsEntityType.getSubEntities().putIfAbsent(subEntityName, subEntityType);
                String subEntityTypeName = emsEntityType.getSubEntityType(subEntityName);
                if (subEntityType.equals(subEntityTypeName)) {
                    return emsSubEntityType;
                }
            }
        }
        return null;
    }

    @Override
    public Boolean hasEntityType(String entityTypeName) {
        return getEntityType(entityTypeName) != null;
    }

    @Override
    public Boolean hasAttributeOfEntityType(String entityTypeName, String attributeTypeName) {
        return getAttributeOfEntityType(entityTypeName, attributeTypeName) != null;
    }

    @Override
    public Boolean hasSubEntityOfEntityType(String entityTypeName, String subEntityType) {
        return getSubEntityOfEntityType(entityTypeName, subEntityType) != null;
    }

    @Override
    public EmsEntityType getEntityType(String entityTypeName) {
        if (StringUtils.isEmpty(entityTypeName)) return null;
        return entityTypeNameToentityType.get(entityTypeName);
    }

    @Override
    public EmsAttributeType getAttributeOfEntityType(String entityTypeName, String attributeTypeName) {
        EmsEntityType emsEntityType = getEntityType(entityTypeName);
        if (emsEntityType != null) {
            return emsEntityType.getAttributes().get(attributeTypeName);
        }
        return null;
    }

    @Override
    public EmsEntityType getSubEntityOfEntityType(String entityTypeName, String subEntityName) {
        EmsEntityType emsEntityType = getEntityType(entityTypeName);
        if (emsEntityType != null) {
            String subEntityType = emsEntityType.getSubEntityType(subEntityName);
            if (subEntityType != null)
                return getEntityType(subEntityType);
        }
        return null;
    }
}
