package com.ems.repository.mapimpl;

import com.ems.model.EmsAttrRef;
import com.ems.model.EmsEntityType;
import com.ems.model.MyHashTable;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Ashish on 28-01-2018.
 */
public class EmsEntityRepositorySimpleMapContainer {
    protected final MyHashTable<String, EmsEntityType> entityTypeNameToentityType;
    protected final MyHashTable<Long, String> referenceToTypeName;
    protected final MyHashTable<String, Long> nameToReference;
    protected final Set<Long> referenceToName;
    protected final MyHashTable<EmsAttrRef, String> attrRefToVal;
    protected final MyHashTable<EmsAttrRef, Long> subEntityRefToVal;
    protected final AtomicLong entityIdGenerator;

    public EmsEntityRepositorySimpleMapContainer() {
        entityTypeNameToentityType = new MyHashTable<>();
        subEntityRefToVal = new MyHashTable<>();
        nameToReference = new MyHashTable<>();
        referenceToName = Collections.synchronizedSet(new HashSet<Long>());
        attrRefToVal = new MyHashTable<>();
        referenceToTypeName = new MyHashTable<>();
        entityIdGenerator = new AtomicLong(0);
    }

    //entityIdGenerator
    public Long generateNewEntityId() {
        return entityIdGenerator.incrementAndGet();
    }

    //entityTypeNameToentityType
    public EmsEntityType getEntityType(String entityType) {
        if (StringUtils.isEmpty(entityType))
            return entityTypeNameToentityType.get(entityType);
        return null;
    }

    //varNameToTypeName
    public EmsEntityType getEntityTypeFromVarName(String varName) {
        Long reference = getReferenceForVarName(varName);
        if (reference != null)
            return getEntityType(referenceToTypeName.get(reference));
        return null;
    }

    //nameToReference
    public Long getReferenceForVarName(String varName) {
        return nameToReference.get(varName);
    }

    //referenceToName
    public boolean isVarName(Long entityId) {
        return referenceToName.contains(entityId);
    }

    //attrRefToVal
    public String getValForAttr(String varName, String attributeName) {
        return getValForAttr(getReferenceForVarName(varName), attributeName);
    }

    public String getValForAttr(Long entityId, String attributeName) {
        if (entityId != null) {
            return attrRefToVal.get(EmsAttrRef.from(entityId, attributeName));
        }
        return null;
    }

    //subEntityRefToVal
    public Long getRefForSubEntity(String varName, String subEntityName) {
        return getRefForSubEntity(getReferenceForVarName(varName), subEntityName);
    }

    public Long getRefForSubEntity(Long entityId, String subEntityName) {
        if (entityId != null) {
            return subEntityRefToVal.get(EmsAttrRef.from(entityId, subEntityName));
        }
        return null;
    }
}
