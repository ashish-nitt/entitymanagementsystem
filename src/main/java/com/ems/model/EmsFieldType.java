package com.ems.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by Ashish on 26-01-2018.
 */
public class EmsFieldType {
    @JsonProperty("fieldTypeName")
    private String fieldTypeName;
    @JsonProperty("subEntity")
    private Boolean subEntity;
    @JsonProperty("renderingDetailsIfAttribute")
    private String renderingDetailsIfAttribute;

    public EmsFieldType() {
        this.fieldTypeName = "";
        this.subEntity = null;
    }

    public EmsFieldType(String fieldTypeName, String renderingDetailsIfAttribute) {
        this.fieldTypeName = fieldTypeName;
        this.renderingDetailsIfAttribute = renderingDetailsIfAttribute;
        this.subEntity = false;
    }

    public EmsFieldType(String fieldTypeName) {
        this.fieldTypeName = fieldTypeName;
        this.subEntity = true;
        this.renderingDetailsIfAttribute = null;
    }

    public String getFieldTypeName() {
        return fieldTypeName;
    }

    public String getRenderingDetailsIfAttribute() {
        return renderingDetailsIfAttribute;
    }

    public Boolean getSubEntity() {
        return subEntity;
    }

    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmsFieldType)) return false;

        EmsFieldType that = (EmsFieldType) o;

        if (!fieldTypeName.equals(that.fieldTypeName)) return false;
        return subEntity.equals(that.subEntity);
    }

    @Override
    public int hashCode() {
        int result = fieldTypeName.hashCode();
        result = 31 * result + subEntity.hashCode();
        return result;

    }
}
