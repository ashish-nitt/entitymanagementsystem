package com.ems.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Ashish on 26-01-2018.
 */
public class EmsEntityType {
    private String entityTypeName;
    private Map<String, EmsAttributeType> attributes;
    private Map<String, String> subEntities;

    public EmsEntityType(){}

    public EmsEntityType(String entityTypeName) {
        this.entityTypeName = entityTypeName;
        this.attributes = Collections.synchronizedMap(new HashMap<>());
        this.subEntities = Collections.synchronizedMap(new HashMap<>());
    }
    public EmsEntityType(EmsEntityType entityType) {
        this.entityTypeName = entityType.getEntityTypeName();
        this.attributes = Collections.synchronizedMap(new HashMap<>());
        this.subEntities = Collections.synchronizedMap(new HashMap<>());
        entityType.getAttributes().forEach((attributeName,attributeType) -> {
            this.attributes.put(attributeName, attributeType);
        });
        entityType.getSubEntities().forEach((subEntityName,subEntityTypeName) -> {
            this.subEntities.put(subEntityName, subEntityTypeName);
        });
    }

    public String getEntityTypeName() {
        return entityTypeName;
    }

    public Map<String, EmsAttributeType> getAttributes() {
        return attributes;
    }

    public Map<String, String> getSubEntities() {
        return subEntities;
    }

    public EmsAttributeType getAttributeType(String attributeName) {
        return attributes.get(attributeName);
    }

    public String getSubEntityType(String subEntityName) {
        return subEntities.get(subEntityName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmsEntityType)) return false;

        EmsEntityType that = (EmsEntityType) o;
        return entityTypeName.equals(that.entityTypeName);
    }

    @Override
    public int hashCode() {
        int result = entityTypeName.hashCode();
        result = 31 * result + attributes.hashCode();
        result = 31 * result + subEntities.hashCode();
        return result;
    }
}
