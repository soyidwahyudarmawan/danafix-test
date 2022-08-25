package com.test.danafixtest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RedisConfig {

    @Value("${setting.cache.redis.time-to-live}")
    private int cacheMinute;

    @Bean
    RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return (builder) -> {
            Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
            configurationMap.put("employeeCache", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(cacheMinute)));
            configurationMap.put("employeeIdCache", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(cacheMinute)));
            configurationMap.put("employeeYearCache", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(cacheMinute)));
            builder.withInitialCacheConfigurations(configurationMap);
        };
    }
}
