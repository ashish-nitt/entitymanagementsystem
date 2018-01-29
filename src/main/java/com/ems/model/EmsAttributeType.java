package com.ems.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by Ashish on 26-01-2018.
 */
public class EmsAttributeType {
    @JsonProperty("attributeTypeName")
    private String attributeTypeName;
    @JsonProperty("renderingDetails")
    private String renderingDetails;

    public EmsAttributeType() {
    }

    public EmsAttributeType(String attributeTypeName, String renderingDetails) {
        this.attributeTypeName = attributeTypeName;
        this.renderingDetails = renderingDetails;
    }

    public String getAttributeTypeName() {
        return attributeTypeName;
    }

    public String getRenderingDetails() {
        return renderingDetails;
    }
}
