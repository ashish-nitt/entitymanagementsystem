package com.ems.repository.mapimpl;

import com.ems.model.EmsFieldType;
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
    public EmsFieldType addAttributeOfEntityType(String entityTypeName, String attributeName, String attributeType, String renderingEngineDetails) {
        EmsEntityType emsEntityType = getEntityType(entityTypeName);
        if (emsEntityType != null) {
            EmsFieldType emsFieldType = new EmsFieldType(attributeName, attributeType);
            emsEntityType.getAttributes().putIfAbsent(attributeName, emsFieldType);
            if (emsEntityType.getAttributeType(attributeName) == emsFieldType) return emsFieldType;
        }
        return null;
    }

    @Override
    public EmsEntityType addSubEntityOfEntityType(String entityTypeName, String subEntityName, String subEntityType) {
        EmsEntityType emsEntityType = getEntityType(entityTypeName);
        EmsEntityType emsSubEntityType = getEntityType(subEntityType);
        if (emsEntityType != null && emsSubEntityType != null) {
            if (!emsEntityType.getSubEntities().containsKey(subEntityName)) {
                EmsFieldType subEntityFieldType = new EmsFieldType(subEntityType);
                emsEntityType.getSubEntities().putIfAbsent(subEntityName, subEntityFieldType);
                EmsFieldType subEntityFieldType1 = emsEntityType.getSubEntityType(subEntityName);
                if (subEntityFieldType1.getFieldTypeName().equals(subEntityFieldType.getFieldTypeName())) {
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
    public EmsFieldType getAttributeOfEntityType(String entityTypeName, String attributeTypeName) {
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
            EmsFieldType subEntityType = emsEntityType.getSubEntityType(subEntityName);
            if (subEntityType != null)
                return getEntityType(subEntityType.getFieldTypeName());
        }
        return null;
    }
}
