package org.springframework.samples.petclinic.system;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.configuration.MutableConfiguration;

@Configuration
public class CacheConfiguration {

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> cm.createCache("vets", new MutableConfiguration<>());
    }
}
