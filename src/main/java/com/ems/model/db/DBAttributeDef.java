package com.ems.model.db;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Ashish on 26-01-2018.
 */
public class DBAttributeDef {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String attributeId;
    private String attributeName;
    private String attributeType;
    @ManyToOne
    DbEntityDef dbEntityDef;
}
