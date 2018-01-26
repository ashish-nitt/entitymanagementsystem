package com.ems.service.impl;

import com.ems.config.TestConfig;
import com.ems.service.EntityDefService;
import com.ems.service.EntityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Ashish on 26-01-2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigContextLoader.class)
public class AppServiceTest {
    @Autowired
    EntityDefService entityDefService;
    @Autowired
    EntityService entityService;

    @Test
    public void test() throws Exception{
        testAddNewEntityDef();
        testAddAttributeToEntityDef();
        testAddSubEntityToEntityDef();
        testAddEntity();
        testAddAttributeToEntity();
        testAddSubEntityToEntity();
        testUpdateAttributeToEntity();
        testUpdateSubEntityToEntity();
        testDeleteAttributeFromEntity();
        testDeleteSubEntityFromEntity();
        testDeleteEntity();
    }

    public void testAddNewEntityDef() throws Exception {
        assertEquals(-1, entityDefService.addNewEntityDef(""));
        assertEquals(0, entityDefService.addNewEntityDef("e1"));
        assertEquals(0, entityDefService.addNewEntityDef("e2"));
        assertEquals(-1, entityDefService.addNewEntityDef("e1"));
        assertEquals(-1, entityDefService.addNewEntityDef("e2"));

        assertNotNull(entityDefService.getEntityDef("e1"));
        assertNotNull(entityDefService.getEntityDef("e2"));
        assertNull(entityDefService.getEntityDef("e3"));
        assertNull(entityDefService.getEntityDef(""));
    }

    public void testAddAttributeToEntityDef() throws Exception {
        assertEquals(0, entityDefService.addAttributeToEntityDef("e1", "attr1", "", ""));
        assertEquals(-1, entityDefService.addAttributeToEntityDef("e1", "attr1", "", ""));
        assertEquals(0, entityDefService.addAttributeToEntityDef("e1", "attr2", "", ""));
        assertEquals(-1, entityDefService.addAttributeToEntityDef("e1", "", "", ""));
        assertEquals(0, entityDefService.addAttributeToEntityDef("e2", "attr1", "", ""));
        assertEquals(-1, entityDefService.addAttributeToEntityDef("e2", "attr1", "", ""));
        assertEquals(0, entityDefService.addAttributeToEntityDef("e2", "attr2", "", ""));

        assertNotNull(entityDefService.getAttributeOfEntityDef("e1", "attr1"));
        assertNotNull(entityDefService.getAttributeOfEntityDef("e2", "attr1"));
        assertNull(entityDefService.getAttributeOfEntityDef("e3", "attr1"));
        assertNull(entityDefService.getAttributeOfEntityDef("e1", "attr3"));
        assertNull(entityDefService.getAttributeOfEntityDef("e1", ""));
        assertNull(entityDefService.getAttributeOfEntityDef("", ""));
    }

