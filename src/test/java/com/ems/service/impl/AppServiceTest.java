package com.ems.service.impl;

import com.ems.config.TestConfig;
import com.ems.service.EntityService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.*;

/**
 * Created by Ashish on 26-01-2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigContextLoader.class)
public class AppServiceTest {
    @Autowired
    EntityService entityService;

    private Long invalidSubEntityRef;

    @Before
    public void setUp(){
        invalidSubEntityRef = -1L;
    }

    @Test
    public void test() throws Exception{
        testAddNewEntityType();
        testAddAttributeOfEntityType();
        testAddSubEntityOfEntityType();
        testAddEntity();
        testAddAttributeOfEntity();
        testAddSubEntityOfEntity();
        testUpdateAttributeOfEntity();
        testUpdateSubEntityOfEntity();
        testDeleteAttributeFromEntity();
        testDeleteSubEntityFromEntity();
        testDeleteEntity();
    }

    public void testAddNewEntityType() throws Exception {
        assertNull(entityService.addNewEntityType(""));
        assertNotNull(entityService.addNewEntityType("t1"));
        assertNotNull(entityService.addNewEntityType("t2"));
        assertNotNull(entityService.addNewEntityType("t3"));
        assertNotNull(entityService.addNewEntityType("t4"));
        assertNotNull(entityService.addNewEntityType("t5"));
        assertNull(entityService.addNewEntityType("t1"));
        assertNull(entityService.addNewEntityType("t2"));

        assertNotNull(entityService.getEntityType("t1"));
        assertNotNull(entityService.getEntityType("t2"));
        assertNull(entityService.getEntityType("e3"));
        assertNull(entityService.getEntityType(""));
    }

    public void testAddAttributeOfEntityType() throws Exception {
        assertNotNull(entityService.addAttributeOfEntityType("t1", "a1", "", ""));
        assertNull(entityService.addAttributeOfEntityType("t1", "a1", "", ""));
        assertNotNull(entityService.addAttributeOfEntityType("t1", "a2", "", ""));
        assertNull(entityService.addAttributeOfEntityType("t1", "", "", ""));
        assertNotNull(entityService.addAttributeOfEntityType("t2", "a1", "", ""));
        assertNull(entityService.addAttributeOfEntityType("t2", "a1", "", ""));
        assertNotNull(entityService.addAttributeOfEntityType("t2", "a2", "", ""));

        assertNotNull(entityService.getAttributeOfEntityType("t1", "a1"));
        assertNotNull(entityService.getAttributeOfEntityType("t2", "a1"));
        assertNull(entityService.getAttributeOfEntityType("e3", "a1"));
        assertNull(entityService.getAttributeOfEntityType("t1", "a3"));
        assertNull(entityService.getAttributeOfEntityType("t1", ""));
        assertNull(entityService.getAttributeOfEntityType("", ""));
    }

    public void testAddSubEntityOfEntityType() throws Exception {
        assertNotNull(entityService.addSubEntityOfEntityType("t1", "se1", "t1"));
        assertNull(entityService.addSubEntityOfEntityType("t1", "se1", "t1"));
        assertNotNull(entityService.addSubEntityOfEntityType("t1", "se2", "t2"));
        assertNull(entityService.addSubEntityOfEntityType("t1", "", "t2"));
        assertNotNull(entityService.addSubEntityOfEntityType("t2", "se1", "t3"));
        assertNull(entityService.addSubEntityOfEntityType("t2", "se1", "t4"));
        assertNotNull(entityService.addSubEntityOfEntityType("t2", "se2", "t5"));

        assertNotNull(entityService.getSubEntityOfEntityType("t1", "se1"));
        assertNotNull(entityService.getSubEntityOfEntityType("t2", "se1"));
        assertNull(entityService.getAttributeOfEntityType("e3", "se3"));
        assertNull(entityService.getAttributeOfEntityType("t1", "se3"));
        assertNull(entityService.getAttributeOfEntityType("t1", ""));
        assertNull(entityService.getAttributeOfEntityType("", ""));
    }

    
    public void testAddEntity() throws Exception {
        assertNull(entityService.addEntity("t1", ""));
        assertNotNull(entityService.addEntity("t1", "v1"));
        assertNotNull(entityService.addEntity("t2", "v2"));
        assertNull(entityService.addEntity("t1", "v1"));

        assertNotNull(entityService.getEntity("v1"));
        assertNotNull(entityService.getEntity("v2"));
        assertNull(entityService.getEntity("v3"));
        assertNull(entityService.getEntity(""));
    }

    
    public void testAddAttributeOfEntity() throws Exception {
        assertNull(entityService.addAttributeOfEntity("v1", "", ""));
        assertNotNull(entityService.addAttributeOfEntity("v1", "a1", "v1a1"));
        assertNotNull(entityService.addAttributeOfEntity("v1", "a2", "v1a2"));
        assertNull(entityService.addAttributeOfEntity("v1", "a1", "v1a1"));

        assertTrue(entityService.getAttributeOfEntity("v1","a1").equals("v1a1"));
        assertTrue(entityService.getAttributeOfEntity("v1","a2").equals("v1a2"));
        assertNull(entityService.getAttributeOfEntity("v1","a4"));
    }

    
    public void testAddSubEntityOfEntity() throws Exception {
        Long v1s1 = entityService.addEntity("t1", "v1s1");
        Long v1s2 = entityService.addEntity("t1", "v1s2");
        assertNull(entityService.addSubEntityOfEntity("v1", "", invalidSubEntityRef));
        assertNotNull(entityService.addSubEntityOfEntity("v1", "s1", v1s1));
        assertNotNull(entityService.addSubEntityOfEntity("v1", "s2", v1s2));
        assertNull(entityService.addSubEntityOfEntity("v1", "s1", invalidSubEntityRef));

        assertTrue(entityService.getSubEntityOfEntity("v1","s1").equals(v1s1));
        assertTrue(entityService.getSubEntityOfEntity("v1","s2").equals(v1s2));
    }

    
    public void testUpdateAttributeOfEntity() throws Exception {
        assertNull(entityService.updateAttributeOfEntity("v1", "", ""));
        assertNotNull(entityService.updateAttributeOfEntity("v1", "a1", "v1a1u1"));
        assertNotNull(entityService.updateAttributeOfEntity("v1", "a2", "v1a2u1"));
        assertNotNull(entityService.updateAttributeOfEntity("v1", "a1", "v1a1u1"));
        assertNull(entityService.updateAttributeOfEntity("v1", "a3", "v1a3u1"));

        assertTrue(entityService.getAttributeOfEntity("v1","a1").equals("v1a1u1"));
        assertTrue(entityService.getAttributeOfEntity("v1","a2").equals("v1a2u1"));
    }

    
    public void testUpdateSubEntityOfEntity() throws Exception {
        Long v1s1u1 = entityService.addEntity("t1", "v1s1u1");
        Long v1s2u1 = entityService.addEntity("t1", "v1s2u1");
        assertNull(entityService.updateSubEntityOfEntity("v1", "", invalidSubEntityRef));
        assertNotNull(entityService.updateSubEntityOfEntity("v1", "se1", v1s1u1));
        assertNotNull(entityService.updateSubEntityOfEntity("v1", "se2", v1s2u1));
        assertNotNull(entityService.updateSubEntityOfEntity("v1", "se1", v1s1u1));
        assertNull(entityService.updateSubEntityOfEntity("v1", "se3", invalidSubEntityRef));

        assertTrue(entityService.getSubEntityOfEntity("v1","se1").equals(v1s1u1));
        assertTrue(entityService.getSubEntityOfEntity("v1","se2").equals(v1s2u1));
    }


    public void testDeleteEntity() throws Exception {
        assertNotNull(entityService.getEntity("v1"));
        assertNotNull(entityService.getEntity("v2"));

        assertFalse(entityService.deleteEntity(""));
        assertTrue(entityService.deleteEntity("v1"));
        assertTrue(entityService.deleteEntity("v2"));
        assertFalse(entityService.deleteEntity("v1"));

        assertNull(entityService.getEntity("v1"));
        assertNull(entityService.getEntity("v2"));
    }

    
    public void testDeleteAttributeFromEntity() throws Exception {
        assertFalse(entityService.deleteAttributeFromEntity("v1", ""));
        assertTrue(entityService.deleteAttributeFromEntity("v1", "a1"));
        assertTrue(entityService.deleteAttributeFromEntity("v1", "a2"));
        assertFalse(entityService.deleteAttributeFromEntity("v1", "a1"));

        assertNull(entityService.getAttributeOfEntity("v1", "a1"));
        assertNull(entityService.getAttributeOfEntity("v1", "a2"));
    }

    
    public void testDeleteSubEntityFromEntity() throws Exception {
        assertNotNull(entityService.getSubEntityOfEntity("v1", "s1"));
        assertNotNull(entityService.getSubEntityOfEntity("v1", "s2"));

        assertFalse(entityService.deleteSubEntityFromEntity("v1", ""));
        assertTrue(entityService.deleteSubEntityFromEntity("v1", "s1"));
        assertTrue(entityService.deleteSubEntityFromEntity("v1", "s2"));
        assertFalse(entityService.deleteSubEntityFromEntity("v1", "s1"));

        assertNull(entityService.getSubEntityOfEntity("v1", "s1"));
        assertNull(entityService.getSubEntityOfEntity("v1", "s2"));
    }
}