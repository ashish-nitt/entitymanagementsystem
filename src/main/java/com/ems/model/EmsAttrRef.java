package com.ems.model;

/**
 * Created by Ashish on 27-01-2018.
 */
public class EmsAttrRef {
    private Long entityId;
    private String fieldName;

    private EmsAttrRef(Long entityId, String fieldName) {
        this.entityId = entityId;
        this.fieldName = fieldName;
    }

    public EmsAttrRef() {
    }

    public static EmsAttrRef from(Long entityId, String fieldName) {
        return new EmsAttrRef(entityId, fieldName);
    }

    public EmsAttrRef newAttributeIdentifier(String fieldNameNew) {
        return new EmsAttrRef(entityId, fieldNameNew);
    }

    public Long getEntityId() {
        return entityId;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmsAttrRef)) return false;

        EmsAttrRef that = (EmsAttrRef) o;

        if (!entityId.equals(that.entityId)) return false;
        return fieldName.equals(that.fieldName);

    }

    @Override
    public int hashCode() {
        int result = entityId.hashCode();
        result = 31 * result + fieldName.hashCode();
        return result;
    }

    public Boolean isEntity() {
        return fieldName.equals("");
    }

    public Boolean isAttribute() {
        return ! fieldName.equals("");
    }
}
