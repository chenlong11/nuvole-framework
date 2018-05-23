package com.nuvole.framework.config;

import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * Created by chenlong
 * Date：2018/4/1
 * time：16:40
 */
@Configuration
public class CacheConfig {

    @Bean
    public EhCacheManagerFactoryBean ehcacheManager() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        Resource res = new ClassPathResource("resources/ehcache.xml");
        ehCacheManagerFactoryBean.setConfigLocation(res);
        return ehCacheManagerFactoryBean;
    }



}
