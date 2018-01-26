package com.ems.model.map;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Ashish on 26-01-2018.
 */
public class AttributeDef {
    private final String attributeName;
    private final String attributeType;
    private final String renderingDetails;

    public AttributeDef(String attributeName, String attributeType, String renderingDetails) {
        this.attributeName = attributeName;
        this.attributeType = attributeType;
        this.renderingDetails = renderingDetails;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public String getRenderingDetails() {
        return renderingDetails;
    }
}
