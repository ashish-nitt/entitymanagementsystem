package com.ems.model;

import java.util.Map;

/**
 * Created by Ashish on 30-01-2018.
 */
public class EmsEntityTypeFieldRef {
    private String entityTypeName;
    private String fieldName;

    public EmsEntityTypeFieldRef() {
    }

    public EmsEntityTypeFieldRef(String entityTypeName, String fieldName) {
        this.entityTypeName = entityTypeName;
        this.fieldName = fieldName;
    }

    public String getEntityTypeName() {
        return entityTypeName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
