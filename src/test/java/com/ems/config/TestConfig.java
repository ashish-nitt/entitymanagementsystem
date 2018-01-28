package com.ems.config;

import com.ems.repository.mapimpl.EmsEntityRepositoryImpl;
import com.ems.service.EntityService;
import com.ems.service.impl.EntityServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ashish on 26-01-2018.
 */
@Configuration
public class TestConfig {
    @Bean
    public EntityService getEntityService() {
        return new EntityServiceImpl();
    }

    @Bean
    public EmsEntityRepositoryImpl getEntityRepositorySimpleMap() {
        return new EmsEntityRepositoryImpl();
    }
}
