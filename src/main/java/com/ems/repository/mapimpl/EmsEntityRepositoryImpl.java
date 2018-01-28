package com.ems.repository.mapimpl;

import com.ems.model.EmsAttrRef;
import com.ems.model.EmsEntityType;
import com.ems.repository.EmsEntityRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ashish on 27-01-2018.
 */
@Repository
public class EmsEntityRepositoryImpl extends EmsEntityTypeRepositoryImpl implements EmsEntityRepository {
    @Override
    public Boolean hasEntity(Long EntityId) {
        return false;
    }

    @Override
    public Long addEntity(String entityTypeName) {
        if (hasEntityType(entityTypeName)) {
            Long newEntityId = generateNewEntityId();
            referenceToName.add(newEntityId);
            return newEntityId;
        }
        return null;
    }

    @Override
    public Long addEntity(String entityTypeName, String entityName) {
        if (! hasEntity(entityName)) {
            Long entityId = nameToReference.addNew(entityName, addEntity(entityTypeName));
            referenceToTypeName.add(entityId, entityTypeName);
            return entityId;
        }
        return null;
    }

    @Override
    public String addAttributeOfEntity(String entityName, String attributeName, String value) {
        return addAttributeOfEntity(getReferenceForVarName(entityName), attributeName, value);
    }

    @Override
    public Long addSubEntityOfEntity(String entityName, String subEntityName, Long emsSubEntityRef) {
        return addSubEntityOfEntity(getReferenceForVarName(entityName), subEntityName, emsSubEntityRef);
    }

    @Override
    public String addAttributeOfEntity(Long entityId, String attributeName, String value) {
        if (entityId != null) {
            return attrRefToVal.addNew(EmsAttrRef.from(entityId, attributeName), value);
        }
        return null;
    }

    @Override
    public Long addSubEntityOfEntity(Long entityId, String subEntityName, Long emsSubEntityRef) {
        if (entityId != null) {
            return subEntityRefToVal.addNew(EmsAttrRef.from(entityId, subEntityName), emsSubEntityRef);
        }
        return null;
    }

    @Override
    public Boolean hasEntity(String entityName) {
        return getReferenceForVarName(entityName) != null;
    }

    @Override
    public Boolean hasAttributeOfEntity(String entityName, String attributeName) {
        return getValForAttr(entityName, attributeName) != null;
    }

    @Override
    public Boolean hasSubEntityOfEntity(String entityName, String subEntityName) {
        return getRefForSubEntity(entityName, subEntityName) != null;
    }

    @Override
    public Boolean hasAttributeOfEntity(Long entityId, String attributeName) {
        return getValForAttr(entityId, attributeName) != null;
    }

    @Override
    public Boolean hasSubEntityOfEntity(Long entityId, String subEntityName) {
        return getRefForSubEntity(entityId, subEntityName) != null;
    }

    @Override
    public Long getEntity(String entityName) {
        return getReferenceForVarName(entityName);
    }

    @Override
    public String getAttributeOfEntity(String entityName, String attributeName) {
        return getValForAttr(entityName, attributeName);
    }

    @Override
    public Long getSubEntityOfEntity(String entityName, String subEntityName) {
        return getRefForSubEntity(entityName, subEntityName);
    }

    @Override
    public String getAttributeOfEntity(Long entityId, String attributeName) {
        return getValForAttr(entityId, attributeName);
    }

    @Override
    public Long getSubEntityOfEntity(Long entityId, String subEntityName) {
        return getRefForSubEntity(entityId, subEntityName);
    }

    @Override
    public String updateAttributeOfEntity(String entityName, String attributeName, String value) {
        return updateAttributeOfEntity(getReferenceForVarName(entityName), attributeName, value);
    }

    @Override
    public String updateAttributeOfEntity(Long entityId, String attributeName, String value) {
        if (entityId != null) {
            EmsEntityType emsEntityType = getEntityType(referenceToTypeName.get(entityId));
            if (emsEntityType != null && emsEntityType.getAttributes().containsKey(attributeName)) {
                return attrRefToVal.add(EmsAttrRef.from(entityId, attributeName), value);
            }
        }
        return null;
    }

    @Override
    public Long updateSubEntityOfEntity(String entityName, String subEntityName, Long emsSubEntityRef) {
        return updateSubEntityOfEntity(getReferenceForVarName(entityName), subEntityName, emsSubEntityRef);
    }

    @Override
    public Long updateSubEntityOfEntity(Long entityId, String subEntityName, Long emsSubEntityRef) {
        if (entityId != null) {
            EmsEntityType emsEntityType = getEntityType(referenceToTypeName.get(entityId));
            if (emsEntityType != null && emsEntityType.getSubEntities().containsKey(subEntityName)) {
                return subEntityRefToVal.add(EmsAttrRef.from(entityId, subEntityName), emsSubEntityRef);
            }
        }
        return null;
    }

    @Override
    public Boolean deleteEntity(String entityName) {
        if (deleteEntity(getReferenceForVarName(entityName))) {
            nameToReference.remove(entityName);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteEntity(Long entityId) {
        if (entityId != null && isVarName(entityId)) {
            referenceToName.remove(entityId);
            EmsEntityType emsEntityType = getEntityType(referenceToTypeName.get(entityId));
            if (emsEntityType != null) {
                for (String attibuteName : emsEntityType.getAttributes().keySet()) {
                    deleteAttributeFromEntity(entityId, attibuteName);
                }
                for (String subEntityName : emsEntityType.getSubEntities().keySet()) {
                    deleteSubEntityFromEntity(entityId, subEntityName);
                }
            }
            referenceToTypeName.remove(entityId);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteAttributeFromEntity(String entityName, String attributeName) {
        return deleteAttributeFromEntity(getReferenceForVarName(entityName), attributeName);
    }

    @Override
    public Boolean deleteSubEntityFromEntity(String entityName, String subEntityName) {
        return deleteSubEntityFromEntity(getReferenceForVarName(entityName), subEntityName);
    }

    @Override
    public Boolean deleteAttributeFromEntity(Long entityId, String attributeName) {
        return attrRefToVal.remove(EmsAttrRef.from(entityId, attributeName));
    }

    @Override
    public Boolean deleteSubEntityFromEntity(Long entityId, String subEntityTypeName) {
        EmsAttrRef emsAttrRef = EmsAttrRef.from(entityId, subEntityTypeName);
        Long subEntityId = subEntityRefToVal.get(emsAttrRef);
        recursiveDelete(subEntityId);
        return subEntityRefToVal.remove(emsAttrRef);
    }

    void recursiveDelete(Long entityId) {
        if (entityId != null && !isVarName(entityId)) {
            referenceToName.remove(entityId);
            EmsEntityType emsEntityType = getEntityType(referenceToTypeName.get(entityId));
            if (emsEntityType != null) {
                for (String attibuteName : emsEntityType.getAttributes().keySet()) {
                    deleteAttributeFromEntity(entityId, attibuteName);
                }
                for (String subEntityName : emsEntityType.getSubEntities().keySet()) {
                    deleteSubEntityFromEntity(entityId, subEntityName);
                }
            }
            referenceToTypeName.remove(entityId);
        }
    }
}
