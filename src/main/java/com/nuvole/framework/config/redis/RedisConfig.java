package com.nuvole.framework.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis 配置
 * Created by chenlong
 * Date：2018/7/16
 * time：16:40
 */
@Configuration
public class RedisConfig {

    @Value("${redis.address}")
    private String redisAddress;

    @Value("${redis.port}")
    private Integer redisPort;

    @Bean
    public JedisPool jedisPool(JedisPoolConfig poolconfig) {
        JedisPool pool = new JedisPool(poolconfig,redisAddress, redisPort);
        return pool;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        return new JedisPoolConfig();
    }

}
