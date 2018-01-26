package com.ems.model.map;

import java.util.Hashtable;

/**
 * Created by Ashish on 26-01-2018.
 */
public class EntityDef {
    private final String entityName;
    private final Hashtable<String, AttributeDef> attributes;
    private final Hashtable<String, String> subEntities;

    public EntityDef(String entityName) {
        this.entityName = entityName;
        this.attributes = new Hashtable<>();
        this.subEntities = new Hashtable<>();
    }

    public String getEntityName() {
        return entityName;
    }

    public Hashtable<String, AttributeDef> getAttributes() {
        return attributes;
    }

    public Hashtable<String, String> getSubEntities() {
        return subEntities;
    }
}
