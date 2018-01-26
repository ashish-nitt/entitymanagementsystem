package com.ems.config;

import com.ems.repository.EntityDefRepositorySimpleMap;
import com.ems.repository.EntityRepositorySimpleMap;
import com.ems.service.EntityDefService;
import com.ems.service.EntityService;
import com.ems.service.impl.EntityDefServiceImpl;
import com.ems.service.impl.EntityServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ashish on 26-01-2018.
 */
@Configuration
public class TestConfig {
    @Bean
    public EntityDefService getEntityDefService() {
        return new EntityDefServiceImpl();
    }

    @Bean
    public EntityService getEntityService() {
        return new EntityServiceImpl();
    }

    @Bean
    public EntityDefRepositorySimpleMap getEntityDefRepositorySimpleMap() {
        return new EntityDefRepositorySimpleMap();
    }

    @Bean
    public EntityRepositorySimpleMap getEntityRepositorySimpleMap() {
        return new EntityRepositorySimpleMap();
    }
}
