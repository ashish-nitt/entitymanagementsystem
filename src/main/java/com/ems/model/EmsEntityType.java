package com.ems.model;

import java.util.Hashtable;
import java.util.stream.Stream;

/**
 * Created by Ashish on 26-01-2018.
 */
public class EmsEntityType {
    private final String entityTypeName;
    private final Boolean isStrict;
    private final Hashtable<String, EmsAttributeType> attributes;
    private final Hashtable<String, String> subEntityTypes;

    public EmsEntityType(String entityTypeName) {
        this.entityTypeName = entityTypeName;
        this.attributes = new Hashtable<>();
        this.subEntityTypes = new Hashtable<>();
        this.isStrict = true;
    }

    public String getEntityTypeName() {
        return entityTypeName;
    }

    public Hashtable<String, EmsAttributeType> getAttributes() {
        return attributes;
    }

    public Hashtable<String, String> getSubEntities() {
        return subEntityTypes;
    }

    public EmsAttributeType getAttributeType(String attributeName) {
        return attributes.get(attributeName);
    }

    public String getSubEntityType(String subEntityName) {
        return subEntityTypes.get(subEntityName);
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
        result = 31 * result + (isStrict ? 1 : 0);
        result = 31 * result + attributes.hashCode();
        result = 31 * result + subEntityTypes.hashCode();
        return result;
    }
}
