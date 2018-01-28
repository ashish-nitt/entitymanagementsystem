package com.ems.model;

/**
 * Created by Ashish on 26-01-2018.
 */
public class EmsAttributeType {
    private final String attributeTypeName;
    private final String renderingDetails;

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
