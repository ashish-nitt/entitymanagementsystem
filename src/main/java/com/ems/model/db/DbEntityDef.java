package com.ems.model.db;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ashish on 26-01-2018.
 */
@javax.persistence.Entity
public class DbEntityDef {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String entityId;
    String entityName;
}
