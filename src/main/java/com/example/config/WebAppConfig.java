package com.example.config;

import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class WebAppConfig {

    /**
     * This bean will help to avoid {@link org.hibernate.LazyInitializationException}
     * thrown by hibernate in lazy loading.
     * It will not load lazy entities and write as null
     *
     * @return {@link Hibernate6Module}
     * @see com.fasterxml.jackson.datatype.hibernate6.PersistentCollectionSerializer
     */
    @Bean
    public Hibernate6Module hibernate6Module() {
        Hibernate6Module hibernate6Module = new Hibernate6Module();
        return hibernate6Module;
    }
}