    public void testAddSubEntityToEntityDef() throws Exception {
        assertEquals(0, entityDefService.addSubEntityToEntityDef("e1", "se1", ""));
        assertEquals(-1, entityDefService.addSubEntityToEntityDef("e1", "se1", ""));
        assertEquals(0, entityDefService.addSubEntityToEntityDef("e1", "se2", ""));
        assertEquals(-1, entityDefService.addSubEntityToEntityDef("e1", "", ""));
        assertEquals(0, entityDefService.addSubEntityToEntityDef("e2", "se1", ""));
        assertEquals(-1, entityDefService.addSubEntityToEntityDef("e2", "se1", ""));
        assertEquals(0, entityDefService.addSubEntityToEntityDef("e2", "se2", ""));

        assertNotNull(entityDefService.getSubEntityOfEntityDef("e1", "se1"));
        assertNotNull(entityDefService.getAttributeOfEntityDef("e2", "se1"));
        assertNull(entityDefService.getAttributeOfEntityDef("e3", "se3"));
        assertNull(entityDefService.getAttributeOfEntityDef("e1", "se3"));
        assertNull(entityDefService.getAttributeOfEntityDef("e1", ""));
        assertNull(entityDefService.getAttributeOfEntityDef("", ""));
    }

    
    public void testAddEntity() throws Exception {
        assertEquals(-1, entityService.addEntity("e1", ""));
        assertEquals(0, entityService.addEntity("e1", "v1"));
        assertEquals(0, entityService.addEntity("e2", "v2"));
        assertEquals(-1, entityService.addEntity("e1", "v1"));

        assertNotNull(entityService.getEntity("v1"));
        assertNotNull(entityService.getEntity("v2"));
        assertNull(entityService.getEntity("v3"));
        assertNull(entityService.getEntity(""));
    }

    
    public void testAddAttributeToEntity() throws Exception {
        assertEquals(-1, entityService.addAttributeToEntity("v1", "", ""));
        assertEquals(0, entityService.addAttributeToEntity("v1", "a1", "v1a1"));
        assertEquals(0, entityService.addAttributeToEntity("v1", "a2", "v2a2"));
        assertEquals(-1, entityService.addAttributeToEntity("v1", "a1", "v1a1"));

        assertThat(entityService.getAttributeOfEntity("v1","a1"), is(equals("v1a1")));
        assertThat(entityService.getAttributeOfEntity("v1","a2"), is(equals("v1a2")));
        assertNull(entityService.getAttributeOfEntity("v1","a3"));
    }

    
    public void testAddSubEntityToEntity() throws Exception {
        assertEquals(-1, entityService.updateAttributeToEntity("v1", "", ""));
        assertEquals(0, entityService.updateAttributeToEntity("v1", "a1", "v1a1u1"));
        assertEquals(0, entityService.updateAttributeToEntity("v1", "a2", "v2a2u1"));
        assertEquals(0, entityService.updateAttributeToEntity("v1", "a1", "v1a1u1"));
        assertEquals(-1, entityService.updateAttributeToEntity("v1", "a3", "v1a3u1"));

        assertThat(entityService.getAttributeOfEntity("v1","a1"), is(equals("v1a1u1")));
        assertThat(entityService.getAttributeOfEntity("v1","a2"), is(equals("v1a2u1")));
    }

    
    public void testUpdateAttributeToEntity() throws Exception {
        assertEquals(-1, entityService.updateAttributeToEntity("v1", "", ""));
        assertEquals(0, entityService.updateAttributeToEntity("v1", "s1", "v1s1u1"));
        assertEquals(0, entityService.updateAttributeToEntity("v1", "s2", "v2s2u1"));
        assertEquals(0, entityService.updateAttributeToEntity("v1", "s1", "v1s1u1"));
        assertEquals(-1, entityService.updateAttributeToEntity("v1", "s3", "v1s1u1"));

        assertThat(entityService.getSubEntityOfEntity("v1","a1"), is(equals("v1s1u1")));
        assertThat(entityService.getSubEntityOfEntity("v1","a2"), is(equals("v1s2u1")));
    }

    
    public void testUpdateSubEntityToEntity() throws Exception {
        assertEquals(-1, entityService.updateAttributeToEntity("v1", "", ""));
        assertEquals(0, entityService.updateAttributeToEntity("v1", "s1", "v1s1u1"));
        assertEquals(0, entityService.updateAttributeToEntity("v1", "s2", "v2s2u1"));
        assertEquals(-1, entityService.updateAttributeToEntity("v1", "s1", "v1s1u1"));
        assertEquals(-1, entityService.updateAttributeToEntity("v1", "s3", "v1s1u1"));

        assertThat(entityService.getSubEntityOfEntity("v1","a1"), is(equals("v1s1u1")));
        assertThat(entityService.getSubEntityOfEntity("v1","a2"), is(equals("v1s2u1")));
    }


    public void testDeleteEntity() throws Exception {
        assertEquals(-1, entityService.deleteEntity(""));
        assertEquals(0, entityService.deleteEntity("v1"));
        assertEquals(0, entityService.deleteEntity("v2"));
        assertEquals(-1, entityService.deleteEntity("v1"));

        assertNull(entityService.getEntity("v1"));
        assertNull(entityService.getEntity("v2"));
    }

    
    public void testDeleteAttributeFromEntity() throws Exception {
        assertEquals(-1, entityService.deleteAttributeFromEntity("v1", ""));
        assertEquals(0, entityService.deleteAttributeFromEntity("v1", "a1"));
        assertEquals(0, entityService.deleteAttributeFromEntity("v1", "a2"));
        assertEquals(-1, entityService.deleteAttributeFromEntity("v1", "a1"));

        assertNull(entityService.getAttributeOfEntity("v1", "a1"));
        assertNull(entityService.getAttributeOfEntity("v1", "a2"));
    }

    
    public void testDeleteSubEntityFromEntity() throws Exception {
        assertEquals(-1, entityService.deleteSubEntityFromEntity("v1", ""));
        assertEquals(0, entityService.deleteSubEntityFromEntity("v1", "s1"));
        assertEquals(0, entityService.deleteSubEntityFromEntity("v1", "s2"));
        assertEquals(-1, entityService.deleteSubEntityFromEntity("v1", "s1"));

        assertNull(entityService.getAttributeOfEntity("v1", "s1"));
        assertNull(entityService.getAttributeOfEntity("v1", "s2"));
    }
}